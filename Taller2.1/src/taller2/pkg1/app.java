
package taller2.pkg1;
import ucn.*;
public class app {
    public void ListadoPersonalInsta(sistemaSUSTO sistema){
        ListaProyectos listaP = returnListaProyectos();
        ListaCientificos listaC = returnListaCient();
        ListaDptos ListaD = returnListaDptos();
        ListaInsta ListaI = returnListaInsta();
        
        for(int i=0;i<ListaI.getCantInsta();i++){
            Instalaciones insta = ListaI.getInstalacionI(i);
            StdOut.println("Instalacion: "+insta.getNombreInstalacion());
            ListaDepartamentoInstalacion listaDepaIn = insta.getListaDepartamentoInstalacion();
            for(int j=0;j<listaDepaIn.getCantDeptos();j++){
                Departamendo dep = listaDepaIn.getDepartamentoI(j);
                StdOut.println("Departamento(s): "+dep.getNombreDpto());
                for(int k=0;k<listaP.getCantProyectos();k++){
                    Proyecto proy = listaP.getProyectoI(k);
                    if(proy.getDptoResponsable().equals(dep.getNombreDpto())){
                        StdOut.println("Proyecto(s): "+proy.getNombreProyecto());
                        for(int l=0;l<listaC.getCantCientificos();l++){
                            Cientifico cient = listaC.getCientificoI(l);
                            ListaProyectosCient listaProyC = cient.getListaProyectosCient();
                            for(int m=0;m<listaProyC.getCantProyectosCient();m++){
                                Proyecto proy1 = listaProyC.getProyectoCientI(m);
                                if(proy1.getNombreProyecto().equals(proy.getNombreProyecto())){
                                    StdOut.println("Personal: "+cient.getNombre()+" "+cient.getApellidoP());
                                }
                            }
                        }
                    }
                }
            }
            
        }
        
    }
    public void ListadoPersonasDpto(SistemaSUSTO sistema){
        ListaProyectos listaP = sistema.returnListaProyectos();
        ListaCientificos listaC = sistema.returnListaCient();
        ListaDptos ListaD = sistema.returnListaDptos();     
        for(int i=0;i<ListaD.getCanDptos();i++){
            Departamento dep = ListaD.getDepartamentoI(i);
            StdOut.println("Departamento: "+dep.getNombreDpto());
            for(int j=0;j<listaP.getCantProyectos();j++){
                Proyecto proy = listaP.getProyectoI(j);
                if(dep.getNompreDepto().equals(proy.getDptoEncargado())){
                    StdOut.println("Proyecto(s): "+proy.getNombreProyecto());
                    for(int k=0;k<listaC.getCantCientificos();k++){
                        Cientifico cient = listaC.getCientificoI(k);
                        ListaProyectosCient LPC = cient.getListaProyectosCient();
                        for(int l=0;l<LPC.getCantProyectosCient();l++){
                            Proyecto proy1 = LPC.getProyectoCientI();
                            if(proy1.getNombreProyecto.equals(proy.getNombreProyecto())){
                                StdOut.println("Personal: "+ cient.getNombre()+" "+cient.getApellidoP());
                            }
                        }
                    }
                }
            }
        }
    } 
    public void CostosPorProyecto(SistemaSUSTO sistema){
        ListaProyectos listaP = sistema.returnListaProyectos();
        ListaCientificos listaC = sistema.returnListaCient();
        StdOut.println("Ingrese codigo del proyecto: ");
        String code = StdIn.readString();
        (for int i=0;i<listaP.getCantProyectos;i++){
            Proyecto proy = listaP.getProyectoI(i);
            if(proy.getCodigoProyecto().equals(code)){
                //validamos que el proyecto existe
                StdOut.println("Proyecto "+proy.getNombreProyecto()+" Presupuesto Total: "+proy.getPresupuestoTotal());
                for(int j=0;j<listaC.getCantCientificos();j++){
                    //recorro la lista general de cientificos y saco su lista de proyectos
                    Cientifico cient = listaC.getCientificoI(j);
                    ListaProyectosCient lista = cient.getListaProyectosCient();
                    for(int k=0;k<lista.getCantProyectosCient();k++){
                        //veo que cientificos trabajan en este proyecto e imprimo su nombre y costo asociado
                        Proyecto proy1 = lista.getProyectoCientI(k);
                        if(proy1.getCodigoProyecto().equals(code)){
                            StdOut.println("cientifico: "+cient.getNombre()+", costo Asociado: "+cient.getCostoAsociado());
                        }
                    }
                }
            }
            else{
                StdOut.println("Proyecto no encontrado");
            }
        }
             
    }
    
    
    
    
    public static void main(String[]args){
        
        ListaProyectos listaP = returnListaProyectos();
        ListaCientificos listaC = returnListaCient();
        ListaDptos ListaD = returnListaDptos();
        ListaInsta ListaI = returnListaInsta();
        for(int i=0;i<listaP.getCantProyectos();i++){
            Proyecto proy = listaP.getProyectoI(i);
            StdOut.println("Proyecto: "+proy.getNombreProyecto());
            for(int j=0;j<ListaC.getCantCientificos();j++){
                Cientifico cient = ListaC.getCientificoI(j);
                String nombre = cient.getNombre();
                String ApellidoP = cient.getApellidoP();
                ListaProyectosCient LPC = cient.getListaProyectosCient;
                for(int k=0;k<LPC.getCantProyectosCient;k++){
                    Proyecto proy1 = LPC.getProyectoCientI(k);
                    if(proy1.getNombreProyecto().equals(proy.getNombreProyecto())){
                        StdOut.println(nombre+" "+ApellidoP);
                    }
                }
            }
            
        }//FIN DEL PRIMERO FOR
        
       
            
        
        
           
        
    }
    
    
    
    

}
