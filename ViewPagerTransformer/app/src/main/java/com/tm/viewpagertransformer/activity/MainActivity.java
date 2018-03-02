package com.tm.viewpagertransformer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.tm.viewpagertransformer.R;
import com.tm.viewpagertransformer.transformer.ViewPagerTransformer;
import com.tm.viewpagertransformer.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int[] imgs = {
            R.drawable.skin1,
            R.drawable.skin2,
            R.drawable.skin3,
            R.drawable.skin4,
            R.drawable.skin5,
            R.drawable.skin6};
    private List<View> list = new ArrayList<>();
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < imgs.length; i++) {
            View view = View.inflate(MainActivity.this, R.layout.item, null);
            ImageView img = (ImageView) view.findViewById(R.id.img_item);
            img.setImageResource(imgs[i]);
            view.setTag(i);
            list.add(view);
        }
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp1);
        ViewPagerAdapter adapter = new ViewPagerAdapter(list, vp);
        vp.setAdapter(adapter);
        vp.setPageTransformer(false, new ViewPagerTransformer(MainActivity.this));
        vp.setOffscreenPageLimit(3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.go_activity2:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.go_activity3:
                Intent intent1 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
