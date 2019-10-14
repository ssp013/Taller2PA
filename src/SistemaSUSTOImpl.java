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
    }	
	@Override
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos, String[] listaDptos,
			int[] listaCapacidades) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean RegistrarIngreso(String Instalacion, String rutCientifico, String fecha, String hora) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean RegistrarSalida(String Instalacion, String rutCientifico, String fecha, String hora) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean ReasignarCientifico(String OpcionCambio) {
		// TODO Auto-generated method stub
		return false;
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
		//Verificar si existe o no el cientifico:
		Cientifico CientificoBuscado = listaCientificos.buscarCientifico(rut);
		if(CientificoBuscado == null) {
			//significa que podemos agregarlo:
			//verificar si la instalacion ingresada existe.
			Instalaciones InstalacionBuscada = listaInsta.buscarInsta(instalacion);
			if(InstalacionBuscada != null) {
				//entonces tenemos la instalacion:
				//recorro ahora elm depto:
				Departamento departamentoBuscado = listaDptos.buscarDpto(dpto);
				if(departamentoBuscado!=null) {
					//puedo verficar q si esta ese departamento
					//Verificamos si existe o no sus proyectos, debemos recorrer su lista.
					for(int l =0;l<listaProyectoCientificoIngresado.getCantProyecto();l++) {
						Proyecto proyectoCientifico = listaProyectoCientificoIngresado.getProyectoI(l);
						String CodigoProyectoCientifico = proyectoCientifico.getCodigoProyecto();
						Proyecto proyectoEncontrado = listaProyectos.buscarProyecto(CodigoProyectoCientifico);
						if(proyectoEncontrado!=null) {
							String DeptoResponsableProyectoCientifico = proyectoEncontrado.getDptoResponsable();
							Departamento depto1 = listaDptos.buscarDpto(DeptoResponsableProyectoCientifico);
							ListaInstalacionDepartamento listaInstalaciones = depto1.getListaInstalacionDepartamento();
							Instalaciones instalacionEncontrada = listaInstalaciones.buscarInstaDepto(instalacion);
							if(instalacionEncontrada!=null) {
								if(instalacionEncontrada.getNombreInstalacion().equals(instalacion) && DeptoResponsableProyectoCientifico.equals(dpto)) {
									//Puedo contratar al cientidico , pero debo veri
									//revisar area especializacion y el costo y presupuesto.
									if(proyectoEncontrado.getPresupuestoTotal() >= costoAsociado) {
										ListaAreaEspecializacion  listaAreaEspecializacion = proyectoEncontrado.getListaEspecializacion();
										AreaEspecializacion AreaEncontrada = listaAreaEspecializacion.buscarEspecializacion(AreaEspecializacion);
										if(AreaEncontrada!=null) {
											//Creamos al cientifico.
											Cientifico CientificoEncontrado = new Cientifico(rut,nombre,apellidoP,apellidoM,AreaEspecializacion, costoAsociado);
											ListaProyectosCient ListaProyectosEncontrado = new ListaProyectosCient(listaProyectoCientificoIngresado.getCantProyecto());
											ListaInstalacionesCient ListaInstaAgregar = new ListaInstalacionesCient(listaProyectoCientificoIngresado.getCantProyecto());
											boolean IngresoProyecto = ListaProyectosEncontrado.ingresarProyecto(proyectoCientifico);
											boolean IngresoInsta = ListaInstaAgregar.ingresarInstaCient( instalacionEncontrada);
											if(IngresoProyecto== true && IngresoInsta==true && depto1.getCapacidadDpto()>0) {
												//descontar presupuesto de proyecto..Verificar capacidad de los depto para alojar cinetificos..
												int presupuesto = proyectoEncontrado.getPresupuestoTotal() -costoAsociado;
												proyectoEncontrado.setPresupuestoTotal(presupuesto);//disminuimos su presupuesto.
												contratar=true;
												return contratar;													
											}
										}
									}
									
								}
							}
						}
					}
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
	public boolean CargarCientifico(String Rut, String Nombre,String  ApellidoP, String ApellidoM, String Area, int CostoAsociado){
		boolean respuesta = false;
		Cientifico CientificoCreado = new Cientifico(Rut, Nombre, ApellidoP, ApellidoM, Area, CostoAsociado);
		respuesta = listaCientificos.ingresarCientifico(CientificoCreado);
		if(respuesta) {
			ListaProyectosCient listaProyectosC = new ListaProyectosCient(10);
			ListaInstalacionesCient listaInstalacionesC = new ListaInstalacionesCient(10);
			CientificoCreado.setListaInstalaciones(listaInstalacionesC);
			CientificoCreado.setListaProyectos(listaProyectosC);	
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
}

