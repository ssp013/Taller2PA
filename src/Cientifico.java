import java.util.Arrays;

public class Cientifico {
	private String Rut;
	private String Nombre;
	private String ApellidoP;
	private String ApellidoM;
	private String Area;
	private int CostoAsociado;
	private ListaProyectosCient  listaProyectos;
	private ListaInstalacionesCient  listaInstalaciones;
	
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
		Rut = rut;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidoP() {
		return ApellidoP;
	}

	public void setApellidoP(String apellidoP) {
		ApellidoP = apellidoP;
	}

	public String getApellidoM() {
		return ApellidoM;
	}

	public void setApellidoM(String apellidoM) {
		ApellidoM = apellidoM;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public int getCostoAsociado() {
		return CostoAsociado;
	}

	public void setCostoAsociado(int costoAsociado) {
		CostoAsociado = costoAsociado;
	}
	public ListaProyectosCient getListaProyectos() {
		return listaProyectos;
	}
	public void setListaProyectos(ListaProyectosCient listaProyectos) {
		this.listaProyectos = listaProyectos;
	}
	public ListaInstalacionesCient getListaInstalacionesCient() {
		return listaInstalaciones;
	}
	public void setListaInstalaciones(ListaInstalacionesCient listaInstalaciones) {
		this.listaInstalaciones = listaInstalaciones;
	}




	
	

}