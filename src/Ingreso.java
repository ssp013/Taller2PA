/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Ingreso {
    private String instalacion;
    private String rutCientifico;
    private String fecha;
    private String hora;

    public Ingreso(String instalacion, String rutCientifico,String fecha,String hora) {
        this.instalacion = instalacion;
        this.rutCientifico = rutCientifico;
        this.fecha = fecha;
        this.hora = hora;
    }

	public String getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(String instalacion) {
		this.instalacion = instalacion;
	}

	public String getRutCientifico() {
		return rutCientifico;
	}

	public void setRutCientifico(String rutCientifico) {
		this.rutCientifico = rutCientifico;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}    
    
}
