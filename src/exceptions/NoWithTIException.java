package exceptions;

public class NoWithTIException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NoWithTIException() {
		super("ERROR: No se permite el ingreso a Menores de Edad");
	}

}