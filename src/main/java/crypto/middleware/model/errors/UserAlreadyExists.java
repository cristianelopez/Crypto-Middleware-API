package crypto.middleware.model.errors;


public class UserAlreadyExists  extends RuntimeException {
    public UserAlreadyExists(){
        super("User already exists with the same Wallet");
        this.setStackTrace(new StackTraceElement[0]);
    }
}
