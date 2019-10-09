public class ListaCientificos {	
	private Cientifico [] lC;
	private int cantCientificos;
	private int max;
	public ListaCientificos(int max) {
		this.lC = new Cientifico[max];
		this.cantCientificos = 0;
		this.max = max;
	}
	public boolean ingresarCientifico(Cientifico C) {
		if(cantCientificos<max) {
			lC[cantCientificos]=C;
			cantCientificos++;
			return true;
		}else {
			return false;
		}
	}
	public Cientifico buscarCientifico(String Rut) {
		int k;
		for(k=0;k<cantCientificos;k++) {
			if(lC[k].getRut().equals(Rut)) {
				break;
			}
		}
		if(k==cantCientificos) {
			return null;
		}else {
			return lC[k];
		}
	}
	public int getCantCientificos() {
		return this.cantCientificos;
	}
	public Cientifico getCientificoI(int i) {
		if(i>=0 && i<cantCientificos) {
			return lC[i];
		}else {
			return null;
		}
	}
	public String toString() {
		String r="";
		for(int i=0;i<cantCientificos;i++) {
			r= r+ lC.toString()+"\n";
		}
		return r;
	}

}
