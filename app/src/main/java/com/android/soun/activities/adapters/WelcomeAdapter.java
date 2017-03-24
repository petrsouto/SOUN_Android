package com.android.soun.activities.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.soun.activities.fragments.WelcomeFragment;

public class WelcomeAdapter extends FragmentStatePagerAdapter{
    public WelcomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return WelcomeFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
