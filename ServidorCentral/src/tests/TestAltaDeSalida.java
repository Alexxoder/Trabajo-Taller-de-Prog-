package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.excepciones.ExcepcionAltaSalida;
import src.logica.clases.ActividadTuristica;
import src.logica.clases.ControladorActividad;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;
import src.logica.datatypes.DTActividadTuristica;
import src.logica.datatypes.DTDepartamento;

public class TestAltaDeSalida {

	@Test
	public void testObtenerDTActividadesDepto() {
		//prueba
		Manejador manejador = Manejador.getInstancia();
		ControladorActividad controlA = new ControladorActividad();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		LocalDate date;
		Map<String, SalidaTuristica> salidas1 = new HashMap<>();
		Map<String, SalidaTuristica> salidas2 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		EstadoActividad estado2 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, date = LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		ActividadTuristica actividad2 = new ActividadTuristica("paseo2", "lindo2", "nacional2", 2, 200, date = LocalDate.of(2, 2, 2),  depto, salidas2, estado2, null);
		actividad1.crearSalidaTuristica("salida1", 1, date=LocalDate.of(1, 1, 1), date, LocalTime.of(1, 1), "casa", null);
		actividad2.crearSalidaTuristica("salida2", 2, date=LocalDate.of(2, 2, 2), date, LocalTime.of(2, 2), "casa", null);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		manejador.getActividades().put(actividad2.getNombre(), actividad2);
		
		//prueba
		Map<String, DTActividadTuristica> actsPrueba = controlA.obtenerDTActividadesConfirmadasDepto("canelones");
		
		//retorno esperado
		DTActividadTuristica dtCorrecta1 = actividad1.obtenerDTActividad();
		DTActividadTuristica dtCorrecta2 = actividad2.obtenerDTActividad();

		
		
		
		//comparacion		
		DTActividadTuristica prueba1 = actsPrueba.get("paseo1");		
		DTActividadTuristica prueba2 = actsPrueba.get("paseo2");
		
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
	void testObtenerDTDepartamentos() {
		Manejador manejador = Manejador.getInstancia();
		ControladorActividad controlA = new ControladorActividad();
		
		//prueba
		Departamento depto1 = new Departamento("nombre1", "url1", "descripcion1");
		Departamento depto2 = new Departamento("nombre2", "url2", "descripcion2");
		manejador.getDepartamentos().put(depto1.getNombreDepto(), depto1);
		manejador.getDepartamentos().put(depto2.getNombreDepto(), depto2);
		
		Map<String, DTDepartamento> pruebaDeptos = controlA.obtenerDTDepartamentos();
		
		//retorno esperado
		DTDepartamento dt1 = depto1.obtenerDTDepto();
		DTDepartamento dt2 = depto2.obtenerDTDepto();
		
		//comparacion
		DTDepartamento prueba1 = pruebaDeptos.get("nombre1");
		DTDepartamento prueba2 = pruebaDeptos.get("nombre2");
		assertEquals(prueba1.getNombreDepto(), dt1.getNombreDepto());
		assertEquals(prueba1.getUrlDepto(), dt1.getUrlDepto());
		assertEquals(prueba1.getDescripcionDepto(), dt1.getDescripcionDepto());
		assertEquals(prueba2.getNombreDepto(), dt2.getNombreDepto());
		assertEquals(prueba2.getUrlDepto(), dt2.getUrlDepto());
		assertEquals(prueba2.getDescripcionDepto(), dt2.getDescripcionDepto());
	
		
		
		
		
		
		
	}

	@Test
	void testIngresarDatosSalidaTuristica() throws ExcepcionAltaSalida {
		ControladorActividad controlA = new ControladorActividad();
		Manejador manejador = Manejador.getInstancia();
		
		HashMap<String, SalidaTuristica> salidas = new HashMap<>();
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo", "lindo1", "nacional1", 1, 100, LocalDate.of(1, 1, 1),  depto, salidas, estado1, null);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		controlA.ingresarDatosSalidaTuristica("paseo", "salida", 1, LocalDate.of(1, 1, 1), LocalDate.of(2, 2, 2), LocalTime.of(1, 1), "lugar1", null);
		
		
		
		//retorno esperado
		SalidaTuristica correcta = new SalidaTuristica("salida", 1, LocalDate.of(1, 1, 1), LocalDate.of(2, 2, 2), LocalTime.of(1, 1), "lugar1", null);
		
		//comparacion
		ActividadTuristica actividad2 = manejador.getActividad("paseo");
		SalidaTuristica prueba = actividad2.getSalida("salida");

		assertEquals(correcta.getNombre(), prueba.getNombre());
		assertEquals(correcta.getTopeTuristas(), prueba.getTopeTuristas());
		assertEquals(correcta.getLugarSalida(), prueba.getLugarSalida());
		
	}

}
