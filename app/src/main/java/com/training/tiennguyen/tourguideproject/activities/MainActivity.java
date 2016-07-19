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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.constants.IntentConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MainActivity
 *
 * @author TienNguyen
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txtHanoi)
    protected TextView txtHanoi;
    @BindView(R.id.txtHue)
    protected TextView txtHue;
    @BindView(R.id.txtDanang)
    protected TextView txtDanang;
    @BindView(R.id.txtHochiminh)
    protected TextView txtHochiminh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init view(s)
        initView();
    }

    /**
     * Initial view(s)
     */
    private void initView() {
        ButterKnife.bind(this);

        txtHanoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseCity(IntentConstants.INTENT_HANOI);
            }
        });

        txtHue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseCity(IntentConstants.INTENT_HUE);
            }
        });

        txtDanang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseCity(IntentConstants.INTENT_DANANG);
            }
        });

        txtHochiminh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseCity(IntentConstants.INTENT_HOCHIMINH);
            }
        });
    }

    /**
     * chooseCity
     *
     * @param tap int
     */
    private void chooseCity(int tap) {
        Intent intent = new Intent(MainActivity.this, CityActivity.class);
        intent.setFlags(tap);
        startActivity(intent);
    }
}
