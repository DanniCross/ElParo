/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME;

import java.awt.Graphics;

/**
 *
 * @author Jose Cruz
 */
public class Isla {
    String[] materiales = {"Oro","Bronce","Plata","Madera","Piedra"};
    private Cueva Entrada;
    private Cueva actual;
    boolean pass = false;
    int dato;
    int i = 0;
    int x ;
    int y ;
    
    public Isla(){
    }
    
    public void EntraCueva(float cant){
        if(this.getEntrada() == null){
            this.setEntrada(new Cueva(null, null, cant, materiales[i], 500, 30, 65, 65));
            this.i = i + 1;
        }else{
            if(this.i > materiales.length - 1){
                this.i = 0;
            }
            Excavacion(this.getEntrada(), this.i, cant);
            this.i = i + 1;
        }
    }
    
    public boolean Excavacion(Cueva actual, int i, float cant){
        if(actual == null){
            return true;
        }else{
            if(cant < actual.getDato()){
                if(Excavacion(actual.getIzq(),i, cant)){
                    actual.setIzq(new Cueva(null, null, cant, materiales[i], actual.getX() - (actual.getAncho() + 100), actual.getY() + (actual.getAlto() + 70), actual.getAlto(), actual.getAncho()));
                    Fe(this.getEntrada());
                    DFe(this.getEntrada());
                    Nivel(this.getEntrada(), 0);
                    return false;
                }
            }else{
                if(Excavacion(actual.getDer(), i, cant)){
                    actual.setDer(new Cueva(null, null, cant, materiales[i], actual.getX() + (actual.getAncho() + 100), actual.getY() + (actual.getAlto() + 70), actual.getAlto(), actual.getAncho()));
                    Fe(this.getEntrada());
                    DFe(this.getEntrada());
                    Nivel(this.getEntrada(), 0);
                    return false;
                }
            }
        }
        return false;
    }
    
    private int Fe(Cueva actual){
        if(actual == null){
            return 0;
        }
        if(actual.getIzq() == null && actual.getDer() == null){
            actual.setFe(0);
        }
        if(actual.getIzq() != null && actual.getDer() == null){
            Fe(actual.getIzq());
            actual.setFe((actual.getIzq().getFe()) + 1);
            actual.setNivel(actual.getNivel()+1);
        }
        if(actual.getIzq() == null && actual.getDer() != null){
            Fe(actual.getDer());
            actual.setFe((actual.getDer().getFe()) + 1);
        }
        if(actual.getIzq() != null && actual.getDer() != null){
            Fe(actual.getIzq());
            Fe(actual.getDer());
            actual.setFe(Math.max(actual.getIzq().getFe(), actual.getDer().getFe()) + 1);
        }
        return actual.getFe();
    }
    
    private int DFe(Cueva actual){
        if(actual == null){
            return 0;
        }
        if(actual.getFe() == 1){
            actual.setDFe(1);
        }else{
            if(actual.getIzq() == null && actual.getDer() == null){
                actual.setDFe(0);
            }else if(actual.getIzq() !=  null && actual.getDer() == null){
                actual.setDFe(actual.getIzq().getFe() + 1);
            }else if(actual.getIzq() == null && actual.getDer() != null){
                actual.setDFe(actual.getDer().getFe() + 1);
            }else{
                actual.setDFe(Math.abs(actual.getIzq().getFe() - actual.getDer().getFe()));
            }
        }
        DFe(actual.getIzq());
        DFe(actual.getDer());
        if(actual.getDFe() == 2){
            if(actual.getIzq() != null && actual.getIzq().getIzq() != null && actual.getIzq().getDer() == null){
                RotaDer(actual);
            }else if(actual.getIzq() != null && actual.getIzq().getIzq() != null && actual.getIzq().getDer() != null){
                RotaDobDer(actual);
            }else if(actual.getIzq() != null && actual.getIzq().getIzq() == null && actual.getIzq().getDer() != null){
                RotaDobDer(actual);
            }else if(actual.getDer() != null && actual.getDer().getDer() != null && actual.getDer().getIzq() == null){
                RotaIzq(actual);
            }else if(actual.getDer() != null && actual.getDer().getDer() != null && actual.getDer().getIzq() != null){
                RotaDobIzq(actual);
            }else if(actual.getDer() != null && actual.getDer().getDer() == null && actual.getDer().getIzq() != null){
                RotaDobIzq(actual);
            }
        }
        return actual.getDFe();
    }
    
    public void Imprimir(Cueva prin){
        PreOrden(prin);
    }
    
    private void PreOrden(Cueva actual){
        if(actual == null){
            return;
        }
        System.out.println(actual.getDato() + " altura: " + actual.getFe() + " Diferencia: " + actual.getDFe() + " Material: " + actual.getMaterial() + " Nivel: " + actual.getNivel());
        PreOrden(actual.getIzq());
        PreOrden(actual.getDer());
    }
    
    private Cueva RotaDer(Cueva actual){
        Cueva aux = actual.getIzq();
        actual.setIzq(aux.getDer());
        aux.setDer(actual);
        
        
        actual.setFe(Fe(actual.getIzq()) - Fe(actual.getDer()));
        DFe(actual);
        aux.setFe((Fe(aux.getIzq()) - Fe(aux.getDer())) + 1);
        DFe(aux);
        return aux;
    }
    
    private Cueva RotaIzq(Cueva actual){
        Cueva temp = actual.getDer();
        actual.setDer(temp.getIzq());
        temp.setIzq(actual);
        
        actual.setFe(Fe(actual.getIzq())-Fe(actual.getDer()));
        DFe(actual);
        temp.setFe((Fe(temp.getIzq())-Fe(temp.getDer()))+1);
        DFe(temp);
        return temp;
    }
    
    private Cueva RotaDobDer(Cueva actual){
        Cueva temp;
        actual.setIzq(RotaDer(actual.getIzq()));
        temp = RotaDer(actual);
        return temp;
    }
    
    private Cueva RotaDobIzq(Cueva actual){
        Cueva aux;
        actual.setDer(RotaDer(actual.getDer()));
        aux = RotaIzq(actual);
        return aux;
    }
    
    private void Nivel(Cueva actual,int j){
        if(actual == null){
            return;
        }
        if(actual != this.getEntrada()){
            actual.setNivel(j);
        }else{
            actual.setNivel(0);
        }
        Nivel(actual.getIzq(), j+1);
        Nivel(actual.getDer(), j+1);
    }

    public Cueva getEntrada() {
        return Entrada;
    }

    public void setEntrada(Cueva Entrada) {
        this.Entrada = Entrada;
    }

    public Cueva getActual() {
        return actual;
    }

    public void setActual(Cueva actual) {
        this.actual = actual;
    }
    
    public void pintar(Cueva Aux, Graphics g){
        if(Aux != null){
            g.drawImage(Aux.getCueva().getImage(), Aux.getX(), Aux.getY(), Aux.getAncho(), Aux.getAlto(), null);
            pintar(Aux.getIzq(), g);
            pintar(Aux.getDer(), g);
        }
    }
}
