
public interface SistemaSUSTO {
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos,String []listaDptos,int []listaCapacidades);//String NombreDpto, int CapacidadDpto
	public boolean RegistrarIngreso(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean RegistrarSalida(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean ReasignarCientifico(String OpcionCambio);
	public boolean isValid(String dateStr);
	public boolean ContratarCientifico(String rut, String nombre, 
			String apellidoP, String apellidoM, String Area, 
			int costoAsociado, ListaProyectos[] listaProyectos , 
			String dpto, String instalacion);
}
 