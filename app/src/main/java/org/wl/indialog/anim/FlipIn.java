package org.wl.indialog.anim;

/**
 * Created by wiky on 11/12/14.
 */
public abstract class FlipIn extends Flip {
    public FlipIn(int d) {
        super(d);
    }

    @Override
    protected float getAlpha(float time) {
        return time;
    }
}
