//package com.example.gmcl.Bo.data;
//
//import android.util.Log;
//
//import com.parse.FindCallback;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//import com.parse.ParseUser;
//
//import java.util.List;
//
///**
// * Created by GMCL on 08/10/2015.
// */
//public class MyCustomObject implements MyCustomObjectListener {
////TODO: Failed (?) attempt at callback Listener. Maybe keep this?
//
//    @Override
//    public void onDataLoaded(String data) {
//
//    }
//
//    private MyCustomObjectListener listener;
//
//    public void setCustomObjectListener(MyCustomObjectListener listener) {
//        this.listener = listener;
//    }
//
//    public MyCustomObject(String JobID) {
//        // set null or default listener or accept as argument to constructor
//        this.listener = null;
//        getJobID(JobID);
//    }
//
//    public void getJobID(String userID) {
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Trucker");
//        query.whereEqualTo("userId", userID);
//
//        query.findInBackground(new FindCallback<ParseObject>() {
//                                   @Override
//                                   public void done(List<ParseObject> trucker, ParseException e) {
//                                       if (e == null) {
//                                           //CHeck for null AND empty
//                                           String currentJobId = trucker.get(0).getString("currentJob");
//
//                                           if (currentJobId.length() < 1) {
//                                               //TODO: If no current job
//                                               Log.d("MyCustomObject", "No Job Found");
//                                           } else {
//                                               Log.d("MyCustomObject", "Current Job is: " + currentJobId);
//                                               ParseQuery<ParseObject> query = ParseQuery.getQuery("Job");
//                                               query.whereEqualTo("objectId", currentJobId);
//
//                                               query.findInBackground(new FindCallback<ParseObject>() {
//                                                   public void done(List<ParseObject> jobs, ParseException e) {
//                                                       if (e == null) {
//                                                           //TODO: what if more than one?
//                                                           ParseObject job = jobs.get(0);
//
//                                                           if (listener != null) {
//
//                                                               //listener.onDataLoaded("I'M MEESEEKS!!! 1234124124");
//                                                               Log.d("Nachos", job.getString("dropoffCity"));
//                                                               Log.d("Nachos", job.getObjectId());
//                                                               listener.onDataLoaded(job.getObjectId());
//                                                         }
//                                                       } else {
//                                                           Log.d("score", "Job not found");
//                                                       }
//                                                   }
//                                               });
//                                           }
//                                       } else {
//
//                                           //TODO: Logging and Class util
//                                           Log.d("MyCustomObject", "Parse exception getting trucker", e);
//                                       }
//                                   }
//
//
//                               }
//        );
//    }
//
//}
