package com.tm.viewpagertransformer.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tm.viewpagertransformer.R;
import com.tm.viewpagertransformer.adapter.ViewPagerAdapter2;
import com.tm.viewpagertransformer.transformer.ViewPagerTransformer3;
import com.tm.viewpagertransformer.utils.DensityUtils;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private static final int[] imgs = {
            R.drawable.skin1,
            R.drawable.skin2,
            R.drawable.skin3,
            R.drawable.skin4,
            R.drawable.skin5,
            R.drawable.skin6};
    private List<View> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initData();

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new ViewPagerAdapter2(list, vp));
        vp.setOffscreenPageLimit(3);
        vp.setPageMargin(-DensityUtils.dp2px(Main3Activity.this, 20));
        vp.setPageTransformer(true, new ViewPagerTransformer3());
    }

    private void initData() {
        for (int i = 0; i < imgs.length; i++) {
            View view = View.inflate(Main3Activity.this, R.layout.item2, null);
            ImageView img = (ImageView) view.findViewById(R.id.img_item);
            img.setImageResource(imgs[i]);
            view.setTag(i);
            list.add(view);
        }
    }
}
