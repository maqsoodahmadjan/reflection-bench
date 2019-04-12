package disi.unitn.refbench.refbench8;


import android.util.Log;


public class Getter {
    String str1 = "disi" ;
    String str2 = "unitn";
    String str3 = "refbench";
    String str4 = "refbench8";
    String c = "BaseClass";
    String m1 = "method1";
    String m2 = "method2";
    String TAG = "BaseClass";


    public Getter() {
        Log.i(TAG, "This is a default constructor!");

    }



    public String get(String str){

        if(str == "B")
            return str1+"."+str2+"."+str3+"."+str4+"."+c;
        else if(str == "m1")
            return m1;
        else if(str == "m2")
            return m2;
        else
            return null;
    }

}
