import java.util.Arrays;

public class Cientifico {
	private String Rut;
	private String Nombre;
	private String ApellidoP;
	private String ApellidoM;
	private String Area;
	private int CostoAsociado;
	private ListaProyectosCient  listaProyectos;
	
	public Cientifico(String Rut,String Nombre,String ApellidoP,String ApellidoM,
			String Area,int CostoAsociado) {
		this.Rut = Rut;
		this.Nombre = Nombre;
		this.ApellidoP=ApellidoP;
		this.ApellidoM = ApellidoM;
		this.Area = Area;
		this.CostoAsociado = CostoAsociado;
	}
	public String getRut() {
		return Rut;
	}

	public void setRut(String rut) {
		this.Rut = rut;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellidoP() {
		return ApellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.ApellidoP = apellidoP;
	}

	public String getApellidoM() {
		return ApellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.ApellidoM = apellidoM;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		this.Area = area;
	}

	public int getCostoAsociado() {
		return CostoAsociado;
	}

	public void setCostoAsociado(int costoAsociado) {
		this.CostoAsociado = costoAsociado;
	}
	public ListaProyectosCient getListaProyectos() {
		return listaProyectos;
	}
	public void setListaProyectos(ListaProyectosCient listaProyectos) {
		this.listaProyectos = listaProyectos;
	}
}