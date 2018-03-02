package com.tm.viewpagertransformer.transformer;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tm.viewpagertransformer.utils.ScreenUtils;

/**
 * Created by Tian on 2018/3/1.
 * 画廊效果
 */

public class ViewPagerTransformer implements ViewPager.PageTransformer {

    private Context context;

    private int halfScreenWidth;

    private static final float MAX_SCALE = 1.0f;
    private static final float MIN_SCALE = 0.6f;

    public ViewPagerTransformer(Context context) {
        this.context = context;
        halfScreenWidth = ScreenUtils.getScreenWidth(context) / 2;
    }

    @Override
    public void transformPage(View view, float v) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            view.getParent().requestLayout();
        }
        if (v < -1) {
            v = -1;
        } else if (v > 1) {
            v = 1;
        }

        float tempScale = v < 0 ? 1 + v : 1 - v;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        float scaleValue = MIN_SCALE + tempScale * slope;
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setScaleX(scaleValue);
        view.setScaleY(scaleValue);
        //让前后的卡片有一半可视
        view.setTranslationX(-halfScreenWidth * v);
    }
}
