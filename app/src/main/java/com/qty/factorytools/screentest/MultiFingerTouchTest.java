package com.qty.factorytools.screentest;

import android.os.Bundle;
import android.view.View;

import com.qty.factorytools.AbstractTestActivity;
import com.qty.factorytools.R;

public class MultiFingerTouchTest extends AbstractTestActivity implements MultiTouchView.CallBack {

    private MultiTouchView mMultiTouchView;

    private boolean mIsPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        super.onCreate(savedInstanceState);
        setTitle(R.string.multi_finger_touch_test_title);
        setContentView(R.layout.multi_finger_touch_test);
        getActionBar().hide();
        mMultiTouchView = (MultiTouchView) findViewById(R.id.multi_touch_view);
        mMultiTouchView.setCallBack(this);
        mIsPass = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!mIsPass) {
            mBottomButtonContainer.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mIsPass) {
            getActionBar().show();
            getWindow().clearFlags(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            getWindow().clearFlags(View.SYSTEM_UI_FLAG_FULLSCREEN);
            getWindow().clearFlags(View.SYSTEM_UI_FLAG_LOW_PROFILE);
            mBottomButtonContainer.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onTestCompleted() {
        mIsPass = true;
        if (mIsAutoTest) {
            mHandler.sendEmptyMessage(MSG_PASS);
        } else {
            getActionBar().show();
            getWindow().clearFlags(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            getWindow().clearFlags(View.SYSTEM_UI_FLAG_FULLSCREEN);
            getWindow().clearFlags(View.SYSTEM_UI_FLAG_LOW_PROFILE);
            mBottomButtonContainer.setVisibility(View.VISIBLE);
        }
    }
}
