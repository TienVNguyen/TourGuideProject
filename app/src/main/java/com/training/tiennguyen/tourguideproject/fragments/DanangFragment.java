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
import com.training.tiennguyen.tourguideproject.adapters.DanangAdapter;
import com.training.tiennguyen.tourguideproject.models.Danang;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * DanangFragment
 *
 * @author TienNguyen
 */
public class DanangFragment extends Fragment {
    @BindView(R.id.lvDanang)
    protected ListView lvDanang;
    private Unbinder unbinder;

    /**
     * Constructor
     */
    public DanangFragment() {
        // Required empty public constructor
    }

    /**
     * newInstance
     *
     * @return DanangFragment
     */
    public static DanangFragment newInstance() {
        Bundle args = new Bundle();
        DanangFragment fragment = new DanangFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danang, container, false);
        unbinder = ButterKnife.bind(this, view);

        // Mock data
        List<Danang> danangs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            danangs.add(new Danang("TestE" + i, R.drawable.hoi_an));
            danangs.add(new Danang("TestF" + i, R.drawable.my_son_sanctuary));
        }

        // Populating
        DanangAdapter danangAdapter = new DanangAdapter(getActivity(), R.layout.list_item_danang, danangs);
        lvDanang.setAdapter(danangAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
