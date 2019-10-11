
package taller2.pkg1;


public class ListaAsociacionCP {
    private AsociacionCP[]ListaAsociacionCP;
    private int CantAsociacionesCP;
    private int max;
    
    public ListaAsociacionCP(int max){
        ListaAsociacionCP = new AsociacionCP[max];
        CantAsociacionesCP = 0;
        this.max = max;
    }
    public boolean ingresarAsociacionCP(AsociacionCP asociacionCP){
        if(CantAsociacionesCP<max){
            ListaAsociacionCP[CantAsociacionesCP]= asociacionCP;
            CantAsociacionesCP++;
            return true;
        }
        else{
            return false;
        }
    }

    public AsociacionCP[] getListaAsociacionCP() {
        return ListaAsociacionCP;
    }

    public int getCantAsociacionesCP() {
        return CantAsociacionesCP;
    }

    public int getMax() {
        return max;
    }
    
    public AsociacionCP getAsociacionCPI(int i){
        if(i>=0 && i<CantAsociacionesCP){
            return ListaAsociacionCP[i];
        }
        else{
            return null;
        }
    }
}
