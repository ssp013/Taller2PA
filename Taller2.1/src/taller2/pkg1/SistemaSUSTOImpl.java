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
    private ListaAsociacionCP listaAsociacionCP;
    private ListaAsociacionCI listaAsociacionCI;
    private ListaIngresos listaIngresos;
    private ListaSalidas listaSalidas;

    public SistemaSUSTOImpl(ListaCientificos listaCientificos, ListaDptos listaDptos, ListaProyectos listaProyectos, ListaInsta listaInsta, ListaAsociacionCP listaAsociacionCP, ListaAsociacionCI listaAsociacionCI, ListaIngresos listaIngresos, ListaSalidas listaSalidas) {
        this.listaCientificos = listaCientificos;
        this.listaDptos = listaDptos;
        this.listaProyectos = listaProyectos;
        this.listaInsta = listaInsta;
        this.listaAsociacionCP = listaAsociacionCP;
        this.listaAsociacionCI = listaAsociacionCI;
        this.listaIngresos = listaIngresos;
        this.listaSalidas = listaSalidas;
    }
    

    
    
    
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
                    boolean registro = ListaSalidas.ingresarSalida(salida);
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
        AsociacionCP asociacion = new AsociacionCP(rutCientifico,codProyecto);
        boolean ingreso = listaAsociacionCP.ingresarAsociacionCP(asociacion);
        return ingreso;
    }
    
    
    
    public boolean ingresarCientificoInstalacion(String rutCientifico, String NombreInstalacion){
        AsociacionCI asociacion = new AsociacionCI(rutCientifico,NombreInstalacion);
        boolean ingreso = listaAsociacionCI.ingresarAsociacionCI(asociacion);
        return ingreso;
    }
    
    
    
    
    public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN){
        //codProyectoA es el codigo del proytecto antiguo y codProyectoN es el codigo del proyecto nuevo.
        for(int i=0;i<ListaAsociacionCP.getCantAsociacionesCP;i++){
            if(ListaAsociacionCP[i].getRutCientifico.equals(rutCientifico)&& ListaAsociacionCP[i].getCodigoProyecto.equals(codProyectoA)){
                for(int j=0;j<ListaProyectos.getCantProyectos;j++){
                    if(ListaProyectos[i].equals(codProyectoN)){
                        ListaAsociacionCP[i].setCodigoProyecto(codProyectoN);
                        return true;
                    }
                    else{
                        return false;
                    }
                    
                }
                return true;
            }
            else{
                return false;
            }
        }
        
    }
    
    
    
    
    public boolean reasignarCientificoInstalacion(String rutCientifico, String nomInstalacionA, String nomInstalacionN){
        for(int i=0;i<listaAsociacionCI.getCantAsociacionesCI;i++){
            if(listaAsociacionCI[i].getRutCientifico.equals(rutCientifico)&& listaAsociacionCI[i].getNombreInstalacion.equals(nomInstalacionA)){
                for(int j=0;j<ListaInsta.getCantInsta;i++){
                    if(listaInsa[i].equals(nomInsalacionN)){
                        listaAsociacionCI.setNombreInstalacion(nomInstalacionN);
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                return true;
            }
            else{
                return false;
            }
            
        }
        
        
    }
    
    
    
    
    
    
    
    
    
}
