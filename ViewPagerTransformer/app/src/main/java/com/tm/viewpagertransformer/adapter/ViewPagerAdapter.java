package com.tm.viewpagertransformer.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.tm.viewpagertransformer.R;

import java.util.List;

/**
 * Created by Tian on 2018/2/27.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private static final String TAG = "ViewPagerAdapter";

    private List<View> list;
    private ViewPager vp;
    public ViewPagerAdapter(List<View> list, ViewPager vp) {
        this.list = list;
        this.vp = vp;
    }
    @Override
    public int getCount() {
        return list == null? 0: list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = list.get(position);

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, View.ROTATION, 0f, 10f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, View.ROTATION_Y, 0f, -10f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator, animator1);
        set.setDuration(10);
        set.start();
        View iv = view.findViewById(R.id.img_item);
        iv.setTag(position);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem((int) v.getTag());
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
