
package taller2.pkg1;

public class ListaAsociacionCI {
    private AsociacionCI[]ListaAsociacionCI;
    private int CantAsociacionesCI;
    private int max;
    
    public ListaAsociacionCI(int max){
        ListaAsociacionCI = new AsociacionCI[max];
        CantAsociacionesCI = 0;
        this.max = max;
    }
    
    public boolean ingresarAsociacionCI(AsociacionCI asociacionCI){
        if(CantAsociacionesCI<max){
            ListaAsociacionCI[CantAsociacionesCI]=asociacionCI;
            CantAsociacionesCI++;
            return true;
        }
        else{
            return false;
        }
    }

    public AsociacionCI[] getListaAsociacionCI() {
        return ListaAsociacionCI;
    }

    public int getCantAsociacionesCI() {
        return CantAsociacionesCI;
    }

    public int getMax() {
        return max;
    }
    
    public AsociacionCI getAsociacionCII(int i){
        if(i>=0 && i<CantAsociacionesCI){
            return ListaAsociacionCI[i];
        }
        else{
            return null;
        }
    }
}
