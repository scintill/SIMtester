package de.srlabs.simlib.androidseekprovider;

import javax.smartcardio.ATR;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;

public class AndroidSEEKCard extends Card {

    private final static boolean DEBUG = false;
    private ATR _atr = null;
    private static AndroidSEEKCard _instance = null;

    public static synchronized AndroidSEEKCard getInstance() {
        if (null == _instance) {
            _instance = new AndroidSEEKCard();
            return _instance;
        } else {
            return _instance;
        }
    }

    private AndroidSEEKCard() {
    }

    @Override
    public ATR getATR() {
        return AndroidSIMTerminal.getInstance().getATR();
    }

    @Override
    public String getProtocol() {
        return "there is no protocol";
    }

    @Override
    public final CardChannel getBasicChannel() {
        return AndroidSEEKCardBasicChannel.getInstance();
    }

    @Override
    public void disconnect(boolean not_really_reset) throws CardException {
        throw new UnsupportedOperationException("disconnect() not implemented in AndroidSEEKCard");
    }

    @Override
    public CardChannel openLogicalChannel() throws CardException {
        throw new CardException("openLogicalChannel() not implemented in AndroidSEEKCard");
    }

    @Override
    public void beginExclusive() throws CardException {
        throw new CardException("beginExclusive() not implemented in AndroidSEEKCard");
    }

    @Override
    public void endExclusive() throws CardException {
        throw new CardException("endExclusive() not implemented in AndroidSEEKCard");
    }

    @Override
    public byte[] transmitControlCommand(int controlCode, byte[] command) throws CardException {
        throw new CardException("transmitControlCommand() not implemented in AndroidSEEKCard");
    }

}
