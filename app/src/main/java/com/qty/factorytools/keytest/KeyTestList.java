package com.qty.factorytools.keytest;

import android.os.Bundle;

import com.qty.factorytools.AbstractListActivity;

public class KeyTestList extends AbstractListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApplication.updateKeyTestList();
        setTestList(mApplication.getKeyTestList());
    }
}
