package javax.smartcardio;

public class ATR {

    private byte[] atr;

    public ATR(byte[] atr) {
        this.atr = atr.clone();
    }

    public byte[] getBytes() {
        return atr.clone();
    }

}
