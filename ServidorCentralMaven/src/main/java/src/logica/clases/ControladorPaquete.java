package src.logica.clases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import src.excepciones.PaqueteRepetidoException;
import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTPaqueteActividadExtendido;

public class ControladorPaquete implements IPaquete {
	//creates
	public ControladorPaquete(){
		
	}
	
	//operaciones
	@Override
	public void crearNuevoPaquete(String nombrePaquete, String descripcion, int periodoValidez, double porcentajeDescuento, LocalDate fechaAlta, String imagen) throws PaqueteRepetidoException{
		Manejador manejador = Manejador.getInstancia();
		Map<String, PaqueteActividad> colPaquetes = manejador.getPaquetes();
		
		//busco si existe un paquete con el mismo nombre
		PaqueteActividad paquete = colPaquetes.get(nombrePaquete);
		if (paquete != null)
			throw new PaqueteRepetidoException("El paquete " + nombrePaquete + " ya esta registrado");
		else {
			HashMap<String, ActividadTuristica> actividades = new HashMap<>();
			PaqueteActividad nuevo = new PaqueteActividad(nombrePaquete, descripcion, periodoValidez, porcentajeDescuento, fechaAlta, imagen, actividades);
			colPaquetes.put(nombrePaquete, nuevo);
		}
	}
	
	@Override
	public HashMap<String, DTActividadExtendida> obtenerDTActividadesExtendido(String nombreDepto){
        HashMap<String, DTActividadExtendida> dtactividadesExtendido = new HashMap<>();


        Manejador manejador = Manejador.getInstancia();
        Map<String, PaqueteActividad> paquetes = manejador.getPaquetes();
        paquetes.forEach((key, value)-> {
        Map<String, DTActividadExtendida> aAgregar = value.obtenerDTActividadesExtendido(nombreDepto);
        String nombrePaquete = value.getNombre();
	        //recorro el conjunto de actividades obtenido
	        aAgregar.forEach((key1, value1)-> {
	                
		        //si no se encontraba en el conjunto a retornar
		        if (!(dtactividadesExtendido.containsKey(key1))){
		        	//agrego
		            dtactividadesExtendido.put(key1, value1);
		        } else {
		        	//obtengo la que ya se encontraba y le agrego el paquete donde obtuve la actividad repetida
		        	DTActividadExtendida dtActividad = dtactividadesExtendido.get(key1);
		            dtActividad.agregarPaquete(nombrePaquete); //implementar en DTActividadExtendida
		        }
	        });
        });

        return dtactividadesExtendido;
    }
	
	@Override
	public DTActividadExtendida obtenerDTActividadExtendido(String nombreActividad){
		Manejador manejador = Manejador.getInstancia();
		Map<String, ActividadTuristica> colActividades = manejador.getActividades();
		ActividadTuristica actividad = colActividades.get(nombreActividad);
		return actividad.obtenerDTActividadExtendida();
	}
	
	@Override
	public DTPaqueteActividadExtendido obtenerPaqueteExtendido(String nombrePaquete){
		DTPaqueteActividadExtendido res;
		
		Manejador manejador = Manejador.getInstancia();
		PaqueteActividad paquete = manejador.getPaquete(nombrePaquete);
		res = paquete.obtenerDTPaqueteExt();
		
		return res;
	}

	@Override
	public void ingresarActividadTuristica(String nombreActividad, String nombrePaquete) {
		Manejador manejador = Manejador.getInstancia();
		PaqueteActividad paquete = manejador.getPaquete(nombrePaquete);
		ActividadTuristica actividad = manejador.getActividad(nombreActividad);
		paquete.getActividades().put(nombrePaquete, actividad);
	}
}
