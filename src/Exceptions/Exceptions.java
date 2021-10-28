package Exceptions;

public class Exceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Exceptions() {
		super();
	}

	public Exceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public Exceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public Exceptions(String message) {
		super(message);
	}

	public Exceptions(Throwable cause) {
		super(cause);
	}

}