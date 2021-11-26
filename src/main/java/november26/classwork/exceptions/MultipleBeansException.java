package november26.classwork.exceptions;

public class MultipleBeansException extends Exception{
    public MultipleBeansException() {
    }

    public MultipleBeansException(String message) {
        super(message);
    }

    public MultipleBeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public MultipleBeansException(Throwable cause) {
        super(cause);
    }

    public MultipleBeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
