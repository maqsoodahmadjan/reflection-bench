package disi.unitn.refbench.refbench13;


import android.util.Log;


public class Getter {
    String str1 = "android" ;
    String str2 = "telephony";
    String c1 = "TelephonyManager";
    String c2 = "SmsManager";
    String m1 = "DeviceId";
    String m2 = "TextMessage";
    String TAG = "BaseClass";


    public Getter() {
        Log.i(TAG, "This is a default constructor!");

    }



    public String get(String str){

        if(str == "T")
            return str1+"."+str2+"."+c1;
        else if(str == "S")
            return str1+"."+str2+"."+c2;
        else if(str == "get")
            return m1;
        else if(str == "send")
            return m2;
        else
            return null;
     }

}
