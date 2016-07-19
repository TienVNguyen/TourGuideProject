/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.tourguideproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.models.Hue;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * HueAdapter
 *
 * @author TienNguyen
 */
public class HueAdapter extends BaseAdapter {

    /**
     * Resource
     */
    private int mResource;

    /**
     * Resource
     */
    private List<Hue> hues;

    /**
     * LayoutInflater
     */
    private LayoutInflater mInflater;

    /**
     * Constructor
     *
     * @param context  Context
     * @param resource int
     * @param hues     List<Hue>
     */
    public HueAdapter(Context context, int resource, List<Hue> hues) {
        this.mResource = resource;
        this.hues = hues;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return hues.size();
    }

    @Override
    public Object getItem(int i) {
        return hues.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Caching
        final ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = mInflater.inflate(mResource, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        //Populating
        Hue hue = (Hue) getItem(i);
        if (hue != null) {
            viewHolder.txName.setText(hue.getmName());
            if (hue.hasImage()) {
                viewHolder.img.setImageResource(hue.getmImg());
            }
        }

        return view;
    }

    /**
     * ViewHolder
     */
    protected static class ViewHolder {
        @BindView(R.id.lvHueItemImg)
        protected ImageView img;
        @BindView(R.id.lvHueItemTxtName)
        protected TextView txName;

        protected ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
