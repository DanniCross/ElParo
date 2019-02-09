/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME;
import Elementos.*;
/**
 *
 * @author Jose Cruz
 */
public class Cueva extends Datos{
    private String Material;
    private Cueva izq;
    private Cueva der;
    private float dato;
    private int Fe;
    private int DFe;
    private int i;
    private int nivel;
    
    public Cueva(Cueva izq, Cueva der, float dato, String Material, int x, int y, int ancho, int alto){
        super(x, y, ancho, alto, "../Iconos/Cueva.png");
        this.izq = izq;
        this.der = der;
        this.dato = dato;
        this.Fe = 0;
        this.DFe = 0;
        this.Material = Material;
        this.i = i;
        this.nivel = 0;
    }
    
    public Cueva(int x, int y, int ancho, int alto){
        super(x, y, ancho, alto, "../Iconos/Cueva.png");
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public Cueva getIzq() {
        return izq;
    }

    public void setIzq(Cueva izq) {
        this.izq = izq;
    }

    public Cueva getDer() {
        return der;
    }

    public void setDer(Cueva der) {
        this.der = der;
    }

    public float getDato() {
        return dato;
    }

    public void setDato(float dato) {
        this.dato = dato;
    }

    public int getFe() {
        return Fe;
    }

    public void setFe(int Fe) {
        this.Fe = Fe;
    }

    public int getDFe() {
        return DFe;
    }

    public void setDFe(int DFe) {
        this.DFe = DFe;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
