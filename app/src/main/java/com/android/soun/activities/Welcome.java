package com.android.soun.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.soun.R;
import com.android.soun.activities.adapters.WelcomeAdapter;
import com.android.soun.common.Utility;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

public class Welcome extends AppCompatActivity {
    private ViewPager mPager;
    private Button btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.welcome_pager);
        mPager.setAdapter(new WelcomeAdapter(getSupportFragmentManager()));

        CirclePageIndicator titleIndicator = (CirclePageIndicator)findViewById(R.id.welcome_page_indicator);
        titleIndicator.setViewPager(mPager);

        btnSkip = (Button)findViewById(R.id.welcome_btn_skip);
        Utility.utility.roundedView(btnSkip, Color.WHITE, 2);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this, Main.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }




}
