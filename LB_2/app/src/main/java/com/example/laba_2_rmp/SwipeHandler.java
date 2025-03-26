package com.example.laba_2_rmp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipeHandler implements View.OnTouchListener {

    private final GestureDetector gestureDetector;
    private final Activity currentActivity;
    private final Class<?> leftActivityClass;
    private final Class<?> rightActivityClass;

    public SwipeHandler(Activity activity, Class<?> leftClass, Class<?> rightClass) {
        this.currentActivity = activity;
        this.leftActivityClass = leftClass;
        this.rightActivityClass = rightClass;
        gestureDetector = new GestureDetector(activity, new GestureListener());
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();

            if (Math.abs(diffX) > Math.abs(diffY) &&
                    Math.abs(diffX) > SWIPE_THRESHOLD &&
                    Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {

                if (diffX < 0) {
                    // -->
                    Intent intent = new Intent(currentActivity, rightActivityClass);
                    currentActivity.startActivity(intent);
                    currentActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                } else {
                    // <--
                    Intent intent = new Intent(currentActivity, leftActivityClass);
                    currentActivity.startActivity(intent);
                    currentActivity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                return true;
            }
            return false;
        }
    }
}