package ScanPortApi.Script.Whois;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.WhoisClient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author whoami
 */

public class WhoisTest {

    public String WhoisBR(String url) {

        String resultado = null;

        try {
            WhoisClient x = new WhoisClient();
            x.connect("whois.nic.br", 43);
            
            resultado = x.query(url);
            
        } catch (IOException ex) {
            Logger.getLogger(WhoisTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String [] aux = resultado.split(" ");
        for (String string : aux) {
            if (string.contains("Invalid")){
                resultado = "Whois não encontrado.";
            }
            if(string.contains("127.0.0.1")){
                resultado = "whois não encontrado.";
            }
        }
        return resultado;
    }
}
