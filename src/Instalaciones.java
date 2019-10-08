
public class Instalaciones {
	private String NombreInstalacion;
	private int CantidadDptos;
	public Instalaciones(String NombreInstalacion,int CantidadDptos) {
		this.NombreInstalacion = NombreInstalacion;
		this.CantidadDptos = CantidadDptos;
	}
	public String getNombreInstalacion() {
		return NombreInstalacion;
	}
	public void setNombreInstalacion(String nombreInstalacion) {
		NombreInstalacion = nombreInstalacion;
	}
	public int getCantidadDptos() {
		return CantidadDptos;
	}
	public void setCantidadDptos(int cantidadDptos) {
		CantidadDptos = cantidadDptos;
	}
	public String toString() {
		return "Instalaciones [NombreInstalacion]: "+this.NombreInstalacion+", [CantidadDptos]: "+this.CantidadDptos;
	}
}
 