
public class ListaAreaEspecializacion {
	private AreaEspecializacion [] lAE;
	private int max;
	private int cantAreaEspecializacion;
	public ListaAreaEspecializacion(int max) {
		lAE = new AreaEspecializacion[max];
		this.cantAreaEspecializacion =0;
		this.max=max;
	}
	public boolean ingresarEspecializacion(AreaEspecializacion area) {
		if(this.cantAreaEspecializacion <this.max) {
			lAE[cantAreaEspecializacion]=area;
			cantAreaEspecializacion++;
			return true;
		}else {
			return false;
		}
	}
	public AreaEspecializacion buscarEspecializacion(String nombre) {
		int k;
		for(k=0;k<cantAreaEspecializacion;k++) {
			if(lAE[k].getNombre().equals(nombre)) {
				break;
			}
		}
		if(k==cantAreaEspecializacion) {
			return null;
		}else {
			return lAE[k];
		}
	}
	public AreaEspecializacion getAreaEspecializacionI(int i) {
		if(i>=0 && i<cantAreaEspecializacion) {
			return lAE[i];
		}
		else {
			return null;
		}
	}
	

}
