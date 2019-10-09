
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
		int k;
		for(k=0;k<this.cantDpto;k++) {
			if(ld[k].getNombreDpto().equals(NombreDepto)) {
				break;
			}
		}
		if(k==cantDpto) {
			return null;
		}else {
			return ld[k];
		}
	}
	public Departamento getDepartamento(int i) {
		if(i>=0 && i<cantDpto) {
			return ld[i];	
		}else {
			return null;
		}
	}
	public int getCantDptos() {
		return this.cantDpto;
	}
	public String toString() {
		String r = "";
		for(int i=0;i<this.cantDpto;i++) {
			r=r+ld[i].toString()+"\n";
		}
		return r;
	}
}
