package org.wl.indialog.anim;

/**
 * Created by wiky on 11/11/14.
 */
public class FlipRightIn extends Flip {

    public FlipRightIn(int d) {
        super(d);
    }

    @Override
    protected FlipDirection getFlipDirection() {
        return FlipDirection.FLIP_HORIZONTAL;
    }

    @Override
    protected float getDegress(float time) {
        return 90 - 90 * time;
    }
}
