
public class Instalaciones {
	private String NombreInstalacion;
	private int CantidadDptos;
	private ListaDepartamentoInstalacion listaDepartamentoInstalacion;
	public Instalaciones(String NombreInstalacion,int CantidadDptos) {
		this.NombreInstalacion = NombreInstalacion;
		this.CantidadDptos = CantidadDptos;
	}
	public String getNombreInstalacion() {
		return NombreInstalacion;
	}
	public void setNombreInstalacion(String nombreInstalacion) {
		this.NombreInstalacion = nombreInstalacion;
	}
	public int getCantidadDptos() {
		return CantidadDptos;
	}
	public void setCantidadDptos(int cantidadDptos) {
		this.CantidadDptos = cantidadDptos;
	}
	public String toString() {
		return "Instalaciones [NombreInstalacion]: "+this.NombreInstalacion+", [CantidadDptos]: "+this.CantidadDptos;
	}
	public ListaDepartamentoInstalacion getListaDepartamentoInstalacion() {
		return listaDepartamentoInstalacion;
	}
	public void setListaDepartamentoInstalacion(ListaDepartamentoInstalacion listaDepartamentoInstalacion) {
		this.listaDepartamentoInstalacion = listaDepartamentoInstalacion;
	}
	
}
 