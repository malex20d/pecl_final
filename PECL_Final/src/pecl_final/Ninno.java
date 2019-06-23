/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Ninno extends Thread {
    
    private Columpio columpio;
    private Tobogan tobogan;
    private Tiovivo tiovivo;
    private int edad;
    
    public Ninno (int edad, Columpio columpio, Tobogan tobogan, Tiovivo tiovivo) {
        this.edad = edad;
        this.columpio = columpio;
        this.tobogan = tobogan;
        this.tiovivo = tiovivo;
    }
    
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep((int) (((Math.random()*1.8)+0.2)*1000));
                switch ((int) ((Math.random() * 2) + 1)){
                    case 1:
                        columpio.entrarColumpios(this);
                        columpio.montarEnColumpio(this);
                        columpio.salirColumpios(this);
                        break;
                    case 2:
                        tobogan.entrarTobogan(this);
                        tobogan.montarEnTobogan(this);
                        tobogan.salirTobogan(this);
                    case 3:
                        tiovivo.entrarTiovivo(this);
                        tiovivo.getBarreraEntrada().await();
                        //tiovivo.montarEnTiovivo();
                        sleep(5000);
                        tiovivo.getBarreraSalida().await();
                        tiovivo.salirTiovivo(this);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ninno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Ninno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
