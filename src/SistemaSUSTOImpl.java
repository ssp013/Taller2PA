import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import ucn.*;
/**
 *
 * @author TomasSandoval Sebastian Sanchez
 */
public class SistemaSUSTOImpl implements SistemaSUSTO {
    private ListaCientificos listaCientificos;
    private ListaDptos listaDptos;
    private ListaProyectos listaProyectos;
    private ListaInsta listaInsta;
    //private ListaAsociacionCP listaAsociacionCP;
    //private ListaAsociacionCI listaAsociacionCI;
    private ListaIngresos listaIngresos;
    private ListaSalidas listaSalidas;

	private String dateFormat;
	@Override
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos,String []listaDptos,int []listaCapacidades) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean ContratarCientifico(String Rut, String Nombre, String ApellidoP, String ApellidoM, String Area,int CostoAsociado) {
		//Verificar si existe cientifico en BD o lo agregamos.
		Cientifico cientifico = new Cientifico(Rut,Nombre,ApellidoP,ApellidoM,Area,CostoAsociado);//proyecto,dpto,instalacion
		boolean ingreso = listaCientificos.ingresarCientifico(cientifico);
		return ingreso;
	}

	
	
	@Override
	public boolean RegistrarIngreso(String Instalacion, String rutCientifico, String fecha, String hora) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean RegistrarSalida(String Instalacion, String rutCientifico, String fecha, String hora) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean ReasignarCientifico(String OpcionCambio) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean contratarCientifico(String nombre, String apellidoP, String apellidoM, String Area,
			int costoAsociado, String proyecto, String dpto, String instalacion) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isValid(String dateStr) {
		try {//"dd/MM/yyyy")
			String[] partes = dateStr.split("/");
			int year = Integer.parseInt(partes[2]);                
			int month =Integer.parseInt(partes[1]);                      
			int dayOfMonth = Integer.parseInt(partes[0]);            
			
			if (year < 1900) {
				return false;//año invalido.
			}
			else {
				LocalDate today = LocalDate.of(year, month, dayOfMonth);//tira un false..
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				return true;
				//System.out.println(formatter.format(today)); // 01/01/2016
			}
		}
		catch(java.time.DateTimeException e) {
			return false;
		}
		
	}
}