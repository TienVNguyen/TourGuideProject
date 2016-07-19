/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.tourguideproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.adapters.CityAdapter;
import com.training.tiennguyen.tourguideproject.constants.IntentConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * CityActivity
 *
 * @author TienNguyen
 */
public class CityActivity extends AppCompatActivity {
    @BindView(R.id.tlCity)
    protected TabLayout tlCity;
    @BindView(R.id.vpCity)
    protected ViewPager vpCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        // Init view(s)
        initView();
    }

    /**
     * Initial view(s)
     */
    private void initView() {
        ButterKnife.bind(this);

        // Tab's Structure
        CityAdapter cityAdapter = new CityAdapter(getSupportFragmentManager(), CityActivity.this);
        vpCity.setAdapter(cityAdapter);
        tlCity.setupWithViewPager(vpCity);
        tlCity.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Tab selected
        Intent intent = getIntent();
        int flags = intent.getFlags();
        String title;
        if (flags == IntentConstants.INTENT_HANOI) {
            title = this.getString(R.string.main_txtHanoi);
        } else if (flags == IntentConstants.INTENT_HUE) {
            title = this.getString(R.string.main_txtHue);
        } else if (flags == IntentConstants.INTENT_DANANG) {
            title = this.getString(R.string.main_txtDanang);
        } else {
            title = this.getString(R.string.main_txtHochiminh);
        }
        setTitle(title);
        TabLayout.Tab tab = tlCity.getTabAt(flags);
        if (tab != null) tab.select();
    }
}
