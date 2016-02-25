package com.application.cuongnv.application;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.application.cuongnv.application.R;
import com.viewpagerindicator.BigCirclePageIndicator;

public class FirstScreen extends AppCompatActivity {
    private ViewPager mViewPager;
    private MyPagerAdapter pagerAdapter;
    private BigCirclePageIndicator mCirclePageIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        initView();
        initData();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.activity_signup_viewpager);
        mCirclePageIndicator = (BigCirclePageIndicator) findViewById(R.id.activity_signup_indicator);
    }

    public void initData() {
        pagerAdapter = new MyPagerAdapter();
        mViewPager.setAdapter(pagerAdapter);
        mCirclePageIndicator.setViewPager(mViewPager);
    }

    private class MyPagerAdapter extends PagerAdapter {
        int[] images = new int[] { R.drawable.guide_1, R.drawable.guide_2,
                R.drawable.guide_3, R.drawable.guide_4 };

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (LinearLayout) object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(getApplicationContext(),
                    R.layout.item_pager_introduction, null);
            ImageView img = (ImageView) view
                    .findViewById(R.id.item_pager_introduction_img);
            img.setImageResource(images[position]);
            ((ViewPager) container).addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

    }

}