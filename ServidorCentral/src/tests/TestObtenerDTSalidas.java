package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.junit.jupiter.api.Test;

import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.Manejador;
import src.logica.clases.SalidaTuristica;
import src.logica.datatypes.DTSalidaTuristica;

class TestObtenerDTSalidas {

	@Test
	void testObtenerDTSalidas() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		
		SalidaTuristica salida = new SalidaTuristica("salida", 10, LocalDate.of(2022, 5, 21), LocalDate.of(2022, 12, 5), LocalTime.of(20, 0), "lugar", null);
		manejador.getSalidas().put("salida", salida);
		
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		DTSalidaTuristica esperado = new DTSalidaTuristica("salida", 10, 10, LocalDate.of(2022, 5, 21), LocalDate.of(2022, 12, 5), LocalTime.of(20, 0), "lugar", null);
		Map<String, DTSalidaTuristica> salidas = controlA.obtenerDTSalidas();
		salidas.forEach((key, value) -> {
			assertEquals(esperado.getNombre(), value.getNombre());
			assertEquals(esperado.getCuposDisponibles(), value.getCuposDisponibles());
			assertEquals(esperado.getTopeTuristas(), value.getTopeTuristas());
			assertEquals(esperado.getFechaAlta().getYear(), value.getFechaAlta().getYear());
			assertEquals(esperado.getFechaSalida().getYear(), value.getFechaSalida().getYear());
			assertEquals(esperado.getHoraSalida().getHour(), value.getHoraSalida().getHour());
			assertEquals(esperado.getLugarSalida(), value.getLugarSalida());
		});
	}

}
