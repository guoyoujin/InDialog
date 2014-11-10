package org.wl.indialog.anim;

/**
 * Created by wiky on 11/10/14.
 */
public class NewspaperIn extends Newspaper {
    public NewspaperIn(int duration) {
        super(duration);
    }

    @Override
    protected float getScaleFrom() {
        return 0.3f;
    }

    @Override
    protected float getScaleTo() {
        return 1.0f;
    }

    @Override
    protected int getRotationFrom() {
        return -180;
    }

    @Override
    protected int getRotationTo() {
        return 720;
    }
}
