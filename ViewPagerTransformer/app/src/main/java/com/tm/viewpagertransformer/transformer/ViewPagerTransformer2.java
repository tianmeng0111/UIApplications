package com.tm.viewpagertransformer.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Tian on 2018/3/1.
 */

public class ViewPagerTransformer2 implements ViewPager.PageTransformer {
    private int viewWidth = 0;

    @Override
    public void transformPage(View view, float v) {
        if (viewWidth <= 0) {
            viewWidth = view.getMeasuredWidth();
        }
        if (v > 0 ) {
            view.setPivotX(0);
        } else {
            view.setPivotX(view.getWidth());
        }
        view.setPivotY(view.getHeight());
        view.setRotation(15f * v);
        //弧度 = 角度xπ/180,    角度 = 弧度x180/π
    }
}
