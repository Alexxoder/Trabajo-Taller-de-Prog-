package src.tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import src.excepciones.UsuarioRepetidoException;
import src.logica.clases.Fabrica;
import src.logica.clases.IUsuario;
import src.logica.clases.Manejador;
import src.logica.clases.Turista;
import src.logica.datatypes.DTTurista;


class TestTurista {

	private static IUsuario controlUser;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = new Fabrica();
		controlUser = fabrica.getIUsuario();	
	}
	
	
	@Test
	void testAceptarAltaTurista() {
		String nombre = "Bruce";
		String apellido = "Wayne";
		String nickname ="Batman";
		String correo = "bruce@wayne.com";
		String contrasenia = "1234";
		String nacionalidad = "DCComics";
		LocalDate fechanacDate = LocalDate.of(1939, 3, 30);
		String imagen = null;
		
		try {
			controlUser.aceptarAltaTurista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad);
			DTTurista turista= (DTTurista) controlUser.obtenerDTUsuarios().get(nickname);
			assertEquals(nickname, turista.getNickname());
			assertEquals(nombre, turista.getNombre());
			assertEquals(apellido, turista.getApellido());
			assertEquals(correo, turista.getCorreo());
			assertEquals(nacionalidad, turista.getNacionalidad());
			assertEquals(fechanacDate, turista.getFechaNacimiento());
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	
	}
	
@Test
	void registrarUsuarioNickRepetido() {
		String nombre = "Bruce1";
		String apellido = "Wayne1";
		String nickname ="Batman1";
		String correo = "bruce@wayne.com1";
		String contrasenia = "1234";
		String nacionalidad = "DCComics1";
		LocalDate fechanacDate = LocalDate.of(1939, 3, 30);
		String imagen = null;
		Turista turista = new Turista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad, null);
		Manejador manejador = Manejador.getInstancia();
		manejador.getUsuarios().put(nickname, turista);

		try {
			controlUser.aceptarAltaTurista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad);
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, ()-> {
			controlUser.aceptarAltaTurista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad);
			});
		
		
	}

	@Test
	void registrarUsuarioCorreoRepetido() {
		String nombre = "Bruce1";
		String apellido = "Wayne1";
		String nickname ="Batman1";
		String correo = "bruce@wayne.com1";
		String contrasenia = "1234";
		String nacionalidad = "DCComics1";
		LocalDate fechanacDate = LocalDate.of(1939, 3, 30);
		String imagen = null;
		Turista turista = new Turista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad, null);
		Manejador manejador = Manejador.getInstancia();
		manejador.getUsuarios().put(nickname, turista);

		try {
			controlUser.aceptarAltaTurista("Batman2", nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad);
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {
			controlUser.aceptarAltaTurista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad);
			});
		
	}
	
	
}
