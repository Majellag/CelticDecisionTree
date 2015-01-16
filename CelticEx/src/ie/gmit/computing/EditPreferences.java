package ie.gmit.computing;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class EditPreferences extends PreferenceActivity{
	
	/**
	 * Notice that instead of the traditional setContentView(),
	 *  I used here addPreferencesFromResource() method.
	 *  This inflates my prefs.xml file and uses it as the Activity’s current layout.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference_setting);
	}



}
