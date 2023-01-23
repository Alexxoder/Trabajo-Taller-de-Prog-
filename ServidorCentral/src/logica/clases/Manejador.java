package src.logica.clases;

import java.util.HashMap;
import java.util.Map;

//singleton
public class Manejador {
	
	private Map<String, PaqueteActividad> paquetes;
	private Map<String, Usuario> usuarios;
	private Map<String, ActividadTuristica> actividades;
	private Map<String, SalidaTuristica> salidas;
	private Map<String, Departamento> departamentos;
	private Map<String, Categoria> categorias;

	private static Manejador instancia = null;

	public Manejador() {
		paquetes = new HashMap<>();
		usuarios = new HashMap<>();
		actividades = new HashMap<>();
		salidas = new HashMap<>();
		departamentos = new HashMap<>();
		categorias = new HashMap<>();
	}

	public static Manejador getInstancia() {
		if (instancia == null) {
			instancia = new Manejador();
		}
		return instancia;
	}

	// getters
	public Map<String, PaqueteActividad> getPaquetes() {
		return paquetes;
	}

	public Map<String, Usuario> getUsuarios() {
		return usuarios;
	}

	public Map<String, ActividadTuristica> getActividades() {
		return actividades;
	}

	public Map<String, SalidaTuristica> getSalidas() {
		return salidas;
	}

	public Map<String, Departamento> getDepartamentos() {
		return departamentos;
	}
	
	public Map<String, Categoria> getCategorias() {
		return categorias;
	}

	public PaqueteActividad getPaquete(String nombrePaquete) {
		PaqueteActividad res = paquetes.get(nombrePaquete);
		return res;
	}

	public ActividadTuristica getActividad(String nombreActividad) {
		ActividadTuristica res = actividades.get(nombreActividad);
		return res;
	}
}
