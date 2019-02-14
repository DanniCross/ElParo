/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME.view;

import java.awt.*;
import javax.swing.*;
import ACME.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jose Cruz
 */
public class Menu extends javax.swing.JFrame {
    Animacion prin;
    Isla isla;
    int n;
    //CuevasView cuevas = new CuevasView();
    /**
     * Creates new form Menu
     */
    public Menu(){
        initComponents();
    }
    
    public Menu(Animacion prin){
        initComponents();
        this.Confirmacion.setVisible(false);
        this.EliCueva.setVisible(false);
        this.Info.setVisible(false);
        this.prin = prin;
        Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimVentana = this.getSize();
        this.setLocation((dimPantalla.width-dimVentana.width)/3, (dimPantalla.height-dimVentana.height)/(10/3));
        transparenceButton();
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/IconAlmacen.png")).getImage());
    }
    
    public void transparenceButton(){
        this.Oro.setOpaque(false);
        this.Oro.setContentAreaFilled(false);
        this.Oro.setBorderPainted(false);
        Bronce.setOpaque(false);
        Bronce.setContentAreaFilled(false);
        Bronce.setBorderPainted(false);
        Plata.setOpaque(false);
        Plata.setContentAreaFilled(false);
        Plata.setBorderPainted(false);
        Madera.setOpaque(false);
        Madera.setContentAreaFilled(false);
        Madera.setBorderPainted(false);
        Piedra.setOpaque(false);
        Piedra.setContentAreaFilled(false);
        Piedra.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bronce = new javax.swing.JButton();
        Piedra = new javax.swing.JButton();
        Oro = new javax.swing.JButton();
        Plata = new javax.swing.JButton();
        Madera = new javax.swing.JButton();
        RecursosT = new javax.swing.JLabel();
        Resultado = new javax.swing.JLabel();
        TotPiedra = new javax.swing.JLabel();
        TotOro = new javax.swing.JLabel();
        RecPiedra = new javax.swing.JLabel();
        TotPlata = new javax.swing.JLabel();
        TotMadera = new javax.swing.JLabel();
        Eliminar = new javax.swing.JButton();
        RecursosT1 = new javax.swing.JLabel();
        Resultado1 = new javax.swing.JLabel();
        Excavar1 = new javax.swing.JButton();
        Camion1 = new javax.swing.JButton();
        TotBronce1 = new javax.swing.JLabel();
        RecOro = new javax.swing.JLabel();
        RecBronce = new javax.swing.JLabel();
        RecPlata = new javax.swing.JLabel();
        RecMadera = new javax.swing.JLabel();
        EliCueva = new javax.swing.JTextField();
        Info = new javax.swing.JLabel();
        Confirmacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ALMACEN");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bronce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Bronce.png"))); // NOI18N
        getContentPane().add(Bronce, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 50));

        Piedra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Piedra.png"))); // NOI18N
        getContentPane().add(Piedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 50));

        Oro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Oro.png"))); // NOI18N
        getContentPane().add(Oro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 50));

        Plata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Plata.png"))); // NOI18N
        getContentPane().add(Plata, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 50));

        Madera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Madera.png"))); // NOI18N
        getContentPane().add(Madera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 50));

        RecursosT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RecursosT.setText("Cuevas totales: ");
        getContentPane().add(RecursosT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, 30));

        Resultado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(Resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 70, 30));

        TotPiedra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TotPiedra.setText("Piedra:");
        getContentPane().add(TotPiedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 40, 30));

        TotOro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TotOro.setText("Oro:");
        getContentPane().add(TotOro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 30, 30));

        RecPiedra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(RecPiedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 50, 30));

        TotPlata.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TotPlata.setText("Plata:");
        getContentPane().add(TotPlata, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 30, 30));

        TotMadera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TotMadera.setText("Madera:");
        getContentPane().add(TotMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 50, 30));

        Eliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Eliminar.setText("Cerrar cueva");
        Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarMouseClicked(evt);
            }
        });
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 140, 30));

        RecursosT1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        RecursosT1.setText("Total recolectado: ");
        getContentPane().add(RecursosT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 110, 30));

        Resultado1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Resultado1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Resultado1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(Resultado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 70, 30));

        Excavar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Excavar1.setText("Excavacion nueva");
        Excavar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excavar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Excavar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 140, 30));

        Camion1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Camion1.setText("Enviar camion");
        Camion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Camion1ActionPerformed(evt);
            }
        });
        getContentPane().add(Camion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 140, 30));

        TotBronce1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TotBronce1.setText("Bronce:");
        getContentPane().add(TotBronce1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 30));

        RecOro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(RecOro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 50, 30));

        RecBronce.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(RecBronce, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 50, 30));

        RecPlata.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(RecPlata, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 50, 30));

        RecMadera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(RecMadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 50, 30));

        EliCueva.setName("CuevaAEliminar"); // NOI18N
        EliCueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliCuevaActionPerformed(evt);
            }
        });
        getContentPane().add(EliCueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 110, -1));

        Info.setText("Seleccione la cueva a eliminar: (1, 2, ...)");
        getContentPane().add(Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        Confirmacion.setText("OK");
        Confirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmacionActionPerformed(evt);
            }
        });
        getContentPane().add(Confirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void Excavar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excavar1ActionPerformed
        int cant = (int) (Math.random()*200)+100;
        try {
            this.prin.Enviardato(cant);
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Excavar1ActionPerformed

    private void Resultado1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Resultado1AncestorAdded

    }//GEN-LAST:event_Resultado1AncestorAdded

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        this.Confirmacion.setVisible(true);
        this.EliCueva.setVisible(true);
        this.Info.setVisible(true);
    }//GEN-LAST:event_EliminarActionPerformed

    private void Camion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Camion1ActionPerformed
        this.prin.EnviarCamion();
    }//GEN-LAST:event_Camion1ActionPerformed

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked

    }//GEN-LAST:event_EliminarMouseClicked

    private void EliCuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliCuevaActionPerformed
        
    }//GEN-LAST:event_EliCuevaActionPerformed

    private void ConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmacionActionPerformed
        this.n = Integer.parseInt(this.EliCueva.getText());
        this.Confirmacion.setVisible(false);
        this.EliCueva.setVisible(false);
        this.Info.setVisible(false);
        this.prin.Eliminar(n);
    }//GEN-LAST:event_ConfirmacionActionPerformed
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Menu().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bronce;
    private javax.swing.JButton Camion1;
    private javax.swing.JButton Confirmacion;
    private javax.swing.JTextField EliCueva;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Excavar1;
    private javax.swing.JLabel Info;
    private javax.swing.JButton Madera;
    private javax.swing.JButton Oro;
    private javax.swing.JButton Piedra;
    private javax.swing.JButton Plata;
    private javax.swing.JLabel RecBronce;
    private javax.swing.JLabel RecMadera;
    private javax.swing.JLabel RecOro;
    private javax.swing.JLabel RecPiedra;
    private javax.swing.JLabel RecPlata;
    private javax.swing.JLabel RecursosT;
    private javax.swing.JLabel RecursosT1;
    private javax.swing.JLabel Resultado;
    private javax.swing.JLabel Resultado1;
    private javax.swing.JLabel TotBronce1;
    private javax.swing.JLabel TotMadera;
    private javax.swing.JLabel TotOro;
    private javax.swing.JLabel TotPiedra;
    private javax.swing.JLabel TotPlata;
    // End of variables declaration//GEN-END:variables

}
