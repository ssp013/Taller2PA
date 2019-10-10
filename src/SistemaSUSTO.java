
public interface SistemaSUSTO {
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos);//String NombreDpto, int CapacidadDpto
	public boolean ContratarCientifico(String Rut,String Nombre, String ApellidoP,String ApellidoM,String Area,int CostoAsociado );
	public boolean RegistrarIngreso(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean RegistrarSalida(String Instalacion, String rutCientifico, String fecha, String hora);
	public boolean ReasignarCientifico(String OpcionCambio);
}
