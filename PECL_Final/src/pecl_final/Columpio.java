/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author alex
 */
public class Columpio {
   
    private ArrayList<Ninno> ninnos = new ArrayList<>();
    private ArrayList<Ninno> ninnosEsperando = new ArrayList<>();
    private ParqueInfantil parque;
    
    public Columpio(ParqueInfantil parque ) {
        this.parque = parque;
    }
    
    public synchronized void entrarColumpios(Ninno ninno) throws InterruptedException {
        while(ninnos.size()==3) {
            System.out.println(ninno.getName()+" espera para entrar a los columpios");
            ninnosEsperando.add(ninno);
            parque.getjTextColaColumpio().setText(ArrayListToString(ninnosEsperando));
            wait();
        }
        if (ninnosEsperando.contains(ninno)) {
            ninnosEsperando.remove(ninno);
            parque.getjTextColaColumpio().setText(ArrayListToString(ninnosEsperando));
        }
        System.out.println(ninno.getName()+" ha entrado a los columpios");
        ninnos.add(ninno);
        parque.getjTextMontandoColumpio().setText(ArrayListToString(ninnos));
    }
    
    public synchronized void salirColumpios(Ninno ninno) {
        ninnos.remove(ninno);
        parque.getjTextMontandoColumpio().setText(ArrayListToString(ninnos));
        System.out.println(ninno.getName()+" sale de los columpios");
        notify();
    }
    
    public void montarEnColumpio(Ninno ninno) throws InterruptedException {
        System.out.println(ninno.getName()+" esta montando en el columpio");
        Thread.sleep((int)(((Math.random()*1.8)+0.2)*1000));
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

    public ArrayList<Ninno> getNinnosEsperando() {
        return ninnosEsperando;
    }
    
    
}
