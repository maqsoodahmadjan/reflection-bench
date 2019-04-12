package disi.unitn.refbench.refbench7;

import java.util.Hashtable;

import android.util.Log;

public class EncodeDecode {
    private static final String TAG = "EncodeDecodeClass";
    private static Hashtable encodeStr = new Hashtable();
    static {
        encodeStr.put(new String("m1"), new String("method1"));
        encodeStr.put(new String("m2"), new String("method2"));
        encodeStr.put(new String("cl"), new String("disi.unitn.refbench.refbench7.BaseClass"));
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