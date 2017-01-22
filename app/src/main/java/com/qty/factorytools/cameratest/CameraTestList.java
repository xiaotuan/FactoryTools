package com.qty.factorytools.cameratest;

import android.os.Bundle;

import com.qty.factorytools.AbstractListActivity;


public class CameraTestList extends AbstractListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApplication.updateCameraTestList();
        setTestList(mApplication.getCameraTestList());
    }
}
