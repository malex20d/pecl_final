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
    private ParqueInfantil parque;
    private int edad;
    private ParqueMonitor parqueMonitor;
    
    public Ninno (int edad, Columpio columpio, Tobogan tobogan, Tiovivo tiovivo, ParqueInfantil parqueInfantil, ParqueMonitor parqueMonitor) {
        this.edad = edad;
        this.columpio = columpio;
        this.tobogan = tobogan;
        this.tiovivo = tiovivo;
        parque = parqueInfantil;
        this.parqueMonitor = parqueMonitor;
    }
    
    
    @Override
    public void run() {
        while (parqueMonitor.isParqueAbierto()) {
            try {
                parque.comprobarDetener(this);
                parqueMonitor.meterNinno(this);
                sleep((int) (((Math.random()*1.8)+0.2)*1000));
                parque.comprobarDetener(this);
                parqueMonitor.sacarNinno(this);
                if (parqueMonitor.isParqueAbierto()) {
                    switch ((int) ((Math.random() * 2) + 1)){
                        case 1:
                            columpio.entrarColumpios(this);
                            parque.comprobarDetener(this);
                            columpio.montarEnColumpio(this);
                            parque.comprobarDetener(this);
                            columpio.salirColumpios(this);
                            break;
                        case 2:
                            tobogan.entrarTobogan(this);
                            parque.comprobarDetener(this);
                            tobogan.montarEnTobogan(this);
                            parque.comprobarDetener(this);
                            tobogan.salirTobogan(this);
                        case 3:
                            tiovivo.entrarTiovivo(this);
                            parque.comprobarDetener(this);
                            tiovivo.getBarreraEntrada().await();
                            tiovivo.montarEnTiovivo();
                            parque.comprobarDetener(this);
                            tiovivo.getBarreraSalida().await();
                            tiovivo.salirTiovivo(this);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ninno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Ninno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getEdad() {
        return edad;
    }
}
