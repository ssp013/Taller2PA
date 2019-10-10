/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.pkg1;
import ucn.*;
/**
 *
 * @author Tomas Sandoval
 */
public class Taller21 {

 public static void desplegarMenu(){
        StdOut.println(" ");
        StdOut.println("-------------------M E N U-------------------");
        StdOut.println("[1] Crear instalacion");
        StdOut.println("[2] Contratar Cientifico");
        StdOut.println("[3] Registrar ingreso");
        StdOut.println("[4] Registrar salida");
        StdOut.println("[5] Reasignar cientifico");
        StdOut.println("[6] Salir");     
    }
    public static void main(String[] args) {
        desplegarMenu();
        StdOut.println("Ingrese opcion: ");
        int op = StdIn.readInt();
        while(op!=6){
            switch(op){
                case 1:
                    
                break;
                case 2:
                
                break;
                case 3:
                    
                break;
                case 4:
                
                break;
                case 5:
                    
                break;
               
            }
            desplegarMenu();
            StdOut.println("opcion: ");
            op = StdIn.readInt();
        }
            
        
    }
    
}
