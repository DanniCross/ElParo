/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACME.principal;

//import ACME.Isla;
//import java.util.*;
import ACME.view.*;
/**
 *
 * @author Jose Cruz
 */
public class ACME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Animacion anim = new Animacion();
        anim.setVisible(true);
        /*Scanner scan = new Scanner(System.in);
        Isla isla = new Isla();
        int cantidad = 100; //cantidad de materiales
        char pass ='Y';
        
        while(pass == 'Y'){
            System.out.println("¿Excavacion nueva?");
            pass = scan.next().charAt(0);
            pass = MinToMay(pass);
            if(pass != 'Y'){
                break;
            }
            isla.EntraCueva(cantidad);
        }
        isla.Imprimir();*/
        
    }
    
    /*public static char MinToMay(char pass){
        char camb1 = 'A';
        char camb2 = 'a';
        for(char i ='a'; i <= 'z'; i++){
            if(pass == camb2){
                pass = camb1;
                i = 'z';
            }
            camb1++;
            camb2++;
        }
        return pass;
    }*/
}
