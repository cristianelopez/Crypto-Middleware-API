package crypto.middleware.model.errors;

public class UserNotFound  extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFound(){
        super("There is not a registered user with that ID");
        this.setStackTrace(new StackTraceElement[0]);
    }
}
