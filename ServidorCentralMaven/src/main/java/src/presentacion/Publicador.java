package src.presentacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
import src.excepciones.ActividadRepetidaException;
import src.excepciones.DepartamentoRepetidoException;
import src.excepciones.ExcepcionAltaCategoria;
import src.excepciones.ExcepcionAltaSalida;
import src.excepciones.ExcepcionModificarSalida;
import src.excepciones.InscripcionCapacidadExcedidaException;
import src.excepciones.InscripcionYaExisteException;
import src.excepciones.PaqueteRepetidoException;
import src.excepciones.SalidasVigentesException;
import src.excepciones.UsuarioNoExisteException;
import src.excepciones.UsuarioRepetidoException;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.IPaquete;
import src.logica.clases.IUsuario;
import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTActividades;
import src.logica.datatypes.DTActividadesExtendidas;
import src.logica.datatypes.DTCategoria;
import src.logica.datatypes.DTCategorias;
import src.logica.datatypes.DTDepartamento;
import src.logica.datatypes.DTDepartamentos;
import src.logica.datatypes.DTInscripcion;
import src.logica.datatypes.DTInscripciones;
import src.logica.datatypes.DTPaqueteActividad;
import src.logica.datatypes.DTPaqueteActividadExtendido;
import src.logica.datatypes.DTProveedor;
import src.logica.datatypes.DTProveedorExtendido;
import src.logica.datatypes.DTProveedores;
import src.logica.datatypes.DTSalidaTuristica;
import src.logica.datatypes.DTSalidas;
import src.logica.datatypes.DTTurista;
import src.logica.datatypes.DTTuristaExtendido;
import src.logica.datatypes.DTTuristas;
import src.logica.datatypes.DTUsuario;
import src.logica.datatypes.DTUsuarioExtendido;
import src.logica.datatypes.DTUsuarios;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
	
	private Fabrica fabrica = new Fabrica();
	private IUsuario controlUsuario = fabrica.getIUsuario();
	private IActividad controlActividad = fabrica.getIActividad();
	private IPaquete controlPaquete = fabrica.getIPaquete();
	private Endpoint endpoint = null;
	
    public Publicador() {
    	
    }

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar() throws IOException{
    	// create and load default properties
    	Properties defaultProps = new Properties();
    	FileInputStream in = new FileInputStream(System.getProperty("user.home") + File.separator + ".turismoUy" + File.separator + ".properties");//ruta a modificar en defensa
    	defaultProps.load(in);
    	in.close();

    	// create application properties with default
    	Properties applicationProps = new Properties(defaultProps);

    	// now load properties 
    	// from last invocation
    	in = new FileInputStream(System.getProperty("user.home") + File.separator + ".turismoUy" + File.separator + ".properties");//ruta a modificar en defensa
    	applicationProps.load(in);
    	in.close();
    	
    	//deja publicada la clase como Web Service
        endpoint = Endpoint.publish(applicationProps.getProperty("URLPublicacion"), this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
    	return endpoint;
    }
    
    @WebMethod
    public DTUsuarios obtenerDTUsuarios() {
    	DTUsuarios res = new DTUsuarios();
    	res.setUsuarios(new ArrayList<DTUsuario>(controlUsuario.obtenerDTUsuarios().values()));
    	return res;
    }
    
    @WebMethod
    public DTUsuarioExtendido obtenerDTUsuarioExtendido(String nickNameUsuario) {
    	DTUsuarioExtendido res = controlUsuario.obtenerDTUsuarioExtendido(nickNameUsuario);
    	if (res.getSeguidores() != null){
    		res.setListaSeguidores(new ArrayList<DTUsuario>(res.getSeguidores().values()));
    	}
    	else {
    		res.setListaSeguidores(new ArrayList<DTUsuario>());
    	}
    	if (res.getSeguidos() != null){
    		res.setListaSeguidos(new ArrayList<DTUsuario>(res.getSeguidos().values()));
    	}
    	else {
    		res.setListaSeguidos(new ArrayList<DTUsuario>());
    	}
    	if (res instanceof DTTuristaExtendido) {
    		DTTuristaExtendido turista = (DTTuristaExtendido) res;
    		turista.setListaSalidas(new ArrayList<DTSalidaTuristica>(turista.getSalidas().values()));
    		turista.setListaInscripciones(new ArrayList<DTInscripcion>(turista.getInscripciones().values()));
    	}
    	else {
    		DTProveedorExtendido prov = (DTProveedorExtendido) res;
    		prov.setListaActividades(new ArrayList<DTActividadTuristica>(prov.getActividades().values()));
    		prov.setListaActividadesConfirmadas(new ArrayList<DTActividadTuristica>(prov.getDTActividadesConfirmadas().values()));
    	}
    	res.setFechaNacString(res.getFechaNacimiento().toString());
    	return res;
    }
    
    @WebMethod
    public DTTuristas obtenerDTTuristas() {
    	DTTuristas res = new DTTuristas();
    	res.setTuristas(new ArrayList<DTTurista>(controlUsuario.obtenerDTTuristas().values()));
    	return res;
    }
    
    @WebMethod
    public void aceptarInscripcion(DTInscripcion datosInscripcion, String nickTurista, String nombreActividad) throws InscripcionYaExisteException, InscripcionCapacidadExcedidaException {
		datosInscripcion.setFecha(LocalDate.now());
    	controlUsuario.aceptarInscripcion(nickTurista, datosInscripcion.getNombreSalida(), nombreActividad, datosInscripcion.getCantTuristas(), datosInscripcion.getFecha());
    }
    
    @WebMethod
    public void cancelarInscripcion() {
    	controlUsuario.cancelarInscripcion();
    }
    
    @WebMethod
    public DTProveedores obtenerDTProveedores() {
    	DTProveedores res = new DTProveedores(); 
    	res.setProveedores(new ArrayList<DTProveedor>(controlUsuario.obtenerDTProveedores().values()));
    	return res;
    }
    
    @WebMethod
    public DTUsuarioExtendido obtenerUsuarioPorID(String nickOCorreo) throws UsuarioNoExisteException {
    	DTUsuarioExtendido res = controlUsuario.obtenerUsuarioPorID(nickOCorreo);
    	res.setListaSeguidos(new ArrayList<DTUsuario>(res.getSeguidos().values()));
    	res.setListaSeguidores(new ArrayList<DTUsuario>(res.getSeguidores().values()));
    	return res;
    }
    
    @WebMethod
    public void aceptarAltaTurista(DTTurista datosTurista) throws UsuarioRepetidoException {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNacimiento = LocalDate.parse(datosTurista.getFechaNacString(), formatter);
    	controlUsuario.aceptarAltaTurista(datosTurista.getNickname(), datosTurista.getNombre(), datosTurista.getApellido(), datosTurista.getCorreo(), datosTurista.getContrasenia(), fechaNacimiento, datosTurista.getImagen(), datosTurista.getNacionalidad());
    }
    
    @WebMethod
    public void aceptarAltaProveedor(DTProveedor datosProveedor) throws UsuarioRepetidoException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNacimiento = LocalDate.parse(datosProveedor.getFechaNacString(), formatter);
    	controlUsuario.aceptarAltaProveedor(datosProveedor.getNombre(), datosProveedor.getApellido(), datosProveedor.getNickname(), datosProveedor.getCorreo(), datosProveedor.getContrasenia(), fechaNacimiento, datosProveedor.getImagen(), datosProveedor.getDescripcion(), datosProveedor.getLink());
    }
    
    @WebMethod
    public DTInscripciones obtenerDTInscripcionesAsociadasTurista(String nombreTurista) {
    	DTInscripciones res = new DTInscripciones();
    	res.setInscripciones(new ArrayList<DTInscripcion>(controlUsuario.obtenerDTInscripcionesAsociadasTurista(nombreTurista).values()));
    	return res;
    }
    
    @WebMethod
    public void seguirONoAUsuario(String nombreUsuario, String nombreASeguir) {
    	controlUsuario.seguirONoAUsuario(nombreUsuario, nombreASeguir);
    }
    
    @WebMethod
    public DTActividades obtenerDTActividadesConfirmadasDepto(String nombreDepartamento) {
    	DTActividades res = new DTActividades();
    	res.setActividades(new ArrayList<DTActividadTuristica>(controlActividad.obtenerDTActividadesConfirmadasDepto(nombreDepartamento).values()));
    	return res;
    }
    
    @WebMethod
    public DTActividades obtenerDTActividades() {
    	DTActividades res = new DTActividades();
    	res.setActividades(new ArrayList<DTActividadTuristica>(controlActividad.obtenerDTActividades().values()));
    	return res;
    }
    
    @WebMethod
    public DTActividades obtenerDTActividadesConfirmadas() {
    	DTActividades res = new DTActividades();
    	res.setActividades(new ArrayList<DTActividadTuristica>(controlActividad.obtenerDTActividadesConfirmadas().values()));
    	return res;
    }
    
    @WebMethod
    public DTSalidas obtenerDTSalidasVigentes(String nombreActividad) {
    	DTSalidas res = new DTSalidas();
    	res.setSalidas(new ArrayList<DTSalidaTuristica>(controlActividad.obtenerDTSalidasVigentes(nombreActividad).values()));
    	return res;
    }
    
    @WebMethod
    public DTDepartamentos obtenerDTDepartamentos() {
    	DTDepartamentos res = new DTDepartamentos();
    	res.setDepartamentos(new ArrayList<DTDepartamento>(controlActividad.obtenerDTDepartamentos().values()));
    	return res;
    }
    
    @WebMethod
    public void aceptarAltaActividad(String nickNameProveedor, DTActividadExtendida datosActividad) throws ActividadRepetidaException {
    	ArrayList<DTCategoria> listaCategorias = datosActividad.getListaCategorias();
    	Map<String, DTCategoria> mapCategorias = new HashMap<>();
    	for (DTCategoria categoria : listaCategorias) {
    		mapCategorias.put(categoria.getNombre(), categoria);
    	}
    	datosActividad.setFechaAlta(LocalDate.now());
    	controlActividad.aceptarAltaActividad(nickNameProveedor, datosActividad.getDepartamento(), datosActividad.getNombre(), datosActividad.getDescripcion(), datosActividad.getCiudad(), datosActividad.getDuracion(), datosActividad.getCosto(), datosActividad.getFechaAlta(), mapCategorias, datosActividad.getImagen());
    }
    
    @WebMethod
    public DTActividadTuristica obtenerDTActividadTuristica(String nombreActividad) {
    	DTActividadTuristica res = controlActividad.obtenerDTActividadTuristica(nombreActividad);
    	res.setFechaDeAltaString(res.getfechaDeAlta().toString());
    	//res.setListaSalidas(new ArrayList<DTSalidaTuristica>(res.getSalidas().values()));
    	return res;
    }
    
    @WebMethod
    public void altaDepartamento(String nombreDepto, String descripcion, String URL) throws DepartamentoRepetidoException {
    	controlActividad.altaDepartamento(nombreDepto, descripcion, URL);
    }
    
    @WebMethod
    public DTSalidas obtenerDTSalidasTuristicas(String nombreActividad) {
    	DTSalidas res = new DTSalidas();
    	res.setSalidas(new ArrayList<DTSalidaTuristica>(controlActividad.obtenerDTSalidasTuristicas(nombreActividad).values()));    	
    	return res;
    }
    

    
    @WebMethod
    public void ingresarDatosSalidaTuristica(String nombreActividad, DTSalidaTuristica datosSalida) throws ExcepcionAltaSalida {
		datosSalida.setFechaAlta(LocalDate.now());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		datosSalida.setFechaSalida(LocalDate.parse(datosSalida.getFechaSalidaString(), formatter));
		formatter = DateTimeFormatter.ofPattern("HH:mm");
		datosSalida.setHoraSalida(LocalTime.parse(datosSalida.getHoraSalidaString(), formatter));
    	controlActividad.ingresarDatosSalidaTuristica(nombreActividad, datosSalida.getNombre(), datosSalida.getTopeTuristas(), datosSalida.getFechaAlta(), datosSalida.getFechaSalida(), datosSalida.getHoraSalida(), datosSalida.getLugarSalida(), datosSalida.getImagen());
    }
    
    @WebMethod
    public void modificarDatosSalidaTuristica(String nombreActividad, DTSalidaTuristica datosSalida) throws ExcepcionModificarSalida {
    	controlActividad.modificarDatosSalidaTuristica(nombreActividad, datosSalida.getNombre(), datosSalida.getTopeTuristas(), datosSalida.getFechaAlta(), datosSalida.getFechaSalida(), datosSalida.getHoraSalida(), datosSalida.getLugarSalida());
    }
    
    @WebMethod
    public DTSalidaTuristica obtenerDTSalidaTuristica(String nombreSalida) {
    	DTSalidaTuristica res = controlActividad.obtenerDTSalidaTuristica(nombreSalida);
    	res.setFechaAltaString(res.getFechaAlta().toString());
    	res.setFechaSalidaString(res.getFechaSalida().toString());
    	res.setHoraSalidaString(res.getHoraSalida().toString());
    	return res;
    }
    
    @WebMethod
    public void aceptarAltaCategoria(String nombre) throws ExcepcionAltaCategoria {
    	controlActividad.aceptarAltaCategoria(nombre);
    }
    
    @WebMethod
    public DTActividades obtenerActividadesTuristicasAgregadas() {
    	DTActividades res = new DTActividades();
    	res.setActividades(new ArrayList<DTActividadTuristica>(controlActividad.obtenerActividadesTuristicasAgregadas().values()));
    	return res;
    }
    
    @WebMethod
    public void confirmarActividad(String nombreActividadAgregada) {
    	controlActividad.confirmarActividad(nombreActividadAgregada);
    }
    
    @WebMethod
    public void rechazarActividad(String nombreActividadAgregada) {
    	controlActividad.rechazarActividad(nombreActividadAgregada);
    }
    
    @WebMethod
    public DTActividades obtenerDTActividadesConfirmadasCategoria(String nombreCategoria) {
    	DTActividades res = new DTActividades();
    	res.setActividades(new ArrayList<DTActividadTuristica>(controlActividad.obtenerDTActividadesConfirmadasCategoria(nombreCategoria).values()));
    	return res;
    }
    

    
    @WebMethod
    public DTSalidas obtenerDTSalidas() {
    	DTSalidas res = new DTSalidas();
    	res.setSalidas(new ArrayList<DTSalidaTuristica>(controlActividad.obtenerDTSalidas().values()));
    	return res;
    }
    
    @WebMethod
    public DTCategorias obtenerDTCategorias() {
    	DTCategorias res = new DTCategorias();
    	res.setCategorias(new ArrayList<DTCategoria>(controlActividad.obtenerDTCategorias().values()));
    	return res;
    }
    
    @WebMethod
    public DTCategoria obtenerDTCategoria(String nombreCategoria) {
    	return controlActividad.obtenerDTCategoria(nombreCategoria);
    }
    
    @WebMethod
    public void finalizarActividad(String nombreActividad) throws SalidasVigentesException {
    	controlActividad.finalizarActividad(nombreActividad);
    }
    
    @WebMethod
    public DTActividadExtendida obtenerDTActividadExtendido(String nombreActividad) {
    	DTActividadExtendida res = controlPaquete.obtenerDTActividadExtendido(nombreActividad);
    	res.setListaCategorias(new ArrayList<DTCategoria>(res.getCategorias().values()));
    	res.setListaPaquetes(new ArrayList<DTPaqueteActividad>(res.getPaquetes().values()));
    	//res.setListaSalidas(new ArrayList<DTSalidaTuristica>(res.getSalidas().values()));
    	return res;
    }
    
    @WebMethod
    public DTPaqueteActividadExtendido obtenerPaqueteExtendido(String nombrePaquete) {
    	DTPaqueteActividadExtendido res = controlPaquete.obtenerPaqueteExtendido(nombrePaquete);
    	res.setListaActividades(new ArrayList <DTActividadTuristica>(res.getActividades().values()));
    	return res;
    }
    
    @WebMethod
    public DTActividadesExtendidas obtenerDTActividadesExtendido(String nombreDepto) {
    	DTActividadesExtendidas res = new DTActividadesExtendidas();
    	res.setActividadesExtendidas(new ArrayList<DTActividadExtendida>(controlPaquete.obtenerDTActividadesExtendido(nombreDepto).values()));
    	return res;
    }
    
    @WebMethod
    public void  crearNuevoPaquete(DTPaqueteActividad datosPaquete) throws PaqueteRepetidoException {
    	controlPaquete.crearNuevoPaquete(datosPaquete.getNombre(), datosPaquete.getDescripcion(), datosPaquete.getValidez(), datosPaquete.getDescuento(), datosPaquete.getFechaAlta(), datosPaquete.getImagen());
    }
    
    @WebMethod
    public void ingresarActividadTuristica(String nombreActividad, String nombrePaquete) {
    	controlPaquete.ingresarActividadTuristica(nombreActividad, nombrePaquete);
    }
    
    @WebMethod
    public DTTuristaExtendido publicarTuristaExtendido() {
    	return new DTTuristaExtendido();
    }
    
    public DTProveedorExtendido publicarProveedorExtendido() {
    	return new DTProveedorExtendido();
    }
}
