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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.adapters.HanoiAdapter;
import com.training.tiennguyen.tourguideproject.models.Hanoi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * HanoiFragment
 *
 * @author TienNguyen
 */
public class HanoiFragment extends Fragment {
    @BindView(R.id.gvHaNoi)
    protected GridView gvHanoi;
    private Unbinder unbinder;

    /**
     * Constructor
     */
    public HanoiFragment() {
        // Required empty public constructor
    }

    /**
     * newInstance
     *
     * @return HanoiFragment
     */
    public static HanoiFragment newInstance() {
        Bundle args = new Bundle();
        HanoiFragment fragment = new HanoiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hanoi, container, false);
        unbinder = ButterKnife.bind(this, view);

        // Mock data
        List<Hanoi> hanois = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            hanois.add(new Hanoi("TestA" + i, R.drawable.khai_dinh_tomb));
            hanois.add(new Hanoi("TestB" + i, R.drawable.thien_mu_pagoda));
        }

        // Populating
        HanoiAdapter hanoiAdapter = new HanoiAdapter(getActivity(), R.layout.list_item_hanoi, hanois);
        gvHanoi.setAdapter(hanoiAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
