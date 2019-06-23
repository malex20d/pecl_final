package pecl_final;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author alex
 */
public class PECL_Final {

    public static void main(String[] args) {
        int contador = 0;
        Columpio columpios = new Columpio();
        Tobogan tobogan = new Tobogan();
        Tiovivo tiovivo = new Tiovivo();
        ExecutorService executor = Executors.newFixedThreadPool(20000);
            for (int i = 1; i <=50; i++) {
                contador++;
                Ninno ninno = new Ninno(2+contador,columpios, tobogan, tiovivo);
                executor.execute(ninno);
                ninno.setName("Niño-"+i);
                if (contador==9) {
                    contador = 0;
                }
            }
            
            executor.shutdown();
            
            try {
                executor.awaitTermination(24, TimeUnit.HOURS);
            } catch (InterruptedException ex) {
            
            } 
    }
    
}
