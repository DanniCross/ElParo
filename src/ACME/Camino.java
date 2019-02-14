/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME;
import Elementos.Datos;

/**
 *
 * @author josec
 */
public class Camino extends Datos{
    private int h;
    private int A;
    
    public Camino(int x, int y, int h, int A, String ruta){
        super(x, y, h, A, ruta);
        this.h = h;
        this.A = A;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }
}
