package com.luania.qingke.utils.ui.animations;

import android.animation.Animator;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by luania on 16/8/3.
 */
public class CircularRevealCreator {
    public Animator openFromRightTop(View view) {
        return ViewAnimationUtils.createCircularReveal(
                view,
                view.getWidth(),
                0,
                0,
                (float) Math.hypot(view.getWidth(), view.getHeight()));
    }

    public Animator closeToRightTop(View view) {
        return ViewAnimationUtils.createCircularReveal(
                view,
                view.getWidth(),
                0,
                (float) Math.hypot(view.getWidth(), view.getHeight()),
                0);
    }

    public Animator closeToOtherView(View view,View otherView) {
        return ViewAnimationUtils.createCircularReveal(
                view,
                (int) (otherView.getX() + otherView.getWidth() / 2),
                view.getHeight(),
                (float) Math.hypot(otherView.getX() + otherView.getWidth() / 2, view.getHeight()),
                0);
    }

}
