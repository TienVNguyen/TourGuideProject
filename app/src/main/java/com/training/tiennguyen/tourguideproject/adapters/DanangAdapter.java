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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.models.Danang;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DanangAdapter
 *
 * @author TienNguyen
 */
public class DanangAdapter extends ArrayAdapter<Danang> {
    /**
     * Resource
     */
    private int mResource;

    /**
     * Constructor
     *
     * @param context  Context
     * @param resource int
     * @param objects  List<Danang>
     */
    public DanangAdapter(Context context, int resource, List<Danang> objects) {
        super(context, 0, objects);
        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Caching
        final ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(mResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        // Populating
        final Danang danang = getItem(position);
        if (danang != null) {
            viewHolder.txtName.setText(danang.getmName());
            if (danang.hasImage()) {
                viewHolder.img.setImageResource(danang.getmImg());
            }
        }

        return convertView;
    }

    /**
     * ViewHolder
     */
    protected static class ViewHolder {
        @BindView(R.id.lvDanangItemImg)
        protected ImageView img;
        @BindView(R.id.lvDanangItemTxtName)
        protected TextView txtName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
