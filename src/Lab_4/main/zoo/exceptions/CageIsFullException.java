package Lab_4.main.zoo.exceptions;

public class CageIsFullException extends RuntimeException {
    public CageIsFullException(String message) {
        super(message);
    }
}