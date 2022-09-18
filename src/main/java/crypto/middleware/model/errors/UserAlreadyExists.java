package crypto.middleware.model.errors;


public class UserAlreadyExists  extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExists(){
        super("User already exists with the same Wallet");
        this.setStackTrace(new StackTraceElement[0]);
    }
}
