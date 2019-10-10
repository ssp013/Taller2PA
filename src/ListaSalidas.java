public class ListaSalidas {
    private Salida[]ListaSalidas;
    private int CantSalidas;
    private int max;
    
    public ListaSalidas(int max){
        ListaSalidas = new Salida[max];
        CantSalidas = 0;
        this.max = max;
    }
    public boolean ingresarSalida(Salida salida){
        if(CantSalidas<max){
            ListaSalidas[CantSalidas]=salida;
            CantSalidas++;
            return true;
        }
        else{
            return false;
        }
    }

    public Salida[] getListaSalidas() {
        return ListaSalidas;
    }

    public int getCantSalidas() {
        return CantSalidas;
    }

    public int getMax() {
        return max;
    }
    public Salida getSalidaI(int i){
        if(i>=0 && i<CantSalidas){
            return ListaSalidas[i];
        }
        else{
            return null;
        }
    }
}
