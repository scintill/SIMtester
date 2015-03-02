package javax.smartcardio;

import java.nio.ByteBuffer;

public abstract class CardChannel {

    public abstract Card getCard();

    public abstract int getChannelNumber();

    public abstract ResponseAPDU transmit(CommandAPDU capdu) throws CardException;

    public abstract void close() throws CardException;

    public abstract int transmit(ByteBuffer command, ByteBuffer response) throws CardException;

}
