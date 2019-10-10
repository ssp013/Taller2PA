/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.pkg1;
import ucn.*;
public class SistemaSUSTOImpl {
    public boolean contratarCientifico(String nombre, String apellidoP, String apellidoM, String Area, int costoAsociado, String proyecto, String dpto, String instalacion){
        Cientifico cientifico = new Cientifico(nombre,apellidoP,apellidoM,Area,costoAsociado,proyecto,dpto,instalacion);
        boolean ingreso = ListaCientificos.ingresarCientifico(cientifico);
        return ingreso;
    }
    public boolean crearInstalacion(String nombreInst, int cantDptos, String []listaDptos,int []listaCapacidades){
        
    }
    public boolean registrarIngreso(String instalacion,String rutCientifico,String fecha,String hora){
        for(int i=0;i<ListaCientificos.getCantCientificos;i++){
            if(ListaCientificos[i].getInstalacion.equals(instalacion)){
                if(ListaCientificos[i].getRut.equals(rutCientifico)){
                    Ingreso ingreso = new Ingreso(instalacion,rutCientifico,fecha,hora);
                    boolean registro = ListaIngresos.ingresarIngreso(ingreso);
                    return registro;
                }
                return false;
            }
            return false;    
        }
    }
    public boolean registrarSalida(String instalacion,String rutCientifico, String fecha, String hora){
        for(int i=0;i<ListaCientificos.getCantCientificos;i++)){
            if(ListaCientificos[i].getInstalacion.equals(instalacion)){
                if(ListaCientificos[i].getRut.equals(rutCientifico)){
                    Salida salida = new Salida(instalacion,rutCientifico,fecha,hora);
                    boolean registro = ListaSalidas.ingresaSalida(salida);
                    return registro;
                }
                return false;
            }
            return false;
        }
    }
    public boolean ingresar cientificoProyecto(String rutCientifico, String codProyecto)
    public boolean reasignarCientificoProyecto(String rutCientifico, String codProyecto){
        
    }
}
