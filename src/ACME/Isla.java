/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


/**
 *
 * @author Jose Cruz
 */
public class Isla {
    String[] materiales = {"Oro","Bronce","Plata","Madera","Piedra"};
    private Cueva Entrada;
    boolean pass = true;
    boolean pass1 = true;
    int dato;
    int i = 0;
    int n = 0;
    int mayor = 0;
    int BenTot = 0;
    LinkedList<Cueva> cuevas = new LinkedList<>();
    Cueva ant;
    Cueva ant2;
    
    public Isla(){
    }
    
    public void EntraCueva(float cant) throws Exception{
        //GeneradorDOM generadorDOM = new GeneradorDOM();
        if (this.getEntrada() == null) {
            this.setEntrada(new Cueva(null, null, cant, materiales[i], 560, 30, 40, 40, 1));
            //generadorDOM.agregarCuevas(cant, materiales[i]);
            this.i = i + 1;
        }else{
            if(this.i > materiales.length - 1){
                this.i = 0;
            }
            Cueva nuevo = new Cueva(null, null, cant, materiales[i], 0, 0, 40, 40, 0);
            //generadorDOM.agregarCuevas(cant, materiales[i]);
            this.setEntrada(insertarAVL(nuevo,this.getEntrada()));
            setPositions(this.getEntrada(), 1, null, 0);
            Nivel(this.getEntrada(),0);
            this.i = i + 1;
        }
    }
    
     public void EntraXML(int cant, String mater){
         if(this.getEntrada() == null){
             this.setEntrada(new Cueva(null, null, cant, mater, 560, 30, 40, 40, 1));
         }else{
             Cueva nuevo = new Cueva(null, null, cant, mater, 0, 0, 40, 40, 0);
             this.setEntrada(insertarAVL(nuevo, this.getEntrada()));
             setPositions(this.getEntrada(), 1, null, 0);
             Nivel(this.getEntrada(), 0);
         }
     }
     
     public Cueva insertarAVL(Cueva nuevo,Cueva subAr){
        if (nuevo.getDato()<subAr.getDato()){
            if (subAr.getIzq()==null) {
                subAr.setIzq(nuevo);
            }else{
                subAr.setIzq(insertarAVL(nuevo,subAr.getIzq()));
                if ((Fe(subAr.getIzq())+1)-(Fe(subAr.getDer())+1)==2){
                    if (nuevo.getDato()<subAr.getIzq().getDato()){
                        subAr=RotaDer(subAr);
                    }else{
                        subAr=RotaDobDer(subAr);
                    }
                }
            
            }
        }else if(nuevo.getDato()>=subAr.getDato()){
            if (subAr.getDer()==null) {
                subAr.setDer(nuevo);
            }else{
                subAr.setDer(insertarAVL(nuevo,subAr.getDer()));
                if ((Fe(subAr.getDer())+1)-(Fe(subAr.getIzq())+1)==2){
                    if (nuevo.getDato()>subAr.getDer().getDato()){
                        subAr=RotaIzq(subAr);
                    }else{
                        subAr=RotaDobIzq(subAr);
                    }
                }
            }
        }
        Fe(subAr);
        return subAr;
    }
    
    private int Fe(Cueva actual){
        if(actual == null){
            return -1;
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
    
    private void setPositions(Cueva actual, int i, Cueva ant, int j){
        if(actual != null){
            switch (i) {
                case 1:
                    actual.setX(560);
                    actual.setY(30);
                    actual.setN(1);
                    this.n = actual.getN() + 1;
                    ant = actual;
                    break;
                case 0:
                    actual.setX(ant.getX() - (330 - j));
                    actual.setY(ant.getY() + 100);
                    actual.setN(this.n);
                    this.n = actual.getN() + 1;
                    ant = actual;
                    break;
                default:
                    actual.setX(ant.getX() + (330 - j));
                    actual.setY(ant.getY() + 100);
                    actual.setN(this.n);
                    this.n = actual.getN() + 1;
                    ant = actual;
                    break;
            }
            setPositions(actual.getIzq(), 0, ant, j+90);
            setPositions(actual.getDer(), 2, ant, j+90);
        }
    }
    
    private Cueva RotaDer(Cueva actual){
        Cueva aux = actual.getIzq();
        actual.setIzq(aux.getDer());
        aux.setDer(actual);
        
        actual.setFe(Fe(actual.getIzq()) - Fe(actual.getDer()));
        //DFe(actual);
        aux.setFe((Fe(aux.getIzq()) - Fe(aux.getDer())) + 1);
        //DFe(aux);
        return aux;
    }
    
    private Cueva RotaIzq(Cueva actual){
        Cueva temp = actual.getDer();
        actual.setDer(temp.getIzq());
        temp.setIzq(actual);
        
        actual.setFe(Fe(actual.getIzq())-Fe(actual.getDer()));
        //DFe(actual);
        temp.setFe((Fe(temp.getIzq())-Fe(temp.getDer()))+1);
        //DFe(temp);
        return temp;
    }
    
    private Cueva RotaDobDer(Cueva actual){
        Cueva temp;
        actual.setIzq(RotaIzq(actual.getIzq()));
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
    
    public void Eliminar(int n){
        LinkedList<Cueva> Lista = new LinkedList<>();
        this.setEntrada(Elim(this.getEntrada(), n));
        Lista = Balance(this.getEntrada(), Lista);
        this.setEntrada(null);
        for(Cueva c : Lista){
            EntraXML((int) c.getDato(), c.getMaterial());
        }
    }
    
    public LinkedList<Cueva> Balance(Cueva Padre, LinkedList<Cueva> lista){
        if(Padre != null){
            lista.add(Padre);
            Balance(Padre.getIzq(), lista);
            Balance(Padre.getDer(), lista);
        }
        return lista;
    }
    
    public Cueva Elim(Cueva actual, int n){
        if(actual != null){
            if(actual.getN() == n ){
                if(actual.getIzq() == null && actual.getDer() == null){
                    actual = ElimHoja(actual);
                }else if(actual.getIzq() != null && actual.getDer() != null){
                }else{
                    actual = EliNodo1Hijo(actual);
                }
            }else{
                actual.setIzq(Elim(actual.getIzq(), n));
                actual.setDer(Elim(actual.getDer(), n));
            }
        }
        return actual;
    }
    
    private Cueva ElimHoja(Cueva Padre){
        if(Padre != null){
            if(Padre.getIzq() == null && Padre.getDer() == null){
                Padre = null;
            }else{
                Padre.setIzq(ElimHoja(Padre.getIzq()));
                Padre.setDer(ElimHoja(Padre.getDer()));
            }
        }
        return Padre;
    }
    //b) Eliminar nodo con un hijo.
    private Cueva EliNodo1Hijo(Cueva Padre){ 
        if(Padre != null){
            if(Padre.getIzq() != null && Padre.getDer() == null || Padre.getIzq() == null && Padre.getDer() != null){
                if(Padre.getIzq() != null){
                    Padre = Padre.getIzq();
                }else{
                    Padre = Padre.getDer();
                }
            }else{
                Padre.setIzq(EliNodo1Hijo(Padre.getIzq()));
                Padre.setDer(EliNodo1Hijo(Padre.getDer()));
            }
        }
        return Padre;
    }
    
    public Cueva getEntrada() {
        return this.Entrada;
    }

    public void setEntrada(Cueva Entrada) {
        this.Entrada = Entrada;
    }
    
    public int MasMat(Cueva Padre){
        if(Padre != null){
            if(Padre.getDato() > this.mayor){
                this.mayor = (int) Padre.getDato();
            }
            this.mayor = MasMat(Padre.getIzq());
            this.mayor = MasMat(Padre.getDer());
        }
        return this.mayor;
    }
  
    public int MasBen(Cueva Padre){
        if(Padre != null){
            if((Padre.getBeneficio()*(Padre.getDato()/100)) > this.BenTot){
                this.BenTot = (int)Padre.getDato();
            }
            this.BenTot = MasBen(Padre.getIzq());
            this.BenTot = MasBen(Padre.getDer());
        }
        return this.BenTot;
    }
    
    public LinkedList<Cueva> getCuevas(Cueva Padre){
        if(Padre != null){
            cuevas.add(Padre);
            getCuevas(Padre.getIzq());
            getCuevas(Padre.getDer());
        }
        return cuevas;
    }
    
    public void pintar(Cueva Aux, Graphics g){
        if(Aux != null){
                g.drawString("CUEVA MAYOR GANANCIA", 1000,90);
                g.setColor(Color.GREEN);
                g.fillRect(1045, 95, 60, 40);
                g.setColor(Color.black);
                g.drawString("CUEVA MAYOR MATERIAL", 1000,30);
                g.setColor(Color.BLUE);
                g.fillRect(1045, 35, 60, 40);
                g.setColor(Color.black);
            if(Aux.getDer() != null || Aux.getIzq() != null){
                Camino v = new Camino(Aux.getX()+12, Aux.getY() + Aux.getAlto()/2, 20, 100, "../Iconos/camino2.png");
                g.drawImage(v.getCueva().getImage(), v.getX(), v.getY(), v.getH(), v.getA(), null);
                if(Aux.getIzq() != null){
                    Camino h1 = new Camino((Aux.getIzq().getX()+Aux.getAncho()/2),Aux.getIzq().getY() , Aux.getX()-Aux.getIzq().getX(), 20, "../Iconos/camino.png");
                    g.drawImage(h1.getCueva().getImage(), h1.getX(), h1.getY(), h1.getH(), h1.getA(), null);
                }
                if(Aux.getDer() != null){
                    Camino h2 = new Camino(Aux.getDer().getX()+Aux.getAncho()/2, Aux.getDer().getY(), Aux.getX()-Aux.getDer().getX(), 20, "../Iconos/camino.png");
                    g.drawImage(h2.getCueva().getImage(), h2.getX(), h2.getY(), h2.getH(), h2.getA(), null);
                }
            }
            g.drawString(Aux.getN() + ")."+Aux.getMaterial() + ": " + (int)Aux.getDato(), Aux.getX() - 10, Aux.getY() - 5);
            if(Aux == this.ant && Aux.getDer() != null){
                Aux.setCueva("../Iconos/Cueva.png");
            }
            if(Aux.getDato() == MasMat(this.getEntrada())){
                this.ant = Aux;
                Aux.setCueva("../Iconos/CuevaM.png");
            }
            if(Aux == this.ant2 && MasBen(this.getEntrada()) != Aux.getDato()){
                Aux.setCueva("../Iconos/Cueva.png");
            }
            if(Aux.getDato() == MasBen(this.getEntrada())){
                this.ant2 = Aux;
                Aux.setCueva("../Iconos/CuevaMB.png");
            }
            g.drawImage(Aux.getCueva().getImage(), Aux.getX(), Aux.getY(), Aux.getAncho(), Aux.getAlto(), null);
            pintar(Aux.getIzq(), g);
            pintar(Aux.getDer(), g);
        }
    }
}












