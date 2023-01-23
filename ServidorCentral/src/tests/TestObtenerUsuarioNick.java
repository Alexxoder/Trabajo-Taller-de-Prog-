package src.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import src.logica.clases.Fabrica;
import src.logica.clases.IUsuario;
import src.logica.clases.Manejador;
import src.logica.clases.Turista;
import src.logica.clases.Usuario;

class TestObtenerUsuarioNick {

private static IUsuario controlUser;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = new Fabrica();
		controlUser = fabrica.getIUsuario();	
	}
	
	@Test
	void ObtenerUsuarioNick() {
		
		String nombre = "Bruce1";
		String apellido = "Wayne1";
		String nickname ="Batman1";
		String correo = "bruce@wayne.com1";
		String nacionalidad = "DCComics1";
		String contrasenia = "123";
		String imagen = "";
		LocalDate fechanacDate = LocalDate.of(1939, 3, 30);
		Turista turista = new Turista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad, null);
		Manejador manejador = Manejador.getInstancia();
		manejador.getUsuarios().put(nickname, turista);
		Usuario user = controlUser.obtenerUsuarioPorNick(nickname);
		assertEquals(user.getNickname(), nickname);
		
	}
}
