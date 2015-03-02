package android.telephony;

/**
 * This is a stub of a non-public piece of Android.  It's here for compiling.
 * When running on Android, the system will use the real class instead of this one.
 */
public interface TelephonyManager {

    public String iccTransmitApduBasicChannel(int cla, int instruction, int p1, int p2, int p3, String data);

}
