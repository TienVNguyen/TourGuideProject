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
import android.widget.ListView;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.adapters.HueAdapter;
import com.training.tiennguyen.tourguideproject.models.Hue;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * HueFragment
 *
 * @author TienNguyen
 */
public class HueFragment extends Fragment {
    @BindView(R.id.lvHue)
    protected ListView lvHue;
    private Unbinder unbinder;

    /**
     * Constructor
     */
    public HueFragment() {
        // Required empty public constructor
    }

    /**
     * newInstance
     *
     * @return HueFragment
     */
    public static HueFragment newInstance() {
        Bundle args = new Bundle();
        HueFragment fragment = new HueFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hue, container, false);
        unbinder = ButterKnife.bind(this, view);

        // Mock data
        List<Hue> hues = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            hues.add(new Hue("TestC" + i, R.drawable.hue_the_citadel));
            hues.add(new Hue("TestD" + i, R.drawable.ha_long_bay));
        }

        // Populating
        HueAdapter hueAdapter = new HueAdapter(getActivity(), R.layout.list_item_hue, hues);
        lvHue.setAdapter(hueAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
