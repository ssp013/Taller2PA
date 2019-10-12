/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tomas Sandoval
 */
public class ListaIngresos {
    private Ingreso[]ListaIngresos;
    private int CantIngresos;
    private int max;
    
    public ListaIngresos(int max){
        ListaIngresos = new Ingreso[max];
        CantIngresos = 0;
        this.max = max;
    }
    public boolean ingresarIngreso(Ingreso ingreso){
        if(CantIngresos < max){
            ListaIngresos[CantIngresos]= ingreso;
            CantIngresos++;
            return true;
        }
        else{
            return false;
        }
    }

    public Ingreso[] getListaIngresos() {
        return ListaIngresos;
    }

    public int getCantIngresos() {
        return CantIngresos;
    }

    public int getMax() {
        return max;
    }
    
    public Ingreso getIngresoI(int i){
        if(i>=0 && i<CantIngresos){
            return ListaIngresos[i];
        }
        else{
            return null;
        }
    }
    
   
}
