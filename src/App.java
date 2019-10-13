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
	public static boolean validarRut(String rut) {
		boolean validacion = false;
		try {
		rut =  rut.toUpperCase();
		rut = rut.replace(".", "");
		rut = rut.replace("-", "");
		int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
		char dv = rut.charAt(rut.length() - 1);
		int m = 0, s = 1;
		for (; rutAux != 0; rutAux /= 10) {
		s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
		}
		if (dv == (char) (s != 0 ? s + 47 : 75)) {
		validacion = true;
		}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return validacion;
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
	public static void desplegarMenuCrearNuevasEntidades() {
		StdOut.println("1. Crear Instalación \n2. Crear Departamento \n3. Contratar Científico \n4.Salir ");
	}
	public static void contratarCientificos(SistemaSUSTO sistema) {
		StdOut.println("Ingrese el rut del cientifico: ");
		String rut = StdIn.readString();
		boolean respuesta = validarRut(rut);
		if(respuesta) {
			StdOut.println("es un rut");
		}else {
			StdOut.println("No es un Rut");
		}
		
		
		//sistema.ContratarCientifico(rut, nombre, apellidoP, apellidoM, AreaEspecializacion, costoAsociado, listaProyectoCient, dpto, instalacion);
	}
	public static void menuCrearNuevasEntidades(SistemaSUSTO sistema) throws IOException {
		desplegarMenuCrearNuevasEntidades();
        StdOut.println("Ingrese una opción ");
        int op = validarOpcion();
        while(op!=4){
            switch(op){
                case 1:
                	//Cargar archivo.
                	
                break;
                case 2:
                	//Creamos nuevas entidades.
                	
                break;
                case 3:
                	contratarCientificos(sistema);
                break;
                case 4:
                
                break;
            }
            desplegarMenuCrearNuevasEntidades();
            StdOut.println("Ingrese una opción ");
            op = validarOpcion();
        }	
	}
	
	public static void menu(SistemaSUSTO sistema) throws IOException {
        desplegarMenu();
        StdOut.println("Ingrese una opción ");
        int op = validarOpcion();
        while(op!=6){
            switch(op){
                case 1:
                	cargarInstalaciones(sistema);
                break;
                case 2:
                	cargarInstalaciones(sistema);
                break;
                case 3:
                	cargarInstalaciones(sistema);
                break;
                case 4:
                	cargarInstalaciones(sistema);
                break;
                case 5:
                	cargarInstalaciones(sistema);
                break;
                case 6:
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