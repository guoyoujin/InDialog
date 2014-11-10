package org.wl.indialog.anim;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

/**
 * Created by wiky on 11/10/14.
 */
public abstract class Newspaper extends AnimationSet {
    protected int mScaleDuration = 200;
    protected int mRotateDuration = 200;

    public Newspaper() {
        super(true);
        initialize();
    }

    public Newspaper(int duration) {
        super(true);
        mScaleDuration = duration;
        mRotateDuration = duration;
        initialize();
    }

    public Newspaper(int scale, int rotation) {
        super(true);
        mScaleDuration = scale;
        mRotateDuration = rotation;
        initialize();
    }

    private void initialize() {
        initializeRotation();
        initializeScale();
    }

    private void initializeRotation() {
        RotateAnimation rotateAnimation = new RotateAnimation(getRotationFrom(), getRotationTo(),
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(mRotateDuration);
        addAnimation(rotateAnimation);
    }

    private void initializeScale() {
        float from = getScaleFrom();
        float to = getScaleTo();
        ScaleAnimation scaleAnimation = new ScaleAnimation(from, to, from, to,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(mScaleDuration);
        addAnimation(scaleAnimation);
    }

    protected abstract float getScaleFrom();

    protected abstract float getScaleTo();

    protected abstract int getRotationFrom();

    protected abstract int getRotationTo();
}
