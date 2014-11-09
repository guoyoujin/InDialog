package org.wl.indialog.anim;

/**
 * Created by wiky on 11/9/14.
 */
public class SlideOutTop extends SlideOut {
    public SlideOutTop(int fade, int translate) {
        super(fade, translate);
    }

    @Override
    protected float getTranslateXTo() {
        return 0.0f;
    }

    @Override
    protected float getTranslateYTo() {
        return -0.25f;
    }

    @Override
    protected float getAlphaTo() {
        return 0.3f;
    }
}
