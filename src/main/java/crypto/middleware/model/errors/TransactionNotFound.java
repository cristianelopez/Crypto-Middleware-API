package crypto.middleware.model.errors;

public class TransactionNotFound extends RuntimeException{
    public TransactionNotFound(String errorMessage) {
        super(errorMessage);
        this.setStackTrace(new StackTraceElement[0]);
    }
}
