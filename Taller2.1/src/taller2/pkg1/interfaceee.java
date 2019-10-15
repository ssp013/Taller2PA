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
public interface interfaceee {
    public boolean CrearInstalacion(String NombreInstalacion, int CantidadDptos);
    //Descripcion: Crea una nueva instalacion.
    //PreCondiciones: Instalacion a crear no debe existir en la lista general de instalaciones.
    //PostCondiciones: Instalacion creada. 
   
    public boolean RegistrarIngreso(String Instalacion, String rutCientifico, String fecha, String hora);
    //Descripcion: Registra el ingreso de un Cientifico.
    //PreCondiciones: El cientifico debe estar en la lista general de cientificos. El cientifico debe haber salido para poder ingresar. La instalacion debe estar en la lista de instalaciones del cientifico.
    //PostCondiciones: Ingreso registrado.
   
    public boolean RegistrarSalida(String Instalacion, String rutCientifico, String fecha, String hora);
    //Descripcion: Registra la salida de un Cientifico.
    //PreCondiciones: El cientifico debe estasr en la lista general de cientificos. El cientifico debe haber entrado para poder salir. La instalacion debe estar en la lista de instalaciones del cientifico. 
    //PostCondiciones: Salida Registrada
    
    public boolean reasignarCientificoProyecto(String rutCientifico, String codProyectoA, String codProyectoN, ListaProyectosCient listaProyectosCient);
    //Descripcion: Reasignacion de proyecto(s) a un cientifico.
    //PreCondiciones: El cientifico debe estar en la lista  general de cientificos. ProyectoA debe estar en la lista de proyectos del cientifico. ProyectoN debe estar en la lista general de proyectos.
    //PostCondiciones: Reasignacion hecha.
   
    public boolean reasignarCientificoInstalacion(String rutCientifico, String nomInstalacionA, String nomInstalacionN, ListaInstalacionesCient listaInstalacionesCient);       
    //Descripcion: Reasignacion de una instalacion a un cientifico.
    //PreCondicion: El cientifico debe estar en la lista general de cientificos. nomInstalacionA debe estar en la lista de instalaciones del cientifico. nomInstalacionN debe estar en la lista general de cientificos.
    //PostCondiciones: Reasignacion hecha.
           
    public boolean isValid(String dateStr);
    //Descripcion: Verifica que el formato de la fecha sea el correcto y que fecha exista, por ejemplo, rechaza un 32 de febrero
    //PreCondicion:
    //PostCondiciones: Fecha validada.
              
    public boolean ContratarCientifico(String rut, String nombre, String apellidoP, String apellidoM, String AreaEspecializacion, int costoAsociado, ListaProyectosCient listaProyectoCient, String dpto,String instalacion);
    //Descripcion: Contrata un nuevo cientifico.
    //PreCondicion: El cientifico debe existir. La instalacion debe existir. El departamento debe existir. El presupuesto debe ser mayor o igual al costo asociado del cientifico. 
    //PostCondiciones: Cientifico contratado.
            
    public boolean CargarInstalaciones(String nombreInstalacion,int cantDepartamentos,ListaDepartamentoInstalacion listaNuevaDI);
    //Descripcion: Crea un objeto instalacion, le saca el departamento y lo guarda en su lista de departamentos. Se carga a lista general de instalaciones.
    //PreCondicion: 
    //PostCondiciones: objeto cargado.
                   
    public boolean CargarProyectos(String CodigoProyecto,String NombreProyecto,int PresupuestoTotal,String DptoResponsable,int CantAreasEspecializacion,ListaAreaEspecializacion listaEspecializacion );
    //Descripcion: Crea un objeto proyecto, le saca su area de especializacion y lo guarda en su lista de areas de especializacion. Se carga a lista general de proyectos
    //PreCondicion:
    //PostCondiciones: objeto cargado
                
    public boolean CargarCientifico(String Rut, String Nombre,String  ApellidoP, String ApellidoM, String Area, int CostoAsociado);
    //Descripcion: crea un objeto cientifico y lo carga a la lista general de cientificos.
    //PreCondicion:
    //PostCondiciones: objeto cargado
                
    public ListaProyectos returnListaProyectos();
    //Descripcion: retorna lista general de proyectos
    //PreCondicion:
    //PostCondiciones:
                
    public ListaInsta returnListaInsta();
    //Descripcion: retorna lista general de instalacion
    //PreCondicion:
    //PostCondiciones:
                
    public ListaDptos returnListaDptos();
    //Descripcion: retorna lista general de departamentos
    //PreCondicion:
    //PostCondiciones:
            
    public ListaCientificos returnListaCient();
    //Descripcion: retorna lista general de cientificos
    //PreCondicion:
    //PostCondiciones:
            
}
