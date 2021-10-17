package exceptions;

public class NoPicoCedulaException extends Exception{

private static final long serialVersionUID = 1L;
	
	public NoPicoCedulaException() {
		super("ERRO: El Usuario no puede ingresar, porque su pico y cedula no es el dia de hoy");
	}
	
	
	
}