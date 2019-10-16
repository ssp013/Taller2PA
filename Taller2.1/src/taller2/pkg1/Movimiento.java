
package taller2.pkg1;

public class Movimiento {
    private String fecha;
    private String rutCientifico;
    private String tipoMovimiento;

    public Movimiento(String fecha, String rutCientifico, String tipoMovimiento) {
        this.fecha = fecha;
        this.rutCientifico = rutCientifico;
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRutCientifico() {
        return rutCientifico;
    }

    public void setRutCientifico(String rutCientifico) {
        this.rutCientifico = rutCientifico;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
           
    
}
