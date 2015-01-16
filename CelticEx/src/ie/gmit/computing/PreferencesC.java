package ie.gmit.computing;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PreferencesC extends Activity{
	TextView textView;
	
	/**
	 * Here I attached 2 listeners for each button and display 
	 * the values retrieved from  SharedPreferences in a TextView.
	 */
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.identify_pref);
	 
	   Button btnPrefs = (Button) findViewById(R.id.btnPrefs);
	   Button btnGetPrefs = (Button) findViewById(R.id.btnGetPreferences);
	 
	   textView = (TextView) findViewById(R.id.txtPrefs);
	 
	   View.OnClickListener listener = new View.OnClickListener() {
	 
	   @Override
	   public void onClick(View v) {
	   switch (v.getId()) {
	   case R.id.btnPrefs:
	      Intent intent = new Intent(PreferencesC.this,
	      EditPreferences.class);
	      startActivity(intent);
	      break;
	 
	   case R.id.btnGetPreferences:
	      displaySharedPreferences();
	      break;
	 
	   default:
	     break;
	   }
	   }
	   };
	 
	   btnPrefs.setOnClickListener(listener);
	   btnGetPrefs.setOnClickListener(listener);
	}
	 
	private void displaySharedPreferences() {
	   SharedPreferences prefs = PreferenceManager
	    .getDefaultSharedPreferences(PreferencesC.this);
	 
	   String scientist = prefs.getString("scientist", "Default Scientist");
	   String ship = prefs.getString("ship", "Default Ship");
	   String email = prefs.getString("email", "Default Email");
	   
	 
	   StringBuilder builder = new StringBuilder();
	   builder.append("Scientist Name: " + scientist + "\n");
	   builder.append("Ship Name: " + ship + "\n");
	   builder.append("Email Address: " + email + "\n");
	   //builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
	   //builder.append("List preference: " + listPrefs);
	 
	   textView.setText(builder.toString());
	}
}


