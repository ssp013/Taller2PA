import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import ucn.*;
/**
 *
 * @author TomasSandoval Sebastian Sanchez
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
    public boolean RegistrarIngreso(String instalacion,String rutCientifico,String fecha,String hora ){
        boolean ingresoB = false;
     
        for(int i=0;i<listaCientificos.getCantCientificos();i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            ListaInstalacionesCient listaInstalacionesCient = cient.getListaInstalacionesCient();
            if(cient.getRut().equals(rutCientifico)){
                //verifico que el cientifico este en la lista general de cientifico, osea exista
                for(int j=0;j<listaSalidas.getCantSalidas();j++){
                    Salida sal = listaSalidas.getSalidaI(j);
                    if(sal.getRutCientifico().equals(j)){
                        //verifico que el cientifico este afuera(no puede ingresar si no esta afuera)
                    	
                        for(int k=0;k<listaInstalacionesCient.getCantInstalacionesCient();k++){
                            Instalaciones inst = listaInstalacionesCient.getInstCientI(k);
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
    @Override
    public boolean RegistrarSalida(String instalacion,String rutCientifico, String fecha, String hora){
        boolean salidaB = false;
        for(int i=0;i<listaCientificos.getCantCientificos();i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            ListaInstalacionesCient listaInstalacionesCient = cient.getListaInstalacionesCient();
            if(cient.getRut().equals(rutCientifico)){
                //verifico que el cientifico exista
                for(int j=0;j<listaIngresos.getCantIngresos();j++){
                    Ingreso ing = listaIngresos.getIngresoI(j);
                    if(ing.getRutCientifico().equals(rutCientifico)){
                        //verifico que el cientifico este adentro (no puede salir si no esta adentro)
                        for(int k=0;k<listaInstalacionesCient.getCantInstalacionesCient();k++){
                            Instalaciones inst = listaInstalacionesCient.getInstCientI(k);
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
	@Override
	public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN, ListaProyectosCient listaProyectosCient){
		boolean ingreso = false;
        for(int i=0;i<listaCientificos.getCantCientificos();i++){
            Cientifico cient = listaCientificos.getCientificoI(i);
            if(cient.getRut().equals(rutCientifico)){
                //verifico que el cientifico si esta en la lista de cientificos
                for(int j=0;j<listaProyectosCient.getCantProyecto();j++){
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
				return true;
				//System.out.println(formatter.format(today)); // 01/01/2016
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
				for(int i =0; i<listaProyectoCientificoIngresado.getCantProyecto();i++) {
					
				}
			}
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
	public boolean CargarProyectos(String CodigoProyecto,String NombreProyecto,int PresupuestoTotal,String DptoResponsable,int CantAreasEspecializacion,ListaAreaEspecializacion listaEspecializacion ) {
		boolean respuesta = false;
		Proyecto proyectoNuevo = new Proyecto(CodigoProyecto, NombreProyecto, PresupuestoTotal, DptoResponsable, CantAreasEspecializacion, listaEspecializacion);
		respuesta = listaProyectos.ingresarProyecto(proyectoNuevo);
		proyectoNuevo.setListaEspecializacion(listaEspecializacion);
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

