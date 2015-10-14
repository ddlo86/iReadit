package com.example.gmcl.Bo.data;

import android.content.Context;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by JamesCrocker on 2015-08-08.
 */
public class jsonObjectSingleton {

    private static jsonObjectSingleton instance= null;
    private RequestQueue mRequestQueue;
    private Context context;

    protected jsonObjectSingleton(Context context){
        this.context = context;
        mRequestQueue = getRequestQueue();

    }

    public static jsonObjectSingleton getInstance(Context context) {
        if(instance == null){
            instance = new jsonObjectSingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue()
    {
        if (mRequestQueue == null)
        {

            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
