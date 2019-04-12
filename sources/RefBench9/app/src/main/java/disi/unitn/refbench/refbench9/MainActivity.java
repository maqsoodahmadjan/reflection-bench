package disi.unitn.refbench.refbench9;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String pass = "secret-key";
        String em1 = "B7A6C2A9DC74E2343611CE46828A8266";
        String em2 = "0B0B8C1316F45A987BC4F7DD91538BD9";
        String ec = "A395DB131C1490146AC5E938FDF5EBF238CABEB6A969B14ECB142C6DC1BF5AF86BD020E08157ABFAC60CE228A018F84F";

        EncryptDecrypt ed = new EncryptDecrypt();

        try {
            Class<?> mclass;
            Object bc;
            Method md1;
            Method md2;

            String str1 = ed.decrypt(pass, em1);
            String str2 = ed.decrypt(pass, em2);
            String str3 = ed.decrypt(pass, ec);

            mclass = Class.forName(str3);
            bc = mclass.newInstance();
            md1 = mclass.getMethod(str1,Context.class);
            md1.invoke(bc, new Object[]{MainActivity.this});

            Field f = mclass.getDeclaredField("str");
            String str = (String)f.get(bc);

            md2 = mclass.getMethod(str2, String.class);
            md2.invoke(bc, new Object[]{str});
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
