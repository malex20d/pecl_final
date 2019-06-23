/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Tobogan {
    
    private ArrayList<Ninno> ninnosEsperando = new ArrayList<>();
    private boolean ocupado = false;
    
    public Tobogan() {
        
    }
    
    public synchronized void entrarTobogan(Ninno ninno) throws InterruptedException {
        while (ocupado) {
            System.out.println(ninno.getName()+" esperando para entrar al tobogan");
            ninnosEsperando.add(ninno);
            wait();
        }
        
        if(ninnosEsperando.contains(ninno)) {
            ninnosEsperando.remove(ninno);
        }
        
        ocupado = true;
        System.out.println(ninno.getName()+"esta subiendo al tobogan");
        Thread.sleep(1200);
    }
    
    public void montarEnTobogan(Ninno ninno) throws InterruptedException{
        System.out.println(ninno.getName()+" montando en tobogan");
        Thread.sleep(500);
    }
    
    public synchronized void salirTobogan(Ninno ninno) {
        System.out.println(ninno.getName()+" sale del tobogan");
        ocupado = false;
        notify();
    }
}
