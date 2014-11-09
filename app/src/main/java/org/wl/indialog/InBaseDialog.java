package org.wl.indialog;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;

/**
 * Created by wiky on 11/9/14.
 */
public abstract class InBaseDialog extends FrameLayout {

    protected int mBackgroundColor = Color.parseColor("#99999999");
    protected Activity mActivity;

    protected FrameLayout mDialog;

    protected InBaseDialog(Activity ac) {
        super(ac);

        mActivity = ac;
        initializeBaseView();
        initializeTouch();

        setVisibility(GONE);
    }

    private void initializeBaseView() {
        float density = mActivity.getResources().getDisplayMetrics().density;

        ViewGroup.LayoutParams rootParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(rootParams);
        setBackgroundColor(mBackgroundColor);

        mDialog = new FrameLayout(mActivity);
        FrameLayout.LayoutParams dialogParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogParams.topMargin = (int) (160 * density);
        dialogParams.gravity = Gravity.CENTER_HORIZONTAL;
        mDialog.setLayoutParams(dialogParams);
        addView(mDialog);

        initDialogContent(mDialog);
    }

    private void clearAnimations() {
        mDialog.clearAnimation();
        clearAnimation();
    }

    public void show() {
        clearAnimations();
        FrameLayout activityContent = (FrameLayout) mActivity.findViewById(android.R.id.content);
        activityContent.addView(this);

        setVisibility(VISIBLE);
        Animation showAnimation = getShowAnimation();
        if (showAnimation != null) {
            mDialog.startAnimation(showAnimation);
        }
        Animation backgroundShowAnimation = getBackgroundShowAnimation();
        if (backgroundShowAnimation != null) {
            startAnimation(backgroundShowAnimation);
        }
    }

    public void dismiss() {
        clearAnimations();
        Animation dismissAnimation = getDismissAnimation();
        if (dismissAnimation != null) {
            dismissAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    removeFromParent();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mDialog.startAnimation(dismissAnimation);
        } else {
            removeFromParent();
        }
        Animation backgroundDismissAnimation = getBackgroundDismissAnimation();
        if (backgroundDismissAnimation != null) {
            startAnimation(backgroundDismissAnimation);
        }
    }

    protected void removeFromParent() {
        ViewGroup parent = (ViewGroup) InBaseDialog.this.getParent();
        parent.removeView(InBaseDialog.this);
    }

    private void initializeTouch() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mDialog.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    protected abstract void initDialogContent(FrameLayout parent);

    protected abstract Animation getShowAnimation();

    protected abstract Animation getDismissAnimation();

    protected abstract Animation getBackgroundShowAnimation();

    protected abstract Animation getBackgroundDismissAnimation();
}
