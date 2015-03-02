package de.srlabs.simlib.androidseekprovider;

import java.nio.ByteBuffer;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

public class AndroidSEEKCardBasicChannel extends CardChannel {

    private final static boolean DEBUG = false;
    private static AndroidSEEKCardBasicChannel _instance = null;

    public static synchronized AndroidSEEKCardBasicChannel getInstance() {
        if (null == _instance) {
            _instance = new AndroidSEEKCardBasicChannel();
            return _instance;
        } else {
            return _instance;
        }
    }

    private AndroidSEEKCardBasicChannel() {
    }

    @Override
    public Card getCard() {
        return AndroidSEEKCard.getInstance();
    }

    @Override
    public int getChannelNumber() {
        return 0; // we only provide 1 channel always
    }

    @Override
    public ResponseAPDU transmit(CommandAPDU capdu) throws CardException {
        return AndroidSIMTerminal.getInstance().transmitBasic(capdu);
    }

    @Override
    public void close() throws CardException {
        throw new UnsupportedOperationException("close() not implemented in AndroidSEEKCardBasicChannel");
    }

    @Override
    public int transmit(ByteBuffer command, ByteBuffer response) throws CardException {
        throw new CardException("transmit() with ByteBuffers not implemented in AndroidSEEKCardBasicChannel");
    }
}
