import java.io.IOException;

import ucn.ArchivoEntrada;

public interface SistemaSUSTO {
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos,String []listaDptos,int []listaCapacidades);//String NombreDpto, int CapacidadDpto
	public boolean RegistrarIngreso(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean RegistrarSalida(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean ReasignarCientifico(String OpcionCambio);
	public boolean isValid(String dateStr);
	boolean ContratarCientifico(String rut, String nombre, String apellidoP, String apellidoM,
			String AreaEspecializacion, int costoAsociado, ListaProyectosCient listaProyectoCient, String dpto,
			String instalacion);
	boolean CargarInstalaciones(ArchivoEntrada archivoInstalaciones) throws IOException;
	boolean CargarProyecto(ArchivoEntrada archivoProyecto) throws IOException;
	boolean CargarCientifico(ArchivoEntrada archivoCientifico) throws IOException;
}
 