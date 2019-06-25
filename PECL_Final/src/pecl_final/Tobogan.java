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
    private ParqueInfantil parque;
    private int edadTobogan;
    private boolean expulsar = false;
    
    public Tobogan(ParqueInfantil parqueInfantil) {
        parque = parqueInfantil;
    }
    
    public synchronized void entrarTobogan(Ninno ninno) throws InterruptedException {
        while (ocupado) {
            System.out.println(ninno.getName()+" esperando para entrar al tobogan");
            ninnosEsperando.add(ninno);
            parque.getjTextColaTobogan().setText(ArrayListToString(ninnosEsperando));
            wait();
        }
        
        if(ninnosEsperando.contains(ninno)) {
            ninnosEsperando.remove(ninno);
            parque.getjTextColaTobogan().setText(ArrayListToString(ninnosEsperando));
        }
        
        ocupado = true;
        edadTobogan = ninno.getEdad();
        parque.getjTextNinnoMontadoTobogan().setText(ninno.getName());
        parque.getjTextEdadNinnoMontadoTobogan().setText(String.valueOf(ninno.getEdad()));
        System.out.println(ninno.getName()+"esta subiendo al tobogan");
        Thread.sleep(1200);
    }
    
    public void montarEnTobogan(Ninno ninno) throws InterruptedException{
        System.out.println(ninno.getName()+" montando en tobogan");
        if (!(expulsar && ninno.getEdad()>7)) {
            Thread.sleep(500);
        }
        expulsar = false;
    }
    
    public synchronized void salirTobogan(Ninno ninno) {
        System.out.println(ninno.getName()+" sale del tobogan");
        ocupado = false;
        parque.getjTextEdadNinnoMontadoTobogan().setText("");
        parque.getjTextNinnoMontadoTobogan().setText("");
        notify();
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

    public int getEdadTobogan() {
        return edadTobogan;
    }

    public void setExpulsar(boolean expulsar) {
        this.expulsar = expulsar;
    }

    public ArrayList<Ninno> getNinnosEsperando() {
        return ninnosEsperando;
    }
    
    
    
}
