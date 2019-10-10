import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 *
 * @author TomasSandoval Sebastian Sanchez
 */
public class SistemaSUSTOImpl implements SistemaSUSTO {
	private String dateFormat;
	@Override
	public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ContratarCientifico(String Rut, String Nombre, String ApellidoP, String ApellidoM, String Area,
			int CostoAsociado) {
		// TODO Auto-generated method stub
		return false;
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

	/*@Override
	public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }*/
 
    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	

}
