package com.android.soun.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.soun.R;
import com.android.soun.common.Utility;

public class WelcomeFragment extends Fragment{
    private static final String PAGE = "page";
    private int mPage;

    public static WelcomeFragment newInstance(int page) {
        WelcomeFragment frag = new WelcomeFragment();
        Bundle b = new Bundle();
        b.putInt(PAGE, page);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!getArguments().containsKey(PAGE))
            throw new RuntimeException("Fragment must contain a \"" + PAGE + "\" argument!");
        mPage = getArguments().getInt(PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Select a layout based on the current page
        int layoutResId;
        switch (mPage) {
            case 0:
                layoutResId = R.layout.fragment_welcome_first;
                break;
            case 1:
                layoutResId = R.layout.fragment_welcome_second;
                break;
            default:
                layoutResId = R.layout.fragment_welcome_third;
        }

        // Inflate the layout resource file
        View view = getActivity().getLayoutInflater().inflate(layoutResId, container, false);
        ImageView imgOut = (ImageView)view.findViewById(R.id.welcome_img_out);
        ImageView imgIn = (ImageView)view.findViewById(R.id.welcome_img_in);
        ImageView imgLogo = (ImageView)view.findViewById(R.id.welcome_img_logo);

        Utility.utility.rotateAnimation(imgOut, 0, 360, 2000);
        Utility.utility.rotateAnimation(imgIn, 0, 360, 2000);
        Utility.utility.flipAnimation(imgLogo, 0, 360, 2000);
        return view;
    }
}
