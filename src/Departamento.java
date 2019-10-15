
public class Departamento {
	private String NombreDpto;
	private int CapacidadDpto;
	//private ListaInstalacionDepartamento listaInstalacionDepartamento;
	private int presupuesto;
	public Departamento(String NombreDpto,int CapacidadDpto,int presupuesto) {
		this.NombreDpto = NombreDpto;
		this.CapacidadDpto = CapacidadDpto;
		this.presupuesto = presupuesto;
	}
	public String getNombreDpto() {
		return this.NombreDpto;
	}
	public int CapacidadDpto() {
		return this.CapacidadDpto;
	}
	public void getNombreDpto(String NombreDpto) {
		this.NombreDpto = NombreDpto;
		
	}
	public int getCapacidadDpto() {
		return CapacidadDpto;
	}
	public void setCapacidadDpto(int capacidadDpto) {
		CapacidadDpto = capacidadDpto;
	}
	/*public ListaInstalacionDepartamento getListaInstalacionDepartamento() {
		return listaInstalacionDepartamento;
	}
	public void setListaInstalacionDepartamento(ListaInstalacionDepartamento listaInstalacionDepartamento) {
		this.listaInstalacionDepartamento = listaInstalacionDepartamento;
	}*/
	public void setNombreDpto(String nombreDpto) {
		NombreDpto = nombreDpto;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}
