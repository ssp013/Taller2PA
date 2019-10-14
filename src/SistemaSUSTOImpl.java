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
	public ListaCientificos listaCientificos;
	public ListaDptos listaDptos;
	public ListaProyectos listaProyectos;
	public ListaInsta listaInsta;
	public ListaIngresos listaIngresos;
	public ListaSalidas listaSalidas;
	public String dateFormat;
	public ListaInstalacionDepartamento listaInstalacionDepartamento;
	public ListaAreaEspecializacion listaAreaEspecializacion;
	public ListaProyectosCient listaProyectosCient;
	
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
	public boolean CargarInstalaciones(ArchivoEntrada archivoInstalaciones) throws IOException  {
		boolean respuesta = false;
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			String nombreInstalacion = regEnt.getString(); 
			int cantDepartamentos =  regEnt.getInt();
			Instalaciones instaNueva = new Instalaciones(nombreInstalacion,cantDepartamentos);
			listaInsta.ingresarInsta(instaNueva);
			ListaDepartamentoInstalacion listaNuevaDI = new ListaDepartamentoInstalacion(cantDepartamentos);
			for(int i=0;i<cantDepartamentos;i++) {
				String depto1 = regEnt.getString();
				int capacidad = regEnt.getInt();
				int presupuesto = regEnt.getInt();
				Departamento DeptoBuscado = listaDptos.buscarDpto(depto1);
				if(DeptoBuscado == null) {//No existe, lo agrego
					Departamento deptoAgregar = new Departamento(depto1,capacidad,presupuesto);
					listaNuevaDI.ingesarDptoInstalacion(deptoAgregar);
					if(listaDptos.ingresarDpto(deptoAgregar)) {
						respuesta = true;
					}
				}else {
					int preObtenido = DeptoBuscado.getPresupuesto();
					int cap = DeptoBuscado.getCapacidadDpto();
					int sumadoPresupuesto = preObtenido + presupuesto;
					int capa2 = cap+capacidad;
					DeptoBuscado.setPresupuesto(sumadoPresupuesto);
					DeptoBuscado.setCapacidadDpto(capa2);
					respuesta= true;
					listaNuevaDI.ingesarDptoInstalacion(DeptoBuscado);
				}
				
			}
		}
		archivoInstalaciones.close();
		return respuesta;
	}
	@Override
	public boolean CargarProyecto(ArchivoEntrada archivoProyecto) throws IOException {
		boolean respuesta = false;
		while(!archivoProyecto.isEndFile()){
			Registro regEnt = archivoProyecto.getRegistro();
			
			String CodigoProyecto = regEnt.getString();
			String NombreProyecto = regEnt.getString();
			int PresupuestoTotal = regEnt.getInt();
			String DptoResponsable = regEnt.getString();
			int  CantAreasEspecializacion = regEnt.getInt();
			ListaAreaEspecializacion  listaEspecializacion = new ListaAreaEspecializacion(CantAreasEspecializacion);
			for(int i =0; i<CantAreasEspecializacion;i++) {
				String areas = regEnt.getString();
				AreaEspecializacion ObjetoArea = new AreaEspecializacion(areas);				
				boolean realizado = listaEspecializacion.ingresarEspecializacion(ObjetoArea);
			}
			Proyecto proyectoNuevo = new Proyecto(CodigoProyecto, NombreProyecto, PresupuestoTotal, DptoResponsable, CantAreasEspecializacion, listaEspecializacion);
			Proyecto proyectoBuscar = listaProyectos.buscarProyecto(CodigoProyecto);
			if(proyectoBuscar == null) {
				listaProyectos.ingresarProyecto(proyectoNuevo);
			}
		}
		archivoProyecto.close();
		return respuesta;

	}
	@Override
	public boolean CargarCientifico(ArchivoEntrada archivoCientifico) throws IOException {
		boolean respuesta = false;
		while(!archivoCientifico.isEndFile()){
			Registro regEnt = archivoCientifico.getRegistro();
			String Rut = regEnt.getString();
			String Nombre = regEnt.getString();
			String ApellidoP = regEnt.getString();
			String ApellidoM = regEnt.getString();
			String Area = regEnt.getString();
			int CostoAsociado =  regEnt.getInt();
			Cientifico CientificoCreado = new Cientifico(Rut, Nombre, ApellidoP, ApellidoM, Area, CostoAsociado);
			Cientifico CientificoBuscado = listaCientificos.buscarCientifico(Rut);
			if(CientificoBuscado == null) {
				boolean resp =listaCientificos.ingresarCientifico(CientificoCreado);
				respuesta = true;
			}
		}
		archivoCientifico.close();
		return respuesta;
	}

}

