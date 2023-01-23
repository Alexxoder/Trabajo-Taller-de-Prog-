package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.logica.clases.ActividadTuristica;
import src.logica.clases.ControladorActividad;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;
import src.logica.datatypes.DTSalidaTuristica;


class TestConsultaSalida {

	@Test
	void testObtenerDTSalidasTuristicas() {
		Manejador manejador = Manejador.getInstancia();
		ControladorActividad controlA = new ControladorActividad();
		
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		Map<String, SalidaTuristica> salidas1 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		actividad1.crearSalidaTuristica("salida1", 1, LocalDate.of(1, 1, 1), LocalDate.of(11, 11, 11), LocalTime.of(1, 1), "casa1", null);
		actividad1.crearSalidaTuristica("salida2", 2, LocalDate.of(2, 2, 2), LocalDate.of(22, 12, 22), LocalTime.of(2, 2), "casa2", null);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		
		//prueba
		Map<String, DTSalidaTuristica> dtsalidasPrueba = controlA.obtenerDTSalidasTuristicas(actividad1.getNombre());
		
		//retorno esperado
		DTSalidaTuristica salida1 = new DTSalidaTuristica("salida1", 1, 1, LocalDate.of(1, 1, 1), LocalDate.of(11, 11, 11), LocalTime.of(1, 1), "casa1", null);
		DTSalidaTuristica salida2 = new DTSalidaTuristica("salida2", 2, 2, LocalDate.of(2, 2, 2), LocalDate.of(22, 12, 22), LocalTime.of(2, 2), "casa2", null);		

		//comparacion
		DTSalidaTuristica dtprueba1 = dtsalidasPrueba.get(salida1.getNombre());
		DTSalidaTuristica dtprueba2 = dtsalidasPrueba.get(salida2.getNombre());
		String nombrePrueba1 = dtprueba1.getNombre();
		String nombreCorrecto1 = salida1.getNombre();
		String nombrePrueba2 = dtprueba2.getNombre();
		String nombreCorrecto2 = salida2.getNombre();
		assertEquals(nombrePrueba1, nombreCorrecto1);
		assertEquals(nombrePrueba2, nombreCorrecto2);
		
		int topePrueba1 = dtprueba1.getTopeTuristas();
		int topeCorrecto1 = salida1.getTopeTuristas();
		int topePrueba2 = dtprueba2.getTopeTuristas();
		int topeCorrecto2 = salida2.getTopeTuristas();		
		assertEquals(topePrueba1, topeCorrecto1);
		assertEquals(topePrueba2, topeCorrecto2);
		
		LocalDate adatePrueba1 = dtprueba1.getFechaAlta();
		LocalDate adateCorrecta1 = salida1.getFechaAlta();
		LocalDate adatePrueba2 = dtprueba2.getFechaAlta();
		LocalDate adateCorrecta2 = salida2.getFechaAlta();
		assertEquals(adatePrueba1, adateCorrecta1);
		assertEquals(adatePrueba2, adateCorrecta2); 
		
		LocalDate sdatePrueba1 = dtprueba1.getFechaSalida();
		LocalDate sdateCorrecta1 = salida1.getFechaSalida();
		LocalDate sdatePrueba2 = dtprueba2.getFechaSalida();
		LocalDate sdateCorrecta2 = salida2.getFechaSalida();
		assertEquals(sdatePrueba1, sdateCorrecta1);
		assertEquals(sdatePrueba2, sdateCorrecta2);
		
		LocalTime horaPrueba1 = dtprueba1.getHoraSalida();
		LocalTime horaCorrecta1 = salida1.getHoraSalida();
		LocalTime horaPrueba2 = dtprueba2.getHoraSalida();
		LocalTime horaCorrecta2 = salida2.getHoraSalida();
		assertEquals(horaPrueba1, horaCorrecta1);
		assertEquals(horaPrueba2, horaCorrecta2); 
		
		String lugarPrueba1 = dtprueba1.getLugarSalida();
		String lugarCorrecto1 = salida1.getLugarSalida();
		String lugarPrueba2 = dtprueba2.getLugarSalida();
		String lugarCorrecto2 = salida2.getLugarSalida();
		assertEquals(lugarPrueba1, lugarCorrecto1);
		assertEquals(lugarPrueba2, lugarCorrecto2);			
	}
	
	@Test
	void testObtenerDTSalidaTuristica() {
		
		Manejador manejador = Manejador.getInstancia();
		ControladorActividad controlA = new ControladorActividad();
		
		Departamento depto = new Departamento("canelones", "urlsito", "feo");
		HashMap<String, SalidaTuristica> salidas1 = new HashMap<>();
		EstadoActividad estado1 = EstadoActividad.Confirmada;
		ActividadTuristica actividad1 = new ActividadTuristica("paseo1", "lindo1", "nacional1", 1, 100, LocalDate.of(1, 1, 1), depto, salidas1, estado1, null);
		actividad1.crearSalidaTuristica("salida1", 1, LocalDate.of(1, 1, 1), LocalDate.of(11, 11, 11), LocalTime.of(1, 1), "casa1", null);
		actividad1.crearSalidaTuristica("salida2", 2, LocalDate.of(2, 2, 2), LocalDate.of(22, 12, 22), LocalTime.of(2, 2), "casa2", null);
		manejador.getActividades().put(actividad1.getNombre(), actividad1);
		
		//prueba
		DTSalidaTuristica dtprueba = controlA.obtenerDTSalidaTuristica( "salida1");
		
		//salida esperada
		DTSalidaTuristica dtcorrecta = new DTSalidaTuristica("salida1", 1, 1, LocalDate.of(1, 1, 1), LocalDate.of(11, 11, 11) , LocalTime.of(1, 1), "casa1", null); 
		
		//comparacion
		String nombrePrueba1 = dtprueba.getNombre();
		String nombreCorrecto1 = dtcorrecta.getNombre();
		assertEquals(nombrePrueba1, nombreCorrecto1);
		
		int topePrueba1 = dtprueba.getTopeTuristas();
		int topeCorrecto1 = dtcorrecta.getTopeTuristas();		
		assertEquals(topePrueba1, topeCorrecto1);
	
		
		LocalDate adatePrueba1 = dtprueba.getFechaAlta();
		LocalDate adateCorrecta1 = dtcorrecta.getFechaAlta();
		assertEquals(adatePrueba1, adateCorrecta1);
 
		
		LocalDate sdatePrueba1 = dtprueba.getFechaSalida();
		LocalDate sdateCorrecta1 = dtcorrecta.getFechaSalida();
		assertEquals(sdatePrueba1, sdateCorrecta1);

		
		LocalTime horaPrueba1 = dtprueba.getHoraSalida();
		LocalTime horaCorrecta1 = dtcorrecta.getHoraSalida();
		assertEquals(horaPrueba1, horaCorrecta1);
		
		String lugarPrueba1 = dtprueba.getLugarSalida();
		String lugarCorrecto1 = dtcorrecta.getLugarSalida();
		assertEquals(lugarPrueba1, lugarCorrecto1);
		
	}
	
	
	

}
