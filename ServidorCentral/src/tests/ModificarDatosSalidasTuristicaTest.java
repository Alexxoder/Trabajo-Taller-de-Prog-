package src.tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import src.excepciones.ExcepcionModificarSalida;
import src.logica.clases.ActividadTuristica;
import src.logica.clases.Departamento;
import src.logica.clases.EstadoActividad;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;

class ModificarDatosSalidasTuristicaTest {

	@Test
	void modificarDatosSalidasTest() {
		
		//cargo datos
		Manejador manejador = Manejador.getInstancia();
		Departamento departamentoTest = new Departamento("Departamento Test", "www.test.com.uy", "Un departamento para hacer test");
		manejador.getDepartamentos().put("Departamento Test", departamentoTest);
		SalidaTuristica salidaTest = new SalidaTuristica("Salida Test", 5, LocalDate.of(2022, 8, 31), LocalDate.of(2023, 9, 1), LocalTime.of(9, 30), "Testeolandia", null);
		manejador.getSalidas().put("Salida Test", salidaTest);
		HashMap<String, SalidaTuristica> salidasTest = new HashMap<>();
		salidasTest.put("Salida Test", salidaTest);
		EstadoActividad estado = EstadoActividad.Confirmada;
		ActividadTuristica actividadTest = new ActividadTuristica("Actividad Test", "Un actividad para hacer test", "Testeolandia", 5, 1500, LocalDate.of(2022, 1, 1), departamentoTest, salidasTest, estado, null);
		manejador.getActividades().put("Actividad Test", actividadTest);
		
		try {
			//ejecuto la operacion
			Fabrica fabrica = new Fabrica();
			IActividad controlActividad = fabrica.getIActividad();
			controlActividad.modificarDatosSalidaTuristica("Actividad Test", "Salida Test", 10, LocalDate.of(2023, 12, 1), LocalDate.of(2022, 12, 1), LocalTime.of(12, 0), "Nueva Salida");
			
			SalidaTuristica ocurrido = manejador.getSalidas().get("Salida Test");
			SalidaTuristica esperado = new SalidaTuristica("Salida Test", 10, LocalDate.of(2023, 12, 1), LocalDate.of(2022, 12, 1), LocalTime.of(12, 0), "Nueva Salida", null);
			
			assertEquals(esperado.getNombre(), ocurrido.getNombre());
			assertEquals(esperado.getTopeTuristas(), ocurrido.getTopeTuristas());
			assertEquals(esperado.getFechaAlta(), ocurrido.getFechaAlta());
			assertEquals(esperado.getFechaSalida(), ocurrido.getFechaSalida());
			assertEquals(esperado.getHoraSalida(), ocurrido.getHoraSalida());
			assertEquals(esperado.getLugarSalida(), ocurrido.getLugarSalida());
			
		} catch (ExcepcionModificarSalida e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
