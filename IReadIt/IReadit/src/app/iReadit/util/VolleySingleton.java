package app.iReadit.util;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import android.app.Application;
import android.text.TextUtils;

public class VolleySingleton extends Application {
	
	   public static final String TAG = VolleySingleton.class
	            .getSimpleName();
	 
	    private RequestQueue mRequestQueue;
	 
	    private static VolleySingleton mInstance;
	 
	    @Override
	    public void onCreate() {
	        super.onCreate();
	        mInstance = this;
	    }
	 
	    public static synchronized VolleySingleton getInstance() {
	        return mInstance;
	    }
	 
	    public RequestQueue getRequestQueue() {
	        if (mRequestQueue == null) {
	            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
	        }
	 
	        return mRequestQueue;
	    }
	 
	    public <T> void addToRequestQueue(Request<T> req, String tag) {
	        // set the default tag if tag is empty
	        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
	        getRequestQueue().add(req);
	    }
	 
	    public <T> void addToRequestQueue(Request<T> req) {
	        req.setTag(TAG);
	        getRequestQueue().add(req);
	    }
	 
	    public void cancelPendingRequests(Object tag) {
	        if (mRequestQueue != null) {
	            mRequestQueue.cancelAll(tag);
	        }
	    }
}
