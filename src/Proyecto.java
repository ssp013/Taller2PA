
public class Proyecto {
	private String CodigoProyecto;
	private String NombreProyecto;
	private int PresupuestoTotal;
	private String DptoResponsable;
	private int  CantAreasEspecializacion;
	private ListaAreaEspecializacion  listaEspecializacion;
	
	
	public Proyecto (String CodigoProyecto,String NombreProyecto,int PresupuestoTotal,String DptoResponsable,int  CantAreasEspecializacion,ListaAreaEspecializacion listaEspecializacion) {
		this.CodigoProyecto = CodigoProyecto;
		this.NombreProyecto = NombreProyecto;
		this.PresupuestoTotal = PresupuestoTotal;
		this.DptoResponsable = DptoResponsable;
		this.CantAreasEspecializacion = CantAreasEspecializacion;
		this.listaEspecializacion = listaEspecializacion;
	}

	public String getCodigoProyecto() {
		return CodigoProyecto;
	}
	public void setCodigoProyecto(String codigoProyecto) {
		this.CodigoProyecto = codigoProyecto;
	}
	public String getNombreProyecto() {
		return NombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.NombreProyecto = nombreProyecto;
	}

	public int getPresupuestoTotal() {
		return PresupuestoTotal;
	}

	public void setPresupuestoTotal(int presupuestoTotal) {
		this.PresupuestoTotal = presupuestoTotal;
	}

	public String getDptoResponsable() {
		return DptoResponsable;
	}

	public void setDptoResponsable(String dptoResponsable) {
		this.DptoResponsable = dptoResponsable;
	}

	public int getCantAreasEspecializacion() {
		return CantAreasEspecializacion;
	}

	public void setCantAreasEspecializacion(int cantAreasEspecializacion) {
		this.CantAreasEspecializacion = cantAreasEspecializacion;
	}
	public ListaAreaEspecializacion getListaEspecializacion() {
		return listaEspecializacion;
	}


	public void setListaEspecializacion(ListaAreaEspecializacion listaEspecializacion) {
		this.listaEspecializacion = listaEspecializacion;
	}
}
