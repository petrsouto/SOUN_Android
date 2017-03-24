package com.android.soun.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.soun.R;

import java.util.ArrayList;

public class DrawerAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<String> drawerItems;

    public DrawerAdapter(Context context, ArrayList<String> drawerItems){
        this.context = context;
        this.drawerItems = drawerItems;
    }

    @Override
    public int getCount() {
        return drawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return drawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_drawer_item, null);
        }
        TextView txtTitle = (TextView) convertView.findViewById(R.id.tv_drawer_title);
        txtTitle.setText(drawerItems.get(position));

        return convertView;
    }
}
