package org.wl.indialog.anim;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

/**
 * Created by wiky on 11/9/14.
 */
public abstract class FadeScale extends AnimationSet {
    protected int mFadeDuration = 150;
    protected int mScaleDuration = 150;

    protected float mScaleFrom;
    protected float mScaleTo;

    protected float mAlphaFrom;
    protected float mAlphaTo;

    public FadeScale() {
        super(true);

        initialize();
    }

    public FadeScale(int fade, int scale) {
        super(true);

        mFadeDuration = fade;
        mScaleDuration = scale;
        initialize();
    }

    protected void initialize() {
        mScaleFrom = getScaleFrom();
        mScaleTo = getScaleTo();
        mAlphaFrom = getAlphaFrom();
        mAlphaTo = getAlphaTo();

        initializeFade();
        initializeScale();
        setFillAfter(true);
    }

    private void initializeFade() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(mAlphaFrom, mAlphaTo);
        alphaAnimation.setDuration(mFadeDuration);
        addAnimation(alphaAnimation);
    }

    private void initializeScale() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(mScaleFrom, mScaleTo, mScaleFrom, mScaleTo,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(mScaleDuration);
        addAnimation(scaleAnimation);
    }

    protected abstract float getScaleFrom();

    protected abstract float getScaleTo();

    protected abstract float getAlphaFrom();

    protected abstract float getAlphaTo();
}
