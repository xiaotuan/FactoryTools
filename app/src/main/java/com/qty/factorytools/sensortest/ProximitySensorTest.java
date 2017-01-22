package com.qty.factorytools.sensortest;

import android.os.Bundle;

import com.qty.factorytools.AbstractTestActivity;
import com.qty.factorytools.R;

public class ProximitySensorTest extends AbstractTestActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proximity_sensor_test);
    }
}
