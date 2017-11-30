/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScanPortApi.Script.Scanner;

import java.net.InetAddress;
import java.util.Enumeration;

/**
 *
 * @author whoami
 */
public class CreatePorts implements Enumeration {

    private InetAddress host = null;
    private int portaInicial = 0;
    private int portaFinal = 0;
    private int proximaPorta = 0;
    
    public CreatePorts(InetAddress host, int portaInicial, int portaFinal) {
        
        this.host = host;
        this.portaFinal = portaFinal;
        this.proximaPorta = this.portaInicial = portaInicial;
        
    }
    
    
    @Override
    public boolean hasMoreElements() {
        return (proximaPorta <= portaFinal);
    }

    @Override
    public Object nextElement() {
        return new ExecutaScan(host,proximaPorta++);
    }

    
    public boolean Acabou(){
     return proximaPorta == portaFinal;
    }
}
