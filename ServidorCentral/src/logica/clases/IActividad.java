package src.logica.clases;

import java.util.Map;
import src.excepciones.DepartamentoRepetidoException;
import src.excepciones.ExcepcionAltaCategoria;
import src.excepciones.ExcepcionAltaSalida;
import src.excepciones.ExcepcionModificarSalida;
import src.excepciones.SalidasVigentesException;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTCategoria;
import src.logica.datatypes.DTDepartamento;
import src.logica.datatypes.DTSalidaTuristica;
import src.excepciones.ActividadRepetidaException;
import java.time.LocalTime;
import java.time.LocalDate;


public interface IActividad {
	public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadasDepto(String nombreDepartamento);
	public Map<String, DTActividadTuristica> obtenerDTActividades();
	public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadas();
	public Map<String, DTSalidaTuristica> obtenerDTSalidasVigentes(String nombreActividad);
	public Map<String, DTDepartamento> obtenerDTDepartamentos();
	public void aceptarAltaActividad(String nickNameProveedor, String nombreDepartamento, String nombre, String descripcion, String ciudad, int duracion, int costo, LocalDate fechaAlta, Map<String, DTCategoria> categorias, String imagen)throws ActividadRepetidaException;
	public DTActividadTuristica obtenerDTActividadTuristica(String nombreActividad);
	public void altaDepartamento(String nombreDepto, String descripcion, String URL) throws DepartamentoRepetidoException;
	public Map<String, DTSalidaTuristica> obtenerDTSalidasTuristicas(String nombreActividad);
	//public DTSalidaTuristica obtenerDTSalidaTuristica(String nombreActividad, String nombreSalida);
	public void ingresarDatosSalidaTuristica(String nombreActividad, String nombreSalida, int topeTuristas, LocalDate fechaAlta, LocalDate fechaSalida, LocalTime horaSalida, String lugarSalida, String imagen) throws ExcepcionAltaSalida;
	public void modificarDatosSalidaTuristica(String nombreActividad, String nombreSalida, int topeTuristas, LocalDate fechaSalida, LocalDate fechaAlta, LocalTime horaSalida, String lugarSalida) throws ExcepcionModificarSalida;
	public DTSalidaTuristica obtenerDTSalidaTuristica(String nombreSalida);
	public void aceptarAltaCategoria(String nombre) throws ExcepcionAltaCategoria;
	public Map<String, DTActividadTuristica> obtenerActividadesTuristicasAgregadas();
	public void confirmarActividad(String nombreActividadAgregada);
	public void rechazarActividad(String nombreActividadAgregada);
	public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadasCategoria(String nombreCategoria);
	//public DTActividadExtendida obtenerDTActividadExtendido(String nombreActividad);
	public Map<String, DTSalidaTuristica> obtenerDTSalidas();
	public Map<String, DTCategoria> obtenerDTCategorias();
	public DTCategoria obtenerDTCategoria(String nombreCategoria);
	public void finalizarActividad(String nombreActividad) throws SalidasVigentesException;
	//public Map<String, DTActividadTuristica> obtenerDTActividadesConfirmadasYFinalizadas();
}
