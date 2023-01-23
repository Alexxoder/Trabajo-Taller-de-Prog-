package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.logica.clases.ActividadTuristica;
import src.logica.clases.ControladorActividad;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;
import src.logica.datatypes.DTActividadTuristica;

class TestObtenerDTActividades {

	@Test
	void testObtenerDTActividades() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		ControladorActividad controlA = new ControladorActividad();
		LocalDate date;
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date, LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date, LocalTime.of(2, 2), "casa", null);
		
		
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		
		HashMap<String, SalidaTuristica> dtSalidasPrueba1 = new HashMap<>();
		dtSalidasPrueba1.putAll(actividad1.getSalidas());
		HashMap<String, SalidaTuristica> dtSalidasPrueba2 = new HashMap<>();
		dtSalidasPrueba2.putAll(actividad2.getSalidas());
		
		//Prueba
		
		Map<String, DTActividadTuristica> dtActividadesPrueba = controlA.obtenerDTActividades();
		
		
		dtActividadesPrueba.forEach((key, value)-> {
			if (value.getNombre() == actividad1.getNombre()) {
				assertEquals(value.getCiudad(), actividad1.getCiudad());
				assertEquals(value.getCosto(), actividad1.getCosto());
				assertEquals(value.getDepartamento(), actividad1.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad1.getDescripcion());
				assertEquals(value.getDuracion(), actividad1.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad1.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad1.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad1.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it1 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it1.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it1.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			
			}
			if (value.getNombre() == actividad2.getNombre()) {
				assertEquals(value.getCiudad(), actividad2.getCiudad());
				assertEquals(value.getCosto(), actividad2.getCosto());
				assertEquals(value.getDepartamento(), actividad2.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad2.getDescripcion());
				assertEquals(value.getDuracion(), actividad2.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad2.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad2.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad2.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it2 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it2.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it2.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			}
			
			
			
		});
	}
	
	@Test
	void testObtenerDTActividadesComfirmadas() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		ControladorActividad controlA = new ControladorActividad();
		LocalDate date;
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date, LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date, LocalTime.of(2, 2), "casa", null);
		
		
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		
		HashMap<String, SalidaTuristica> dtSalidasPrueba1 = new HashMap<>();
		dtSalidasPrueba1.putAll(actividad1.getSalidas());
		HashMap<String, SalidaTuristica> dtSalidasPrueba2 = new HashMap<>();
		dtSalidasPrueba2.putAll(actividad2.getSalidas());
		
		//Prueba
		
		Map<String, DTActividadTuristica> dtActividadesPrueba = controlA.obtenerDTActividadesConfirmadas();
		
		
		dtActividadesPrueba.forEach((key, value)-> {
			if (value.getNombre() == actividad1.getNombre()) {
				assertEquals(value.getCiudad(), actividad1.getCiudad());
				assertEquals(value.getCosto(), actividad1.getCosto());
				assertEquals(value.getDepartamento(), actividad1.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad1.getDescripcion());
				assertEquals(value.getDuracion(), actividad1.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad1.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad1.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad1.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it1 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it1.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it1.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			
			}
			if (value.getNombre() == actividad2.getNombre()) {
				assertEquals(value.getCiudad(), actividad2.getCiudad());
				assertEquals(value.getCosto(), actividad2.getCosto());
				assertEquals(value.getDepartamento(), actividad2.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad2.getDescripcion());
				assertEquals(value.getDuracion(), actividad2.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad2.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad2.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad2.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it2 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it2.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it2.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			}
			
			
			
		});
	}
	
	@Test
	void testObtenerDTActividadesComfirmadasDepto() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		ControladorActividad controlA = new ControladorActividad();
		LocalDate date;
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date, LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date, LocalTime.of(2, 2), "casa", null);
		
		
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		
		HashMap<String, SalidaTuristica> dtSalidasPrueba1 = new HashMap<>();
		dtSalidasPrueba1.putAll(actividad1.getSalidas());
		HashMap<String, SalidaTuristica> dtSalidasPrueba2 = new HashMap<>();
		dtSalidasPrueba2.putAll(actividad2.getSalidas());
		
		//Prueba
		
		Map<String, DTActividadTuristica> dtActividadesPrueba = controlA.obtenerDTActividadesConfirmadasDepto("canelones");
		
		
		dtActividadesPrueba.forEach((key, value)-> {
			if (value.getNombre() == actividad1.getNombre()) {
				assertEquals(value.getCiudad(), actividad1.getCiudad());
				assertEquals(value.getCosto(), actividad1.getCosto());
				assertEquals(value.getDepartamento(), actividad1.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad1.getDescripcion());
				assertEquals(value.getDuracion(), actividad1.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad1.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad1.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad1.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it1 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it1.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it1.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			
			}
			if (value.getNombre() == actividad2.getNombre()) {
				assertEquals(value.getCiudad(), actividad2.getCiudad());
				assertEquals(value.getCosto(), actividad2.getCosto());
				assertEquals(value.getDepartamento(), actividad2.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad2.getDescripcion());
				assertEquals(value.getDuracion(), actividad2.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad2.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad2.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad2.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it2 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it2.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it2.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			}
			
			
			
		});
	}
	
	@Test
	void testObtenerActividadesTuristicasAgregadas() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		ControladorActividad controlA = new ControladorActividad();
		LocalDate date;
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		EstadoActividad estado1 = EstadoActividad.Agregada;
		EstadoActividad estado2 = EstadoActividad.Agregada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date, LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date, LocalTime.of(2, 2), "casa", null);
		
		
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		
		HashMap<String, SalidaTuristica> dtSalidasPrueba1 = new HashMap<>();
		dtSalidasPrueba1.putAll(actividad1.getSalidas());
		HashMap<String, SalidaTuristica> dtSalidasPrueba2 = new HashMap<>();
		dtSalidasPrueba2.putAll(actividad2.getSalidas());
		
		//Prueba
		
		Map<String, DTActividadTuristica> dtActividadesPrueba = controlA.obtenerActividadesTuristicasAgregadas();
		
		
		dtActividadesPrueba.forEach((key, value)-> {
			if (value.getNombre() == actividad1.getNombre()) {
				assertEquals(value.getCiudad(), actividad1.getCiudad());
				assertEquals(value.getCosto(), actividad1.getCosto());
				assertEquals(value.getDepartamento(), actividad1.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad1.getDescripcion());
				assertEquals(value.getDuracion(), actividad1.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad1.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad1.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad1.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it1 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it1.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it1.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			
			}
			if (value.getNombre() == actividad2.getNombre()) {
				assertEquals(value.getCiudad(), actividad2.getCiudad());
				assertEquals(value.getCosto(), actividad2.getCosto());
				assertEquals(value.getDepartamento(), actividad2.getDepartamento().getNombreDepto());
				assertEquals(value.getDescripcion(), actividad2.getDescripcion());
				assertEquals(value.getDuracion(), actividad2.getDuracion());
				assertEquals(value.getfechaDeAlta(), actividad2.getfechaDeAlta());
				assertEquals(value.getEstado(),actividad2.getEstadoActividad());
				
				//PRUEBA DE SALIDAS
				Map<String, SalidaTuristica> dtSalidacorrecta1 = actividad2.getSalidas();
				boolean error = false;
				Iterator<HashMap.Entry<String, SalidaTuristica>> it2 = dtSalidacorrecta1.entrySet().iterator();
				
				while (it2.hasNext() && !error) {
					HashMap.Entry<String, SalidaTuristica> entry = it2.next();
					String clave = entry.getKey();
					if (!(dtSalidasPrueba1.containsKey(clave))) {
						error = true;
					}
					
				}
				//si entra arreglos distintos.
				if (error) {
					assertEquals(null, error);
				}
				
			}
			
			
			
		});
	}
}
