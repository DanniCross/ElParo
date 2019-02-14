/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;
import javax.swing.*;
/**
 *
 * @author Jose Cruz
 */
public class Datos {
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private ImageIcon cueva;
    
    public Datos(){
    }
    
    public Datos(int x, int y, int ancho, int alto, String ruta){
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.cueva = new ImageIcon(getClass().getResource(ruta));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public ImageIcon getCueva() {
        return cueva;
    }

    public void setCueva(String ruta) {
        this.cueva = new ImageIcon(getClass().getResource(ruta));
    }
}
