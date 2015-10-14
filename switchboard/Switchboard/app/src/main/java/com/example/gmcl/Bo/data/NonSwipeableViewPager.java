package com.example.gmcl.Bo.data;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by ddlo86 on 13/10/2015.
 */
public class NonSwipeableViewPager extends ViewPager {

    private boolean swipeable = true;

    public NonSwipeableViewPager(Context context) {
        super(context);
    }

    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSwipeable(boolean swipeable) {
        this.swipeable = swipeable;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        return (this.swipeable) ? super.onInterceptTouchEvent(event) : false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return (this.swipeable) ? super.onTouchEvent(event) : false;
    }
}
