/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author alex
 */
public class Tiovivo {
    
    private CyclicBarrier barreraEntrada = new CyclicBarrier(5);
    private CyclicBarrier barreraSalida = new CyclicBarrier(5);
    private ArrayList<Ninno> ninnosEsperando = new ArrayList<>();
    private ArrayList<Ninno> ninnosMontados = new ArrayList<>();
    
    public Tiovivo () {
        
    }
    
    public synchronized void entrarTiovivo(Ninno ninno) throws InterruptedException {
        while(ninnosMontados.size()==5) {
            System.out.println(ninno.getName()+" esta esperando para montarse en el tiovivo");
            ninnosEsperando.add(ninno);
            wait();
        }
        
        if (ninnosEsperando.contains(ninno)) {
            ninnosEsperando.remove(ninno);
        }
        System.out.println(ninno.getName()+" esta montado en el tiovivo");
        ninnosMontados.add(ninno);
    }
    
    /*public void montarEnTiovivo() throws InterruptedException {
        System.out.println(ninnosMontados.toString()+" estan montando en el tiovivo");
        Thread.sleep(5000);
    }*/
    
    public synchronized void salirTiovivo (Ninno ninno) {
        System.out.println(ninno.getName()+" esta saliendo del tiovivo");
        ninnosMontados.remove(ninno);
        notify();
    }
    
    public CyclicBarrier getBarreraEntrada() {
        return this.barreraEntrada;
    }
    
    public CyclicBarrier getBarreraSalida() {
        return this.barreraSalida;
    }
}
