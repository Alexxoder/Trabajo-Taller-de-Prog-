package src.logica.clases;

public class Fabrica {
	
	public IPaquete getIPaquete() {
		return new ControladorPaquete();
	}
	
	public IUsuario getIUsuario() {
		return new ControladorUsuario();
	}
	
	public IActividad getIActividad() {
		return new ControladorActividad();
	}
}