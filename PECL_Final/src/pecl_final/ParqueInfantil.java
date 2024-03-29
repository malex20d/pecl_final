/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecl_final;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 *
 * @author alex
 */
public class ParqueInfantil extends JFrame {

    /**
     * Creates new form ParqueInfantil
     */
    
    private CountDownLatch parar = new CountDownLatch(1);
    private boolean detenido = false;
    
    public ParqueInfantil() throws RemoteException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNinnnosDecidiendo = new javax.swing.JTextArea();
        jLabelDecidiendo = new javax.swing.JLabel();
        jLabelColaTobogan = new javax.swing.JLabel();
        jTextColaTobogan = new javax.swing.JTextField();
        jLabelToboganMontado = new javax.swing.JLabel();
        jTextNinnoMontadoTobogan = new javax.swing.JTextField();
        jLabelDe = new javax.swing.JLabel();
        jTextEdadNinnoMontadoTobogan = new javax.swing.JTextField();
        jLabelColaColumpio = new javax.swing.JLabel();
        jTextColaColumpio = new javax.swing.JTextField();
        jLabelColaTiovivo = new javax.swing.JLabel();
        jTextColaTiovivo = new javax.swing.JTextField();
        jLabelMontandoColumpio = new javax.swing.JLabel();
        jTextMontandoColumpio = new javax.swing.JTextField();
        jLabelTiovivoMontando = new javax.swing.JLabel();
        jTextMontandoTiovivo = new javax.swing.JTextField();
        jButtonDetener = new javax.swing.JButton();
        jButtonReanudar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaNinnnosDecidiendo.setEditable(false);
        jTextAreaNinnnosDecidiendo.setColumns(1);
        jTextAreaNinnnosDecidiendo.setRows(50);
        jScrollPane2.setViewportView(jTextAreaNinnnosDecidiendo);

        jLabelDecidiendo.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabelDecidiendo.setText("Decidiendo a dónde ir:");

        jLabelColaTobogan.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabelColaTobogan.setText("Cola de espera tobogán:");

        jTextColaTobogan.setEditable(false);
        jTextColaTobogan.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N

        jLabelToboganMontado.setText("En tobogán:");

        jTextNinnoMontadoTobogan.setEditable(false);
        jTextNinnoMontadoTobogan.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N

        jLabelDe.setText("de");
        jLabelDe.setToolTipText("");

        jTextEdadNinnoMontadoTobogan.setEditable(false);

        jLabelColaColumpio.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabelColaColumpio.setText("Cola de espera columpios");

        jTextColaColumpio.setEditable(false);
        jTextColaColumpio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextColaColumpioActionPerformed(evt);
            }
        });

        jLabelColaTiovivo.setFont(new java.awt.Font("URW Gothic L", 0, 12)); // NOI18N
        jLabelColaTiovivo.setText("Cola esperando tiovivo");

        jTextColaTiovivo.setEditable(false);

        jLabelMontandoColumpio.setText("En columpios:");

        jTextMontandoColumpio.setEditable(false);
        jTextMontandoColumpio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMontandoColumpioActionPerformed(evt);
            }
        });

        jLabelTiovivoMontando.setText("En tiovivo:");

        jTextMontandoTiovivo.setEditable(false);

        jButtonDetener.setText("Detener");
        jButtonDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetenerActionPerformed(evt);
            }
        });

        jButtonReanudar.setText("Reanudar");
        jButtonReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReanudarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonReanudar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabelColaTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(28, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelToboganMontado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextNinnoMontadoTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelDe)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextEdadNinnoMontadoTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextColaTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextColaColumpio, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextColaTiovivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(15, 15, 15)
                                                    .addComponent(jLabelColaTiovivo, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelMontandoColumpio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextMontandoColumpio, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelTiovivoMontando)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextMontandoTiovivo, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabelDecidiendo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabelColaColumpio, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDetener))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDecidiendo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabelColaTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextColaTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelToboganMontado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNinnoMontadoTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDe)
                            .addComponent(jTextEdadNinnoMontadoTobogan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelColaColumpio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextColaColumpio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMontandoColumpio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMontandoColumpio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelColaTiovivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextColaTiovivo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTiovivoMontando, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMontandoTiovivo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDetener))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReanudar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabelTiovivoMontando.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextColaColumpioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextColaColumpioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextColaColumpioActionPerformed

    private void jTextMontandoColumpioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMontandoColumpioActionPerformed
        
    }//GEN-LAST:event_jTextMontandoColumpioActionPerformed

    private void jButtonDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetenerActionPerformed
        detenido = true;
    }//GEN-LAST:event_jButtonDetenerActionPerformed

    private void jButtonReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReanudarActionPerformed
        detenido = false;
        parar.countDown();
        parar = new CountDownLatch(1);
    }//GEN-LAST:event_jButtonReanudarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws RemoteException, IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParqueInfantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParqueInfantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParqueInfantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParqueInfantil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        ParqueInfantil parque = new ParqueInfantil();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                parque.setVisible(true);
            }
        });
        int contador = 0;
        Columpio columpios = new Columpio(parque);
        Tobogan tobogan = new Tobogan(parque);
        Tiovivo tiovivo = new Tiovivo(parque);
        ParqueMonitor parqueMonitor = new ParqueMonitor(parque);
        ServidorParque parqueServidor = new ServidorParque(tobogan, columpios, tiovivo, parqueMonitor);
        parqueServidor.start();
        ExecutorService executor = Executors.newFixedThreadPool(20000);
            for (int i = 1; i <=50; i++) {
                contador++;
                Ninno ninno = new Ninno(2+contador,columpios, tobogan, tiovivo, parque, parqueMonitor);
                executor.execute(ninno);
                ninno.setName("Niño-"+i);
                System.out.println(ninno.getEdad());
                if (contador==10) {
                    contador = 0;
                }
            }
            executor.shutdown();
            
            try {
                executor.awaitTermination(24, TimeUnit.HOURS);
            } catch (InterruptedException ex) {
            
            }
    }
    
    public void comprobarDetener(Thread hilo) throws InterruptedException {
        if(detenido){
            parar.await();   
        }
    }
    
    public JButton getjButtonDetener() {
        return jButtonDetener;
    }

    public JButton getjButtonReanudar() {
        return jButtonReanudar;
    }

    public JLabel getjLabelColaColumpio() {
        return jLabelColaColumpio;
    }

    public JLabel getjLabelColaTiovivo() {
        return jLabelColaTiovivo;
    }

    public JLabel getjLabelColaTobogan() {
        return jLabelColaTobogan;
    }

    public JLabel getjLabelDe() {
        return jLabelDe;
    }

    public JLabel getjLabelDecidiendo() {
        return jLabelDecidiendo;
    }

    public JLabel getjLabelMontandoColumpio() {
        return jLabelMontandoColumpio;
    }

    public JLabel getjLabelTiovivoMontando() {
        return jLabelTiovivoMontando;
    }

    public JLabel getjLabelToboganMontado() {
        return jLabelToboganMontado;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JTextArea getjTextAreaNinnnosDecidiendo() {
        return jTextAreaNinnnosDecidiendo;
    }

    public JTextField getjTextColaColumpio() {
        return jTextColaColumpio;
    }

    public JTextField getjTextColaTiovivo() {
        return jTextColaTiovivo;
    }

    public JTextField getjTextColaTobogan() {
        return jTextColaTobogan;
    }

    public JTextField getjTextEdadNinnoMontadoTobogan() {
        return jTextEdadNinnoMontadoTobogan;
    }

    public JTextField getjTextMontandoColumpio() {
        return jTextMontandoColumpio;
    }

    public JTextField getjTextMontandoTiovivo() {
        return jTextMontandoTiovivo;
    }

    public JTextField getjTextNinnoMontadoTobogan() {
        return jTextNinnoMontadoTobogan;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetener;
    private javax.swing.JButton jButtonReanudar;
    private javax.swing.JLabel jLabelColaColumpio;
    private javax.swing.JLabel jLabelColaTiovivo;
    private javax.swing.JLabel jLabelColaTobogan;
    private javax.swing.JLabel jLabelDe;
    private javax.swing.JLabel jLabelDecidiendo;
    private javax.swing.JLabel jLabelMontandoColumpio;
    private javax.swing.JLabel jLabelTiovivoMontando;
    private javax.swing.JLabel jLabelToboganMontado;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaNinnnosDecidiendo;
    private javax.swing.JTextField jTextColaColumpio;
    private javax.swing.JTextField jTextColaTiovivo;
    private javax.swing.JTextField jTextColaTobogan;
    private javax.swing.JTextField jTextEdadNinnoMontadoTobogan;
    private javax.swing.JTextField jTextMontandoColumpio;
    private javax.swing.JTextField jTextMontandoTiovivo;
    private javax.swing.JTextField jTextNinnoMontadoTobogan;
    // End of variables declaration//GEN-END:variables
}
