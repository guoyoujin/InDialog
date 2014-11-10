package org.wl.indialog.anim;

import android.view.animation.DecelerateInterpolator;

/**
 * Created by wiky on 11/9/14.
 */
public class FadeInScale extends FadeScale {

    public FadeInScale() {
        super();
        setInterpolator(new DecelerateInterpolator());
    }

    public FadeInScale(int fade, int scale) {
        super(fade, scale);
        setInterpolator(new DecelerateInterpolator());
    }

    public FadeInScale(int d) {
        super(d);
        setInterpolator(new DecelerateInterpolator());
    }

    @Override
    protected float getScaleFrom() {
        return 0.75f;
    }

    @Override
    protected float getScaleTo() {
        return 1.0f;
    }

    @Override
    protected float getAlphaFrom() {
        return 0.4f;
    }

    @Override
    protected float getAlphaTo() {
        return 1.0f;
    }
}
