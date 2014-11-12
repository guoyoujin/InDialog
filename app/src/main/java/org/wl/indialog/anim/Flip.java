package org.wl.indialog.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by wiky on 11/11/14.
 */
public abstract class Flip extends Animation {
    protected float mPivotX;
    protected float mPivotY;

    protected int mDuration = 200;

    public Flip() {
        super();
        initialize(mDuration);
    }

    public Flip(int d) {
        super();
        initialize(d);
    }

    private void initialize(int d) {
        setDuration(d);
        setFillAfter(true);
    }

    @Override
    public void applyTransformation(float interploterTime, Transformation t) {
        Matrix matrix = t.getMatrix();

        float degress = getDegress(interploterTime);

        t.setAlpha(getAlpha(interploterTime));

        Camera camera = new Camera();

        camera.save();
        if (getFlipDirection() == FlipDirection.FLIP_HORIZONTAL) {
            camera.rotateY(degress);
        } else {
            camera.rotateX(degress);
        }
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-mPivotX, -mPivotY);
        matrix.postTranslate(mPivotX, mPivotY);
    }

    protected abstract FlipDirection getFlipDirection();

    protected abstract float getDegress(float time);

    protected abstract float getAlpha(float time);

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = resolveSize(Animation.RELATIVE_TO_SELF, 0.5f, width, parentWidth);
        mPivotY = resolveSize(Animation.RELATIVE_TO_SELF, 0.5f, height, parentHeight);
    }

    public enum FlipDirection {
        FLIP_HORIZONTAL,
        FLIP_VERTICAL,
    }
}
