
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
                StdOut.println("Departamento(s): "+dep.getNombreDpto;);
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
