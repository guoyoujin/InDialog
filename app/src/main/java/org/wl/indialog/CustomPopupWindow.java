package org.wl.indialog;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by wiky on 11/11/14.
 */
public class CustomPopupWindow extends PopupWindow {

    private Activity mActivity;

    public CustomPopupWindow(Activity activity) {
        super(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mActivity = activity;

        initializeView();
    }

    protected void initializeView() {
        float density = mActivity.getResources().getDisplayMetrics().density;

        TextView v = new TextView(mActivity);
        v.setText("Hello World");
        v.setTextSize(50);
        v.setTextColor(Color.BLUE);
        v.setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int) (300 * density), (int) (200 * density));
        v.setLayoutParams(params);

        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setColor(Color.WHITE);
        bg.setCornerRadius(20);
        v.setBackgroundDrawable(bg);

        setContentView(v);
    }
}
