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
	public static void cargarTXTInstalaciones(SistemaSUSTO sistema) throws IOException {
		ArchivoEntrada archivoInstalaciones = new ArchivoEntrada("Instalaciones.txt");
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			String nombreInstalacion = regEnt.getString(); 
			int cantDepartamentos =  regEnt.getInt();
			ListaDepartamentoInstalacion listaNuevaDI = new ListaDepartamentoInstalacion(cantDepartamentos);
			for(int i=0;i<cantDepartamentos;i++) {
				String depto1 = regEnt.getString();
				int capacidad = regEnt.getInt();
				int presupuesto = regEnt.getInt();
				Departamento NuevoDepartamento = new Departamento(depto1, capacidad, presupuesto);
				listaNuevaDI.ingesarDptoInstalacion(NuevoDepartamento);
			}
			sistema.CargarInstalaciones(nombreInstalacion,cantDepartamentos,listaNuevaDI);
		}
		archivoInstalaciones.close();
	}
	public static void cargarTXTProyectos(SistemaSUSTO sistema) throws IOException {
		ArchivoEntrada archivoProyecto = new ArchivoEntrada("Proyectos.txt");
		while(!archivoProyecto.isEndFile()){
			Registro regEnt = archivoProyecto.getRegistro();
			String CodigoProyecto = regEnt.getString();
			String NombreProyecto = regEnt.getString();
			int PresupuestoTotal = regEnt.getInt();
			String DptoResponsable = regEnt.getString();
			int  CantAreasEspecializacion = regEnt.getInt();
			ListaAreaEspecializacion  listaEspecializacion = new ListaAreaEspecializacion(CantAreasEspecializacion);
			for(int i =0; i<CantAreasEspecializacion;i++) {
				String areas = regEnt.getString();
				AreaEspecializacion ObjetoArea = new AreaEspecializacion(areas);				
				boolean realizado = listaEspecializacion.ingresarEspecializacion(ObjetoArea);
			}
			sistema.CargarProyectos(CodigoProyecto,NombreProyecto,PresupuestoTotal,DptoResponsable,CantAreasEspecializacion,listaEspecializacion);
		}
		archivoProyecto.close();
	}
	public static void cargarTXTCientifico(SistemaSUSTO sistema) throws IOException {
		ArchivoEntrada archivoCientifico = new ArchivoEntrada("Cientificos.txt");
		while(!archivoCientifico.isEndFile()){
			Registro regEnt = archivoCientifico.getRegistro();
			String Rut = regEnt.getString();
			String Nombre = regEnt.getString();
			String ApellidoP = regEnt.getString();
			String ApellidoM = regEnt.getString();
			String Area = regEnt.getString();
			int CostoAsociado =  regEnt.getInt();
			sistema.CargarCientifico(Rut, Nombre, ApellidoP, ApellidoM, Area, CostoAsociado);
		}
		archivoCientifico.close();
	}
	public static void cargarTXT(SistemaSUSTO sistema) throws IOException {
		cargarTXTInstalaciones(sistema);
		cargarTXTProyectos(sistema);
		cargarTXTCientifico(sistema);
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
			Proyecto p2 = new Proyecto(nombreProyecto, nombreProyecto, i, nombreProyecto, i, null);
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
	public static void listadoProyectoPersonal(SistemaSUSTO sistema) {
		ListaProyectos listaP = sistema.returnListaProyectos();
		ListaCientificos listaC = sistema.returnListaCient();
		for(int i=0;i<listaP.getCantProyectos();i++){
			Proyecto proy = listaP.getProyectoI(i);
			StdOut.println("Proyecto: "+proy.getNombreProyecto());
			for(int j=0;j<listaC.getCantCientificos();j++){
				Cientifico cient = listaC.getCientificoI(j);
				String nombre = cient.getNombre();
				String ApellidoP = cient.getApellidoP();
				ListaProyectosCient LPC = cient.getListaProyectos();
				for(int k=0;k<LPC.getCantProyecto();k++){
					Proyecto proy1 = LPC.getProyectoI(k);
					if(proy1.getNombreProyecto().equals(proy.getNombreProyecto())){
						StdOut.println(nombre+" "+ApellidoP);
					}
				}
			}
		}
	}
	public static void ListadoPersonalInsta(SistemaSUSTO sistema){
        ListaProyectos listaP = sistema.returnListaProyectos();
        ListaCientificos listaC = sistema.returnListaCient();
        ListaInsta ListaI = sistema.returnListaInsta();
        for(int i=0;i<ListaI.CantInsta();i++){
            Instalaciones insta = ListaI.getInstI(i);
            StdOut.println("Instalacion: "+insta.getNombreInstalacion());
            ListaDepartamentoInstalacion listaDepaIn = insta.getListaDepartamentoInstalacion();
            for(int j=0;j<listaDepaIn.getCantDptosInstalacion();j++){
                Departamento dep = listaDepaIn.getDepartamentoInstalacion(j);
                StdOut.println("Departamento(s): "+dep.getNombreDpto());
                for(int k=0;k<listaP.getCantProyectos();k++){
                    Proyecto proy = listaP.getProyectoI(k);
                    if(proy.getDptoResponsable().equals(dep.getNombreDpto())){
                        StdOut.println("Proyecto(s): "+proy.getNombreProyecto());
                        for(int l=0;l<listaC.getCantCientificos();l++){
                            Cientifico cient = listaC.getCientificoI(l);
                            ListaProyectosCient listaProyC = cient.getListaProyectos();
                            for(int m=0;m<listaProyC.getCantProyecto();m++){
                                Proyecto proy1 = listaProyC.getProyectoI(m);
                                if(proy1.getNombreProyecto().equals(proy.getNombreProyecto())){
                                    StdOut.println("Personal: "+cient.getNombre()+" "+cient.getApellidoP());
                                }
                            }
                        }
                    }
                }
            }
            
        } 
    }	
	public static void menu(SistemaSUSTO sistema) throws IOException {
        desplegarMenu(); 
        StdOut.println("Ingrese una opción ");
        int op = validarOpcion();
        boolean cargoTXT = false;
        while(op!=6){  	
            switch(op){
                case 1:
                	cargoTXT = true;
                	cargarTXT(sistema);
                	listadoProyectoPersonal(sistema);
                	ListadoPersonalInsta(sistema);
                break;
                case 2:
                	if(cargoTXT == true) {
                		menuCrearNuevasEntidades(sistema);                		
                	}else {
                		StdOut.println("Debe cargar los arhivos txt!");
                	}
                break;
                case 3:
                	if(cargoTXT == true) {
                		menuCrearNuevasEntidades(sistema);                		
                	}else {
                		StdOut.println("Debe cargar los arhivos txt!");
                	}
                break;
                case 4:
                	if(cargoTXT == true) {
                		menuCrearNuevasEntidades(sistema);                		
                	}else {
                		StdOut.println("Debe cargar los arhivos txt!");
                	}
                break;
                case 5:
                	if(cargoTXT == true) {
                		menuCrearNuevasEntidades(sistema);                		
                	}else {
                		StdOut.println("Debe cargar los arhivos txt!");
                	}
                break;
                case 6:
                	StdOut.println("Muchas gracias por ocupar sistema SUSTO ");
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