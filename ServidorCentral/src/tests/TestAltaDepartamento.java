package src.tests;

import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;

import java.util.Map;

import src.excepciones.DepartamentoRepetidoException;
import src.logica.clases.ControladorActividad;
import src.logica.clases.Departamento;
import src.logica.clases.Manejador;

public class TestAltaDepartamento {
	@Test
	public void testAltaDepartamento1() throws DepartamentoRepetidoException {
		//ejecuto el CU
		ControladorActividad controlA = new ControladorActividad();
		controlA.altaDepartamento("Montevideo", "La capital", "www.montevideo.com.uy");
		
		//Esto es lo que deberia de haber pasado
		Departamento esperado = new Departamento("Montevideo", "La capital", "www.montevideo.com.uy");
		//Consigo lo que paso
		Manejador manejador = Manejador.getInstancia();
		Map<String, Departamento> col = manejador.getDepartamentos();
		Departamento alta = col.get("Montevideo");
		
		//comparo resultados
		assertEquals(esperado.getNombreDepto(), alta.getNombreDepto());
		assertEquals(esperado.getDescripcionDepto(), alta.getDescripcionDepto());
		assertEquals(esperado.getUrlDepto(), alta.getUrlDepto());
	}
}
