package com.listview.gps1;

import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES=1;
    private static final long MINIMUM_TIME_BETWEEN_UPDATES=1000;

    protected LocationManager locationManager;
    protected Button retriveLocationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retriveLocationButton=(Button)findViewById(R.id.btn1);
        locationManager=(LocationManager)getSystemService(context.LOCATION.SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MINIMUM_TIME_BETWEEN_UPDATES,MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,new MyLocatioListener()
        );
        retriveLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCurrentLocation();
            }
        });
    }
    protected void showCurrentLocation(){
        LocationManager=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        String message=String.format("CurrentLocation\n Longitude:%1$s\n Latitude: %2$s ",location.getLongitude(),location.getLatitude()
        );
        Toast.makeText(MainActivity.this,"mesage",Toast.LENGTH_LONG).show();
    }
    private Class MyLocationListener implements LocationListener{
     public void onLocationChanged
    }
}
//private Class MyLocationListener implements LocationListener{
//
//        }
