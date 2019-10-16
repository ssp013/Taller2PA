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
public class ListaMovimientos {
    private Movimiento [] ListaMovimientos;
    private int cantMovimientos;
    private int max;
    
    public ListaMovimientos(int max){
        ListaMovimientos = new Movimiento[max];
        cantMovimientos = 0;
        this.max = max;
    }
    public boolean ingresarMovimiento(Movimiento mov){
        if(cantMovimientos < max){
            ListaMovimientos[cantMovimientos]= mov;
            cantMovimientos++;
            return true;
        }
        else{
            return false;
        }
    }
    public Movimiento getMovimientoI(int i){
        if(i>=0 && i<cantMovimientos){
            return ListaMovimientos[i];
        }
        else{
            return null;
        }
    }

    public Movimiento[] getListaMovimientos() {
        return ListaMovimientos;
    }

    public void setListaMovimientos(Movimiento[] ListaMovimientos) {
        this.ListaMovimientos = ListaMovimientos;
    }

    public int getCantMovimientos() {
        return cantMovimientos;
    }

    public void setCantMovimientos(int cantMovimientos) {
        this.cantMovimientos = cantMovimientos;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
}
