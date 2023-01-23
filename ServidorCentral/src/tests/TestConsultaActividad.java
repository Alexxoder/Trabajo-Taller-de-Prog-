package src.tests;

import static org.junit.Assert.assertEquals;





import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.logica.clases.ActividadTuristica;
import src.logica.clases.Categoria;
import src.logica.clases.ControladorActividad;
import src.logica.clases.ControladorPaquete;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;
import src.logica.clases.SalidaTuristica;
import src.logica.datatypes.DTActividadExtendida;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTPaqueteActividad;
import src.logica.datatypes.DTSalidaTuristica;



class TestConsultaActividad {

	@Test
	void testObtenerDTActividadesDepto() {
		Manejador manejador = Manejador.getInstancia();
		ControladorActividad controladorActividad = new ControladorActividad();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		LocalDate date;
		Map<String, SalidaTuristica> salidas1 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas1, estado1, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		
		//prueba
		Map<String, DTActividadTuristica> dtsPrueba = controladorActividad.obtenerDTActividadesConfirmadasDepto("canelones");
		
		//salida esperada
		Map<String, DTSalidaTuristica> dtsalidas1 = new HashMap<>();
		Map<String, DTSalidaTuristica> dtsalidas2 = new HashMap<>();
		DTActividadTuristica dtCorrecta1 = new DTActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), "canelones", dtsalidas1, estado1, null);
		DTActividadTuristica dtCorrecta2 = new DTActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), "canelones", dtsalidas2, estado2, null);
		
		//comparacion
		DTActividadTuristica prueba1 = dtsPrueba.get("paseo1");		
		DTActividadTuristica prueba2 = dtsPrueba.get("paseo2");
		
		assertEquals(prueba1.getNombre(), dtCorrecta1.getNombre());
		assertEquals(prueba1.getCiudad(), dtCorrecta1.getCiudad());
		assertEquals(prueba1.getDescripcion(), dtCorrecta1.getDescripcion());
		assertEquals(prueba1.getDuracion(), dtCorrecta1.getDuracion());
		assertEquals(prueba1.getfechaDeAlta(), dtCorrecta1.getfechaDeAlta());
		assertEquals(prueba1.getDepartamento(), dtCorrecta1.getDepartamento());
		assertEquals(prueba2.getNombre(), dtCorrecta2.getNombre());
		assertEquals(prueba2.getCiudad(), dtCorrecta2.getCiudad());
		assertEquals(prueba2.getDescripcion(), dtCorrecta2.getDescripcion()); 
		assertEquals(prueba2.getDuracion(), dtCorrecta2.getDuracion());
		assertEquals(prueba2.getfechaDeAlta(), dtCorrecta2.getfechaDeAlta());
		assertEquals(prueba2.getDepartamento(), dtCorrecta2.getDepartamento());
		
	}
	
	@Test
	void testObtenerDTActividad() {
		Manejador manejador = Manejador.getInstancia();
		ControladorPaquete controlP = new ControladorPaquete();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		LocalDate date;
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		HashMap<String, SalidaTuristica> salidas2 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1),  depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), depto, salidas2, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date , LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date , LocalTime.of(2, 2), "casa", null);
		Categoria categoria = new Categoria("categoria1");
		Map<String, Categoria> categorias = new HashMap<>();
		categorias.put("categoria1", categoria);
		actividad1.setCategorias(categorias);
		actividad2.setCategorias(categorias);
		Map<String, ActividadTuristica> actividades = new HashMap<>();
		actividades.put(actividad2.getNombre(), actividad2);
		actividades.put(actividad1.getNombre(), actividad1);
		PaqueteActividad paquete1 = new PaqueteActividad("paq1", "paquetefeo1", 1, 1, date = LocalDate.of(1, 1, 1), null, actividades);
		PaqueteActividad paquete2 = new PaqueteActividad("paq2", "paquetefeo2", 2, 2, date = LocalDate.of(2, 2, 2), null, actividades);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		manejador.getPaquetes().put(paquete1.getNombre(), paquete1);
		manejador.getPaquetes().put(paquete2.getNombre(), paquete2);
		
		//prueba
		DTActividadExtendida prueba1 = controlP.obtenerDTActividadExtendido(actividad1.getNombre());
		DTActividadExtendida prueba2 = controlP.obtenerDTActividadExtendido(actividad2.getNombre());
		
		//salida esperada
		HashMap<String, DTSalidaTuristica> dtsalidas1 = new HashMap<>();
		HashMap<String, DTSalidaTuristica> dtsalidas2 = new HashMap<>();
		dtsalidas1.put("salida1", actividad1.obtenerDTSalidaTuristica("salida1"));
		dtsalidas2.put("salida2", actividad2.obtenerDTSalidaTuristica("salida2"));
		EstadoActividad estadoCorr1= actividad1.getEstadoActividad();
		EstadoActividad estadoCorr2= actividad2.getEstadoActividad();
		DTActividadTuristica dtCorrecta1 = new DTActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), "canelones", dtsalidas1, estadoCorr1, null);
		DTActividadTuristica dtCorrecta2 = new DTActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2), "canelones", dtsalidas2, estadoCorr2, null);
		DTPaqueteActividad dtPcorrecto1 = new DTPaqueteActividad(paquete1.getNombre(), paquete1.getDescripcion(), paquete1.getValidez(), paquete1.getDescuento(), paquete1.getFechaAlta(), paquete1.getImagen());
		DTPaqueteActividad dtPcorrecto2 = new DTPaqueteActividad(paquete2.getNombre(), paquete2.getDescripcion(), paquete2.getValidez(), paquete2.getDescuento(), paquete2.getFechaAlta(), paquete2.getImagen());
		
		
		
		//comparacion
		assertEquals(prueba1.getNombre(), dtCorrecta1.getNombre());
		assertEquals(prueba1.getCiudad(), dtCorrecta1.getCiudad());
		assertEquals(prueba1.getDescripcion(), dtCorrecta1.getDescripcion());
		assertEquals(prueba1.getDuracion(), dtCorrecta1.getDuracion());
		assertEquals(prueba1.getFechaAlta(), dtCorrecta1.getfechaDeAlta());
		assertEquals(prueba1.getDepartamento(), dtCorrecta1.getDepartamento());
		
		//PRUEBA DE SALIDAS
		Map<String, DTSalidaTuristica> dtSalidacorrecta1 = actividad1.obtenerDTSalidasTuristicas();
		boolean error = false;
		Iterator<Map.Entry<String, DTSalidaTuristica>> iter = dtSalidacorrecta1.entrySet().iterator();
		
		while (iter.hasNext() && !error){
			HashMap.Entry<String, DTSalidaTuristica> entry = iter.next();
			String key = entry.getKey();
			if (!(dtsalidas1.containsKey(key))){
				error = true;
			}
			
		}
		
		if (error){
			assertEquals(null, error);
		}
		
		//PRUEBA DE PAQUETES
		HashMap<String, DTPaqueteActividad> dtPaquetesCorrecto = new HashMap<>();
		dtPaquetesCorrecto.put(dtPcorrecto1.getNombre(), dtPcorrecto1);
		dtPaquetesCorrecto.put(dtPcorrecto2.getNombre(), dtPcorrecto2);
		
		Map<String, DTPaqueteActividad> dtPaquetesPrueba1 = prueba1.getPaquetes();
		
		Iterator<HashMap.Entry<String, DTPaqueteActividad>> it1 = dtPaquetesCorrecto.entrySet().iterator();
		error = false;
		
		while (it1.hasNext() && !error){
			HashMap.Entry<String, DTPaqueteActividad> entry = it1.next();
			String key = entry.getKey();
			if (!(dtPaquetesPrueba1.containsKey(key))){
				error = true;
			}
			
			if (error){
				assertEquals(null, error);
			}
		}	
			
		
		assertEquals(prueba2.getNombre(), dtCorrecta2.getNombre());
		assertEquals(prueba2.getCiudad(), dtCorrecta2.getCiudad());
		assertEquals(prueba2.getDescripcion(), dtCorrecta2.getDescripcion()); 
		assertEquals(prueba2.getDuracion(), dtCorrecta2.getDuracion());
		assertEquals(prueba2.getFechaAlta(), dtCorrecta2.getfechaDeAlta());
		assertEquals(prueba2.getDepartamento(), dtCorrecta2.getDepartamento());
		
		//PRUEBA DE SALIDAS
				Map<String, DTSalidaTuristica> dtSalidacorrecta2 = actividad2.obtenerDTSalidasTuristicas();
				error = false;
				Iterator<HashMap.Entry<String, DTSalidaTuristica>> it3 = dtSalidacorrecta2.entrySet().iterator();
				
				while (it3.hasNext() && !error){
					HashMap.Entry<String, DTSalidaTuristica> entry = it3.next();
					String key = entry.getKey();
					if (!(dtsalidas2.containsKey(key))){
						error = true;
					}
					
				}
				
				if (error){
					assertEquals(null, error);
				}
		
		
		
		//PRUEBA DE PAQUETES		
		Map<String, DTPaqueteActividad> dtPaquetesPrueba2 = prueba2.getPaquetes();
		
		Iterator<HashMap.Entry<String, DTPaqueteActividad>> it2 = dtPaquetesCorrecto.entrySet().iterator();
		error = false;
		
		while (it2.hasNext() && !error){
			HashMap.Entry<String, DTPaqueteActividad> entry = it2.next();
			String key = entry.getKey();
			if (!(dtPaquetesPrueba2.containsKey(key))){
				error = true;
			}
			
			if (error){
				assertEquals(null, error);
			}
		}	
	
	}
	
	
	
	
	
	

}
