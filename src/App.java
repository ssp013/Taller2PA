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
	    System.out.print("Error: Ingrese nuevamente : ");
	   }
	  }
	 }
	public static String validarOpcionString()
	 {
	  while (true)
	  {
	   try
	   {
	    return sc.nextLine();
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
		StdOut.println("Ingrese el rut del cientifico (XX.XXX.XXX-X): ");
		String rut = StdIn.readString();
		boolean respuesta=validarRut(rut);
		while(respuesta != true) {
			StdOut.println("Ingrese el rut del cientifico: ");
			rut = StdIn.readString();
			respuesta=validarRut(rut);
		}
		StdOut.println("Ingrese el nombre del cientifico :");
		String nombre = StdIn.readString();
		StdOut.println("Ingrese el apellido paterno del cientifico : ");
		String apellidoP = StdIn.readString();
		StdOut.println("Ingrese el apellido materno del cientifico: ");
		String apellidoM = StdIn.readString();
		StdOut.println("Ingrese su área de especialización:");
		String AreaEspecializacion = StdIn.readString();
		StdOut.println("Ingrese el su costo asociado:  ");
		int costoAsociado = validarOpcion();
		StdOut.println("Ingrese el departamento que se le asiganará a "+nombre+" "+apellidoP+" : ");
		String dpto = StdIn.readString();
		StdOut.println("Ingrese la instalación que se le asiganará a "+nombre+" "+apellidoP+" : ");
		String instalacion = StdIn.readString();
		//Solicitar los proyectos a los cuáles se asignará:
		StdOut.println("Ingrese la cantidad de proyectos de "+nombre+" "+apellidoP+" : ");
		int n = validarOpcion();
		ListaProyectosCient listaProyectoDelCientifico = new ListaProyectosCient(n);
		for(int i=0;i<n;i++) {
			StdOut.println("Ingrese código proyecto proyecto N "+i+1+" :");
			String codigo = StdIn.readString();
			StdOut.println("Ingrese nombre proyecto proyecto N "+i+1+" :");
			String nombreProyecto = StdIn.readString();
			Proyecto p1 = new Proyecto(codigo, nombreProyecto, 0, null, 0, null);
			listaProyectoDelCientifico.ingresarProyecto(p1);
		}
		boolean resp = sistema.ContratarCientifico(rut, nombre, apellidoP, apellidoM, AreaEspecializacion, costoAsociado, listaProyectoDelCientifico, dpto, instalacion);
		if(resp) {
			StdOut.println("Ingreso correcto ");
		}else {
			StdOut.println("Error! al contratar Científico");			
		}
	}
	public static void menuCrearNuevasEntidades(SistemaSUSTO sistema) throws IOException {
		desplegarMenuCrearNuevasEntidades();
        StdOut.println("Ingrese una opción ");
        int opcion = validarOpcion();
        while(opcion!=4){
            switch(opcion){
                case 1:
                	StdOut.println("Hola");
                break;
                case 2:
                	StdOut.println("Hola");
                break;
                case 3:
                	contratarCientificos(sistema);
                break;
                case 4:
                	StdOut.println("Salir");
                break;

            }
            desplegarMenuCrearNuevasEntidades();
            opcion = validarOpcion();
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
                	menuCrearNuevasEntidades(sistema);
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