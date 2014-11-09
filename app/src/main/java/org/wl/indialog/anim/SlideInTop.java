package org.wl.indialog.anim;

/**
 * Created by wiky on 11/9/14.
 */
public class SlideInTop extends SlideIn {
    public SlideInTop(int fade, int translate) {
        super(fade, translate);
    }

    @Override
    protected float getTranslateXFrom() {
        return 0;
    }

    @Override
    protected float getTranslateYFrom() {
        return -0.25f;
    }

    @Override
    protected float getAlphaFrom() {
        return 0.3f;
    }
}
