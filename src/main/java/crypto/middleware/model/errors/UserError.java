package crypto.middleware.model.errors;

public class UserError extends RuntimeException {
    public UserError(String errorMessage) {
        super(errorMessage);
        this.setStackTrace(new StackTraceElement[0]);
    }
}
