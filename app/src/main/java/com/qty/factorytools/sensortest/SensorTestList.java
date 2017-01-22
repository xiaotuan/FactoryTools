package com.qty.factorytools.sensortest;

import android.os.Bundle;

import com.qty.factorytools.AbstractListActivity;

public class SensorTestList extends AbstractListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApplication.updateSensorTestList();
        setTestList(mApplication.getSensorTestList());
    }
}
