package com.android.soun.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.soun.R;
import com.android.soun.common.AppController;
import com.android.soun.common.Utility;

public class Language extends AppCompatActivity implements View.OnClickListener{

    private Animation animation;
    private long ANIMATION_DURATION = 2000;

    private ImageView imgOut, imgIn, imgLogo;
    private Button btnArabic, btnEnglish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        findIDs();
        initUI();
    }

    private void findIDs() {
        imgOut = (ImageView)findViewById(R.id.language_img_out);
        imgIn = (ImageView)findViewById(R.id.language_img_in);
        imgLogo = (ImageView)findViewById(R.id.language_img_logo);
        btnArabic = (Button) findViewById(R.id.language_btn_arabic);
        btnEnglish = (Button) findViewById(R.id.language_btn_english);

        btnArabic.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);
    }

    private void initUI() {
        Utility.utility.rotateAnimation(imgOut, 0, -360, ANIMATION_DURATION);
        Utility.utility.rotateAnimation(imgIn, 0, 360, ANIMATION_DURATION);
        Utility.utility.flipAnimation(imgLogo, 0, 360, ANIMATION_DURATION);

        Utility.utility.roundedView(btnArabic, getResources().getColor(R.color.whiteColor), 2);
        Utility.utility.roundedView(btnEnglish, getResources().getColor(R.color.whiteColor), 2);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnArabic)) {
            ((AppController) this.getApplication()).setLanguage(false);
        } else {
            ((AppController) this.getApplication()).setLanguage(true);
        }

        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }
}
