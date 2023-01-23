package src.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import src.excepciones.ExcepcionAltaCategoria;
import src.logica.clases.Categoria;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.Manejador;

class AceptarAltaCategoriasTest {
	
	@Test
	void testAceptarAltaCategoria() {
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		try {
			controlA.aceptarAltaCategoria("Categoria1");
			Manejador manejador = Manejador.getInstancia();
			Categoria obtenido = manejador.getCategorias().get("Categoria1");
			Categoria esperado = new Categoria("Categoria1");
			
			assertEquals(esperado.getNombre(), obtenido.getNombre());
		} catch (ExcepcionAltaCategoria e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAceptarAltaCategoriaExcepcionAltaCategoria() {
		Fabrica fabrica = new Fabrica();
		IActividad controlA = fabrica.getIActividad();
		try {
			controlA.aceptarAltaCategoria("Categoria1");
		} catch (ExcepcionAltaCategoria e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
