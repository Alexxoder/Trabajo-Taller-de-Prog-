package src.tests;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.excepciones.UsuarioNoExisteException;
import src.logica.clases.Fabrica;
import src.logica.clases.IUsuario;
import src.logica.clases.Manejador;
import src.logica.clases.Turista;
import src.logica.datatypes.DTUsuarioExtendido;

class TestObtenerUsuarioID {

private static IUsuario controlUser;
	
	@BeforeEach
	public  void limpiarDatos(){
	
		Manejador manejador = Manejador.getInstancia();
		manejador.getPaquetes().clear();
		manejador.getActividades().clear();
		manejador.getUsuarios().clear();
		manejador.getDepartamentos().clear();
	}

	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = new Fabrica();
		controlUser = fabrica.getIUsuario();	
	}
	 @Test
	 void testObtenerUsuarioPorIDCorreo() {
		 String nombre = "Bruce";
			String apellido = "Wayne";
			String nickname ="Batman";
			String correo = "bruce@wayne.com";
			String contrasenia = "1234";
			String nacionalidad = "DCComics";
			LocalDate fechanacDate = LocalDate.of(1939, 3, 30);
			String imagen = null;
			Turista turista = new Turista(nickname, nombre, apellido, correo, contrasenia, fechanacDate, imagen, nacionalidad, null);
			Manejador manejador = Manejador.getInstancia();
			manejador.getUsuarios().put(nickname, turista);
			try {
				DTUsuarioExtendido usercorreo = controlUser.obtenerUsuarioPorID(correo);
				assertEquals(usercorreo.getCorreo(), correo);
			} catch (UsuarioNoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }
	 
	@Test
	 void testObtenerUsuarioPorIDnick() {
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
			try {
				DTUsuarioExtendido usernick = controlUser.obtenerUsuarioPorID(nickname);
				assertEquals(usernick.getNickname(), nickname);
			} catch (UsuarioNoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }
}
