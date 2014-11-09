package org.wl.indialog;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import org.wl.indialog.anim.FadeInScale;
import org.wl.indialog.anim.FadeOutScale;
import org.wl.indialog.anim.SlideInBottom;
import org.wl.indialog.anim.SlideInLeft;
import org.wl.indialog.anim.SlideInRight;
import org.wl.indialog.anim.SlideInTop;
import org.wl.indialog.anim.SlideOutBottom;
import org.wl.indialog.anim.SlideOutLeft;
import org.wl.indialog.anim.SlideOutRight;
import org.wl.indialog.anim.SlideOutTop;

/**
 * Created by wiky on 11/9/14.
 */
public class InEmptyDialog extends InBaseDialog {
    public enum SlideType {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        BOTTOM_TO_TOP,
        TOP_TO_BOTTOM,
        FADE_IN_OUT,
    }

    private SlideType slideType = SlideType.LEFT_TO_RIGHT;

    protected InEmptyDialog(Activity ac) {
        super(ac);
    }

    public InEmptyDialog setSlideType(SlideType type) {
        slideType = type;
        return this;
    }

    public static InEmptyDialog build(Activity activity) {
        InEmptyDialog emptyDialog = new InEmptyDialog(activity);

        return emptyDialog;
    }

    @Override
    protected void initDialogContent(FrameLayout parent) {
        float density = getResources().getDisplayMetrics().density;

        View v = new View(mActivity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int) (300 * density), (int) (200 * density));
        v.setLayoutParams(params);

        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setColor(Color.WHITE);
        bg.setCornerRadius(20);
        v.setBackgroundDrawable(bg);

        parent.addView(v);
    }

    @Override
    public Animation getShowAnimation() {
        switch (slideType) {
            case LEFT_TO_RIGHT:
                return new SlideInLeft(200, 200);
            case RIGHT_TO_LEFT:
                return new SlideInRight(200, 200);
            case TOP_TO_BOTTOM:
                return new SlideInTop(200, 200);
            case BOTTOM_TO_TOP:
                return new SlideInBottom(200, 200);
            case FADE_IN_OUT:
                return new FadeInScale(150, 150);
        }
        return new SlideInLeft(200, 200);
    }

    @Override
    public Animation getDismissAnimation() {
        switch (slideType) {
            case LEFT_TO_RIGHT:
                return new SlideOutRight(200, 200);
            case RIGHT_TO_LEFT:
                return new SlideOutLeft(200, 200);
            case TOP_TO_BOTTOM:
                return new SlideOutBottom(200, 200);
            case BOTTOM_TO_TOP:
                return new SlideOutTop(200, 200);
            case FADE_IN_OUT:
                return new FadeOutScale(150, 150);
        }
        return new SlideOutRight(200, 200);
    }

    @Override
    public Animation getBackgroundShowAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200);
        return alphaAnimation;
    }

    @Override
    public Animation getBackgroundDismissAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }
}
