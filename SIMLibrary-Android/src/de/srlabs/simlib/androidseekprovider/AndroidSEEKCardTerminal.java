package de.srlabs.simlib.androidseekprovider;

import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;

public class AndroidSEEKCardTerminal extends CardTerminal {

    private final static boolean DEBUG = false;
    private static AndroidSEEKCardTerminal _instance = null;
    public static boolean _initialized = false;

    public static synchronized AndroidSEEKCardTerminal getInstance() throws CardException {
        if (null == _instance) {
            _instance = new AndroidSEEKCardTerminal();
            return _instance;
        } else {
            return _instance;
        }
    }

    private AndroidSEEKCardTerminal() {
    }

    @Override
    public String getName() {
        return "AndroidSEEKCardTerminal";
    }

    @Override
    public Card connect(String protocol) throws CardException {
        return AndroidSEEKCard.getInstance();
    }

    @Override
    public boolean isCardPresent() throws CardException {
        throw new CardException("isCardPresent() not implemented in AndroidSEEKCardTerminal");
    }

    @Override
    public boolean waitForCardPresent(long l) throws CardException {
        throw new CardException("waitForCardPresent() not implemented in AndroidSEEKCardTerminal");
    }

    @Override
    public boolean waitForCardAbsent(long l) throws CardException {
        throw new CardException("waitForCardAbsent() not implemented in AndroidSEEKCardTerminal");
    }

}
