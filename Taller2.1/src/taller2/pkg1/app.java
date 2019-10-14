
package taller2.pkg1;
import ucn.*;
public class app {
    public static void main(String[]args){
        
        ListaProyectos listaP = returnListaProyectos();
        ListaCientificos listaC = returnListaCient();
        StdOut.println("ingrese codigo proyecto: ");
        String code = StdIn.readString();
        for(int i=0;i<listaP.getCantProyectos();i++){
            Proyecto proy = listaP.getProyectoI(i);
            if(proy.getCodigoProyecto.equals(code)){
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
            }
        }
                
               
        
    }
    
    

}
