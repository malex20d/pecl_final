/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 *
 * @author alex
 */
public interface InterfaceControlVigilante extends Remote {
    
    String controlarNinio() throws RemoteException;
    
}
