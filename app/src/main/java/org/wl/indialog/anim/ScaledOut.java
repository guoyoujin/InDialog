package org.wl.indialog.anim;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by wiky on 11/12/14.
 */
public class ScaledOut extends Animation {
    private float mPivotX;
    private float mPivotY;

    private float mMaxScale = 3.0f;

    private int mDuration = 200;

    public ScaledOut() {
        super();

        initialize(mDuration);
    }

    public ScaledOut(int d) {
        super();

        initialize(d);
    }

    private void initialize(int d) {
        setDuration(d);
    }

    @Override
    public void applyTransformation(float interploterTime, Transformation t) {
        Matrix matrix = t.getMatrix();

        float scaled = 1.0f + interploterTime * (mMaxScale - 1.0f);
        matrix.setScale(scaled, scaled);

        t.setAlpha(1 - interploterTime * interploterTime);

        matrix.preTranslate(-mPivotX, -mPivotY);
        matrix.postTranslate(mPivotX, mPivotY);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mPivotX = resolveSize(Animation.RELATIVE_TO_SELF, 0.5f, width, parentWidth);
        mPivotY = resolveSize(Animation.RELATIVE_TO_SELF, 0.5f, height, parentHeight);
    }
}
