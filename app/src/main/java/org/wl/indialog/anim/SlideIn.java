package org.wl.indialog.anim;

/**
 * Created by wiky on 11/9/14.
 */
public abstract class SlideIn extends Slide {
    public SlideIn() {
        super(200, 200);
    }

    public SlideIn(int fade, int translate) {
        super(fade, translate);
    }

    @Override
    protected float getTranslateXTo() {
        return 0.0f;
    }

    @Override
    protected float getTranslateYTo() {
        return 0.0f;
    }

    @Override
    protected float getAlphaTo() {
        return 1.0f;
    }
}
