package org.wl.indialog.anim;

/**
 * Created by wiky on 11/11/14.
 */
public class FlipLeftIn extends FlipIn {
    public FlipLeftIn(int d) {
        super(d);
    }

    @Override
    protected FlipDirection getFlipDirection() {
        return FlipDirection.FLIP_HORIZONTAL;
    }

    @Override
    protected float getDegress(float time) {
        return -80 + 80 * time;
    }
}
