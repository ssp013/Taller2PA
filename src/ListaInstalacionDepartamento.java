
public class ListaInstalacionDepartamento {
		private Instalaciones [] li;
		private int CantInsta;
		private int max;
		public ListaInstalacionDepartamento(int max) {
			this.li = new Instalaciones[max];
			this.CantInsta =0;
			this.max= max;
		}
		public boolean ingresarInstaDepto(Instalaciones i) {
			if(this.CantInsta < this.max) {
				li[this.CantInsta]=i;
				this.CantInsta++;
				return true;
			}else {
				return false;
			}
		}
		public Instalaciones buscarInstaDepto(String NombreInstalacion) {
			int k;
			for(k=0;k<this.CantInsta;k++) {
				if(li[k].getNombreInstalacion().equals(NombreInstalacion) ) {
					break;
				}
			}
			if(k==CantInsta) {
				return null;
			}else {
				return li[k];
			}
		}
		public Instalaciones getInstDeptoI(int i){
			if(i>=0 && i<CantInsta) {
				return li[i];	
			}else {
				return null;
			}
		}
		public int CantInstaDepto() {
			return this.CantInsta;
		}
		public String toString() {
			String r = "";
			for(int i=0;i<this.CantInsta;i++) {
				r=r+li[i].toString()+"\n";
			}
			return r;
		}
	

}
