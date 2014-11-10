package org.wl.indialog.anim;

import android.view.animation.AccelerateInterpolator;

/**
 * Created by wiky on 11/9/14.
 */
public class FadeOutScale extends FadeScale {

    public FadeOutScale() {
        super();
        setInterpolator(new AccelerateInterpolator());
    }

    public FadeOutScale(int fade, int scale) {
        super(fade, scale);
        setInterpolator(new AccelerateInterpolator());
    }

    public FadeOutScale(int d) {
        super(d);
        setInterpolator(new AccelerateInterpolator());
    }

    @Override
    protected float getScaleFrom() {
        return 1.0f;
    }

    @Override
    protected float getScaleTo() {
        return 0.75f;
    }

    @Override
    protected float getAlphaFrom() {
        return 1.0f;
    }

    @Override
    protected float getAlphaTo() {
        return 0.4f;
    }
}
