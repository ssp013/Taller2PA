/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.pkg1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import ucn.*;
public class SistemaSUSTOImpl{
    private ListaCientificos listaCientificos;
    private ListaDptos listaDptos;
    private ListaProyectos listaProyectos;
    private ListaInsta listaInsta;
    private ListaIngresos listaIngresos;
    private ListaSalidas listaSalidas;
    
    
    
    public boolean contratarCientifico(String rut, String nombre, String apellidoP, String apellidoM, String Area, int costoAsociado, String []listaProyA, String dpto, String instalacion){
        
    }        
         
    public boolean crearInstalacion(String NombreInstalacion, int CantidadDptos){
        boolean creado = false;
        Instalaciones insta = new Instalaciones(NombreInstalacion, CantidadDptos);
        boolean f = listaInsta.ingresarInsta(insta);
        if(f){
            creado = true;
        }
        return creado; 
    }
    
    public boolean registrarIngreso(String instalacion,String rutCientifico,String fecha,String hora){
        boolean ingresoB = false;
        Salida sal = listaSalidas.buscarSalida(rutCientifico);
        if(sal!=null){
            Instalaciones insta = listaInsta.buscarInsta(instalacion);
            Cientifico cient = listaCientificos.buscarCient(rutCientifico);
            if(insta != null && cient != null){
                ListaProyectosCient LPC = cient.getListaProyectosCient();
                for(int i=0;i<LPC.getCantProyectosCient();i++){
                    Proyecto proy = LPC.getProyectoCientI(i);
                    String dptoAsociado = proy.getDptoResponsable();
                    ListaDepartamentoInstalacion LDI = insta.getListaDepartamentoInstalacion();
                    Departamento deptoEncontrado = LDI.buscarDptoInstalacion(dptoAsociado);
                    if(deptoEncontrado!=null){
                        String nombreDeptoEncontrado = deptoEncontrado.getNombreDpto();
                        if(nombreDeptoEncontrado.equals(dptoAsociado)){
                            Ingreso ingresoNuevo = new Ingreso (instalacion,rutCientifico,fecha,hora);
                            boolean registro = listaIngreso.agregarIngreso(ingresoNuevo);
                            ingresoB = registro;
                        }
                    }
                            
                }
            }
                
                
            
        }  
        return ingresoB;
            
                  
    }
   
    public boolean registrarSalida(String instalacion,String rutCientifico, String fecha, String hora){
        boolean ingresoB = false;
        Ingreso ing = listaIngresos.buscarIngreso(rutCientifico);
        if(ing!=null){
            Instalaciones insta = listaInsta.buscarInsta(instalacion);
            Cientifico cient = listaCientificos.buscarCient(rutCientifico);
            if(insta != null && cient != null){
                ListaProyectosCient LPC = cient.getListaProyectosCient();
                for(int i=0;i<LPC.getCantProyectosCient();i++){
                    Proyecto proy = LPC.getProyectoCientI(i);
                    String dptoAsociado = proy.getDptoResponsable();
                    ListaDepartamentoInstalacion LDI = insta.getListaDepartamentoInstalacion();
                    Departamento deptoEncontrado = LDI.buscarDptoInstalacion(dptoAsociado);
                    if(deptoEncontrado!=null){
                        String nombreDeptoEncontrado = deptoEncontrado.getNombreDpto();
                        if(nombreDeptoEncontrado.equals(dptoAsociado)){
                            Salida nuevaSalida = new Salida (instalacion,rutCientifico,fecha,hora);
                            boolean registro = listaSalidas.ingresarSalida(nuevaSalida);
                            ingresoB = registro;
                        }
                    }
                            
                }
            }
                
                
            
        }  
        return ingresoB;
    }
    
    public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN, ListaProyectosCient listaProyectosCient){
        boolean ingreso = false;
        for(int i=0;i<listaCientificos.getCantCientificos;i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            if(cient.getRut().equals(rutCientifico)){
                //verifico que el cientifico si esta en la lista de cientificos
                for(int j=0;j<listaProyectosCient.getCantProyectosCient();j++){
                    Proyecto proy = listaProyectosCient.getProyectoCientI(j);
                    if(proy.getCodProyecto().equals(codProyectoA)){
                        //verifico que el proyecto antiguo este en la lista de proyectos del cientifico
                        for(int k=0;k<listaProyectos.getCantProyectos;k++){
                            Proyecto proy1 = listaProyectos.getProyectoI(k);
                            if(proy1.getCodProyecto().equals(codProyectoN)){
                                //verifico que el proyecto nuevo este en la lista general de proyectos, osea que exista. En este momento estaria todo validado
                                proy.setCodProyecto(codProyectoN);
                                ingreso = true;
                                
                            }
                            
                        }
                        
                    }
                    
                    
                }
                
            }
            
                      
        }
        return ingreso;
    }
   
    public boolean reasignarCientificoInstalacion(String rutCientifico, String nomInstalacionA, String nomInstalacionN, ListaInstalacionesCient listaInstalacionesCient){
        boolean ingreso = false;
        for(int i=0;i<listaCientificos.getCantCientificos();i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            if(cient.getRutCientifico().equals(rutCientifico)){
                //verifico si esque el cientifico esta en la lista general de cientificos, osea exista
                for(int j=0;j<listaInstalacionesCient.getCantInstalacionesCient();j++){
                    Instalaciones insta = listaInstalacionesCient.getInstalacionCientI(j);
                    if(insta.getNombreInstalacion().equals(nomInstalacionA)){
                        //verifico que la instalacion antigua este en la lista de instalaciones de instalaciones
                        for(int k=0;k<listaInsta.getCantInsta();k++){
                            Instalaciones insta1 = listaInsta.getInstalacionI(i);
                            if(insta1.getNombreInstalacion().equals(nomInstalacionN)){
                                //verifico que la nueva instalacion este en la lista general de instalaciones, osea exista. En este momento estaria todo validado
                                insta.setNombreInstalacion(nomInstalacionN);
                                ingreso = true;
                            }
                           
                        }
                    }
                }
            }
        }
        return ingreso;
    }
    
    public boolean crearDpto(String nomDpto,int capacidad, int presupuesto){
        boolean resp = false;
        boolean dpto = listaDpto.buscarDpto(nomDpto);
        if(dpto){
            return resp;
        } 
        else {
            Departamento dpto1 = new Departamento(nomDpto,capacidad,presupuesto);
            listaDptos.ingresarDpto(dpto1);
            resp = true;
        }
        return resp;
    }
    
    public ListaProyectos returnListaProyectos(){
        return listaProyectos;
    }
    
    public ListaInsta returnListaInsta(){
        return listaInsta;
    }
    
    public ListaDptos returnListaDptos(){
        return listaDptos;
    }
    
    public ListaCientificos returnListaCient(){
        return listaCientificos;
    }
    
    
    
    
    
    
}
