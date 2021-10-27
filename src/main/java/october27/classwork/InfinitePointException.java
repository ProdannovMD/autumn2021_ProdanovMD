package october27.classwork;

public class InfinitePointException extends Exception{
    public InfinitePointException() { }

    public InfinitePointException(String message) {
        super(message);
    }

    public void printMessage() {
        System.out.println(getMessage());
    }
}
