/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScanPortApi.Script.Scanner;

import ScanPortApi.Script.DAO.ControladorPortasSalvas;
import ScanPortApi.Script.DAO.ControladorScanPortas;
import ScanPortApi.Script.DAO.ControladorVinculoPortas;
import ScanPortApi.Script.DAO.obj_PortasSalvas;
import ScanPortApi.Script.DAO.obj_ScanPortas;
import ScanPortApi.Script.DAO.obj_ServiceData;
import ScanPortApi.Script.DAO.obj_VinculoPortas;
import ScanPortApi.View.Screen;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author whoami
 */
public abstract class ManagerPorts {

    public abstract EntityManager getEntityManager();
    private final EntityManager em = getEntityManager();
    private String site;
    private int portaInicial;
    private int portaFinal;
    private InetAddress ip;
    private DefaultTableModel model;
    private final Date dth_ini;
    private final LinkedList<Integer> portasAbertas = new LinkedList<>();

    public ManagerPorts(String site, int portaInicial, int portaFinal) {
        this.site = site;
        this.dth_ini = new Date();
        this.portaInicial = portaInicial;
        this.portaFinal = portaFinal;
        
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setPortaInicial(int portaInicial) {
        this.portaInicial = portaInicial;
    }

    public void setPortaFinal(int portaFinal) {
        this.portaFinal = portaFinal;
    }

    public void iniciarScan() throws UnknownHostException, Throwable {

        try {
            System.out.println(site);
           ip = InetAddress.getByName(site);

            CreatePorts portas = new CreatePorts(ip, portaInicial, portaFinal);

            while (!portas.Acabou()) {
                synchronized (portas) {

                    if (!portas.hasMoreElements()) {
                        portas.wait(3000);
                        return;

                    }

                    ExecutaScan numeroporta = (ExecutaScan) portas.nextElement();

                    SwingWorker worker = new SwingWorker() {

                        @Override
                        protected synchronized Object doInBackground() throws Exception {
                            
                            synchronized(ManagerPorts.this){
                            //Thread t = new Thread(() -> numeroporta.run());
                            Thread t = new Thread(() -> {
                              
                                numeroporta.run();
                                if(numeroporta.taaberto()){
                                    portasAbertas.add(numeroporta.getPort());
                                }
                            
                            });
                            t.setPriority(10);
                            t.start();
                            }

                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                    worker.run();

                    if (portas.Acabou()) {

                        long tempo = System.currentTimeMillis();
                        long espera = tempo + 2000;
                        while (tempo < espera) {
                            tempo = System.currentTimeMillis();
                        }
                        JOptionPane.showMessageDialog(null, "Todas as portas foram Verificadas");
                        System.out.println(portasAbertas);
                        Collections.sort(portasAbertas);
                        updateTable();

                    }
                }
            }
        } catch (UnknownHostException ex) {
        }
    }

    private void updateTable() {

        model = (DefaultTableModel) Screen.portastable.getModel();

        JOptionPane.showMessageDialog(null, "Iniciando Verificaçao de Serviços");
//        Query query = em.createNamedQuery("obj_ServiceData.findByPorta");
//        CachedQuery(query, "obj_ServiceData.findByPorta");

        for (int i = 0; i < portasAbertas.size(); i++) {

            model.setRowCount(portasAbertas.size());
            model.setValueAt(portasAbertas.get(i), i, 0);
            obj_ServiceData data = (obj_ServiceData) em.createNamedQuery("obj_ServiceData.findByPorta").setParameter("porta", portasAbertas.get(i)).getResultList().get(0);
            model.setValueAt(data.getServico(), i, 1);
            model.setValueAt(data.getDescricao(), i, 2);
            model.setValueAt(data.getRisco(), i, 3);
           

            ScanPortApi.View.Screen.portastable.setModel(model);

        }
        salvar();
    }
//
//    private Query CachedQuery(Query query, String region) {
//        query.setHint("org.hibernate.cacheable", true);
//        query.setHint("org.hibernate.cacheRegion", region);
//        return query;
//    }

    private void salvar() {
        ControladorScanPortas csp = new ControladorScanPortas(em.getEntityManagerFactory());

        ControladorPortasSalvas ps = new ControladorPortasSalvas(em.getEntityManagerFactory());
        
        
        JOptionPane.showMessageDialog(null, "Scan Finalizado");
        ScanPortApi.View.Screen.jProgressBar1.setIndeterminate(false);
        ScanPortApi.View.Screen.jProgressBar1.setString("Completo");
        obj_ScanPortas scan = new obj_ScanPortas();
        scan.setSite(site);
        scan.setIp(ip.getHostAddress());
        scan.setWhois(ScanPortApi.View.Screen.textwhois.getText());
        csp.create(scan);

        for (int i = 0; i < model.getRowCount(); i++) {

            obj_PortasSalvas ports = new obj_PortasSalvas();
            ports.setPorta(String.valueOf(model.getValueAt(i, 0)));
            ports.setIdScanPortas(scan.getId());
            ports.setServico(String.valueOf(model.getValueAt(i, 1)));
            ports.setDescricao(String.valueOf(model.getValueAt(i, 2)));
            ps.create(ports);

        }
        Date dth_fim = new Date();

        ControladorVinculoPortas vc = new ControladorVinculoPortas(em.getEntityManagerFactory());
        obj_VinculoPortas vinc = new obj_VinculoPortas();
        vinc.setDtIni(dth_ini);
        vinc.setDtFim(dth_fim);
        vinc.setIdUser(setIdUser());
        vinc.setIdSub(setIdSub_user());
        vinc.setIdTeste(scan.getId());
        vc.create(vinc);
    }
    
    public abstract int setIdUser();
    public abstract int setIdSub_user();
    
}
