package ie.gmit.computing;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toast;

public class CameraCeltic extends Activity {
	
	/**
	 * GPS Location Tracking the longitude and latitude
	 */
	private ImageView imgFavorite;
	private static final float LOCATION_REFRESH_DISTANCE = 0;
	private static final long LOCATION_REFRESH_TIME = 0;
	
	 private final LocationListener mLocationListener = new LocationListener() {
	        @Override
	        public void onLocationChanged(final Location location) {
	            //your code here
	        }

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
	    };

	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_camera_celtic);
	      imgFavorite = (ImageView)findViewById(R.id.imageView1);
	      imgFavorite.setOnClickListener(new OnClickListener() 
	      {
	         @Override
	         public void onClick(View v) {
	            open();
	         }
	      });
	      
	      Button btnTree = (Button) findViewById(R.id.nextTree);
	      btnTree.setOnClickListener(new View.OnClickListener()
			{			
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					Intent in = new Intent(CameraCeltic.this, DynamicTree.class);
					startActivity(in);
				}
			});
	      
	      LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

	      mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME,
	              LOCATION_REFRESH_DISTANCE, mLocationListener);
	      
	      GPSTracker mGPS = new GPSTracker(this);

	      TextView text = (TextView) findViewById(R.id.texts);
	      if(mGPS.canGetLocation ){
	      mGPS.getLocation();
	      text.setText("Lat"+mGPS.getLatitude()+"Lon"+mGPS.getLongitude());
	      }else{
	          text.setText("Unabletofind");
	          System.out.println("Unable");
	      }


	      
	      //LocationManager myLocationMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	     // LocationListener myLocationLis = new MyLocationListener();
	      //myLocationMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocationLis);
	   }
	   public void open(){
	      Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	      startActivityForResult(intent, 0);
	   }

	   @Override
	   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	      // TODO Auto-generated method stub
	      super.onActivityResult(requestCode, resultCode, data);
	      Bitmap bp = (Bitmap) data.getExtras().get("data");
	      imgFavorite.setImageBitmap(bp);
	   }
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
	      // Inflate the menu; this adds items to the action bar if it is present.
		   getMenuInflater().inflate(R.menu.camera_celtic, menu);
		   return true;
	   }
	   
	   
	   
	   
}
	
	   /*public class MyLocationListener implements LocationListener
	   {

		@Override
		public void onLocationChanged(Location location) {
			location.getLatitude();
			location.getLongitude();
			String text = "My Location" + "Latitude = " + location.getLatitude() + "Longitude = " + location.getLongitude();
			Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			Toast.makeText( getApplicationContext(), "GPS Enabled", Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			Toast.makeText( getApplicationContext(), "GPS Disabled", Toast.LENGTH_SHORT).show();
		}
		   
	   }
	}*/
