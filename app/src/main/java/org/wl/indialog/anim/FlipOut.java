package org.wl.indialog.anim;

/**
 * Created by wiky on 11/12/14.
 */
public abstract class FlipOut extends Flip {
    public FlipOut(int d) {
        super(d);
    }

    @Override
    protected float getAlpha(float time) {
        return 1.0f - time;
    }
}
