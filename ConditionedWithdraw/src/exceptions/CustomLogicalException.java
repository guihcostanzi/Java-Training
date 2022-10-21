package exceptions;

public class CustomLogicalException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CustomLogicalException (String msg) {
		super(msg);
	}

}
