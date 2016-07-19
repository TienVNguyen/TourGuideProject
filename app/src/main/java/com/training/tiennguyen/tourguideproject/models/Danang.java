/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.tourguideproject.models;

import com.training.tiennguyen.tourguideproject.constants.VariableConstants;

/**
 * Danang
 *
 * @author TienNguyen
 */
public class Danang {
    private String mName;
    private int mImg = VariableConstants.NO_IMAGE_PROVIDED;

    public Danang(String mName, int mImg) {
        this.mName = mName;
        this.mImg = mImg;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmImg() {
        return mImg;
    }

    public void setmImg(int mImg) {
        this.mImg = mImg;
    }

    public boolean hasImage() {
        return mImg != VariableConstants.NO_IMAGE_PROVIDED;
    }
}
