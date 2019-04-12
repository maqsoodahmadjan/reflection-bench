package disi.unitn.refbench.refbench12;

import java.util.Hashtable;

import android.util.Log;

public class EncodeDecode {
    private static final String TAG = "EncodeDecodeClass";
    private static Hashtable encodeStr = new Hashtable();
    static {

        encodeStr.put(new String("c1"), new String("android.telephony.TelephonyManager"));
        encodeStr.put(new String("m1"), new String("getDeviceId"));
        encodeStr.put(new String("c2"), new String("android.telephony.SmsManager"));
        encodeStr.put(new String("m2"), new String("sendTextMessage"));



    }
    public EncodeDecode(){
        Log.i(TAG, "This is a default constructor!");
    }

    public String decode(String encode){
        String decodeStr;
        decodeStr = (String) encodeStr.get(encode);
        return decodeStr;
    }
}