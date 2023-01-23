package src.excepciones;

public class InscripcionYaExisteException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public InscripcionYaExisteException(String string) {
    super(string);
  }
}
