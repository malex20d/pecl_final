/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ControlSupervisor extends Thread{
    
    private Socket conexionServidor;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private Tobogan tobogan;
    private Columpio columpio;
    private Tiovivo tiovivo;
    private ParqueMonitor parqueMonitor;
    

    ControlSupervisor(Socket conexion, Tobogan tobogan, Columpio columpio, Tiovivo tiovivo, ParqueMonitor parqueMonitor) {
        conexionServidor = conexion;
        this.tiovivo = tiovivo;
        this.tobogan = tobogan;
        this.columpio = columpio;
        this.parqueMonitor = parqueMonitor;
    }
    
    @Override
    public void run() {
        while (true) {            
            try {
                entrada = new DataInputStream(conexionServidor.getInputStream());
                salida = new DataOutputStream(conexionServidor.getOutputStream());
                String mensaje = entrada.readUTF();
                switch (mensaje) {
                    case "Cerrar":
                        parqueMonitor.setParqueAbierto(false);
                        break;
                    case "Refrescar":
                        salida.writeUTF(tiovivo.getNinnosEsperando().size()+"-"+columpio.getNinnosEsperando().size()+"-"+tobogan.getNinnosEsperando().size());
                        break;
                    default:
                        conexionServidor.close();
                        entrada.close();
                        salida.close();
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ControlSupervisor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
