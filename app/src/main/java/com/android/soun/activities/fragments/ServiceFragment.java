package com.android.soun.activities.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.soun.R;
import com.android.soun.common.Utility;

public class ServiceFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource file
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_service, container, false);
        return view;
    }
}
