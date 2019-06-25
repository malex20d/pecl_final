/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class ServidorParque extends Thread {
    
    private ControlVigilante objeto;
    private ControlSupervisor controlSupervisor;
    private Registry registro;
    private Tobogan tobogan;
    private Columpio columpio;
    private Tiovivo tiovivo;
    private ServerSocket servidor;
    private ParqueMonitor parqueMonitor;
    
    public ServidorParque (Tobogan tobogan, Columpio columpio, Tiovivo tiovivo, ParqueMonitor parqueMonitor) throws RemoteException, IOException {
        
        this.tiovivo = tiovivo;
        this.columpio = columpio;
        this.tobogan= tobogan;
        registro = LocateRegistry.createRegistry(1099); //arranca RMIregistry local en el puesto 1099
        servidor = new ServerSocket(2222);
        this.parqueMonitor = parqueMonitor;
    }
    
    @Override
    public void run() {
        Socket conexion; 
        while (true) {            
            try {
                objeto = new ControlVigilante(tobogan);
                Naming.rebind("//127.0.0.1/ObjetoControlVigilante", objeto);
                System.out.println("El Objeto ControlVigilante ha quedado registrado");
                conexion = servidor.accept();
                if (conexion.isConnected()) {
                    controlSupervisor = new ControlSupervisor(conexion, tobogan, columpio, tiovivo, parqueMonitor);
                    controlSupervisor.start();
                }
            } catch (RemoteException | MalformedURLException ex) {
                Logger.getLogger(ServidorParque.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServidorParque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
