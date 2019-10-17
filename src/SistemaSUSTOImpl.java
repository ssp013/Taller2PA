import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import ucn.*;
/**
 * @author Tomas Sandoval  - Sebastian Sanchez
 */
public class SistemaSUSTOImpl implements SistemaSUSTO {
	private ListaCientificos listaCientificos;
	private ListaDptos listaDptos;
	private ListaProyectos listaProyectos;
	private ListaInsta listaInsta;
	private ListaIngresos listaIngresos;
	private ListaSalidas listaSalidas;
	private String dateFormat;
	private ListaInstalacionDepartamento listaInstalacionDepartamento;
	private ListaAreaEspecializacion listaAreaEspecializacion;
	private ListaProyectosCient listaProyectosCient;
    public SistemaSUSTOImpl(){//Son listas globales debemos inicializarlas:
    	listaInsta = new ListaInsta(1000);
    	listaDptos = new ListaDptos(1000);
    	listaCientificos = new ListaCientificos(1000);
    	listaProyectos = new ListaProyectos(1000);
    	listaIngresos= new ListaIngresos(1000);
    	listaSalidas = new ListaSalidas(1000);
    	listaAreaEspecializacion = new ListaAreaEspecializacion(1000);
    }	
	@Override
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos,ListaDepartamentoInstalacion listaNuevaDepto){
	    boolean creado = false;
	    Instalaciones insta = new Instalaciones(NombreInstalacion, CantidadDptos);
	    insta.setListaDepartamentoInstalacion(listaNuevaDepto);
	    boolean f = listaInsta.ingresarInsta(insta);
	    if(f){
	        creado = true;
	    }
	    return creado; 
	}
	@Override
    public boolean crearDpto(String nomDpto,int capacidad, int presupuesto){
        boolean resp = false;
        Departamento dpto = listaDptos.buscarDpto(nomDpto);
        if(dpto==null) {
        	Departamento deptoNuevo = new Departamento(nomDpto,capacidad,presupuesto);
        	resp = listaDptos.ingresarDpto(deptoNuevo);
        }
        return resp;
    }
	@Override
    public boolean RegistrarIngreso(String instalacion,String rutCientifico,String fecha,String hora){
        boolean ingresoB = false;
        Salida sal = listaSalidas.buscarSalida(rutCientifico);
        if(sal!=null){
            Instalaciones insta = listaInsta.buscarInsta(instalacion);
            Cientifico cient = listaCientificos.buscarCientifico(rutCientifico);
            if(insta != null && cient != null){
                ListaProyectosCient LPC = cient.getListaProyectos();
                for(int i=0;i<LPC.getCantProyecto();i++){
                    Proyecto proy = LPC.getProyectoI(i);
                    String dptoAsociado = proy.getDptoResponsable();
                    ListaDepartamentoInstalacion LDI = insta.getListaDepartamentoInstalacion();
                    Departamento deptoEncontrado = LDI.buscarDptoInstalacion(dptoAsociado);
                    if(deptoEncontrado!=null){
                        String nombreDeptoEncontrado = deptoEncontrado.getNombreDpto();
                        if(nombreDeptoEncontrado.equals(dptoAsociado)){
                            Ingreso ingresoNuevo = new Ingreso (instalacion,rutCientifico,fecha,hora);
                            boolean registro = listaIngresos.ingresarIngreso(ingresoNuevo);
                            ingresoB = registro;
                        }
                    }
                            
                }
            }
        }  
        return ingresoB;         
    }
    @Override
    public boolean RegistrarSalida(String instalacion,String rutCientifico, String fecha, String hora){
        boolean ingresoB = false;
        Ingreso ing = listaIngresos.buscarIngreso(rutCientifico);
        if(ing!=null){
            Instalaciones insta = listaInsta.buscarInsta(instalacion);
            Cientifico cient = listaCientificos.buscarCientifico(rutCientifico);
            if(insta != null && cient != null){
                ListaProyectosCient LPC = cient.getListaProyectos();
                for(int i=0;i<LPC.getCantProyecto();i++){
                    Proyecto proy = LPC.getProyectoI(i);
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
	@Override
	public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN){
        boolean ingreso = false;
        for(int i=0;i<listaCientificos.getCantCientificos();i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            ListaProyectosCient listaProyectosCient = cient.getListaProyectos();
            if(cient.getRut().equals(rutCientifico)){
                //verifico que el cientifico si esta en la lista de cientificos
                for(int j=0;j<listaProyectosCient.getCantProyecto();j++){
                	//StdOut.print(listaProyectosCient.getProyectoI(j).getNombreProyecto());
                    Proyecto proy = listaProyectosCient.getProyectoI(j);
                    if(proy.getCodigoProyecto().equals(codProyectoA)){
                        //verifico que el proyecto antiguo este en la lista de proyectos del cientifico
                        for(int k=0;k<listaProyectos.getCantProyectos();k++){
                            Proyecto proy1 = listaProyectos.getProyectoI(k);
                            if(proy1.getCodigoProyecto().equals(codProyectoN)){
                                //verifico que el proyecto nuevo este en la lista general de proyectos, osea que exista. En este momento estaria todo validado
                                proy.setCodigoProyecto(codProyectoN);
                                ingreso = true;
                                
                            }
                            
                        }
                        
                    }
                    
                    
                }
                
            }
            
                      
        }
        return ingreso;
    }		
	@Override
	public boolean reasignarCientificoInstalacion(String rutCientifico, String nomInstalacionA, String nomInstalacionN){
        boolean ingreso = false;
        for(int i=0;i<listaCientificos.getCantCientificos();i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            if(cient.getRut().equals(rutCientifico)){
            //verifico si esque el cientifico esta en la lista general de cientificos, osea exista
                    //verifico que la instalacion antigua este en la lista de instalaciones de instalaciones
            	for(int k=0;k<listaInsta.CantInsta();k++){
                    Instalaciones insta1 = listaInsta.getInstI(i);
                    if(insta1.getNombreInstalacion().equals(nomInstalacionN)){
                        //verifico que la nueva instalacion este en la lista general de instalaciones, osea exista. En este momento estaria todo validado
                        insta.setNombreInstalacion(nomInstalacionN);
                        ingreso = true;
                     }
                           
                 }
            }
        }
        return ingreso;
    }
	@Override
	public boolean isValid(String dateStr) {
		try {//"dd/MM/yyyy")
			String[] partes = dateStr.split("/");
			int year = Integer.parseInt(partes[2]);                
			int month =Integer.parseInt(partes[1]);                      
			int dayOfMonth = Integer.parseInt(partes[0]);       
			
			
			if (year < 1900) {
				return false;//año invalido.
			}
			else {
				LocalDate today = LocalDate.of(year, month, dayOfMonth);//tira un false..
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String ingresada = formatter.format(today);
				LocalDateTime now = LocalDateTime.now(); 
				String fecha = formatter.format(now);
				if(fecha.equals(ingresada)) {
					return true;
				}else {
					return false;
				}

				
			}
		}
		catch(java.time.DateTimeException e) {
			return false;
		}
		
	}
	@Override
	public boolean ContratarCientifico(String rut, String nombre, String apellidoP, String apellidoM, String AreaEspecializacion,
			int costoAsociado,ListaProyectosCient listaProyectoCientificoIngresado, String dpto, String instalacion) {
		boolean contratar = false;
		Cientifico cientifico = new Cientifico (rut,nombre,apellidoP,apellidoM,
				AreaEspecializacion,costoAsociado);
		
		//verificar si los proyectos son compatibles con los deptos e instalaciones de estos.
		Instalaciones InstaExiste = listaInsta.buscarInsta(instalacion);
		if(InstaExiste!=null) {//Existe la Instlacion
			ListaDepartamentoInstalacion listaDepatosInsta = InstaExiste.getListaDepartamentoInstalacion();
			Departamento deptoExiste = listaDepatosInsta.buscarDptoInstalacion(dpto);
			if(deptoExiste!=null) {//Existe el departamento:
				int capa = deptoExiste.getCapacidadDpto();
				int presupuesto = deptoExiste.getPresupuesto();
				if(capa>0 && presupuesto>=costoAsociado) {
					listaCientificos.ingresarCientifico(cientifico);
					int resta = presupuesto- costoAsociado;
					int capaReal = capa -1;
					deptoExiste.setCapacidadDpto(capaReal);
					deptoExiste.setPresupuesto(resta);
					contratar = true;								
								}
							}
						
		}
		for(int k=0;k<listaCientificos.getCantCientificos();k++) {
			StdOut.println(listaCientificos.getCientificoI(k).getNombre());
		}
					
				
		return contratar;
	}
	@Override
	public boolean CargarInstalaciones(String nombreInstalacion,int cantDepartamentos,ListaDepartamentoInstalacion listaNuevaDI) {
		boolean resultado = false;
		Instalaciones instaNueva = new Instalaciones(nombreInstalacion,cantDepartamentos);
		resultado = listaInsta.ingresarInsta(instaNueva);
		instaNueva.setListaDepartamentoInstalacion(listaNuevaDI);
		return resultado;
	}
	@Override
	public boolean CargarProyectos(String CodigoProyecto,String NombreProyecto,int PresupuestoTotal,String DptoResponsable,int CantAreasEspecializacion,ListaAreaEspecializacion listaEspecializacion1 ) {
		boolean respuesta = false;
		Proyecto proyectoNuevo = new Proyecto(CodigoProyecto, NombreProyecto, PresupuestoTotal, DptoResponsable, CantAreasEspecializacion, listaEspecializacion1);
		respuesta = listaProyectos.ingresarProyecto(proyectoNuevo);
		for(int a =0;a<listaEspecializacion1.getcantArea();a++) {
			AreaEspecializacion area = listaEspecializacion1.getAreaEspecializacionI(a);
			AreaEspecializacion areaBuscada =  listaAreaEspecializacion.buscarEspecializacion(area.getNombre());
			if(areaBuscada==null) {
				listaAreaEspecializacion.ingresarEspecializacion(area);
			}
		}
		return respuesta;
	}
	@Override
	public boolean CargarCientifico(String Rut, String Nombre,String  ApellidoP, String ApellidoM, String Area, int CostoAsociado,String codProyecto){
		boolean respuesta = false;
		Cientifico CientificoCreado = new Cientifico(Rut, Nombre, ApellidoP, ApellidoM, Area, CostoAsociado);
		//Verificar si existe o no en las lista general,
		Cientifico cientificoBuscado = listaCientificos.buscarCientifico(Rut);
		if(cientificoBuscado==null) {
			if(listaCientificos.ingresarCientifico(CientificoCreado)) {
				//se pudo ingresar el cientifico, por lo tanto creamos su lista, con los posibles proyectpos.
				ListaProyectosCient listaProyectosC = new ListaProyectosCient(10);//Tomamos en cuenta que el Cientifico presentará hasta un máximo de 10 proyecto.
				//buscar proyecto:
				Proyecto proyecto = listaProyectos.buscarProyecto(codProyecto);
				if(proyecto!=null) {
					listaProyectosC.ingresarProyecto(proyecto);
					CientificoCreado.setListaProyectos(listaProyectosC);
					respuesta = true;
				}
			}	
		}else {//en el caso q existiera el cientifico, debemos agregar su proyecto.
			ListaProyectosCient listaProyectosC = cientificoBuscado.getListaProyectos();
			Proyecto proyecto = listaProyectos.buscarProyecto(codProyecto);
			if(proyecto!=null) {
				if(listaProyectosC.ingresarProyecto(proyecto)) {
					CientificoCreado.setListaProyectos(listaProyectosC);
					respuesta = true;					
				}
			}
		}
		return respuesta;
	}
	@Override
    public ListaProyectos returnListaProyectos(){
        return listaProyectos;
    }
	@Override
    public ListaInsta returnListaInsta(){
        return listaInsta;
    }
	@Override
    public ListaDptos returnListaDptos(){
        return listaDptos;
    }
	@Override
    public ListaCientificos returnListaCient(){
        return listaCientificos;
    }
	@Override
    public ListaIngresos returnListaIngresos(){
        return listaIngresos;
    }
	@Override
    public ListaSalidas returnListaSalidas(){
        return listaSalidas;
    }
}