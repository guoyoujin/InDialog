package org.wl.indialog.anim;

/**
 * Created by wiky on 11/10/14.
 */
public class NewspaperOut extends Newspaper {
    public NewspaperOut(int duration) {
        super(duration);
    }

    public NewspaperOut(int scale, int rotate) {
        super(scale, rotate);
    }

    @Override
    protected float getScaleFrom() {
        return 1.0f;
    }

    @Override
    protected float getScaleTo() {
        return 0.3f;
    }

    @Override
    protected int getRotationFrom() {
        return 720;
    }

    @Override
    protected int getRotationTo() {
        return 0;
    }
}
