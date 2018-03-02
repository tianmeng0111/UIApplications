package com.tm.viewpagertransformer.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tm.viewpagertransformer.R;
import com.tm.viewpagertransformer.transformer.ViewPagerTransformer2;
import com.tm.viewpagertransformer.adapter.ViewPagerAdapter2;
import com.tm.viewpagertransformer.transformer.ViewPagerTransformer3;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vp;

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
        setContentView(R.layout.activity_main2);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < imgs.length; i++) {
            View view = View.inflate(Main2Activity.this, R.layout.item2, null);
            ImageView img = (ImageView) view.findViewById(R.id.img_item);
            img.setImageResource(imgs[i]);
            view.setTag(i);
            list.add(view);
        }
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new ViewPagerAdapter2(list, vp));
        vp.setOffscreenPageLimit(3);
        vp.setPageTransformer(false, new ViewPagerTransformer2());
    }
}
