package com.android.soun.activities;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.soun.R;
import com.android.soun.activities.adapters.DrawerAdapter;
import com.android.soun.activities.fragments.ServiceFragment;
import com.android.soun.common.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends AppCompatActivity {
    public FragmentManager fragmentManager;

    private Toolbar toolbar;
    private TextView tvTitle;

    private ArrayList<String> mMenuTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private LinearLayout mLeftDrawer;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        initUI(savedInstanceState);
    }

    private void initUI(Bundle savedInstanceState) {
        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        tvTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.drawer_list);
        mLeftDrawer = (LinearLayout) findViewById(R.id.left_drawer);

        mMenuTitles =new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.menu_titles)));

        mDrawerList.setAdapter(new DrawerAdapter(getApplicationContext(), mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerListClickListener());

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.str_navigation_drawer_open, // nav drawer open - description for accessibility
                R.string.str_navigation_drawer_close // nav drawer close - description for accessibility
        );

        toolbar.setNavigationIcon(R.drawable.ic_toolbar_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(mLeftDrawer))
                    mDrawerLayout.closeDrawer(mLeftDrawer);
                else
                    mDrawerLayout.openDrawer(mLeftDrawer);
            }
        });

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            displayView(0);
        }

        Button btnSignOut = (Button)mDrawerLayout.findViewById(R.id.menu_btn_sign_out);
        Utility.utility.roundedView(btnSignOut, Color.WHITE, 2);
    }

    private class DrawerListClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            displayView(position);
        }
    }

    private void displayView(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ServiceFragment();
                break;
            case 1:
                fragment = new ServiceFragment();
                break;
            case 2:
                fragment = new ServiceFragment();
                break;
        }

        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            setTitle(mMenuTitles.get(position));
            mDrawerLayout.closeDrawer(mLeftDrawer);
        }
        else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        tvTitle.setText(title.toString().toUpperCase());
    }
}