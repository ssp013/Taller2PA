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
                else{
                    return false;
                }
                
            }
            else{
                return false;
            }
        }
    }
    
    
    
    
    public boolean ingresarCientificoProyecto(String rutCientifico, String codProyecto){
        AsociacionCP asociacion = new AsociacionCP(rutCliente,codProyecto);
        boolean ingreso = ListaAsociacionCP.ingresarAsociacion(asociacion);
        return ingreso;
    }
    
    
    
    public boolean ingresarCientificoInstalacion(String rutCientifico, String NombreInstalacion){
        AsociacionCI asociacion = new AsociacionCI(rutCliente,nomInstalacion);
        boolean ingreso = ListaAsociacionCI.ingresarAsociacion(asociacion);
        return ingreso;
    }
    
    
    
    
    public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN){
        //codProyectoA es el codigo del proytecto antiguo y codProyectoN es el codigo del proyecto nuevo.
        for(int i=0;i<ListaAsociacionCF.getCantidad;i++){
            if(ListaProyectos[i].equals(codProyectoA)&& ListaProyectos[i].equals(codProyectoN)){
                ListaAsociacionCF[i].setCodProyecto(codProyectoN);
                return true;
                 
            }
            else{
                return false;
            }
        }
        
    }
    
    
    
    
    public boolean reasignarCientificoInstalacion(String rutCientifico, String nomInstalacionA, String nomInstalacionN){

        for(int i=0;i<ListaAsociacionCI.getCantidad;i++){
            if(ListaInsta[i].equals(nomInstalacionA)&& ListaInsta[i].equals(nomInstalacionN)){
                ListaAsociacionCI[i].setNombreInstalacion(nomInstalacionN);
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    
    
    
    
    
    
    
    
}
