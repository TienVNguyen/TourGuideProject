/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.tourguideproject.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.training.tiennguyen.tourguideproject.R;
import com.training.tiennguyen.tourguideproject.constants.IntentConstants;
import com.training.tiennguyen.tourguideproject.fragments.DanangFragment;
import com.training.tiennguyen.tourguideproject.fragments.HanoiFragment;
import com.training.tiennguyen.tourguideproject.fragments.HochiminhFragment;
import com.training.tiennguyen.tourguideproject.fragments.HueFragment;

/**
 * CityAdapter
 *
 * @author TienNguyen
 */
public class CityAdapter extends FragmentPagerAdapter {
    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Constructor
     *
     * @param fm      FragmentManager
     * @param context Context
     */
    public CityAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == IntentConstants.INTENT_HANOI) {
            return HanoiFragment.newInstance();
        } else if (position == IntentConstants.INTENT_HUE) {
            return HueFragment.newInstance();
        } else if (position == IntentConstants.INTENT_DANANG) {
            return DanangFragment.newInstance();
        } else {
            return HochiminhFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return IntentConstants.INTENT_PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == IntentConstants.INTENT_HANOI) {
            return mContext.getString(R.string.main_txtHanoi);
        } else if (position == IntentConstants.INTENT_HUE) {
            return mContext.getString(R.string.main_txtHue);
        } else if (position == IntentConstants.INTENT_DANANG) {
            return mContext.getString(R.string.main_txtDanang);
        } else {
            return mContext.getString(R.string.main_txtHochiminh);
        }
    }
}
