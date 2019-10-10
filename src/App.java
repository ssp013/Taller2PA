import ucn.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class App { 
	public static void desplegarMenu() {
		StdOut.println("1. Cargar Archivos \n2. Crear Nuevas Entidades \n3. Registrar Ingreso y Salida \n4. Reasignar Científico \n5. Reportes de Personal y Costos \n6. Cierre de Sistema");
	}
	public static boolean validarFecha(SistemaSUSTO sistema,String dateStr) {
		boolean result = sistema.isValid(dateStr);
		if(result) {
			return true;
		}else {
			return false;
		}
	}

	public static void menu(SistemaSUSTO sistema) {
        desplegarMenu();
        StdOut.println("Ingrese opcion: ");
        int op = StdIn.readInt();
        
        while(op!=6){
            switch(op){
                case 1:
                    
                break;
                case 2:
                
                break;
                case 3:
                    
                break;
                case 4:
                
                break;
                case 5:
                    
                break;
               
            }
            desplegarMenu();
            StdOut.println("Ingrese opcion: ");
            op = StdIn.readInt();
        }
	
	}
	public static void main(String[] args) {
		StdOut.println("¡Bienvenido al sistema SUSTO!");
		SistemaSUSTO sistema = new SistemaSUSTOImpl();
		StdOut.println("Ingrese la fecha (dd/MM/yyyy) :");
		String dateStr = StdIn.readString();
		boolean resultado = validarFecha(sistema,dateStr);
		while(!resultado) {
			StdOut.println("Ingrese fecha correcta!");
			dateStr = StdIn.readString();
			resultado = validarFecha(sistema,dateStr);
		}
		menu(sistema);
		
	}

}