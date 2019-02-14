/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME;

import Elementos.Datos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josec
 */
public class Camion extends Datos implements Runnable{
    private Cueva cuevas;
    private int x;
    private int y;
    private int alto;
    private int ancho;
    
    public Camion(){
    }
    
    public Camion(int x, int y, int alto, int ancho){
        super(x, y, alto, ancho, "../Iconos/Camion.png");
        new Thread(this).start();
    }  

    @Override
    public void run(){
        boolean bandera = true;
        while(bandera){
            this.setX(this.getX() + 5);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Camion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Cueva getCuevas() {
        return cuevas;
    }

    public void setCuevas(Cueva cuevas) {
        this.cuevas = cuevas;
    }
}
