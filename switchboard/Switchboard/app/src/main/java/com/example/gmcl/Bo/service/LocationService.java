package com.example.gmcl.Bo.service;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by JamesCrocker on 2015-08-03.
 */
public class LocationService extends Service {

    public static final String BROADCAST_ACTION = "TruckerTracking";
    //TODO: Change these to more appropriate rates
    private static final int MIN_TIME = 1000 * 5; //5_SECONDS
    private static final int MIN_DISTANCE = 0; //METRES
    private boolean serviceOn;
    public BoLocationListener listener;

    Intent intent;

    @Override
    public void onCreate() {
        super.onCreate();
        intent = new Intent(BROADCAST_ACTION);
    }

    @Override
    public int onStartCommand(Intent intent, int flag, int startId){
        serviceOn = true;
        Log.d("BO", "GPS Starting");

        listener = new BoLocationListener();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        PackageManager pm = getApplicationContext().getPackageManager();
        int hasPermission = pm.checkPermission(
                Manifest.permission.ACCESS_FINE_LOCATION,
                getApplicationContext().getPackageName()
        );

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, listener);

        if(hasPermission != PackageManager.PERMISSION_GRANTED) {
            return START_STICKY;
        }
            return 0;

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d("BO", "Done Logging");
        serviceOn = false;
        super.onDestroy();
    }

    public class BoLocationListener implements LocationListener{

        public void onLocationChanged(final Location loc){
            if (serviceOn){
                Log.d("BO", "GPS Coordinates: " + loc.getLatitude() + " " + loc.getLongitude());

                ParseUser currentUser = ParseUser.getCurrentUser();

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Trucker");
                query.whereEqualTo("userId", currentUser.getObjectId());
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, com.parse.ParseException e) {
                        if (e == null && list.size() > 0) {
                            ParseObject trucker = list.get(0);
                            trucker.put("location", new ParseGeoPoint(loc.getLatitude(), loc.getLongitude()));
                            trucker.saveInBackground();
                        } else {
                            //Errored
                            Log.d("BO", "LocationService - Unable to Save Trucker Location");
                        }
                    }
                });
            }
        }

        public void onStatusChanged(String provider, int status, Bundle extras){

        }

        public void onProviderEnabled(String provider){
            Log.d("BO", "GPS Enabled");

        }

        public void onProviderDisabled(String provider){
            Log.d("BO", "GPS Disabled");
        }

    }

}
