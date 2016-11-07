package banking.exceptions;


public class NoProductDefinitionFoundException extends RuntimeException{
    public NoProductDefinitionFoundException(String message) {
        super(message);
    }

    public NoProductDefinitionFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
