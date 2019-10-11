
package taller2.pkg1;

public class AsociacionCP {
    private String rutCientifico;
    private String CodigoProyecto;

    public AsociacionCP(String rutCientifico, String CodigoProyecto) {
        this.rutCientifico = rutCientifico;
        this.CodigoProyecto = CodigoProyecto;
    }

    public String getRutCientifico() {
        return rutCientifico;
    }

    public void setRutCientifico(String rutCientifico) {
        this.rutCientifico = rutCientifico;
    }

    public String getCodigoProyecto() {
        return CodigoProyecto;
    }

    public void setCodigoProyecto(String CodigoProyecto) {
        this.CodigoProyecto = CodigoProyecto;
    }
    
}
