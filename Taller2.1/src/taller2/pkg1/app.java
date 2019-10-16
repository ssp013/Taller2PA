
package taller2.pkg1;
import java.text.ParseException;
import ucn.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
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
    
    public void HorasTrabajadas() throws ParseException{
       
        for(int i=0;i<listaProyectos.getCantProyectos();i++){
            Proyecto proy = listaProyectos.getProyectoI(i);
            StdOut.println("Proyecto: "+proy.getNombreProyecto());
            for(int j=0;j<listaCientificos.getCantCientificos();j++){
                Cientifico cient = listaCientificos.getCientificoI(j);
                ListaProyectosCient proy1 = cient.getListaProyectos();
                if(proy1.getDptoResponsable().equals(proy.getDptoResponsable())){
                    //si se cumple significa que el cientifico trabaja en proy1.
                    StdOut.println("Cientifico: "+cient.getNombre()+" "+cient.getApellidoP());
                    for(int k=0;k<listaIngresos.getCantIngresos();k++){
                        Ingreso ingreso = listaIngresos.getIngresoI(k);
                        String horaI = ingreso.getHora();
                        for(int l=0;l<listaSalidas.getCantSalidas();l++){
                            Salida salida = listaSalidas.getSalidaI(l);
                            String horaS = salida.getHora();
                            if(ingreso.getRutCientifico().equals(salida.getRutCientifico())){
                                boolean horaIng = false;
                                boolean horaSal = false;
                                try{
                                    LocalTime.parse(horaI);
                                    LocalTime.parse(horaS);
                                    horaIng = true;
                                    horaSal = true;
                                }catch(DateTimeParseException|NullPointerException e){
                                    StdOut.println("hora invalida");
                                }
                                if(horaIng == true && horaSal == true){
                                    String dateStart = horaI;
                                    String dateStop = horaS;
                                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                                    Date d1 = null;
                                    Date d2 = null;
                                    try{
                                        d1 = format.parse(dateStart);
                                        d2 = format.parse(dateStop);
                                        long diff = d2.getTime()-d1.getTime();
                                        long diffMinutes = diff/(60*1000)%60;
                                        long diffHours = diff/(60*60*60)%24;
                                        StdOut.println("tiempo trabajado: "+diffHours+" horas "+diffMinutes+" minutos");
                                        
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                    
                }
            }
        }
        
    }
    
    public static boolean validarHora(String hora){
        boolean valido = false;
        try{
            LocalTime.parse(hora);
            valido = true;
        }catch(DateTimeParseException|NullPointerException e){
            
        }
        return valido;
    }
    
    public static void menuRegistrarIngresoSalida(SistemaSUSTO sistema){
      
    }
    public static void main(String[]args){
        
           
        
    }
    
    
    
    

}

