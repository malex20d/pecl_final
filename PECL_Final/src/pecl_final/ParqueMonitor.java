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
public class ParqueMonitor {
    
    private ArrayList<Ninno> ninnosDecidiendo = new ArrayList<>();
    private ParqueInfantil parque;
    private boolean parqueAbierto = true;
    
    public ParqueMonitor (ParqueInfantil parque) {
        this.parque = parque;
    }
    
    public synchronized void meterNinno (Ninno ninno) {
        ninnosDecidiendo.add(ninno);
        parque.getjTextAreaNinnnosDecidiendo().setText(ArrayListToString(ninnosDecidiendo));
    }
    
    public synchronized void sacarNinno (Ninno ninno) {
        ninnosDecidiendo.remove(ninno);
        parque.getjTextAreaNinnnosDecidiendo().setText(ArrayListToString(ninnosDecidiendo));
    }
    
    public String ArrayListToString (ArrayList<Ninno> ninnos) {
        String s = "";
        for (int i = 0; i < ninnos.size(); i++) {
            if (i==0) {
                s= s+ninnos.get(i).getName();
            } else {
                s = s+"\n"+ninnos.get(i).getName();
            }
        }
        
        return s;
    }

    public boolean isParqueAbierto() {
        return parqueAbierto;
    }

    void setParqueAbierto(boolean parqueAbierto) {
        this.parqueAbierto = parqueAbierto;
    }
    
    
    
}
