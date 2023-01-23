package src.tests;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.logica.clases.ActividadTuristica;
import src.logica.clases.Categoria;
import src.logica.clases.ControladorPaquete;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Inscripcion;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;
import src.logica.clases.Proveedor;
import src.logica.clases.SalidaTuristica;
import src.logica.clases.Turista;
import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTPaqueteActividad;
import src.logica.datatypes.DTSalidaTuristica;

class ObtenerDTActividadesExtendido {
	
	@BeforeEach
	public  void limpiarDatos(){
		
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
	}
	
	@Test
	void testobtenerDTActividadesExtendidoDepto() {
		Manejador manejador = Manejador.getInstancia();
		ControladorPaquete controlP = new ControladorPaquete();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		LocalDate date;
		Map<String, SalidaTuristica> salidas1 = new HashMap<>();
		Map<String, SalidaTuristica> salidas2 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
		Map<String, ActividadTuristica> actividades = new HashMap<>();
		Categoria categoria = new Categoria("categoria1");
		Map<String, Categoria> categorias = new HashMap<>();
		categorias.put("categoria1", categoria);
		actividad1.setCategorias(categorias);
		actividad2.setCategorias(categorias);
		actividades.put(actividad2.getNombre(), actividad2);
		actividades.put(actividad1.getNombre(), actividad1);
		PaqueteActividad paquete1 = new PaqueteActividad("paq1", "paquetefeo1", 1 , 1, date = LocalDate.of(1, 1, 1), null, actividades);
		PaqueteActividad paquete2 = new PaqueteActividad("paq2", "paquetefeo2", 2, 2, date = LocalDate.of(2, 2, 2), null, actividades);
		Set<Inscripcion> colInscripciones = new HashSet<>();
		Turista turista = new Turista("nickT", "nombreT", "apellidoT", "correoT", "1234", date = LocalDate.of(1, 1, 1), null, "nacionalidad", colInscripciones);
		Proveedor proveedor = new Proveedor("nickU", "nombreU", "apellidoU", "correoU", "1234", date = LocalDate.of(2, 2, 2), null, "enlace", "descri", actividades);
		
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		manejador.getPaquetes().put(paquete1.getNombre(), paquete1);
		manejador.getPaquetes().put(paquete2.getNombre(), paquete2);
		manejador.getUsuarios().put(turista.getNickname(), turista);
		manejador.getUsuarios().put(proveedor.getNickname(), proveedor);
	
		//prueba
		HashMap<String, DTActividadExtendida> dtprueba = controlP.obtenerDTActividadesExtendido(depto.getNombreDepto());
		DTActividadExtendida prueba1 = dtprueba.get(actividad1.getNombre());
		DTActividadExtendida prueba2 = dtprueba.get(actividad2.getNombre());
		Map<String, DTSalidaTuristica> dtsalidas1 = prueba1.getSalidas();
		Map<String, DTSalidaTuristica> dtsalidas2 = prueba2.getSalidas();
		
		
		//salida esperada
		//las dtcategorias en null, agregar luego TODO
		DTActividadExtendida dtCorrecta1 = new DTActividadExtendida(actividad1.getNombre(), actividad1.getDescripcion(), actividad1.getDuracion(), actividad1.getCosto(), actividad1.getCiudad(), actividad1.getfechaDeAlta(), actividad1.getNombreDepartamento(), actividad1.obtenerDTSalidasTuristicas(), actividad1.obtenerDTPaquetes(), null, null);
		DTActividadExtendida dtCorrecta2 = new DTActividadExtendida(actividad2.getNombre(), actividad2.getDescripcion(), actividad2.getDuracion(), actividad2.getCosto(), actividad2.getCiudad(), actividad2.getfechaDeAlta(), actividad2.getNombreDepartamento(), actividad2.obtenerDTSalidasTuristicas(), actividad2.obtenerDTPaquetes(), null, null);
		Map<String, DTSalidaTuristica> dtSalidacorrecta1 = dtCorrecta1.getSalidas();
		Map<String, DTSalidaTuristica> dtSalidacorrecta2 = dtCorrecta2.getSalidas();
		DTPaqueteActividad dtPcorrecto1 = paquete1.obtenerDTPaquete();
		DTPaqueteActividad dtPcorrecto2 = paquete2.obtenerDTPaquete();
		
		
		
		//comparacion
		assertEquals(prueba1.getNombre(), dtCorrecta1.getNombre());
		assertEquals(prueba1.getCiudad(), dtCorrecta1.getCiudad());
		assertEquals(prueba1.getDescripcion(), dtCorrecta1.getDescripcion());
		assertEquals(prueba1.getDuracion(), dtCorrecta1.getDuracion());
		assertEquals(prueba1.getFechaAlta(), dtCorrecta1.getFechaAlta());
		assertEquals(prueba1.getDepartamento(), dtCorrecta1.getDepartamento());
		
		//PRUEBA DE SALIDAS

		boolean error = false;
		Iterator<Map.Entry<String, DTSalidaTuristica>> iter = dtSalidacorrecta1.entrySet().iterator();
		
		while (iter.hasNext() && !error) {
			Map.Entry<String, DTSalidaTuristica> entry = iter.next();
			String key = entry.getKey();
			if (!(dtsalidas1.containsKey(key))) {
				error = true;
			}
			
		}
		
		if (error) {
			assertEquals(null, error);
		}
		
		//PRUEBA DE PAQUETES
		Map<String, DTPaqueteActividad> dtPaquetesCorrecto = new HashMap<>();
		dtPaquetesCorrecto.put(dtPcorrecto1.getNombre(), dtPcorrecto1);
		dtPaquetesCorrecto.put(dtPcorrecto2.getNombre(), dtPcorrecto2);
		
		Map<String, DTPaqueteActividad> dtPaquetesPrueba1 = prueba1.getPaquetes();
		
		Iterator<Map.Entry<String, DTPaqueteActividad>> it1 = dtPaquetesCorrecto.entrySet().iterator();
		error = false;
		
		while (it1.hasNext() && !error) {
			Map.Entry<String, DTPaqueteActividad> entry = it1.next();
			String key = entry.getKey();
			if (!(dtPaquetesPrueba1.containsKey(key))) {
				error = true;
			}
		}	
			if (error) {
				assertEquals(null, error);
			}
			
			
		
		assertEquals(prueba2.getNombre(), dtCorrecta2.getNombre());
		assertEquals(prueba2.getCiudad(), dtCorrecta2.getCiudad());
		assertEquals(prueba2.getDescripcion(), dtCorrecta2.getDescripcion()); 
		assertEquals(prueba2.getDuracion(), dtCorrecta2.getDuracion());
		assertEquals(prueba2.getFechaAlta(), dtCorrecta2.getFechaAlta());
		assertEquals(prueba2.getDepartamento(), dtCorrecta2.getDepartamento());
		
		//PRUEBA DE SALIDAS
				error = false;
				Iterator<Map.Entry<String, DTSalidaTuristica>> it3 = dtSalidacorrecta2.entrySet().iterator();
				
				while (it3.hasNext() && !error) {
					Map.Entry<String, DTSalidaTuristica> entry = it3.next();
					String key = entry.getKey();
					if (!(dtsalidas2.containsKey(key))) {
						error = true;
					}
					
				}
				
				if (error) {
					assertEquals(null, error);
				}
		
		
		
		//PRUEBA DE PAQUETES		
		Map<String, DTPaqueteActividad> dtPaquetesPrueba2 = prueba2.getPaquetes();
		
		Iterator<HashMap.Entry<String, DTPaqueteActividad>> it2 = dtPaquetesCorrecto.entrySet().iterator();
		error = false;
		
		while (it2.hasNext() && !error) {
			Map.Entry<String, DTPaqueteActividad> entry = it2.next();
			String key = entry.getKey();
			if (!(dtPaquetesPrueba2.containsKey(key))) {
				error = true;
			}
		}	
			if (error) {
				assertEquals(null, error);
			}
			
	
	}
}


