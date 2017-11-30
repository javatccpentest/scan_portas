/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScanPortApi.Script.Scanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.SwingWorker;

/**
 *
 * @author whoami
 */
public class ExecutaScan extends SwingWorker {

    private final InetAddress ip;
    private final int port;

    public int getPort() {
        return port;
    }


    public ExecutaScan(InetAddress ip, int port) {
        this.ip = ip;
        this.port = port;

    }

    
    private boolean estado;
    
    synchronized public void Abertas(boolean state, int porta) {
        if (state) {
            estado = true;
            
        } else {
            estado = false;
        }

    }

   synchronized public boolean taaberto(){
       return estado;
   }
   
    @Override
    protected synchronized Object doInBackground() throws Exception {

        try (Socket s = new Socket(ip, port)) {

            Abertas(true, port);
            s.close();

        } catch (IOException ex) {
            //System.out.println(port + " Fechada");
        }

        super.isDone();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
