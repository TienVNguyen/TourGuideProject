/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.tourguideproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.adapters.HochiminhAdapter;
import com.training.tiennguyen.tourguideproject.models.Hochiminh;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * HochiminhFragment
 *
 * @author TienNguyen
 */
public class HochiminhFragment extends Fragment {
    @BindView(R.id.rvHochiminh)
    protected RecyclerView rvHochiminh;
    private Unbinder unbinder;

    /**
     * Constructor
     */
    public HochiminhFragment() {
        // Required empty public constructor
    }

    /**
     * newInstance
     *
     * @return HochiminhFragment
     */
    public static HochiminhFragment newInstance() {
        Bundle args = new Bundle();
        HochiminhFragment fragment = new HochiminhFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hochiminh, container, false);
        unbinder = ButterKnife.bind(this, view);

        // Mock data
        List<Hochiminh> hochiminhs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            hochiminhs.add(new Hochiminh("TestG" + i, R.drawable.khai_dinh_tomb));
            hochiminhs.add(new Hochiminh("TestH" + i, R.drawable.thien_mu_pagoda));
        }

        // Populating
        HochiminhAdapter hochiminhAdapter = new HochiminhAdapter(hochiminhs, getActivity());
        rvHochiminh.setAdapter(hochiminhAdapter);
        rvHochiminh.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
