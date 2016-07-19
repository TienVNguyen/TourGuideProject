/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.tourguideproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.models.Hochiminh;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * HochiminhAdapter
 *
 * @author TienNguyen
 */
public class HochiminhAdapter extends RecyclerView.Adapter<HochiminhAdapter.ViewHolder> {
    /**
     * List<Hochiminh>
     */
    private List<Hochiminh> hochiminhs;

    /**
     * Context
     */
    private Context mContext;

    /**
     * Constructor
     *
     * @param hochiminhs List<Hochiminh>
     * @param mContext   Context
     */
    public HochiminhAdapter(List<Hochiminh> hochiminhs, Context mContext) {
        this.hochiminhs = hochiminhs;
        this.mContext = mContext;
    }

    /**
     * getmContext
     *
     * @return Context
     */
    public Context getmContext() {
        return mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.list_item_hochiminh, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hochiminh hochiminh = hochiminhs.get(position);

        if (hochiminh.hasImage()) {
            ImageView imageView = holder.img;
            imageView.setImageResource(hochiminh.getmImg());
        }
        TextView txtName = holder.txtName;
        txtName.setText(hochiminh.getmName());
    }

    @Override
    public int getItemCount() {
        return hochiminhs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lvHochiminhItemImg)
        protected ImageView img;
        @BindView(R.id.lvHochiminhItemTxtName)
        protected TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
