package javax.smartcardio;

import java.util.List;

public abstract class CardTerminals {

    public List<CardTerminal> list() throws CardException {
        return this.list(State.ALL);
    }

    public abstract List<CardTerminal> list(State state) throws CardException;

    public abstract boolean waitForChange(long timeout) throws CardException;

    public static enum State {
        /**
         * All CardTerminals.
         */
        ALL,
        /**
         * CardTerminals in which a card is present.
         */
        CARD_PRESENT,
        /**
         * CardTerminals in which a card is not present.
         */
        CARD_ABSENT,
        /**
         * CardTerminals for which a card insertion was detected during the
         * latest call to {@linkplain State#waitForChange waitForChange()}
         * call.
         */
        CARD_INSERTION,
        /**
         * CardTerminals for which a card removal was detected during the
         * latest call to {@linkplain State#waitForChange waitForChange()}
         * call.
         */
        CARD_REMOVAL,
    }

}
