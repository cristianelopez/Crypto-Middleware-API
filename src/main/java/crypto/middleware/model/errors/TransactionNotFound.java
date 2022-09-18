package crypto.middleware.model.errors;

public class TransactionNotFound extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionNotFound(String errorMessage) {
        super(errorMessage);
        this.setStackTrace(new StackTraceElement[0]);
    }
}
