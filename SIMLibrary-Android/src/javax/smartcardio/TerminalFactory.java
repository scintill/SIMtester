package javax.smartcardio;

import de.srlabs.simlib.androidseekprovider.AndroidSEEKCardTerminals;
import java.security.NoSuchAlgorithmException;

public class TerminalFactory {

    public static TerminalFactory getInstance(String type, Object params) throws NoSuchAlgorithmException {
        if (!type.equals("AndroidSEEKTerminalFactory")) {
            throw new NoSuchAlgorithmException("Unsupported terminal factory");
        }

        return getDefault();
    }

    public static TerminalFactory getDefault() {
        return new TerminalFactory();
    }

    public CardTerminals terminals() {
        return new AndroidSEEKCardTerminals();
    }

}
