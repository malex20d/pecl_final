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
public class Columpio {
   
    private ArrayList<Ninno> ninnos = new ArrayList<>();
    private ArrayList<Ninno> ninnosEsperando = new ArrayList<>();
    
    public Columpio() {
        
    }
    
    public synchronized void entrarColumpios(Ninno ninno) throws InterruptedException {
        while(ninnos.size()==3) {
            System.out.println(ninno.getName()+" espera para entrar a los columpios");
            ninnosEsperando.add(ninno);
            wait();
        }
        
        if (ninnosEsperando.contains(ninno)) {
            ninnosEsperando.remove(ninno);
        }
        System.out.println(ninno.getName()+" ha entrado a los columpios");
        ninnos.add(ninno);
    }
    
    public synchronized void salirColumpios(Ninno ninno) {
        ninnos.remove(ninno);
        System.out.println(ninno.getName()+" sale de los columpios");
        notify();
    }
    
    public void montarEnColumpio(Ninno ninno) throws InterruptedException {
        System.out.println(ninno.getName()+" esta montando en el columpio");
        Thread.sleep((int)(((Math.random()*1.8)+0.2)*1000));
    }
}
