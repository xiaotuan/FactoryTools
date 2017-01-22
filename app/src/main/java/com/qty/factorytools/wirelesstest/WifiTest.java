package com.qty.factorytools.wirelesstest;

import android.app.Activity;
import android.os.Bundle;

import com.qty.factorytools.AbstractTestActivity;
import com.qty.factorytools.R;

public class WifiTest extends AbstractTestActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_test);
    }
}
