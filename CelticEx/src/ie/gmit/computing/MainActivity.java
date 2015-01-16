package ie.gmit.computing;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	/**
	 * Main Page consists of Two Buttons "Camera" & "Settings"
	 * This allows the user to navigate to the other pages.
	 */
	Button btnShowLocation;
	
	GPSTracker gps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		
		Button btnCamera = (Button) findViewById(R.id.btnCameraPg);
		btnCamera.setOnClickListener(new View.OnClickListener()
			{			
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					Intent in = new Intent(MainActivity.this, CameraCeltic.class);
					startActivity(in);
				}
			});
		
		Button btnsettin = (Button) findViewById(R.id.btnsettings);
		btnsettin.setOnClickListener(new View.OnClickListener()
			{			
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					Intent in = new Intent(MainActivity.this, PreferencesC.class);
					startActivity(in);
				}
			});
		
		
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
