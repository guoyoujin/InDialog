package org.wl.indialog.anim;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/**
 * Created by wiky on 11/9/14.
 */
public abstract class Slide extends AnimationSet {

    private int mFadeDuration = 200;
    private int mTranslateDuration = 200;

    private float mTranslateXFrom;
    private float mTranslateXTo;
    private float mTranslateYFrom;
    private float mTranslateYTo;
    private float mAlphaFrom;
    private float mAlphaTo;

    public Slide() {
        super(true);

        initialize();
    }

    public Slide(int fade, int translate) {
        super(true);
        mFadeDuration = fade;
        mTranslateDuration = translate;

        initialize();
    }

    private void initialize() {
        mTranslateXFrom = getTranslateXFrom();
        mTranslateXTo = getTranslateXTo();
        mTranslateYFrom = getTranslateYFrom();
        mTranslateYTo = getTranslateYTo();
        mAlphaFrom = getAlphaFrom();
        mAlphaTo = getAlphaTo();

        initializeTranslate();
        initializeFade();
        setFillAfter(true);
    }

    private void initializeTranslate() {
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, mTranslateXFrom,
                Animation.RELATIVE_TO_SELF, mTranslateXTo,
                Animation.RELATIVE_TO_SELF, mTranslateYFrom,
                Animation.RELATIVE_TO_SELF, mTranslateYTo);
        translateAnimation.setDuration(mTranslateDuration);
        addAnimation(translateAnimation);
    }

    private void initializeFade() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(mAlphaFrom, mAlphaTo);
        alphaAnimation.setDuration(mFadeDuration);
        addAnimation(alphaAnimation);
    }

    protected abstract float getTranslateXFrom();

    protected abstract float getTranslateXTo();

    protected abstract float getTranslateYFrom();

    protected abstract float getTranslateYTo();

    protected abstract float getAlphaFrom();

    protected abstract float getAlphaTo();
}
