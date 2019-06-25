/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author alex
 */
public class ClienteSupervisor {
    
    private Socket conexion;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private JTextField jTextColumpios;
    private JTextField jTextTobogan;
    private JTextField jTextTiovivo;
    
    public ClienteSupervisor(JTextField jTextColumpios, JTextField jTextTiovivo, JTextField jTextTobogan) {
        try {
            conexion = new Socket(InetAddress.getLocalHost(),2222);
            entrada = new DataInputStream(conexion.getInputStream());
            salida = new DataOutputStream(conexion.getOutputStream());
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteSupervisor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteSupervisor.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
    
    public void interaccion(String accion) {
        try {
            salida.writeUTF(accion);
        } catch (IOException ex) {
            Logger.getLogger(ClienteSupervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recibirLista (String mensaje) throws IOException {
        String[] colas = new String[3];
        colas = mensaje.split("-");
        jTextTiovivo.setText(String.valueOf(colas[0]));
        jTextColumpios.setText(String.valueOf(colas[1]));
        jTextTobogan.setText(String.valueOf(colas[2]));
    }
    
    public String recibir() throws IOException {
        String mensaje = entrada.readUTF();
        return mensaje;
    }
    
    public void cerrarConexiones() throws IOException {
        entrada.close();
        salida.close();
        conexion.close();
    }
    
}
