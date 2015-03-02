package javax.smartcardio;

public class CardException extends Exception {

    public CardException(Throwable cause) {
        super(cause);
    }

    public CardException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardException(String message) {
        super(message);
    }

}
