package src.presentacion;

import java.io.IOException;
import src.excepciones.ActividadRepetidaException;
import src.excepciones.DepartamentoRepetidoException;
import src.excepciones.ExcepcionAltaCategoria;
import src.excepciones.ExcepcionAltaSalida;
import src.excepciones.PaqueteRepetidoException;
import src.excepciones.UsuarioRepetidoException;

public class Main {

	public static void main(String[] args) throws DepartamentoRepetidoException, PaqueteRepetidoException, ExcepcionAltaSalida, UsuarioRepetidoException, ActividadRepetidaException, ExcepcionAltaCategoria, IOException {
        // TODO code application logic here
        Publicador p = new Publicador();
        p.publicar();
        Prueba prueba = new Prueba();
    }
}
