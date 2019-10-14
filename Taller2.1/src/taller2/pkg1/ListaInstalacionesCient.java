
package taller2.pkg1;

public class ListaInstalacionesCient {
    private Instalaciones [] ListaInstalacionesCient;
    private int CantInstalacionesCient;
    private int max;

    public ListaInstalacionesCient(Instalaciones[] ListaInstalacionesCient, int CantInstalacionesCient, int max) {
        this.ListaInstalacionesCient = ListaInstalacionesCient;
        this.CantInstalacionesCient = CantInstalacionesCient;
        this.max = max;
    }

    public Instalaciones[] getListaInstalacionesCient() {
        return ListaInstalacionesCient;
    }

    public void setListaInstalacionesCient(Instalaciones[] ListaInstalacionesCient) {
        this.ListaInstalacionesCient = ListaInstalacionesCient;
    }

    public int getCantInstalacionesCient() {
        return CantInstalacionesCient;
    }

    public void setCantInstalacionesCient(int CantInstalacionesCient) {
        this.CantInstalacionesCient = CantInstalacionesCient;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    public Salida getInstalacionCientI(int i){
        if(i>=0 && i<CantInstalacionesCient){
            return ListaInstalacionesCient[i];
        }
        else{
            return null;
        }
    }
    
    
    
}
