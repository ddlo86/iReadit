package com.example.gmcl.Bo.Fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cocoahero.android.geojson.LineString;
import com.cocoahero.android.geojson.Position;
import com.example.gmcl.Bo.R;
import com.example.gmcl.Bo.activities.LoginActivity;
import com.example.gmcl.Bo.data.Job;
import com.example.gmcl.Bo.data.RouteMapView;
import com.example.gmcl.Bo.data.jsonObjectSingleton;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.overlay.PathOverlay;
import com.mapbox.mapboxsdk.views.MapView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JamesCrocker on 2015-08-05.
 */
public class DetailsFragment extends Fragment {

    private MapView mapView;
    private Job job;

    private ParseGeoPoint pickupPoint = null;
    private ParseGeoPoint dropOffPoint = null;
    private ParseGeoPoint currentLocation = null;

    private int remainingDistance;

    private int parseCounter;
    private int pointCounter;
    private boolean hitCurrentAlready;
    private Activity activity;

    private View.OnTouchListener mListener;

    final static String TAG = DetailsFragment.class.getSimpleName();

    public DetailsFragment(){


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {

            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist.  The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // won't be displayed.  Note this is not needed -- we could
            // just run the code below, where we would create and return
            // the view hierarchy; it would just never be used.
            return null;
        }

        Bundle bundle = this.getArguments();
        //TODO: check if null or object comparison fucksup
        job = (Job) bundle.getSerializable("currentJob");


        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        //return (LinearLayout)

        TextView jobId = (TextView) rootView.findViewById(R.id.jobId);
        jobId.setText((String) job.getJobId());

        TextView pickupCity = (TextView) rootView.findViewById(R.id.pickupCity);
        pickupCity.setText((String) job.getPickupCity());

        TextView dropoffCity = (TextView) rootView.findViewById(R.id.dropoffCity);
        dropoffCity.setText((String) job.getDropoffCity());

        TextView eta = (TextView) rootView.findViewById(R.id.eta);
        eta.setText("ETA: 00:00:00");

        if (!rootView.isInEditMode()) {
            mapView = (MapView) rootView.findViewById(R.id.mapview);
            mapView.setOnTouchListener(new View.OnTouchListener() {


                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    switch(event.getAction()) {
                        case MotionEvent.ACTION_DOWN:

                            //((HomeActivity) getContext().getApplicationContext()).setSwipeable(false);
                            ((MapViewSwipeListener) activity ).onSwipeOn();
                            break;

                        case MotionEvent.ACTION_UP:

                            ((MapViewSwipeListener) activity ).onSwipeOff();
                            break;

                        case MotionEvent.ACTION_MOVE:
                            ((MapViewSwipeListener) activity ).onSwipeOn();
                            break;

                        case MotionEvent.ACTION_CANCEL:
                            ((MapViewSwipeListener) activity ).onSwipeOff();
                            break;
                    }
                    return false;
                }

            });
        }
        pointCounter = 0;
        parseCounter = 0;
        hitCurrentAlready = false;

        //TODO: Move these queries over to the TabbedActivity, that way they don't get repeatedly called every time tab changes
        ParseQuery query = ParseQuery.getQuery("PickupGeoPoint");
        query.whereEqualTo("jobObjectId", job.getObjectId());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null  && list.size() > 0) {
                    pickupPoint = (ParseGeoPoint) list.get(0).get("geoPoint");
                    parseCounter ++;
                    if (parseCounter == 3){
                        //setPath(pickupPoint, dropOffPoint);
                        setMap();
                    }
                } else {
                    //Errored
                    Log.d("BO", "Details Tab - Pickup location could not be found");
                    if (hitCurrentAlready) {
                        hitCurrentAlready = false;
                        setMap();
                    }
                }

                pointCounter++;
            }
        });

        ParseQuery query2 = ParseQuery.getQuery("DropoffGeoPoint");
        query2.whereEqualTo("jobObjectId", job.getObjectId());
        query2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null  && list.size() > 0) {
                    dropOffPoint = (ParseGeoPoint) list.get(0).get("geoPoint");
                    parseCounter++;
                    if (parseCounter == 3) {
                        //setPath(pickupPoint, dropOffPoint);
                        setMap();
                    }
                } else {
                    //Errored
                    Log.d("BO", "Details Tab - Dropoff location could not be found");
                    if (hitCurrentAlready) {
                        hitCurrentAlready = false;
                        setMap();
                    }
                }

                pointCounter++;
            }
        });

        ParseUser currentUser = ParseUser.getCurrentUser();
        ParseQuery query3 = ParseQuery.getQuery("Trucker");
        query3.whereEqualTo("userId", currentUser.getObjectId());
        query3.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null  && list.size() > 0) {
                    currentLocation = (ParseGeoPoint) list.get(0).get("location");
                    parseCounter ++;
                    if (parseCounter == 3 || pointCounter == 2){
                        //setPath(pickupPoint, dropOffPoint);
                        setMap();
                    }
                } else {
                  //Errored
                    Log.d("BO", "Details Tab - Dropoff location could not be found");
                }

                hitCurrentAlready = true;
            }
        });

        return rootView;
    }

    public interface MapViewSwipeListener {

        void onSwipeOn();
        void onSwipeOff();
    }


    public void setListener(View.OnTouchListener listener) {
        mListener = listener;
    }
//    public interface OnTouchListener {
//        public abstract void onTouch();
//    }


    public class TouchableWrapper extends FrameLayout {

        public TouchableWrapper(Context context) {
            super(context);
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mListener.onTouch(getView(), event);
                    break;
                case MotionEvent.ACTION_UP:
                    mListener.onTouch(getView(), event);
                    break;
            }
            return super.dispatchTouchEvent(event);

        }
    }

    private void setMap(){

        if (pickupPoint != null){
            Marker marker1 = new Marker(mapView, "Pickup", job.getPickupAddress() + ", " + job.getPickupCity(), new LatLng(pickupPoint.getLatitude(), pickupPoint.getLongitude()));
            mapView.addMarker(marker1);
        }

        if(dropOffPoint != null) {
            Marker marker2 = new Marker(mapView, "DropOff", job.getDropoffAddress() + ", " + job.getDropoffCity(), new LatLng(dropOffPoint.getLatitude(), dropOffPoint.getLongitude()));
            mapView.addMarker(marker2);
        }

        if (currentLocation != null){
            Marker marker3 = new Marker(mapView, "You", "", new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()));
            mapView.addMarker(marker3);
        }

        mapView.setCenter(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()));

        double bottomPadding = 0.002;
        double topPadding = 0.005;
        double sidePadding = 5;

        List<ParseGeoPoint> list = new ArrayList<>();
        if (pickupPoint != null) list.add(pickupPoint);
        if (dropOffPoint != null) list.add(dropOffPoint);
        if (currentLocation != null) list.add(currentLocation);


        BoundingBox box = new BoundingBox(findTopMost(list) + topPadding,
                findRightMost(list) + sidePadding,
                findBottomMost(list) - bottomPadding,
                findLeftMost(list) - sidePadding);

        mapView.zoomToBoundingBox(box, true, true);
        mapView.invalidate();

        setPath(currentLocation, dropOffPoint);

    }

    private double findTopMost(List<ParseGeoPoint> array){
        double topLat = array.get(0).getLatitude();
        for (int i = 1; i < array.size(); i ++){
            if (array.get(i).getLatitude() > topLat){
                topLat = array.get(i).getLatitude();
            }
        }
        return topLat;
    }

    private double findBottomMost(List<ParseGeoPoint> array){
        double bottomLat = array.get(0).getLatitude();
        for (int i = 1; i < array.size(); i ++){
            if (array.get(i).getLatitude() < bottomLat){
                bottomLat = array.get(i).getLatitude();
            }
        }
        return bottomLat;
    }

    private double findRightMost(List<ParseGeoPoint> array){
        double rightLat = array.get(0).getLongitude();
        for (int i = 1; i < array.size(); i ++){
            if (array.get(i).getLongitude() > rightLat){
                rightLat = array.get(i).getLongitude();
            }
        }
        return rightLat;
    }

    private double findLeftMost(List<ParseGeoPoint> array){
        double leftLat = array.get(0).getLongitude();
        for (int i = 1; i < array.size(); i ++){
            if (array.get(i).getLongitude() < leftLat){
                leftLat = array.get(i).getLongitude();
            }
        }
        return leftLat;
    }


    private void setPath(ParseGeoPoint a, ParseGeoPoint b){

        if (a != null && b != null){
            String url = "https://api.mapbox.com/v4/directions/mapbox.driving/";
            String profile1 = String.valueOf(Math.round(a.getLongitude() * 100.0) / 100.0) + "," + String.valueOf(Math.round(a.getLatitude() * 100.0) / 100.0);
            String profile2 = String.valueOf(Math.round(b.getLongitude() * 100.0) / 100.0) + "," + String.valueOf(Math.round(b.getLatitude() * 100.0) / 100.0);
            url += profile1 + ";" + profile2 + ".json?access_token=" +  "pk.eyJ1IjoiaW9wMjgwIiwiYSI6IjhjNmRjODdlMmVlNjhkMGE4MmM1OThkZWRhZjA5MGYxIn0.4f--rrX1DX1hem3JmC3Ljw";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject jsonObject) {
                    PathOverlay line = new PathOverlay(Color.RED, 3);
                    JSONArray routes = new JSONArray();
                    JSONObject geometry = new JSONObject();
                    int duration = 0;
                    //JSONArray coordinates = new JSONArray();
                    LineString coordinateLine = new LineString();
                    try {
                        routes = jsonObject.getJSONArray("routes");
                        geometry = ((JSONObject) routes.get(0)).getJSONObject("geometry");
                        //coordinates = geometry.getJSONArray("coordinates");
                        remainingDistance = ((JSONObject) routes.get(0)).getInt("distance");

                        duration = ((JSONObject) routes.get(0)).getInt("duration");
                        Log.d(TAG, String.valueOf(duration));
                        int hours =  duration / 3600;
                        int min = (duration % 3600) / 60;
                        int sec = duration % 60;

                        Log.d(TAG, String.valueOf(hours));
                        Log.d(TAG, String.valueOf(min));
                        Log.d(TAG, String.valueOf(sec));

                        try {
                            TextView eta = (TextView) getView().findViewById(R.id.eta);
                            eta.setText("ETA: " + String.format("%02d", hours) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec));
                        } catch (NullPointerException e){
                            Log.d("BO", "DetailsTab - NUll pointer exception on ETA");
                        }


                        coordinateLine = new LineString(geometry);
                        List<Position> positions = coordinateLine.getPositions();
                        List<LatLng> latlngs = new ArrayList<>();
                        for (int i = 0; i < positions.size(); i += 1){
                            Position pos = positions.get(i);
                            LatLng newll = new LatLng(pos.getLatitude(), pos.getLongitude());
                            latlngs.add(newll);
                        }
                        line.addPoints(latlngs);

                        mapView.getOverlays().add(line);
                        mapView.invalidate();
                    }catch (JSONException e){
                        Log.d("BO", "DetailsTab - No routes array found");
                    }

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            jsonObjectSingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);
        }

        setProgressBar(pickupPoint, dropOffPoint);

    }


    private void setProgressBar(ParseGeoPoint a, ParseGeoPoint b){

        if (a != null && b != null){
            String url = "https://api.mapbox.com/v4/directions/mapbox.driving/";
            final String profile1 = String.valueOf(Math.round(a.getLongitude() * 100.0) / 100.0) + "," + String.valueOf(Math.round(a.getLatitude() * 100.0) / 100.0);
            String profile2 = String.valueOf(Math.round(b.getLongitude() * 100.0) / 100.0) + "," + String.valueOf(Math.round(b.getLatitude() * 100.0) / 100.0);
            url += profile1 + ";" + profile2 + ".json?access_token=" +  "pk.eyJ1IjoiaW9wMjgwIiwiYSI6IjhjNmRjODdlMmVlNjhkMGE4MmM1OThkZWRhZjA5MGYxIn0.4f--rrX1DX1hem3JmC3Ljw";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject jsonObject) {
                    JSONArray routes = new JSONArray();

                    try {
                        routes = jsonObject.getJSONArray("routes");
                        int totalDistance = ((JSONObject) routes.get(0)).getInt("distance");

                        try {
                            ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
                            progressBar.setIndeterminate(false);
                            progressBar.setMax(100);
                            progressBar.setProgress((100 * (1 - remainingDistance / totalDistance)) % 101);

                        } catch (NullPointerException e){
                            Log.d("BO", "DetailsTab - NUll pointer exception on progressbar");
                        }

                    }catch (JSONException e){
                        Log.d("BO", "DetailsTab - No 2nd routes array found");
                    }

                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            jsonObjectSingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);
        }
        else {
            ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
            progressBar.setIndeterminate(false);
            progressBar.setMax(100);
            progressBar.setProgress(100);
        }

    }
}
