package com.example.gmcl.Bo.activities;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gmcl.Bo.R;
import com.example.gmcl.Bo.data.Job;
import com.example.gmcl.Bo.service.LocationService;
import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;


import java.util.List;

/**
 * Created by GMCL on 06/10/2015.
 */
public class LoginActivity  extends AppCompatActivity {

    private String email, password;
    private Button login, register;
    ConnectivityManager manager;
    boolean is3G, isWifi;

    final static String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnRegister);

        //--TODO:Create validation checksd for email and password
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RegisterUserActivity.class);
                startActivity(intent);
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                is3G = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                        .isConnectedOrConnecting();
                isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                        .isConnectedOrConnecting();

                if (is3G | isWifi) {
                    email = ((EditText) findViewById(R.id.etEmail)).getText().toString().trim();
                    password = ((EditText) findViewById(R.id.etPassword)).getText().toString().trim();

                    ParseUser user = new ParseUser();
                    user.setPassword(password);
                    user.setUsername(email);

                    //TODO: This shit is like Inception, look into not going deeper
                    //TODO: Use getinbackgground
                    user.logInInBackground(email, password, new LogInCallback() {
                        @Override
                        public void done(ParseUser parseUser, ParseException e) {
                            if (e != null) {
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            } else {

                                final ParseUser currentUser = ParseUser.getCurrentUser();

                                Log.d(TAG, "CHECKPOINT1");


                                if (currentUser != null ){
                                //if (currentUser != null) {
                                    Log.d(TAG, "CHECKPOINT1.5");
                                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Trucker");
                                    Log.d(TAG, currentUser.getObjectId().toString());
                                    query.whereEqualTo("userId", currentUser.getObjectId().toString());
                                    query.whereNotEqualTo("currentJob", "");
                                    //TODO: Check not empty
                                    Log.d(TAG, "CHECKPOINT1.72");
                                    query.findInBackground(new FindCallback<ParseObject>() {

                                        @Override
                                        public void done(List<ParseObject> users, ParseException e) {
                                            Log.d(TAG, "size is " + users.size());
                                            if (e == null && users.size() > 0) {
                                                Log.d(TAG, "CHECKPOINT2");


                                                ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Job"); //TODO: Odds are for calling we'll need JobDetails too. MORE INCEPTION
                                                query2.whereEqualTo("objectId", users.get(0).getString("currentJob"));
                                                query2.findInBackground(new FindCallback<ParseObject>() {

                                                    @Override
                                                    public void done(List<ParseObject> users, ParseException e) {

                                                        if (e == null) {
                                                            Log.d(TAG, "CHECKPOINT3");

                                                            ParseObject currentJob = users.get(0);
                                                            Job job = new Job();
                                                            job.setAssigned(currentJob.getBoolean("assigned"));
                                                            job.setDropoffAddress(currentJob.getString("dropoffAddress"));
                                                            job.setDropoffCity(currentJob.getString("dropoffCity"));
                                                            job.setDropoffCompany(currentJob.getString("dropoffCompany"));
                                                            job.setDropoffCompanyNumber(currentJob.getString("dropoffCountryNumber"));
                                                            job.setDropoffCountry(currentJob.getString("dropoffCountry"));
                                                            job.setDropoffPostalCode(currentJob.getString("dropoffPostalCode"));
                                                            job.setDropoffProvince(currentJob.getString("dropoffProvince"));
                                                            job.setDropoffDate(currentJob.getString("dropoffDate")); //this should be a date?

                                                            Log.d(TAG, "CHECKPOINT4");
                                                            job.setPickupAddress(currentJob.getString("pickupAddress"));
                                                            job.setPickupCity(currentJob.getString("pickupCity"));
                                                            job.setPickupCompany(currentJob.getString("pickupCompany"));
                                                            job.setPickupCompanyNumber(currentJob.getString("pickupCompanyNumber"));
                                                            job.setPickupProvince(currentJob.getString("pickupProvince"));
                                                            job.setPickupPostalCode(currentJob.getString("pickupPostalCode"));
                                                            job.setPickupCountry(currentJob.getString("pickupCountry"));
                                                            job.setPickupDate(currentJob.getString("pickupDate"));
                                                            Log.d(TAG, "CHECKPOINT5");

                                                            job.setObjectId(currentJob.getObjectId());
                                                            job.setQuantity(currentJob.getInt("quantity"));
                                                            job.setSize(currentJob.getString("size"));
                                                            job.setJobId(currentJob.getString("jobId"));
                                                            Log.d(TAG, job.getObjectId());
                                                            job.setWeight(currentJob.getInt("weight"));


                                                            if (ServiceRunningCheck(LocationService.class)) {
                                                                startServiceOnLogIn();
                                                            }

                                                            Bundle bundle = new Bundle();
                                                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                                                    Intent.FLAG_ACTIVITY_NEW_TASK);

                                                            intent.putExtra("currentJob", job);
                                                            startActivity(intent);


                                                        } else {
                                                            Log.d(TAG, "Fail Getting the current Job");
                                                        }
                                                    }
                                                });
                                            } else {
                                                //Errored
                                            }
                                        }
                                    });


                                    //alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, 1000 * 10, 1000 * 10, service.startService());
                                }
                            }
                        }
                    });
                } else {
                    Toast.makeText(getBaseContext(), "No Internet Connection Available", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    private void startServiceOnLogIn() {
        startService(new Intent(this, LocationService.class));
    }

    private boolean ServiceRunningCheck(Class<?> serviceClass){
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {

                return true;
            }
        }
        return false;
    }

}
