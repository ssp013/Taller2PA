
public interface SistemaSUSTO {
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos,String []listaDptos,int []listaCapacidades);//String NombreDpto, int CapacidadDpto
	public boolean RegistrarIngreso(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean RegistrarSalida(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean ReasignarCientifico(String OpcionCambio);
	public boolean isValid(String dateStr);
	boolean ContratarCientifico(String rut, String nombre, String apellidoP, String apellidoM,
			String AreaEspecializacion, int costoAsociado, ListaProyectoCient[] listaProyectoCient, String dpto,
			String instalacion);
}
 