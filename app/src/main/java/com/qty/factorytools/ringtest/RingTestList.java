package com.qty.factorytools.ringtest;

import android.os.Bundle;

import com.qty.factorytools.AbstractListActivity;
import com.qty.factorytools.R;

public class RingTestList extends AbstractListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.ring_test_title);
        mApplication.updateRingTestList();
        setTestList(mApplication.getRingTestList());
    }
}
