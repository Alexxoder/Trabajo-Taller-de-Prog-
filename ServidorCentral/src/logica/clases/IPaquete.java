package src.logica.clases;

import java.time.LocalDate;
import java.util.Map;

import src.excepciones.PaqueteRepetidoException;
import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTPaqueteActividadExtendido;

public interface IPaquete {
	public DTActividadExtendida obtenerDTActividadExtendido(String nombreActividad);
	public DTPaqueteActividadExtendido obtenerPaqueteExtendido(String nombrePaquete);
	public Map<String, DTActividadExtendida> obtenerDTActividadesExtendido(String nombreDepto);
	public void crearNuevoPaquete(String nombrePaquete, String descripcion, int periodoValidez, double porcentajeDescuento, LocalDate fechaAlta, String imagen) throws PaqueteRepetidoException;
	public void ingresarActividadTuristica(String nombreActividad, String nombrePaquete);
}
