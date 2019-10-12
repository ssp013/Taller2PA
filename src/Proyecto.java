
public class Proyecto {
	private String CodigoProyecto;
	private String NombreProyecto;
	private int PresupuestoTotal;
	private String DptoResponsable;
	private int  CantAreasEspecializacion;
	
	public Proyecto (String CodigoProyecto,String NombreProyecto,int PresupuestoTotal,String DptoResponsable,int  CantAreasEspecializacion) {
		this.CodigoProyecto = CodigoProyecto;
		this.NombreProyecto = NombreProyecto;
		this.PresupuestoTotal = PresupuestoTotal;
		this.DptoResponsable = DptoResponsable;
		this.CantAreasEspecializacion = CantAreasEspecializacion;
	}

	public String getCodigoProyecto() {
		return CodigoProyecto;
	}
	public String getNombreProyecto() {
		return NombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		NombreProyecto = nombreProyecto;
	}

	public int getPresupuestoTotal() {
		return PresupuestoTotal;
	}

	public void setPresupuestoTotal(int presupuestoTotal) {
		PresupuestoTotal = presupuestoTotal;
	}

	public String getDptoResponsable() {
		return DptoResponsable;
	}

	public void setDptoResponsable(String dptoResponsable) {
		DptoResponsable = dptoResponsable;
	}

	public int getCantAreasEspecializacion() {
		return CantAreasEspecializacion;
	}

	public void setCantAreasEspecializacion(int cantAreasEspecializacion) {
		CantAreasEspecializacion = cantAreasEspecializacion;
	}
}
