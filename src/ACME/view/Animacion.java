/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME.view;
import javax.swing.*;
import ACME.*;
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
    
    public Animacion() {
        /*Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimVentana = this.getSize();
        this.setLocation((dimPantalla.width-dimVentana.width)/5, (dimPantalla.height-dimVentana.height)/4);*/
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
        cuevasView1 = new ACME.view.CuevasView();

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

        cuevasView1.setBackground(new java.awt.Color(238, 238, 238));

        javax.swing.GroupLayout cuevasView1Layout = new javax.swing.GroupLayout(cuevasView1);
        cuevasView1.setLayout(cuevasView1Layout);
        cuevasView1Layout.setHorizontalGroup(
            cuevasView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );
        cuevasView1Layout.setVerticalGroup(
            cuevasView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(TotAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(cuevasView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cuevasView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlmacenActionPerformed
        this.menu = new Menu(this);
        this.menu.setVisible(true);
    }//GEN-LAST:event_AlmacenActionPerformed
    
    public void Enviardato(float dato){
        this.cuevasView1.Recibirdato(dato);
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
            new Animacion().setVisible(true);
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Almacen;
    private javax.swing.JLabel ResAlmacen;
    private javax.swing.JLabel TotAlmacen;
    private ACME.view.CuevasView cuevasView1;
    // End of variables declaration//GEN-END:variables

}
