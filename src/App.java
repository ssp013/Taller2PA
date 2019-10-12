import ucn.*;
import java.io.IOException;
import java.util.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class App { 
	static Scanner sc = new Scanner(System.in);
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
	public static int validarOpcion()
	 {
	  while (true)
	  {
	   try
	   {
	    return sc.nextInt();
	   }
	   catch (InputMismatchException e)
	   {
	    sc.next();
	    System.out.print("Error ingrese una opción! ");
	   }
	  }
	 }
	public static void cargarInstalaciones(SistemaSUSTO sistema) throws IOException {
		ArchivoEntrada archivoInstalaciones = new ArchivoEntrada("Instalaciones.txt");
		
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			//Se separa el registro en los campos que lo constituyen
			String nombreInstalacion = regEnt.getString(); 
			StdOut.println(nombreInstalacion);
			
			int cantDepartamentos =  regEnt.getInt();
			String[] ListaDepartamento = new String[cantDepartamentos];
			int[] ListaCapacidad = new int[cantDepartamentos];
			for(int i=0;i<cantDepartamentos;i++) {
				String Departamento = regEnt.getString();
				int capacidad = regEnt.getInt();
				ListaDepartamento[i]=Departamento;
				ListaCapacidad[i]=capacidad;				
			}
			for(int l=0;l<cantDepartamentos;l++){
				StdOut.print(ListaDepartamento[l]+",");
				StdOut.print(ListaCapacidad[l]);
				StdOut.println("");
			}
			
		}
		archivoInstalaciones.close();
		
	}
	public static void menu(SistemaSUSTO sistema) throws IOException {
        desplegarMenu();
        StdOut.println("Ingrese una opción ");
        int op = validarOpcion();
        while(op!=6){
            switch(op){
                case 1:
                	//Cargar archivo.
                	cargarInstalaciones(sistema);
                    
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
            StdOut.println("Ingrese una opción ");
            op = validarOpcion();
        }
	
	}
	public static void main(String[] args) throws IOException {
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