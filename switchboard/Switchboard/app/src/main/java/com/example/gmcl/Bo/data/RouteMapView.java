package com.example.gmcl.Bo.data;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.gmcl.Bo.activities.HomeActivity;
import com.mapbox.mapboxsdk.views.MapView;

/**
 * Created by ddlo86 on 13/10/2015.
 */
public class RouteMapView extends MapView {



    public RouteMapView(Context aContext) {

        super(aContext);
    }

    public RouteMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                //((HomeActivity) getContext().getApplicationContext()).setSwipeable(false);

                break;

            case MotionEvent.ACTION_UP:

                break;
        }

        return super.onTouchEvent(event);
    }


    public interface SwipeListener {

        void onSwipeOn();
        void onSwipeOff();
    }

}
