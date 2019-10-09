
public class ListaDptos {
	private Departamento [] ld;
	private int cantDpto;
	private int max;
	public ListaDptos(int max) {
		this.ld = new Departamento[max];
		this.cantDpto =0;
		this.max = max;
	}
	public boolean ingesarDpto(Departamento depto) {
		if(this.cantDpto < this.max) {
			ld[this.cantDpto] = depto;
			cantDpto++;
			return true;
		}else {
			return false;
		}
	}
	public Departamento buscarDpto(String NombreDepto) {
		
	}
	
	
}
