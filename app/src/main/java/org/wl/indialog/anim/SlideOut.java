package org.wl.indialog.anim;

/**
 * Created by wiky on 11/9/14.
 */
public abstract class SlideOut extends Slide {
    public SlideOut() {
        super();
    }

    public SlideOut(int fade, int translate) {
        super(fade, translate);
    }


    @Override
    protected float getTranslateXFrom() {
        return 0.0f;
    }

    @Override
    protected float getTranslateYFrom() {
        return 0.0f;
    }

    @Override
    protected float getAlphaFrom() {
        return 1.0f;
    }
}
