
package lazeez.tech.com.lazeez.control;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.locks.Lock;



public class GlobalVariables extends Application {
	public static boolean installed;
	public static Lock lc = null;



	public static String no_connection= "You don't have internet connection.";








	public static class FINALS{
		public final static String appVersion="1.0";
		public static final int LicenseAgreed=1;
		public final static String dbVersion="1.0";
	}



	public static void hide_keyboard(Activity activity) {
		InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
		//Find the currently focused view, so we can grab the correct window token from it.
		View view = activity.getCurrentFocus();
		//If no view currently has focus, create a news one, just so we can grab a window token from it
		if (view == null) {
			view = new View(activity);
		}
		inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
		//et_leadNumber.setCursorVisible(false);

	}



	public static void set_satusbar(Activity activity, int color) {


		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

			// clear FLAG_TRANSLUCENT_STATUS flag:
			activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

			// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
			activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

			// finally change the color
			activity.getWindow().setStatusBarColor(activity.getResources().getColor(color));



		}
	}

}
