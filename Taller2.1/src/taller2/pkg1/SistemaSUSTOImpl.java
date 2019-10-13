/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.pkg1;
import ucn.*;
public class SistemaSUSTOImpl {
    private ListaCientificos listaCientificos;
    private ListaDptos listaDptos;
    private ListaProyectos listaProyectos;
    private ListaInsta listaInsta;
    private ListaIngresos listaIngresos;
    private ListaSalidas listaSalidas;
    
    
    
    public boolean contratarCientifico(String rut, String nombre, String apellidoP, String apellidoM, String Area, int costoAsociado, String []listaProyA, String dpto, String instalacion){
        
    }        
         
    public boolean crearInstalacion(String nombreInst, int cantDptos, String listaDptos,int listaCapacidades){
        
    }
    
    
    
    public boolean registrarIngreso(String instalacion,String rutCientifico,String fecha,String hora, ListaInstalacionesCient listaInstalacionesCient){
        boolean ingresoB = false;
        for(int i=0;i<listaCientificos.getCantCientificos;i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            if(cient.getRut().equals(rutCientifico)){
                //verifico que el cientifico este en la lista general de cientifico, osea exista
                for(int j=0;j<listaSalidas.getCantSalidas();j++){
                    Salida sal = listaSalidas.getSalidaI(j);
                    if(sal.getRutCientifico().equals(j)){
                        //verifico que el cientifico este afuera(no puede ingresar si no esta afuera)
                        for(int k=0;k<listaInstalacionesCient.getCantInstalacionesCient();k++){
                            Instalaciones inst = listaInstalacionesCient.getInstalacionCentI(k);
                            if(inst.getNombreInstalacion().equals(instalacion)){
                                //verifico que la instalacion este el la lista de instalaciones del cientifico. En este momento esta todo validado
                                Ingreso ingreso = new Ingreso(instalacion,rutCientifico,fecha,hora);
                                boolean registro = listaIngresos.ingresarIngreso(ingreso);
                                ingresoB = registro;    
                            }
                        }
                    }
                }
            }
            
           
              
        }
        return ingresoB;
    }
   
    public boolean registrarSalida(String instalacion,String rutCientifico, String fecha, String hora,ListaInstalacionesCient listaInstalacionesCient){
        boolean salidaB = false;
        for(int i=0;i<listaCientificos.getCantCientificos();i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            if(cient.getRut().equals(rutCientifico)){
                //verifico que el cientifico exista
                for(int j=0;j<listaIngresos.getCantIngresos();j++){
                    Ingreso ing = listaIngresos.getIngresoI(j);
                    if(ing.getRutCientifico().equals(rutCientifico)){
                        //verifico que el cientifico este adentro (no puede salir si no esta adentro)
                        for(int k=0;k<listaInstalacionesCient.getCantInstalacionesCient();k++){
                            Instalaciones inst = listaInstalacionesCient.getInstalacionCientI(k);
                            if(inst.getNombreInstalacion().equals(instalacion)){
                                //verifico que la instalacion este el la lista de instalaciones del cientifico. En este momento esta todo validado
                                Salida salida = new Salida(instalacion,rutCientifico,fecha,hora);
                                boolean registro = listaSalidas.ingresarSalida(salida);
                                salidaB = registro;

                            }
                        }
                    }
                }

            }
        }
        return salidaB;
    }
    

   
    
    public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN, ListaProyectosCient listaProyectosCient){
        boolean ingreso = false;
        for(int i=0;i<listaCientificos.getCantCientificos;i++){
            Cientifico cient = listaCientificos.getInstalacionI(i);
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
    
    
    
    
    
    
    
    
    
}
