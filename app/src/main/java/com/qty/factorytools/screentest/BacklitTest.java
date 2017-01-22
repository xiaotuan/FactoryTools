package com.qty.factorytools.screentest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.qty.factorytools.AbstractTestActivity;
import com.qty.factorytools.R;

public class BacklitTest extends AbstractTestActivity {

    private static final int MSG_SWTCH_COLOR = 100;

    private View mBacklitTestView;

    private int[] mColors;
    private int mSwitchColorDelayed;
    private int mSwitchTimes;
    private int mTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backlit_test);
        setTitle(R.string.backlit_test_title);
        mColors = getResources().getIntArray(R.array.backlit_test_colors);
        mSwitchColorDelayed = getResources().getInteger(R.integer.backlit_test_switch_color_delayed);
        mSwitchTimes = getResources().getInteger(R.integer.backlit_test_switch_times);
        mTimes = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBacklitTestView = findViewById(R.id.backlit_test);
        mBacklitTestView.setBackgroundColor(mColors[0]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSwitchHandler.sendEmptyMessageDelayed(MSG_SWTCH_COLOR,mSwitchColorDelayed);
    }

    private Handler mSwitchHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SWTCH_COLOR:
                    if (mTimes < mSwitchTimes) {
                        mTimes++;
                        mBacklitTestView.setBackgroundColor(mColors[mTimes % mColors.length]);
                        mSwitchHandler.sendEmptyMessageDelayed(MSG_SWTCH_COLOR,mSwitchColorDelayed);
                    } else {
                        mBacklitTestView.setBackgroundColor(getResources().getColor(R.color.white));
                    }
                    break;
            }
        }
    };
}
