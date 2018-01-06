package lazeez.tech.com.lazeez.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.concurrent.locks.ReentrantLock;

import lazeez.tech.com.lazeez.R;
import lazeez.tech.com.lazeez.control.ConnectionDetector;
import lazeez.tech.com.lazeez.control.GlobalVariables;


public class Splash_screen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 8000;
    public static  SharedPreferences prefs = null;
    ConnectionDetector cd;
    Boolean isInternetPresent ;
    public static String name;
    public static String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        GlobalVariables.set_satusbar(Splash_screen.this, R.color.status);




        GlobalVariables.lc =  new ReentrantLock();


        prefs = getSharedPreferences("lazeez", MODE_PRIVATE);
        GlobalVariables.installed = prefs.getBoolean("firstrun", true);



        cd = new ConnectionDetector(getApplicationContext());

        isInternetPresent = cd.isConnectingToInternet();

        if (isInternetPresent) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (GlobalVariables.installed == true) {
                        Intent i = new Intent(Splash_screen.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else {


//                        GlobalVariables.FullName = Splash_screen.prefs.getString("FullName","");
//                        GlobalVariables.password = Splash_screen.prefs.getString("Password","");
//                        GlobalVariables.username = Splash_screen.prefs.getString("UserName","");
//                        GlobalVariables.token = Splash_screen.prefs.getString("DeviceToken","");
//                        GlobalVariables.facebook = Splash_screen.prefs.getString("Facebook","");
//                        GlobalVariables.Mobile = Splash_screen.prefs.getString("Mobile","");
//                        GlobalVariables.Gender = Splash_screen.prefs.getString("Gender","");
//                        GlobalVariables.BirthDate = Splash_screen.prefs.getString("BirthDate","");
//                        GlobalVariables.email = Splash_screen.prefs.getString("Email","");
//                        GlobalVariables.id = Splash_screen.prefs.getString("Id","");
                        Intent i = new Intent(Splash_screen.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            }, SPLASH_DISPLAY_LENGHT);
        }
        else {
            if (GlobalVariables.installed == true) {
                Toast.makeText(Splash_screen.this, GlobalVariables.no_connection, Toast.LENGTH_LONG).show();
            }

        }
    }
}
