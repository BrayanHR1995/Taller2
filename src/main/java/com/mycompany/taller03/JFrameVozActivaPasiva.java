/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller03;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Pavilion g4
 */
public class JFrameVozActivaPasiva extends javax.swing.JFrame {
File abre;
    /**
     * Creates new form JFrameVozActivaPasiva
     */
    public JFrameVozActivaPasiva() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        enteredPhrase = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        analyzePhrase = new javax.swing.JButton();
        loadCsv = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        correctas = new javax.swing.JLabel();
        incorrectas = new javax.swing.JLabel();
        porcentaje = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalPhrases = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        executionTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Taller voz activa y pasiva");

        jLabel2.setText("Ingrese una frase en ingles, Ejemplo: He is a man, Voz activa");

        jLabel3.setText("Resultado del analisis:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        analyzePhrase.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        analyzePhrase.setText("Analizar frase");
        analyzePhrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzePhraseActionPerformed(evt);
            }
        });

        loadCsv.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        loadCsv.setText("Cargar CSV");
        loadCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCsvActionPerformed(evt);
            }
        });

        jLabel4.setText("Frses correctas:");

        jLabel5.setText("Frases incorrectas:");

        jLabel6.setText("Porcentaje de exito:");

        correctas.setText("0");

        incorrectas.setText("0");

        porcentaje.setText("0");

        jLabel7.setText("Total frases analizadas:");

        totalPhrases.setText("0");

        jLabel8.setText("Tiempo de ejecucion en segundos:");

        executionTime.setText("0");

        jLabel9.setText("Frases incorrectas:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(correctas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(incorrectas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalPhrases, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(executionTime)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(enteredPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(analyzePhrase, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(loadCsv, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(70, 70, 70)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(259, 259, 259))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enteredPhrase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(analyzePhrase)
                    .addComponent(loadCsv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correctas)
                    .addComponent(incorrectas)
                    .addComponent(porcentaje)
                    .addComponent(totalPhrases)
                    .addComponent(executionTime))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCsvActionPerformed
        // TODO add your handling code here:
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(this);
   /**abrimos el archivo seleccionado*/
        abre=file.getSelectedFile();
        System.out.println(abre);
        int cont_correctas=0;
        int cont_incorrectas=0;
        double cal_porcentaje=0;
        LeerCsv csv = new LeerCsv();
        String mensaje="";
        String mensaje1="";
        String resultado="";
        String[] frases=null;
        String[] aux=null;
        PosTagger posTagger = new PosTagger();
        String result_analisis;
        try {
            long timeStart = System.currentTimeMillis();
            resultado = csv.mostrarCsv(String.valueOf(abre));
            frases = resultado.split("\n");
            posTagger.decomposePhrase();
            for(int i=0;i<frases.length;i++){
                aux=frases[i].split(",");
                aux[1]=aux[1].replaceFirst(" ", "");
                posTagger.comparar(aux[0]);
                result_analisis = posTagger.analyzePhrase();
                mensaje=mensaje+"Frase analizada: "+posTagger.getSentence()+"\n"+"Forma verbal de la frase: "+aux[1]
                        +"\n"+"Resultado del analisis: la frase esta en "+result_analisis+"\n";
                if(result_analisis.equals(aux[1])){
                    cont_correctas++;
                    mensaje=mensaje+"Analisis correcto\n\n";
                }else{
                    cont_incorrectas++;
                    mensaje=mensaje+"Analisis incorrecto\n\n";
                    mensaje1=mensaje1+frases[i]+"\n";
                }
            }
            long timeEnd = System.currentTimeMillis();
            long timeTotal = timeEnd - timeStart;
            double timeExecution = timeTotal/1000;
            jTextArea1.setText(mensaje);
            jTextArea2.setText(mensaje1);
            cal_porcentaje=(cont_correctas*100)/(cont_correctas+cont_incorrectas);
            correctas.setText(""+cont_correctas);
            incorrectas.setText(""+cont_incorrectas);
            totalPhrases.setText(""+(cont_correctas+cont_incorrectas));
            porcentaje.setText(""+cal_porcentaje+"%");
            executionTime.setText(""+timeExecution);
        } catch (IOException ex) {
            Logger.getLogger(JFrameVozActivaPasiva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadCsvActionPerformed

    private void analyzePhraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzePhraseActionPerformed
        // TODO add your handling code here:
        int cont_correctas=0;
        int cont_incorrectas=0;
        double cal_porcentaje=0;
        PosTagger posTagger = new PosTagger();
        String phrase=enteredPhrase.getText();
        String[] aux = phrase.split(",");
        aux[1]=aux[1].replaceFirst(" ", "");
        posTagger.decomposePhrase();
        posTagger.comparar(aux[0]);
        String result = posTagger.analyzePhrase();
        jTextArea1.setText("Frase ingresada: " + posTagger.getSentence() + "\n" 
                            + "Forma verbal de frase: " + aux[1] + "\n" 
                            + "Resultado del analisis: la frase esta en: " + result);
        if(result.equals(aux[1])){
            cont_correctas++;
        }else {
            cont_incorrectas++;
        }
        cal_porcentaje=(cont_correctas*100)/(cont_correctas+cont_incorrectas);
        correctas.setText(""+cont_correctas);
        incorrectas.setText(""+cont_incorrectas);
        totalPhrases.setText(""+(cont_correctas+cont_incorrectas));
        porcentaje.setText(""+cal_porcentaje+"%");
    }//GEN-LAST:event_analyzePhraseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(JFrameVozActivaPasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVozActivaPasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVozActivaPasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVozActivaPasiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameVozActivaPasiva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyzePhrase;
    private javax.swing.JLabel correctas;
    private javax.swing.JTextField enteredPhrase;
    private javax.swing.JLabel executionTime;
    private javax.swing.JLabel incorrectas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton loadCsv;
    private javax.swing.JLabel porcentaje;
    private javax.swing.JLabel totalPhrases;
    // End of variables declaration//GEN-END:variables
}
