package de.srlabs.simlib.androidseekprovider;

import android.content.Context;
import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.telephony.ITelephony;
import de.srlabs.simlib.HexToolkit;
import javax.smartcardio.ATR;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

public class AndroidSIMTerminal {

    private static final String TAG = "AndroidSIMTerminal";

    private static AndroidSIMTerminal sInstance = null;

    public static AndroidSIMTerminal getInstance() {
        if (sInstance == null) {
            sInstance = new AndroidSIMTerminal();
        }
        return sInstance;
    }

    public ResponseAPDU transmitBasic(CommandAPDU capdu) {
        Log.d(TAG, "transmitBasic "+HexToolkit.toString(capdu.getBytes()));

        // XXX I just took a guess that bytes[4] is P3, and got some things
        // working, but upon skimming some specs and SEEK service code, I
        // suspect it's more complicated...
        byte[] bytes = capdu.getBytes();
        String data = HexToolkit.toString(bytes, 5, bytes.length-5);
        String response = getITelephony().transmitIccBasicChannel(capdu.getCLA(), capdu.getINS(),
            capdu.getP1(), capdu.getP2(), bytes[4] & 0xff, data);

        Log.d(TAG, "response: "+response);

        return new ResponseAPDU(HexToolkit.fromString(response));
    }

    public ATR getATR() {
        return new ATR(getITelephony().getATR());
    }

    private static ITelephony getITelephony() {
        return ITelephony.Stub.asInterface(ServiceManager.getService(Context.TELEPHONY_SERVICE));
    }

}
