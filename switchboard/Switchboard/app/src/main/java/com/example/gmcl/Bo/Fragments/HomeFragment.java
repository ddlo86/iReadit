package com.example.gmcl.Bo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gmcl.Bo.R;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by GMCL on 06/10/2015.
 */
public class HomeFragment extends Fragment{

    private static final String TAG = HomeFragment.class.getSimpleName();

    ParseUser user;

    TextView tvPickup, tvPickCompany, tvPickAddress, tvPickCity, tvDestination, tvDestCompany,
            tvDestAddress, tvDestCity, tvRoute, tvDescLoadID, tvLoadID, tvETA, tvDescETA;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        user = ParseUser.getCurrentUser();

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        tvRoute = (TextView) view.findViewById(R.id.tvRoute);

        tvDescETA = (TextView) view.findViewById(R.id.tvDescETA);
        tvDescLoadID = (TextView) view.findViewById(R.id.tvDescLoadID);
        tvETA = (TextView) view.findViewById(R.id.tvETA);
        tvLoadID = (TextView) view.findViewById(R.id.tvLoadID);

        tvPickup = (TextView) view.findViewById(R.id.tvPickup);
        tvPickCompany = (TextView) view.findViewById(R.id.tvPickCompany);
        tvPickAddress = (TextView) view.findViewById(R.id.tvPickAddress);
        tvPickCity = (TextView) view.findViewById(R.id.tvPickCity);


        tvDestAddress = (TextView) view.findViewById(R.id.tvDestAddress);
        tvDestination = (TextView) view.findViewById(R.id.tvDestination);
        tvDestCity = (TextView) view.findViewById(R.id.tvDestCity);
        tvDestCompany = (TextView) view.findViewById(R.id.tvDestCompany);
        displayCurrentJob();



        return view;
    }

    public void displayCurrentJob() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Trucker");
        query.whereEqualTo("userId", user.getObjectId());
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> trucker, ParseException e) {
                if (e == null) {
                    //CHeck for null AND empty

                    String currentJobId = trucker.get(0).getString("currentJob");

                    if(currentJobId.length() < 1) {
                        //TODO: If no current job
                        Log.d(TAG, "No Job Found");
                    } else {
                        Log.d(TAG, "Current Job is: " + currentJobId);
                        ParseQuery<ParseObject> query = ParseQuery.getQuery("Job");
                        query.whereEqualTo("objectId", currentJobId);

                        query.findInBackground(new FindCallback<ParseObject>() {
                            public void done(List<ParseObject> jobs, ParseException e) {
                                if (e == null) {
                                    //TODO: what if more than one?
                                    ParseObject job = jobs.get(0);
                                    tvRoute.setText(job.getString("pickupCity") + "   to  " + job.getString("dropoffCity"));;

                                    tvLoadID.setText(job.getString("jobId"));

                                    //TODO: Needs to be calculated by MapBox
                                    tvETA.setText("Unknown");

                                    String pickupCity = job.getString("pickupCity");
                                    String pickupProvince = job.getString("pickupProvince");
                                    String pickupPostalCode = job.getString("pickupPostalCode");
                                    String pickupCountry = job.getString("pickupCountry");

                                    String pickupLocation = pickupCity + ", " + pickupProvince + ", " + pickupCountry + ", "
                                                            + pickupPostalCode;
                                    tvPickCompany.setText(job.getString("pickupCompany"));
                                    tvPickAddress.setText(job.getString("pickupAddress"));
                                    tvPickCity.setText(pickupLocation);

                                    String dropoffCity = job.getString("dropoffCity");
                                    String dropoffProvince = job.getString("dropoffProvince");
                                    String dropoffPostalCode = job.getString("dropoffPostalCode");
                                    String dropoffCountry = job.getString("dropoffCountry");

                                    String dropoffLocation = dropoffCity + ", " + dropoffProvince + ", " + dropoffCountry + ", "
                                                             + dropoffPostalCode;;

                                    tvDestAddress.setText(job.getString("dropoffAddress"));
                                    tvDestCity.setText(dropoffLocation);
                                    tvDestCompany.setText(job.getString("dropoffCompany"));


                                } else {
                                    Log.d("score", "Job not found");
                                }
                            }
                        });

                    }


                } else {

                    //TODO: Logging and Class util
                    Log.d(TAG, "Parse exception getting trucker", e);
                }
            }
        });
    }

}
