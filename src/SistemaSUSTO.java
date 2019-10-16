import java.io.IOException;

import ucn.ArchivoEntrada;

public interface SistemaSUSTO {
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos,ListaDepartamentoInstalacion listaNuevaDepto);
	public boolean crearDpto(String nomDpto,int capacidad, int presupuesto);
	public boolean RegistrarIngreso(String instalacion,String rutCientifico,String fecha,String hora);
	public boolean RegistrarSalida(String instalacion,String rutCientifico, String fecha, String hora);
	public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN, ListaProyectosCient listaProyectosCient);
	public boolean isValid(String dateStr);
	public boolean ContratarCientifico(String rut, String nombre, String apellidoP, String apellidoM,
			String AreaEspecializacion, int costoAsociado, ListaProyectosCient listaProyectoCient, String dpto,
			String instalacion);
	public boolean CargarInstalaciones(String nombreInstalacion,int cantDepartamentos,ListaDepartamentoInstalacion listaNuevaDI);
	public boolean CargarProyectos(String CodigoProyecto,String NombreProyecto,int PresupuestoTotal,String DptoResponsable,int CantAreasEspecializacion,ListaAreaEspecializacion listaEspecializacion );
	public boolean CargarCientifico(String Rut, String Nombre,String  ApellidoP, String ApellidoM, String Area, int CostoAsociado);
	public ListaProyectos returnListaProyectos();
	public ListaInsta returnListaInsta();
	public ListaDptos returnListaDptos();
	public ListaCientificos returnListaCient();
	public ListaIngresos returnListaIngresos();
	public ListaSalidas returnListaSalidas();
}
 