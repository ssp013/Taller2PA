
package taller2.pkg1;

public class AsociacionCI {
    private String rutCientifico;
    private String NombreInstalacion;

    public AsociacionCI(String rutCientifico, String NombreInstalacion) {
        this.rutCientifico = rutCientifico;
        this.NombreInstalacion = NombreInstalacion;
    }

    public String getRutCientifico() {
        return rutCientifico;
    }

    public void setRutCientifico(String rutCientifico) {
        this.rutCientifico = rutCientifico;
    }

    public String getNombreInstalacion() {
        return NombreInstalacion;
    }

    public void setNombreInstalacion(String NombreInstalacion) {
        this.NombreInstalacion = NombreInstalacion;
    }
    
}
