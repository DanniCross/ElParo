/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME;

import Elementos.Datos;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josec
 */
public class Camion extends Datos implements Runnable{
    private Isla cuevas;
    private LinkedList<Cueva> cuev = new LinkedList<>();
    private Cueva cue = null;
    private float dat = 0;
    private int canr;
    
    public Camion(){
    }
    
    public Camion(int x, int y, int alto, int ancho, Isla cuevas) throws Exception{
        super(x, y, alto, ancho, "../Iconos/Camion.png");
        this.cuevas = cuevas;
        this.setCuev(this.getCuevas().getCuevas(this.getCuevas().getEntrada()));
        //this.cue = new Cueva(this.getCuevas().getEntrada().getIzq(), this.getCuevas().getEntrada().getDer(), this.getCuevas().getEntrada().getDato(), this.getCuevas().getEntrada().getMaterial(), this.getCuevas().getEntrada().getX(), this.getCuevas().getEntrada().getY(), this.getCuevas().getEntrada().getAlto(), this.getCuevas().getEntrada().getAncho(), this.getCuevas().getEntrada().getN());
        new Thread(this).start();
    }  

    @Override
    public void run(){
        boolean bandera = true;
        while(bandera){
            movimiento(this.getCuevas().getEntrada());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Camion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void movimiento(Cueva Padre){
        if(Padre != null){
            if(this.getY() == Padre.getY()-20){
                if(this.getX() < Padre.getX() && this.getY() == Padre.getY()-20){
                    this.setX(this.getX() + 5);
                }else if(this.getX() > Padre.getX() && this.getY() == Padre.getY()-20){
                    this.setX(this.getX() - 5);
                }else if(this.getX() == Padre.getX() && (Padre.getIzq() != null && !Padre.getIzq().getRec() || Padre.getDer() != null && !Padre.getDer().getRec())){
                    this.setY(this.getY() + 5);
                }
                if(this.getX() == Padre.getX() && this.getY() == Padre.getY()-20){
                    if(Padre.getIzq() == null && Padre.getDer() == null){
                        Padre.setRec(true);
                    }else if(Padre.getIzq() != null && Padre.getDer() == null){
                        if(Padre.getIzq().getRec()){
                            Padre.setRec(true);
                        }
                    }else if(Padre.getIzq() == null && Padre.getDer() != null){
                        if(Padre.getDer().getRec()){
                            Padre.setRec(true);
                        }
                    }
                }
            }else{
                if(Padre.getIzq() != null && Padre.getIzq().getRec() != true){
                    movimiento(Padre.getIzq());
                }else if(Padre.getDer() != null && Padre.getDer().getRec() != true){
                    movimiento(Padre.getDer());
                }
                if(this.getX() == Padre.getX() && (Padre.getIzq() != null && !Padre.getIzq().getRec() || Padre.getDer() != null && !Padre.getDer().getRec())){
                    this.setY(this.getY() + 5);
                }
            }
        }
    }
    
    public Isla getCuevas() {
        return cuevas;
    }

    public void setCuevas(Isla cuevas) {
        this.cuevas = cuevas;
    }

    public int getCanr() {
        return canr;
    }

    public void setCanr(int canr) {
        this.canr = canr;
    }

    public LinkedList<Cueva> getCuev() {
        return cuev;
    }

    public void setCuev(LinkedList<Cueva> cuev) {
        this.cuev = cuev;
    }

}
