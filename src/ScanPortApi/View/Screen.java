/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScanPortApi.View;

import ScanPortApi.Script.Scanner.ManagerPorts;
import ScanPortApi.Script.Whois.WhoisTest;
import java.awt.HeadlessException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author q216-18
 */
public abstract class Screen extends javax.swing.JFrame {

    /**
     * Creates new form tela
     */
    private String url;
    private InetAddress ip;

    public abstract EntityManager getEntityManager();

    public abstract int IdUser();

    public abstract int IdSubUser();

    public final EntityManager em = getEntityManager();;

    public Screen() {

        initComponents();
        descLabel.setText("Este tipo de scan vai explorar de 0 até 1000 portas");

        descWhois.setText("A verficação de informação whois não esta ativada");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelScan = new javax.swing.JPanel();
        labelhttp = new javax.swing.JLabel();
        hostTxt = new javax.swing.JTextField();
        scrolltable = new javax.swing.JScrollPane();
        portastable = new javax.swing.JTable();
        lblInfo1 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textwhois = new javax.swing.JTextArea();
        panelOption = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelScan = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        labelPortaInicio = new javax.swing.JLabel();
        txtportaini = new javax.swing.JFormattedTextField();
        labelPortafim = new javax.swing.JLabel();
        txtportafim = new javax.swing.JFormattedTextField();
        descLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labeltipodeWhois = new javax.swing.JLabel();
        whois_br = new javax.swing.JRadioButton();
        descWhois = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scan de porta");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        panelScan.setBackground(new java.awt.Color(255, 255, 255));

        labelhttp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelhttp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanPortApi/View/images/icons8-add-link-filled_crawler.png"))); // NOI18N
        labelhttp.setText("http://");

        hostTxt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        hostTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 102, 102)));

        scrolltable.setBorder(null);

        portastable.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        portastable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Porta", "Serviço", "Descrição", "Risco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        portastable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        portastable.setGridColor(new java.awt.Color(255, 255, 255));
        portastable.setRowHeight(20);
        portastable.setSelectionBackground(new java.awt.Color(52, 152, 219));
        scrolltable.setViewportView(portastable);
        if (portastable.getColumnModel().getColumnCount() > 0) {
            portastable.getColumnModel().getColumn(0).setResizable(false);
            portastable.getColumnModel().getColumn(0).setPreferredWidth(100);
            portastable.getColumnModel().getColumn(1).setResizable(false);
            portastable.getColumnModel().getColumn(1).setPreferredWidth(150);
            portastable.getColumnModel().getColumn(2).setResizable(false);
            portastable.getColumnModel().getColumn(2).setPreferredWidth(280);
            portastable.getColumnModel().getColumn(3).setResizable(false);
            portastable.getColumnModel().getColumn(3).setPreferredWidth(140);
        }

        lblInfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanPortApi/View/images/icons8-info_crawler.png"))); // NOI18N
        lblInfo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblInfo1MousePressed(evt);
            }
        });

        btnIniciar.setBackground(new java.awt.Color(52, 152, 219));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Iniciar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout btnIniciarLayout = new javax.swing.GroupLayout(btnIniciar);
        btnIniciar.setLayout(btnIniciarLayout);
        btnIniciarLayout.setHorizontalGroup(
            btnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnIniciarLayout.setVerticalGroup(
            btnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jProgressBar1.setName(""); // NOI18N
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout panelScanLayout = new javax.swing.GroupLayout(panelScan);
        panelScan.setLayout(panelScanLayout);
        panelScanLayout.setHorizontalGroup(
            panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelScanLayout.createSequentialGroup()
                        .addComponent(labelhttp, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                        .addGap(9, 9, 9)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrolltable)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelScanLayout.setVerticalGroup(
            panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelScanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelhttp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelScanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrolltable, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Scan", panelScan);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textwhois.setEditable(false);
        textwhois.setColumns(20);
        textwhois.setRows(5);
        jScrollPane1.setViewportView(textwhois);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Whois", jPanel1);

        panelOption.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        labelScan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelScan.setText("Tipo de Scan:");

        comboTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rapido", "Completo", "Personalizado" }));
        comboTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTipoItemStateChanged(evt);
            }
        });

        labelPortaInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelPortaInicio.setText("Numero da porta inicial");
        labelPortaInicio.setEnabled(false);

        txtportaini.setEditable(false);
        txtportaini.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 102, 102)));
        txtportaini.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtportaini.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        labelPortafim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelPortafim.setText("Numero da porta final");
        labelPortafim.setEnabled(false);

        txtportafim.setEditable(false);
        txtportafim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(102, 102, 102)));
        txtportafim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtportafim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        descLabel.setBackground(new java.awt.Color(255, 255, 255));
        descLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanPortApi/View/images/icons8-info_crawler.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanPortApi/View/images/icons8-info_crawler.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        labeltipodeWhois.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labeltipodeWhois.setText("Detecção Whois:");

        whois_br.setBackground(new java.awt.Color(255, 255, 255));
        whois_br.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        whois_br.setText("Dominios Brasileiros");
        whois_br.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                whois_brStateChanged(evt);
            }
        });

        descWhois.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelScan, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(whois_br)
                        .addGap(18, 18, 18)
                        .addComponent(descWhois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelPortaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtportaini, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelPortafim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtportafim, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labeltipodeWhois, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelScan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelPortaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtportaini, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtportafim)
                    .addComponent(labelPortafim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labeltipodeWhois, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descWhois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(whois_br, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelOptionLayout = new javax.swing.GroupLayout(panelOption);
        panelOption.setLayout(panelOptionLayout);
        panelOptionLayout.setHorizontalGroup(
            panelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelOptionLayout.setVerticalGroup(
            panelOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Opções", panelOption);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTipoItemStateChanged
        if (comboTipo.getSelectedItem().equals("Rapido")) {
            descLabel.setText("Este tipo de scan vai explorar de 0 até 1000 portas");
            txtportafim.setEditable(false);
            txtportaini.setEditable(false);
            labelPortaInicio.setEnabled(false);
            labelPortafim.setEnabled(false);
            descLabel.revalidate();
            descLabel.updateUI();

        } else if (comboTipo.getSelectedItem().equals("Completo")) {
            descLabel.setText("Este tipo de scan vai explorar de 0 até 66535 portas (experimental)");
            txtportafim.setEditable(false);
            txtportaini.setEditable(false);
            labelPortaInicio.setEnabled(false);
            labelPortafim.setEnabled(false);
            descLabel.revalidate();
            descLabel.updateUI();
        } else if (comboTipo.getSelectedItem().equals("Personalizado")) {
            descLabel.setText("Você escolhe a faixa de portas a serem verificadas");
            descLabel.revalidate();
            descLabel.updateUI();
            txtportafim.setEditable(true);
            txtportaini.setEditable(true);
            labelPortaInicio.setEnabled(true);
            labelPortafim.setEnabled(true);
        }
    }//GEN-LAST:event_comboTipoItemStateChanged

    private void whois_brStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_whois_brStateChanged

        if (whois_br.isSelected() == true) {
            descWhois.setText("Verifica informações do dominio pela nic.br | pesquisa nacional");
        } else {
            descWhois.setText("A verficação de informação whois nao esta ativada");
        }

    }//GEN-LAST:event_whois_brStateChanged

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        Thread x = new Thread(() -> {

            resetTable();
            textwhois.setText("");
            jProgressBar1.setIndeterminate(true);
            jProgressBar1.setString("Processando");
            url = hostTxt.getText();
            try {
                ip = InetAddress.getByName(url);
                if (whois_br.isSelected() == true) {
                    WhoisTest whbr = new WhoisTest();
                    textwhois.setText(whbr.WhoisBR(url));
                }

                if (url.isEmpty()) {
                    hostTxt.setText(ip.getHostAddress());
                }
                if (comboTipo.getSelectedItem().equals("Rapido")) {
                    ManagerPorts gerenciador = new ManagerPorts(url, 0, 1001) {
                        @Override
                        public EntityManager getEntityManager() {
                            return em;
                        }

                        @Override
                        public int setIdUser() {
                            return IdUser();
                        }

                        @Override
                        public int setIdSub_user() {
                            return IdSubUser();
                        }
                    };
                    gerenciador.iniciarScan();

                } else if (comboTipo.getSelectedItem().equals("Completo")) {
                    ManagerPorts gerenciador = new ManagerPorts(url, 0, 65536) {
                        @Override
                        public EntityManager getEntityManager() {
                            return em;
                        }

                        @Override
                        public int setIdUser() {
                            return IdUser();
                        }

                        @Override
                        public int setIdSub_user() {
                            return IdSubUser();
                        }
                    };
                    gerenciador.iniciarScan();
                } else if (comboTipo.getSelectedItem().equals("Personalizado")) {
                    try {
                        if (Integer.parseInt(txtportaini.getValue().toString()) <= 66534 && Integer.parseInt(txtportaini.getValue().toString()) >= 0) {
                            if (Integer.parseInt(txtportafim.getValue().toString()) > Integer.parseInt(txtportaini.getValue().toString()) && Integer.parseInt(txtportafim.getValue().toString()) <= 66535) {
                                ManagerPorts gerenciador = new ManagerPorts(url, Integer.parseInt(txtportaini.getValue().toString()), Integer.parseInt(txtportafim.getValue().toString()) + 1) {
                                    @Override
                                    public EntityManager getEntityManager() {
                                        return em;
                                    }

                                    @Override
                                    public int setIdUser() {
                                        return IdUser();
                                    }

                                    @Override
                                    public int setIdSub_user() {
                                        return IdSubUser();
                                    }
                                };

                                gerenciador.iniciarScan();

                            } else {
                                JOptionPane.showMessageDialog(null, "A porta final deve conter um valor maior do que o contido na porta inicial a 66535", "erro", JOptionPane.ERROR_MESSAGE);

                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "A porta inicial deve conter um valor de 0 a 66534", "erro", JOptionPane.ERROR_MESSAGE);

                        }
                    } catch (NumberFormatException number) {
                        JOptionPane.showMessageDialog(null, "O numero inserido é muito longo , insira um numero menor que 66534", "erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (UnknownHostException ex) {
                JOptionPane.showMessageDialog(null, "A url inserida não é valida \n insira uma url valida", "erro", JOptionPane.ERROR_MESSAGE);
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "As portas nao foram marcadas para o scan personalizado", "erro", JOptionPane.ERROR_MESSAGE);

            } catch (Throwable ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        x.start();


    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        btnIniciar.setBackground(new java.awt.Color(52, 152, 219));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        btnIniciar.setBackground(new java.awt.Color(41, 128, 185));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void lblInfo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInfo1MousePressed
        JOptionPane.showMessageDialog(null, "Digite o ip ou a url que sera explorada");
    }//GEN-LAST:event_lblInfo1MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        JOptionPane.showMessageDialog(null, "Numero da porta que o scan vai iniciar o teste.");
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        JOptionPane.showMessageDialog(null, "Numero da porta que o scan vai finalizar o teste.");
    }//GEN-LAST:event_jLabel3MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnIniciar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel descLabel;
    private javax.swing.JLabel descWhois;
    private javax.swing.JTextField hostTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelPortaInicio;
    private javax.swing.JLabel labelPortafim;
    private javax.swing.JLabel labelScan;
    private javax.swing.JLabel labelhttp;
    private javax.swing.JLabel labeltipodeWhois;
    private javax.swing.JLabel lblInfo1;
    private javax.swing.JPanel panelOption;
    private javax.swing.JPanel panelScan;
    public static javax.swing.JTable portastable;
    private javax.swing.JScrollPane scrolltable;
    public static javax.swing.JTextArea textwhois;
    private javax.swing.JFormattedTextField txtportafim;
    private javax.swing.JFormattedTextField txtportaini;
    private javax.swing.JRadioButton whois_br;
    // End of variables declaration//GEN-END:variables

    private void resetTable() {

        portastable = new javax.swing.JTable();

        portastable.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        portastable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Porta", "Serviço", "Descrição", "Risco"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        portastable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        portastable.setGridColor(new java.awt.Color(255, 255, 255));

        portastable.setRowHeight(20);

        portastable.setSelectionBackground(new java.awt.Color(52, 152, 219));

        scrolltable.setViewportView(portastable);

        if (portastable.getColumnModel().getColumnCount() > 0) {
            portastable.getColumnModel().getColumn(0).setResizable(false);
            portastable.getColumnModel().getColumn(0).setPreferredWidth(100);
            portastable.getColumnModel().getColumn(1).setResizable(false);
            portastable.getColumnModel().getColumn(1).setPreferredWidth(150);
            portastable.getColumnModel().getColumn(2).setResizable(false);
            portastable.getColumnModel().getColumn(2).setPreferredWidth(280);
            portastable.getColumnModel().getColumn(3).setResizable(false);
            portastable.getColumnModel().getColumn(3).setPreferredWidth(140);
        }

    }
}