package de.srlabs.simlib.androidseekprovider;

import java.util.ArrayList;
import java.util.List;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CardTerminals;

public class AndroidSEEKCardTerminals extends CardTerminals {

    final static CardTerminals INSTANCE = new AndroidSEEKCardTerminals();

    public AndroidSEEKCardTerminals() {
    }

    @Override
    public List<CardTerminal> list(CardTerminals.State state) throws CardException {
        if (state != CardTerminals.State.ALL) {
            throw new CardException("AndroidSEEKCardTerminals doesn't support statuses!");
        }
        List<CardTerminal> list = new ArrayList<>(1);
        list.add(AndroidSEEKCardTerminal.getInstance());
        return list;
    }

    @Override
    public boolean waitForChange(long timeout) throws CardException {
        throw new CardException("waitForChange() not implemented in AndroidSEEKCardTerminals");
    }

}
