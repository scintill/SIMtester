# [SIMtester](https://opensource.srlabs.de/projects/simtester) on Android experiment

Android 5 has an [iccTransmitApduBasicChannel() API](https://developer.android.com/reference/android/telephony/TelephonyManager.html#iccTransmitApduBasicChannel\(int, int, int, int, int, java.lang.String\)), and some earlier builds of Android have similar patches ([SEEK](https://code.google.com/p/seek-for-android/)).  I wondered if SIMtester could be ported to this.  I've made a first attempt here.  This is only tested on my CyanogenMod 11 Sony phone, and it doesn't work very well.  The SEEK APIs used should be available on several commercial Android builds, but it's hard to find reliable information about which.

It's able to read the first few SIM files, but fails at MANUAREA, with SW = 6f00.  If I hack that out, it goes on to probe TARs, but the results don't match what I see on my PC with PCSC.  Looking at the logs from my Qualcomm RIL, I think what is happening is that only certain types of commands are allowed.  The error message also points to a QMI error code, which leads me to believe the baseband is denying access, so it's not something that could be trivially bypassed.

I'm not sure if I can or will pursue this further, but here are some ideas for discussion or further investigation:

- Logical channel access might have less restrictions.  I don't know enough about SIMs/smartcards to know if SIMtester can be rewritten to use a logical channel rather than the basic channel.
- The [Remote SIM Access for Android app](http://www.android-rsap.com/) proxies SIM requests in some way over Bluetooth on supported phones.  Maybe it has another route to SIM card access that is less restricted.  I tried the trial app on my phone (which is supposed to be supported), but I could not get it to work.  It seemed to be a fairly superficial problem with the installation of a RIL wrapper library, rather than something deeper, so maybe there is some hope yet.
- Arbitrary SIM requests may be possible with proprietary RIL requests, AT commands, and/or Linux device ioctl's etc.  Personally, that's not very interesting to me, though -- full Android support would be much more useful.

## Build and running

1. Build all three projects (SIMLibrary, SIMLibrary-Android, SIMTester) in Netbeans.  You will probably have to change the path to the android.jar library in SIMLibrary-Android.
2. You will probably need to change the path to the Android SDK in `Makefile.android`.
2. `Make -f Makefile.android phone-setup-once` (only needed once, needs `adb`)
3. `Make -f Makefile.android run` builds and runs the  app with `adb`. The first run is slow for me with ART, because it has to compile the bootstrap classes into the sandboxed data path the Makefile uses (which is done because of permissions issues writing to the system's dalvik-cache.)

## Implementation notes

The basic code is in AndroidSIMTerminal.  I put in stubs of some Android/SEEK private classes to compile against.  At runtime, the real classes are found.

Part of the `javax.smartcardio` API is implemented, since Android doesn't have it.  CommandAPDU implementation not included, because it looks kind of complicated, so I've just been testing with OpenJDK's GPL'd implementation.

The application is run as the user `nfc`, because on CM11 that user is allowed to call the SEEK APIs in the telephony service.  The applicable user ID may be different on other builds.

Some of this may be possible through the official SEEK service APK, which would be nice because root would not be required.  But I have not used it for a few reasons: a) My CyanogenMod phone doesn't have it, but does have the SEEK patches, b) There are access controls implemented in the service APK, which might get in the way.
