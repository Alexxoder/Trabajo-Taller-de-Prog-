package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import src.excepciones.ExcepcionAltaCategoria;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.datatypes.DTCategoria;

class TestObtenerDTCategoria {

	@Test
	void testObtenerDTCategorias() {
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		try {
			controlA.aceptarAltaCategoria("categoria1");
			controlA.aceptarAltaCategoria("categoria2");
			
			DTCategoria categoria1 = new DTCategoria("categoria1");
			DTCategoria categoria2 = new DTCategoria("categoria2");
			
			controlA.obtenerDTCategorias().forEach((key, value) -> {
				if (key.equals(categoria1.getNombre()))
					assertEquals(categoria1.getNombre(), value.getNombre());
				if (key.equals(categoria2.getNombre()))
					assertEquals(categoria2.getNombre(), value.getNombre());
			});
		} catch (ExcepcionAltaCategoria e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	void testObtenerDTCategoria() {
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		try {
			controlA.aceptarAltaCategoria("categoria3");
			
			DTCategoria categoria3 = new DTCategoria("categoria3");
			
			DTCategoria dtCategoria = controlA.obtenerDTCategoria("categoria3");
			
			assertEquals(categoria3.getNombre(), dtCategoria.getNombre());
		} catch (ExcepcionAltaCategoria e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
