package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import src.excepciones.PaqueteRepetidoException;
import src.logica.clases.Fabrica;
import src.logica.clases.IPaquete;
import src.logica.clases.Manejador;
import src.logica.clases.PaqueteActividad;

class TestCrearNuevoPaquete {

	@Test
	void testCrearNuevoPaquete() {
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
		
		Fabrica fabrica = new Fabrica();
		IPaquete controlP = fabrica.getIPaquete();
		try {
			controlP.crearNuevoPaquete("paquete1", "descripcion1", 15, 0.50, LocalDate.of(2022, 10, 23), null);
			
			PaqueteActividad esperado = new PaqueteActividad("paquete1", "descripcion1", 15, 0.50, LocalDate.of(2022, 10, 23), null, new HashMap<>());
			PaqueteActividad obtenido = manejador.getPaquete("paquete1");
			
			
			assertEquals(esperado.getNombre(), obtenido.getNombre());
			assertEquals(esperado.getDescripcion(), obtenido.getDescripcion());
			assertEquals(esperado.getValidez(), obtenido.getValidez());
			assertEquals(esperado.getDescuento(), obtenido.getDescuento());
			assertEquals(esperado.getFechaAlta().getYear(), obtenido.getFechaAlta().getYear());
		} catch (PaqueteRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
