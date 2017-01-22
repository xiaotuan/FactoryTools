package com.qty.factorytools.wirelesstest;

import android.os.Bundle;

import com.qty.factorytools.AbstractListActivity;

public class WirelessTestList extends AbstractListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApplication.updateWirelessTestList();
        setTestList(mApplication.getWirelessTestList());
    }
}
