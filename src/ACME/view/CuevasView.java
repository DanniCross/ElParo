/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME.view;
import ACME.*;
import Elementos.LeerCuevas;
import java.awt.*;
import java.io.File;
import java.util.LinkedList;
import java.util.logging.*;
import javax.xml.parsers.*;
/**
 *
 * @author Jose Cruz
 */
public class CuevasView extends javax.swing.JPanel{
    Isla cuevas;
    Camion cam;
    LinkedList<Camion> camiones;
    LinkedList<Cueva> cuev;
    Menu menu = new Menu();
    Thread hiloC;
    int i = 0;
    
    public CuevasView(){
        this.cuevas = new Isla();
        this.camiones = new LinkedList<>();
        this.cuev = new LinkedList<>();
        this.cam = new Camion();
        initComponents();
    }
    
    public CuevasView(Isla cuevas, LinkedList<Camion> camiones){
        this.cuevas = cuevas;
        this.camiones = camiones;
        try {
            Leer();
        } catch (Exception ex) {
            Logger.getLogger(CuevasView.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }
    
    public void Leer() throws Exception{
        SAXParserFactory saxPF = SAXParserFactory.newInstance();
        SAXParser saxP = saxPF.newSAXParser();
    
        
        
        File file = new File("/run/media/josec/Jose Cruz/Documentos/Netbeans Projects/ElParo/ElParo/Cuevas.xml");
        LeerCuevas handler = new LeerCuevas();
        saxP.parse(file, handler);
        
        LinkedList<Cueva> c = handler.getCuevas();
        c.forEach((cu) -> {
            this.cuevas.EntraXML((int)cu.getDato(), cu.getMaterial());
        });
    }
    
    public void Recibirdato(float cant){
        try {
            this.cuevas.EntraCueva(cant);
        } catch (Exception ex) {
            Logger.getLogger(CuevasView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ElimN(int n){
        this.cuevas.Eliminar(n);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(this.cuevas != null){
            this.cuevas.pintar(this.cuevas.getEntrada(), g);
        }
        camiones.forEach(Camion -> {
                g.drawImage(Camion.getCueva().getImage(), Camion.getX(), Camion.getY(), Camion.getAlto(), Camion.getAncho(), null);
        }); 
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
