import ucn.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
	//Comprobar Fecha:
	public static void ComprobarFecha() {
		Date fecha = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");
		String todayDay = timeFormat.format(fecha);
		
		StdOut.println("Ingrese la fecha actual (dd/mm/yyyy");
		String DateInsert = StdIn.readString();
	}
	public static void VerificarFecha() {
		try {
			String fechaIngreso ="30/02/2016";
			Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaIngreso);
			String fechaSalida = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
			StdOut.println ("ingreso: "+fechaIngreso);
			StdOut.println(fecha);
			StdOut.println(fechaSalida);	
			StdOut.println((fechaIngreso.equals(fechaSalida))?"fecha correcta":"fecha incorrecta");
		} catch (Exception e) {
			if
		}
	}
	//Funciones: 
	public static void menu() {
		//Declaracion de variables:
		StdOut.println("¡Bienvenido al sistema SUSTO!");
		VerificarFecha();//Verificamos fecha ingresada..
		//Opcion MENU:
		int opcion=0;
		while(opcion!= 6) {
			StdOut.println("1. Cargar Archivos \n2. Crear Nuevas Entidades \n3. Registrar Ingreso y Salida \n4. Reasignar Científico \n5. Reportes de Personal y Costos \n6. Cierre de Sistema");
			opcion = StdIn.readInt();
		}
	
	}
	public static void main(String[] args) {
		menu();
		
	}

}