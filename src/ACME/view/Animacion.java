/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME.view;
import javax.swing.*;
import ACME.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jose Cruz
 */
public class Animacion extends javax.swing.JFrame {
    Menu menu = new Menu();
    Isla isla = new Isla();
    Cueva cueva;
    CuevasView dibujo;
    String Res = "0";
    String[] materiales = {"Oro","Bronce","Plata","Madera","Piedra"};
    int i = 0;
    int dato = 25;
    public Camion camion;
    public LinkedList<Camion> camiones;
    
    public Animacion(){
        this.camiones = new LinkedList<>();
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        transparenceButton();
        cerrar();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/IconIsla.png")).getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Almacen = new javax.swing.JButton();
        TotAlmacen = new javax.swing.JLabel();
        ResAlmacen = new javax.swing.JLabel();
        try{
            cuevasView1 = new ACME.view.CuevasView(this.isla, this.camiones);

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("ELPARO");
            setName("animacion"); // NOI18N

            Almacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Almacen.png"))); // NOI18N
            Almacen.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AlmacenActionPerformed(evt);
                }
            });

            TotAlmacen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            TotAlmacen.setText("Almacen:");

            ResAlmacen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
            ResAlmacen.setText("0");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(TotAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuevasView1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
            .addComponent(cuevasView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlmacenActionPerformed
        this.menu = new Menu(this);
        this.menu.setVisible(true);
    }//GEN-LAST:event_AlmacenActionPerformed
    
    public void Enviardato(float dato) throws Exception{
        this.cuevasView1.Recibirdato(dato);
    }
    
    public void EnviarCamion() throws Exception{
        camiones.add(new Camion(0,10, 60, 70, this.isla));
    }
    
    public void Eliminar(int n){
        this.cuevasView1.ElimN(n);
    }
    
    public void cerrar(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void transparenceButton(){
        Almacen.setOpaque(false);
        Almacen.setContentAreaFilled(false);
        Almacen.setBorderPainted(false);
    }
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
            java.util.logging.Logger.getLogger(Animacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Animacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Animacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Animacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Animacion().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Almacen;
    private javax.swing.JLabel ResAlmacen;
    private javax.swing.JLabel TotAlmacen;
    private ACME.view.CuevasView cuevasView1;
    // End of variables declaration//GEN-END:variables

}
