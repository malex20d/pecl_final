/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author alex
 */
class ControlVigilante extends UnicastRemoteObject implements InterfaceControlVigilante{
    
    private Tobogan tobogan;

    public ControlVigilante(Tobogan tobogan) throws RemoteException {
        this.tobogan = tobogan;
    }

    @Override
    public String controlarNinio() throws RemoteException {
        
        tobogan.setExpulsar(true);
        
        return Integer.toString(tobogan.getEdadTobogan());
    }
}
