package com.android.soun.common;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class Utility {
    public static Utility utility = new Utility();

    public void rotateAnimation(View view, float fromDegrees, float toDegrees, long durationMillis) {
        Animation animation;
        animation = new RotateAnimation(fromDegrees, toDegrees, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(durationMillis);
        animation.setFillAfter(true);
        view.setAnimation(animation);
    }

    public void flipAnimation(View view, float fromDegrees, float toDegrees, long durationMillis) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(view, "rotationY", fromDegrees, toDegrees);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.setDuration(durationMillis);
        animation.start();
    }

    public void roundedView(final View view, final int color, final int ratio) {
        final int[] height = new int[1];
        ViewTreeObserver vto = view.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height[0] = view.getMeasuredHeight();

                GradientDrawable shape =  new GradientDrawable();
                shape.setCornerRadius(height[0]/ratio);
                shape.setColor(color);

                view.setBackgroundDrawable(shape);
            }
        });
    }
}
