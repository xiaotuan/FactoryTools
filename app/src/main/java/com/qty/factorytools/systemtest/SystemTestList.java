package com.qty.factorytools.systemtest;

import android.os.Bundle;

import com.qty.factorytools.AbstractListActivity;
import com.qty.factorytools.R;

public class SystemTestList extends AbstractListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle(R.string.system_test_title);
        mApplication.updateSystemTestList();
        setTestList(mApplication.getSystemTestList());
    }
}
