package com.qty.factorytools.screentest;

import android.os.Bundle;
import android.view.View;

import com.qty.factorytools.AbstractTestActivity;
import com.qty.factorytools.Log;
import com.qty.factorytools.R;

public class SingleFingerTouchTest extends AbstractTestActivity implements SingleTouchView.CallBack {

    private SingleTouchView mTouchView;

    private boolean mIsPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().addFlags(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        super.onCreate(savedInstanceState);
        setTitle(R.string.single_finger_touch_test_title);
        setContentView(R.layout.single_finger_touch_test);
        getActionBar().hide();
        mTouchView = (SingleTouchView) findViewById(R.id.single_touch_view);
        mTouchView.setCallBack(this);
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
        Log.d(this, "onResume=>pass: " + mIsPass);
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
