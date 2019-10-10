/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.pkg1;

/**
 *
 * @author Tomas Sandoval
 */
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
