 /**
  * Aplicación general 
  * @author  Sebatián Sánchez - Tomás Sandoval
  * @param App.java
  * @throws IllegalArgumentException
  */
import ucn.*;
import java.io.IOException;
import java.util.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
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
	public static boolean validarFecha2(SistemaSUSTO sistema,String dateStr) {
		boolean result = sistema.isValidDate(dateStr);
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
    public static boolean validarHora(String hora){
    	boolean valido = false;
        try{
            LocalTime.parse(hora);
            valido= true;
        }catch(DateTimeParseException|NullPointerException e){
          
        } 
        return valido;
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
	public static boolean cargarTXTInstalaciones(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
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
				sistema.crearDpto(depto1, capacidad, presupuesto);	
			}
			resp = sistema.CargarInstalaciones(nombreInstalacion,cantDepartamentos,listaNuevaDI);
		}
		archivoInstalaciones.close();
		return resp;
	}
	public static boolean cargarTXTIngresos(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoInstalaciones = new ArchivoEntrada("Ingresos.txt");
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			String nombreInstalacion = regEnt.getString(); 
			String rut =  regEnt.getString();
			String fecha =  regEnt.getString();
			String hora = regEnt.getString();
			resp = sistema.CargarIngresos(nombreInstalacion,rut,fecha,hora);
		}
		archivoInstalaciones.close();
		return resp;
	}
	public static boolean cargarTXTEgresos(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoInstalaciones = new ArchivoEntrada("Salidas.txt");
		while(!archivoInstalaciones.isEndFile()){
			Registro regEnt = archivoInstalaciones.getRegistro();
			String nombreInstalacion = regEnt.getString(); 
			String rut =  regEnt.getString();
			String fecha =  regEnt.getString();
			String hora = regEnt.getString();
			resp = sistema.CargarSalidas(nombreInstalacion,rut,fecha,hora);
		}
		archivoInstalaciones.close();
		return resp;
	}
	public static boolean cargarTXTProyectos(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
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
			resp = sistema.CargarProyectos(CodigoProyecto,NombreProyecto,PresupuestoTotal,DptoResponsable,CantAreasEspecializacion,listaEspecializacion);
		}
		archivoProyecto.close();
		return resp;
	}
	public static boolean cargarTXTCientifico(SistemaSUSTO sistema) throws IOException {
		boolean resp = false;
		ArchivoEntrada archivoCientifico = new ArchivoEntrada("Cientificos.txt");
		while(!archivoCientifico.isEndFile()){
			Registro regEnt = archivoCientifico.getRegistro();
			String Rut = regEnt.getString();
			String Nombre = regEnt.getString();
			String ApellidoP = regEnt.getString();
			String ApellidoM = regEnt.getString();
			String Area = regEnt.getString();
			int CostoAsociado =  regEnt.getInt();
			String codProyecto = regEnt.getString();
			resp = sistema.CargarCientifico(Rut, Nombre, ApellidoP, ApellidoM, Area, CostoAsociado,codProyecto);
		}
		archivoCientifico.close();
		return resp;
	}
	public static boolean cargarTXT(SistemaSUSTO sistema) throws IOException {
		boolean resp1,resp2,resp3,resp4,resp5;
		resp1=cargarTXTInstalaciones(sistema);
		resp2=cargarTXTProyectos(sistema);
		resp3=cargarTXTCientifico(sistema);
		resp4 = cargarTXTIngresos(sistema);
		resp5 = cargarTXTEgresos(sistema);
		if(resp1==true && resp2 ==true && resp3 == true && resp4 ==true && resp5 == true) {
			return true;
		}else {
			return false;
		}
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
		ListaCientificos listaCientificicosGlobal = sistema.returnListaCient();
		Cientifico CientificoEncontrado = listaCientificicosGlobal.buscarCientifico(rut);
		if(CientificoEncontrado==null) {
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
				int r = i+1;
				StdOut.println("Ingrese código proyecto proyecto Nº "+r+" :");
				String codigo = StdIn.readString();
				ListaProyectos listaproyectosGlobal = sistema.returnListaProyectos();
				Proyecto proyectoEncontrado = listaproyectosGlobal.buscarProyecto(codigo);
				if(proyectoEncontrado!=null) {
					StdOut.println("Ingrese nombre proyecto proyecto Nº "+r+" :");
					String nombreProyecto = StdIn.readString();	
					Proyecto p1 = new Proyecto(codigo, nombreProyecto, 0, "buscar", 0, null);
					listaProyectoDelCientifico.ingresarProyecto(p1);
				}
			}
			boolean resp = sistema.ContratarCientifico(rut, nombre, apellidoP, apellidoM, AreaEspecializacion, costoAsociado, listaProyectoDelCientifico, dpto, instalacion);
			if(resp) {
				StdOut.println("Ingreso Correcto!");
			}else {
				StdOut.println("Ingreso Incorrecto!");
			}
		}else {
			StdOut.println("Ya existe este cientifico! Cuidado!");
		}
		
		
	}
	public static void menuCrearNuevasEntidades(SistemaSUSTO sistema) throws IOException {
		desplegarMenuCrearNuevasEntidades();
        StdOut.println("Ingrese una opción ");
        int opcion = validarOpcion();
        while(opcion!=4){
            switch(opcion){
                case 1:
                	CrearInstalacion(sistema);
                break;
                case 2:
                	CrearDpto(sistema);
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
        			if(proy.getDptoResponsable().equals(dep.getNombreDpto())){//primer if, 
        				StdOut.println("Proyecto(s): "+proy.getNombreProyecto());
        				for(int l=0;l<listaC.getCantCientificos();l++){
        					Cientifico cient = listaC.getCientificoI(l);
        					ListaProyectosCient listaProyC = cient.getListaProyectos();
        					for(int m=0;m<listaProyC.getCantProyecto();m++){
        						Proyecto proy1 = listaProyC.getProyectoI(m);
        						String nombreDeptoproyectoResponsable = proy1.getDptoResponsable();
        						if(proy1.getNombreProyecto().equals(proy.getNombreProyecto())      && proy1.getDptoResponsable().equals(dep.getNombreDpto())){//Segundo if
        							
        								StdOut.println("Personal: "+cient.getNombre()+" "+cient.getApellidoP());
        							
        						}
        					}
        				}
        			}
        		}
        	}
        	
        } 


    }	
    public static void ListadoPersonasDpto(SistemaSUSTO sistema){
        ListaProyectos listaP = sistema.returnListaProyectos();
        ListaCientificos listaC = sistema.returnListaCient();
        ListaDptos ListaD = sistema.returnListaDptos();     
        for(int i=0;i<ListaD.getCantDptos();i++){
            Departamento dep = ListaD.getDepartamento(i);
            StdOut.println("Departamento: "+dep.getNombreDpto());
            for(int j=0;j<listaP.getCantProyectos();j++){
                Proyecto proy = listaP.getProyectoI(j);
                if(dep.getNombreDpto().equals(proy.getDptoResponsable())){
                    StdOut.println("Proyecto(s): "+proy.getNombreProyecto());
                    for(int k=0;k<listaC.getCantCientificos();k++){
                        Cientifico cient = listaC.getCientificoI(k);
                        ListaProyectosCient LPC = cient.getListaProyectos();
                        for(int l=0;l<LPC.getCantProyecto();l++){
                            Proyecto proy1 = LPC.getProyectoI(l);
                            if(proy1.getNombreProyecto().equals(proy.getNombreProyecto())){
                                StdOut.println("Personal: "+ cient.getNombre()+" "+cient.getApellidoP());
                            }
                        }
                    }
                }
            }
        }
    }
	public static void desplegarMenuReportesDePersonalYCostos() {
		StdOut.println("1. Listado de personal \n2. Listado de proyecto \n3.Costos por proyecto \n4.Horas trabajadas  \n5.Movimientos \n6.Salir  ");
	}
	public static void ElegirPorInstalacionODepto(SistemaSUSTO sistema) {
		StdOut.println("1.Por instalación \n2. Por departamento");
			int opcion = validarOpcion();
			switch(opcion){
	        case 1:
	        	ListadoPersonalInsta(sistema);
	        break;
	        case 2:
	        	ListadoPersonasDpto(sistema);
	        break;
	    }
	}
	public static void CostosPorProyecto(SistemaSUSTO sistema){
        ListaProyectos listaP = sistema.returnListaProyectos();
        ListaCientificos listaC = sistema.returnListaCient();
        StdOut.println("Ingrese codigo del proyecto: ");
        String code = StdIn.readString();
        for (int i=0;i<listaP.getCantProyectos();i++){
            Proyecto proy = listaP.getProyectoI(i);
            if(proy.getCodigoProyecto().equals(code)){
                //validamos que el proyecto existe
                StdOut.println("Proyecto "+proy.getNombreProyecto()+" Presupuesto Total: "+proy.getPresupuestoTotal());
                for(int j=0;j<listaC.getCantCientificos();j++){
                    //recorro la lista general de cientificos y saco su lista de proyectos
                    Cientifico cient = listaC.getCientificoI(j);
                    ListaProyectosCient lista = cient.getListaProyectos();
                    for(int k=0;k<lista.getCantProyecto();k++){
                        //veo que cientificos trabajan en este proyecto e imprimo su nombre y costo asociado
                        Proyecto proy1 = lista.getProyectoI(k);
                        if(proy1.getCodigoProyecto().equals(code)){
                            StdOut.println("cientifico: "+cient.getNombre()+", costo Asociado: "+cient.getCostoAsociado());
                        }
                    }
                }
            }
            else{
                StdOut.println("Proyecto no encontrado");
            }
        }
             
    }
	public static void menuReportesDePersonalYCostos(SistemaSUSTO sistema) throws ParseException {
    	desplegarMenuReportesDePersonalYCostos();
        StdOut.println("Ingrese una opción ");
        int opcion = validarOpcion();
        while(opcion!=6){
            switch(opcion){
                case 1:
                	ElegirPorInstalacionODepto(sistema);
                break;
                case 2:
                	listadoProyectoPersonal(sistema);
                break;
                case 3:
                	CostosPorProyecto(sistema);
                break;
                case 4:
                	HorasTrabajadas(sistema);
                break;
                case 5:
                	StdOut.println("Problemas técnicos");//creamos clase y su contenedor. 
                break;
                case 6:
                	StdOut.println("Salida con éxito!");
                break;

            }
        	desplegarMenuReportesDePersonalYCostos();
            opcion = validarOpcion();
        }
	}
	public static void CrearInstalacion(SistemaSUSTO sistema) {
		StdOut.println("Ingrese el nombre de la instalación:");
		String NombreInstalacion = StdIn.readString();
		ListaInsta listaInstalacionTraida = sistema.returnListaInsta();
		Instalaciones instaEncontrada = listaInstalacionTraida.buscarInsta(NombreInstalacion);
		if(instaEncontrada==null) {	
			StdOut.println("Ingrese la cantidad de departamentos que tiene la instalación");
			int CantidadDptos = validarOpcion();
			ListaDepartamentoInstalacion listaNuevaDepto = new ListaDepartamentoInstalacion(CantidadDptos);
			for(int i=0;i<CantidadDptos;i++) {
				int re = i+1;
				StdOut.println("Ingrese el nombre del departamento Nº"+re+" :");
				String nombreDpto = StdIn.readString();
				ListaDptos listaDepartamentosglobal = sistema.returnListaDptos();
				Departamento deptoEncontrado = listaDepartamentosglobal.buscarDpto(nombreDpto);
				if(deptoEncontrado!=null) {
					StdOut.println("Ingrese la capacidad del departamento:  ");
					int CapacidadDpto = validarOpcion();
					StdOut.println("Ingrese el presupuesto del departamento "+nombreDpto+" : ");
					int presupuesto =validarOpcion();
					Departamento depto = new Departamento(nombreDpto, CapacidadDpto, presupuesto);
					listaNuevaDepto.ingesarDptoInstalacion(depto);
				}else {
					StdOut.println("No existe el departamento de "+nombreDpto+", primero debe crear Departamento!");
				}
			}
			if(sistema.CrearInstalacion(NombreInstalacion, CantidadDptos,listaNuevaDepto)) {
				StdOut.println("Ingreso correctamente!");
				
			}else {
				StdOut.println("Ingreso incorrecto!");
			}
		}else {
			StdOut.println("Ya existe la instalacion "+NombreInstalacion+"!");
		}
	}
	public static void CrearDpto(SistemaSUSTO sistema) {
		StdOut.println("Ingrese el nombre del departamento:");
		String nomDpto = StdIn.readString();
		StdOut.println("Ingrese la capacidad del departamento "+nomDpto+" :");
		int capacidad = validarOpcion();
		StdOut.println("Ingrese el presupuesto del departamento "+nomDpto+" :");
		int presupuesto = validarOpcion();
		if(sistema.crearDpto(nomDpto, capacidad, presupuesto)) {
			StdOut.println("Departamento ingresado correctamente!");
		}else {
			StdOut.println("Departamento ya existe!");
		}
	}
	public static void HorasTrabajadas(SistemaSUSTO sistema) throws ParseException{     
        ListaProyectos listaProyectos = sistema.returnListaProyectos();
        ListaCientificos listaCientificos = sistema.returnListaCient();
        ListaIngresos listaIngresos = sistema.returnListaIngresos();
        ListaSalidas listaSalidas = sistema.returnListaSalidas();
		for(int i=0;i<listaProyectos.getCantProyectos();i++){
            Proyecto proy = listaProyectos.getProyectoI(i);
            StdOut.println("Proyecto: "+proy.getNombreProyecto());
            for(int j=0;j<listaCientificos.getCantCientificos();j++){
                Cientifico cient = listaCientificos.getCientificoI(j);
                ListaProyectosCient listaProyecto1 = cient.getListaProyectos();
                for(int m=0;m<listaProyecto1.getCantProyecto();m++) {
                	Proyecto proy1 = listaProyecto1.getProyectoI(m);
                	if(proy1.getDptoResponsable().equals(proy.getDptoResponsable())){
                		//si se cumple significa que el cientifico trabaja en proy1.
                		StdOut.println("Cientifico: "+cient.getNombre()+" "+cient.getApellidoP());
                		for(int k=0;k<listaIngresos.getCantIngresos();k++){
                			Ingreso ingreso = listaIngresos.getIngresoI(k);
                			String horaI = ingreso.getHora();
                			for(int l=0;l<listaSalidas.getCantSalidas();l++){
                				Salida salida = listaSalidas.getSalidaI(l);
                				String horaS = salida.getHora();
                				if(ingreso.getRutCientifico().equals(salida.getRutCientifico())){
                					boolean horaIng = false;
                					boolean horaSal = false;
                					try{
                						LocalTime.parse(horaI);
                						LocalTime.parse(horaS);
                						horaIng = true;
                						horaSal = true;
                					}catch(DateTimeParseException|NullPointerException e){
                						StdOut.println("hora invalida");
                					}
                					if(horaIng == true && horaSal == true){
                						String dateStart = horaI;
                						String dateStop = horaS;
                						SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                						Date d1 = null;
                						Date d2 = null;
                						try{
                							d1 = format.parse(dateStart);
                							d2 = format.parse(dateStop);
                							long diff = d2.getTime()-d1.getTime();
                							long diffMinutes = diff/(60*1000)%60;
                							long diffHours = diff/(60*60*60)%24;
                							StdOut.println("tiempo trabajado: "+diffHours+" horas "+diffMinutes+" minutos");
                							
                						}catch(Exception e){
                							e.printStackTrace();
                						}
                					}
                				}
                			}
                		}
                		
                	}
                	
                }
            }
        }
        
    }    
	public static void  EnlistarIngreso(SistemaSUSTO sistema) {
		StdOut.println("Ingrese la Instalación: ");
		String instalacion = StdIn.readString();
		StdOut.println("Ingrese el Rut del Cientifico: ");
		String rutCientifico = StdIn.readString();
		StdOut.println("Ingrese la fecha (dd/MM/yyyy) : ");
		String fecha = StdIn.readString();
		boolean resultado = validarFecha2(sistema,fecha);
		while(!resultado) {
			StdOut.println("Ingrese fecha correcta!");
			fecha = StdIn.readString();
			resultado = validarFecha2(sistema,fecha);
		}
		StdOut.println("Ingrese la hora (hh:mm) : ");
		String hora = StdIn.readString();
		boolean horaValidar = validarHora(hora);
		while(!resultado) {
			StdOut.println("Ingrese fecha correcta!");
			hora = StdIn.readString();
			horaValidar = validarHora(hora);
		}
		if(sistema.RegistrarIngreso(instalacion,rutCientifico,fecha,hora)) {
			StdOut.println("Ingreso correcto!");
		}else {
			StdOut.println("Ingreso incorrecto!");
		}
		
		//RegistrarIngreso(String instalacion,String rutCientifico,
		//String fecha,String hora, ListaInstalacionesCient listaInstalacionesCient)
	}
	public static void  EnlistarSalida(SistemaSUSTO sistema) {
		StdOut.println("Ingrese la Instalación: ");
		String instalacion = StdIn.readString();
		StdOut.println("Ingrese el Rut del Cientifico: ");
		String rutCientifico = StdIn.readString();
		StdOut.println("Ingrese la fecha (dd/MM/yyyy) : ");
		String fecha = StdIn.readString();
		boolean resultado = validarFecha2(sistema,fecha);
		while(!resultado) {
			StdOut.println("Ingrese fecha correcta!");
			fecha = StdIn.readString();
			resultado = validarFecha2(sistema,fecha);
		}
		StdOut.println("Ingrese la hora (hh:mm) : ");
		String hora = StdIn.readString();
		boolean horaValidar = validarHora(hora);
		while(!resultado) {
			StdOut.println("Ingrese fecha correcta!");
			hora = StdIn.readString();
			horaValidar = validarHora(hora);
		}
		if(sistema.RegistrarSalida(instalacion,rutCientifico,fecha,hora)) {
			StdOut.println("Ingreso correcto!");
		}else {
			StdOut.println("Ingreso incorrecto!");
		}
	}
	public static void menuEntradaSalida(SistemaSUSTO sistema) {
		StdOut.println("1. Regisrar Ingreso \n2. Registrar Salida \n3. Salir ");
		StdOut.println("Ingrese una opción ");
        int op = validarOpcion();
        while(op!=3){  	
            switch(op){
                case 1:
                	EnlistarIngreso(sistema);
                break;
                case 2:
                	EnlistarSalida(sistema);
                break;
                case 3:
                break;
            }
            StdOut.println("1. Regisrar Ingreso \n2. Regisrar Salida \n3. Salir ");
            StdOut.println("Ingrese una opción ");
            op = validarOpcion();
        }
		
	}
	public static void reasignarCientificoProyecto(SistemaSUSTO sistema) {
		StdOut.println("Ingrese el rut del cientifico (XX.XXX.XXX-X): ");
		String rutCientifico = StdIn.readString();
		boolean respuesta=validarRut(rutCientifico);
		while(respuesta != true) {
			StdOut.println("Ingrese el rut del cientifico: ");
			rutCientifico = StdIn.readString();
			respuesta=validarRut(rutCientifico);
		}
		StdOut.println("Ingrese el código del proyecto anterior:");
		String codProyectoA = StdIn.readString();
		StdOut.println("Ingrese el código del proyecto nuevo:");
		String codProyectoN= StdIn.readString();
		if(sistema.reasignarCientificoProyecto(rutCientifico, codProyectoA, codProyectoN)) {
			StdOut.println("Reasignación correcta!");
		}else {
			StdOut.println("Reasignación incorrecta!");
		}
	}
	public static void reasignarCientificoInstalacion(SistemaSUSTO sistema) {
		StdOut.println("Ingrese el rut del cientifico (XX.XXX.XXX-X): ");
		String rutCientifico = StdIn.readString();
		boolean respuesta=validarRut(rutCientifico);
		while(respuesta != true) {
			StdOut.println("Ingrese el rut del cientifico: ");
			rutCientifico = StdIn.readString();
			respuesta=validarRut(rutCientifico);
		}
		StdOut.println("Ingrese el nombre de la instalación anterior:");
		String nomInstalacionA = StdIn.readString();
		StdOut.println("Ingrese el nombre de la instalación nueva:");
		String nomInstalacionN= StdIn.readString();
		if(sistema.reasignarCientificoInstalacion(rutCientifico, nomInstalacionA, nomInstalacionN)) {
			StdOut.println("Reasignación correcta!");
		}else {
			StdOut.println("Reasignación incorrecta!");
		}		
	}
	public static void menuReasignarCientifico(SistemaSUSTO sistema) {
		StdOut.println("1. Reasignar cientifico por proyecto \n2. Reasignar cientifico por instalacion \n3. Salir");
		int op = validarOpcion();
        while(op!=3){  	
            switch(op){
            	case 1:
            		reasignarCientificoProyecto(sistema);
            	break;
            	case 2:
            		reasignarCientificoInstalacion(sistema);
                break;
            	case 3:
            		StdOut.println("Salio correctamente!");
                break;
            }
            StdOut.println("1. Reasignar cientifico por proyecto \n2. Reasignar cientifico por instalacion \n3. Salir");
            StdOut.println("Ingrese una opción ");
            op = validarOpcion();
        }
    }
	public static void menu(SistemaSUSTO sistema) throws IOException, ParseException {
        desplegarMenu(); 
        StdOut.println("Ingrese una opción ");
        int op = validarOpcion();
        boolean cargoTXT = false;
        while(op!=6){  	
            switch(op){
                case 1:
                	boolean respTXT = false;
                	cargoTXT = true;
                	respTXT=cargarTXT(sistema);
                	if(respTXT) {
                		StdOut.println("Datos cargados exitosamente");                		
                	}else {
                		StdOut.println("Revise la carpeta de los archivos TXT");
                	}
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
                		menuEntradaSalida(sistema);                		
                	}else {
                		StdOut.println("Debe cargar los arhivos txt!");
                	}
                break;
                case 4:
                	if(cargoTXT == true) {
                		menuReasignarCientifico(sistema);                		
                	}else {
                		StdOut.println("Debe cargar los arhivos txt!");
                	}
                break;
                case 5:
                	if(cargoTXT == true) {
                		menuReportesDePersonalYCostos(sistema);              		
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
        ActualizarTXT(sistema);
	}
	public static void sacarTXTCientifico(SistemaSUSTO sistema)throws IOException{
		ListaCientificos listaGlobCienti = sistema.returnListaCient();
		ArchivoSalida archivo = new ArchivoSalida("Cientificos.txt");
		for(int i =0;i<listaGlobCienti.getCantCientificos();i++) {
			Cientifico sc1 = listaGlobCienti.getCientificoI(i);
			if(sc1!=null) {
				ListaProyectosCient lista = sc1.getListaProyectos();
				for(int k=0;k<lista.getCantProyecto();k++) {
					if(lista.getProyectoI(k).getCodigoProyecto()!=null) {
						StdOut.println(lista.getProyectoI(k).getCodigoProyecto());
						Registro linea = new Registro(7);
						linea.agregarCampo(sc1.getRut());
						linea.agregarCampo(sc1.getNombre());
						linea.agregarCampo(sc1.getApellidoP());
						linea.agregarCampo(sc1.getApellidoM());
						linea.agregarCampo(sc1.getArea());
						linea.agregarCampo(sc1.getCostoAsociado());
						linea.agregarCampo(lista.getProyectoI(k).getCodigoProyecto());
						archivo.writeRegistro(linea);		
					}
				}	
			}
		}
		archivo.close();
	}
	public static void sacarTXTProyectos(SistemaSUSTO sistema)throws IOException{
		ListaProyectos listaGlobProyec = sistema.returnListaProyectos();
		ArchivoSalida archivo = new ArchivoSalida("Proyectos.txt");
		for(int i =0;i<listaGlobProyec.getCantProyectos();i++) {
			Proyecto py1 = listaGlobProyec.getProyectoI(i);
			if(py1!=null) {
				ListaAreaEspecializacion lista = py1.getListaEspecializacion();
				for(int k=0;k<lista.getcantArea();k++) {
					if(lista.getAreaEspecializacionI(k).getNombre()!=null) {
						Registro linea = new Registro(6);
						linea.agregarCampo(py1.getCodigoProyecto());
						linea.agregarCampo(py1.getNombreProyecto());
						linea.agregarCampo(py1.getPresupuestoTotal());
						linea.agregarCampo(py1.getDptoResponsable());
						linea.agregarCampo(py1.getCantAreasEspecializacion());
						linea.agregarCampo(lista.getAreaEspecializacionI(k).getNombre());
						archivo.writeRegistro(linea);		
					}
				}	
			}
		}
		archivo.close();
	}
	public static void sacarTXTInstalaciones(SistemaSUSTO sistema)throws IOException{
		ListaInsta listaGlobal = sistema.returnListaInsta();
		ArchivoSalida archivo = new ArchivoSalida("Instalaciones.txt");
		for(int i =0;i<listaGlobal.CantInsta();i++) {
			Instalaciones is1 = listaGlobal.getInstI(i);
			if(is1!=null) {
				ListaDepartamentoInstalacion lista = is1.getListaDepartamentoInstalacion();
				for(int k=0;k<lista.getCantDptosInstalacion();k++) {
					if(lista.getDepartamentoInstalacion(k).getNombreDpto()!=null) {
						Registro linea = new Registro(5);
						linea.agregarCampo(is1.getNombreInstalacion());
						linea.agregarCampo(is1.getCantidadDptos());
						linea.agregarCampo(lista.getDepartamentoInstalacion(k).getNombreDpto());
						linea.agregarCampo(lista.getDepartamentoInstalacion(k).getCapacidadDpto());
						linea.agregarCampo(lista.getDepartamentoInstalacion(k).getPresupuesto());
						archivo.writeRegistro(linea);		
					}
				}	
			}
		}
		archivo.close();
	}
	public static void ActualizarTXT(SistemaSUSTO sistema)throws IOException{
		sacarTXTCientifico(sistema);
		sacarTXTProyectos(sistema);
		sacarTXTInstalaciones(sistema);
	}
	public static void main(String[] args) throws IOException, ParseException {
		StdOut.println("¡Bienvenido al sistema SUSTO!");
		SistemaSUSTO sistema = new SistemaSUSTOImpl();
		StdOut.println("Ingrese la fecha (dd/MM/yyyy) :");
		String dateStr = StdIn.readString();
		boolean resultado = validarFecha(sistema,dateStr);

		while(!resultado) {
			StdOut.println("Ingrese fecha actual!");
			dateStr = StdIn.readString();
			resultado = validarFecha(sistema,dateStr);

		}
		menu(sistema);
	}
}