package javax.smartcardio;

public abstract class CardTerminal {

    public abstract String getName();

    public abstract Card connect(String protocol) throws CardException;

    public abstract boolean isCardPresent() throws CardException;

    public abstract boolean waitForCardPresent(long l) throws CardException;

    public abstract boolean waitForCardAbsent(long l) throws CardException;

}
