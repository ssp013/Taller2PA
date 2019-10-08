
public class Departamento {
	private String NombreDpto;
	private int CapacidadDpto;
	
	public Departamento(String NombreDpto,int CapacidadDpto) {
		this.NombreDpto = NombreDpto;
		this.CapacidadDpto = CapacidadDpto;
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
	
}
