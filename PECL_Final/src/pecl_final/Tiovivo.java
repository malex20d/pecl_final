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
    
    private int contadorSalida = 0;
    private CyclicBarrier barreraEntrada = new CyclicBarrier(5);
    private CyclicBarrier barreraSalida = new CyclicBarrier(5);
    private ArrayList<Ninno> ninnosEsperando = new ArrayList<>();
    private ArrayList<Ninno> ninnosMontados = new ArrayList<>();
    private ParqueInfantil parque;
    
    public Tiovivo (ParqueInfantil parqueInfantil) {
        parque = parqueInfantil;
    }
    
    public synchronized void entrarTiovivo(Ninno ninno) throws InterruptedException {
        while(ninnosMontados.size()==5) {
            System.out.println(ninno.getName()+" esta esperando para montarse en el tiovivo");
            ninnosEsperando.add(ninno);
            parque.getjTextColaTiovivo().setText(ArrayListToString(ninnosEsperando));
            wait();
        }
        
        if (ninnosEsperando.contains(ninno)) {
            ninnosEsperando.remove(ninno);
            parque.getjTextColaTiovivo().setText(ArrayListToString(ninnosEsperando));
        }
        System.out.println(ninno.getName()+" esta montado en el tiovivo");
        ninnosMontados.add(ninno);
        parque.getjTextMontandoTiovivo().setText(ArrayListToString(ninnosMontados));
    }
    
    public void montarEnTiovivo() throws InterruptedException {
        System.out.println(ninnosMontados.toString()+" estan montando en el tiovivo");
        Thread.sleep(5000);
        contadorSalida++;
        if (contadorSalida==5) {
            contadorSalida = 0;
            parque.getjTextMontandoTiovivo().setText(null);
        }
    }
    
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
    
    public String ArrayListToString (ArrayList<Ninno> ninnos) {
        String s = "";
        for (int i = 0; i < ninnos.size(); i++) {
            if (i==0) {
                s= s+ninnos.get(i).getName();
            } else {
                s = s+", "+ninnos.get(i).getName();
            }
        }
        
        return s;
    }
}
