package javax.smartcardio;

public class ResponseAPDU {

    private byte[] apdu;

    public ResponseAPDU(byte[] apdu) {
        this.apdu = apdu.clone();
    }

    public byte[] getBytes() {
        return apdu.clone();
    }

    public int getSW1() {
        return apdu[apdu.length-2] & 0xff;
    }

    public int getSW2() {
        return apdu[apdu.length-1] & 0xff;
    }

    public int getSW() {
        return (getSW1() << 8) | getSW2();
    }

    public byte[] getData() {
        byte[] data = new byte[apdu.length-2];
        System.arraycopy(apdu, 0, data, 0, data.length);
        return data;
    }

}
