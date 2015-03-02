package com.android.internal.telephony;

import android.os.IBinder;

/**
 * This is a stub of a non-public piece of Android. It's here for compiling.
 * When running on Android, the system will use the real class instead of this
 * one.
 */
public interface ITelephony {

    /**
     * Get ATR (Answer To Reset; as per ISO/IEC 7816-4) from SIM card.
     * From SEEK (CodeAurora version)
     */
    byte[] getATR();

    /**
     * Returns the response APDU for a command APDU sent to the basic channel.
     * From SEEK (CodeAurora version)
     * https://www.eftlab.com.au/index.php/site-map/knowledge-base/118-apdu-response-list.
     */
    String transmitIccBasicChannel(int cla, int command,
            int p1, int p2, int p3, String data);


    public abstract class Stub implements ITelephony {
        public static ITelephony asInterface(IBinder service) {
            throw new RuntimeException("stub!");
        }
    }

}
