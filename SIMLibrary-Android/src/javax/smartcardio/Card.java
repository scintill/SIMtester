package javax.smartcardio;

public abstract class Card {

    public abstract ATR getATR();

    public abstract String getProtocol();

    public abstract CardChannel getBasicChannel();

    public abstract void disconnect(boolean reset) throws CardException;

    public abstract CardChannel openLogicalChannel() throws CardException;

    public abstract void beginExclusive() throws CardException;

    public abstract void endExclusive() throws CardException;

    public abstract byte[] transmitControlCommand(int controlCode, byte[] command) throws CardException;

}
