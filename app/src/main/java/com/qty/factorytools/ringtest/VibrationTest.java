package com.qty.factorytools.ringtest;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.widget.TextView;

import com.qty.factorytools.AbstractTestActivity;
import com.qty.factorytools.R;

public class VibrationTest extends AbstractTestActivity {

    private static final long AUTO_TEST_NEXT_DELAYED = 1000L;

    private TextView mVibrationTip;
    private Vibrator mVibrator;

    private long[] mVibratorTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.vibration_test_title);
        setContentView(R.layout.vibration_test);
        mVibrationTip = (TextView) findViewById(R.id.vibrator_tip);
        mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        mVibratorTime = getVibratorTime();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                mVibrator.vibrate(mVibratorTime, 1);
                mVibrationTip.setTextColor(getResources().getColor(R.color.green));
                if (mIsAutoTest) {
                    mHandler.sendEmptyMessageDelayed(MSG_PASS, AUTO_TEST_NEXT_DELAYED);
                }
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mVibrator.cancel();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    private long[] getVibratorTime() {
        int[] times = getResources().getIntArray(R.array.vibration_time);
        long[] vibratorTimes = new long[times.length];
        for (int i = 0; i < times.length; i++) {
            vibratorTimes[i] = times[i];
        }
        return vibratorTimes;
    }
}
