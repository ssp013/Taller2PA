public class ListaProyectosCient {
	private Proyecto [] lp;
	private int cantProyecto;
	private int max;
	
	public ListaProyectosCient(int max) {
		lp = new Proyecto [max];
		this.cantProyecto =0;
		this.max = max;
	}
	public boolean ingresarProyecto(Proyecto proyecto) {
		if(this.cantProyecto <this.max) {
			lp[cantProyecto]=proyecto;
			cantProyecto++;
			return true;
		}else {
			return false;
		}
	}
	public Proyecto buscarProyecto(String CodigoProyecto) {
		int k;
		for(k=0;k<cantProyecto;k++) {
			if(lp[k].getCodigoProyecto().equals(CodigoProyecto)) {
				break;
			}
		}
		if(k==cantProyecto) {
			return null;
		}else {
			return lp[k];
		}
	}
	public Proyecto getProyectoI(int i) {
		if(i>=0 && i<cantProyecto) {
			return lp[i];
		}
		else {
			return null;
		}
	}
	public int getCantProyecto() {
		return this.cantProyecto;
	}
	/*public boolean setearProyecto(String CodigoAntiguo,String CodigoNuevo,String nombreProyecto,int presupuestoTotal,String dptoResponsable,int  cantAreasEspecializacion,ListaAreaEspecializacion listaEspecializacion){//ingresar
		
		int k;
		for(k=0;k<cantProyecto;k++) {
			if(lp[k].getCodigoProyecto().equals(CodigoAntiguo)) {
				break;
			}
		}
		if(k==cantProyecto) {
			return false;
		}else {
			lp[k].setCodigoProyecto(CodigoNuevo);
			lp[k].setNombreProyecto(nombreProyecto);
			lp[k].setPresupuestoTotal(presupuestoTotal);
			lp[k].setDptoResponsable(dptoResponsable);
			lp[k].setCantAreasEspecializacion(cantAreasEspecializacion);
			lp[k].setListaEspecializacion(listaEspecializacion);
			return true;
			
		}
		
	}*/

}