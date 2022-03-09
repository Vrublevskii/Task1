package exeptions;

public class OverloadException extends RuntimeException {

    public OverloadException() {
        super("Truck is overloaded");
    }
}
