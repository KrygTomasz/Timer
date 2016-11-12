package com.example.kryguu.timer;

import android.os.CountDownTimer;

/**
 * Created by kryguu on 12.11.2016.
 */

public class CustomCountDownTimer extends CountDownTimer {

    private MainActivity mContext;
    private Timer mTimer;
    private long mTotalSecondsNumber;

    public CustomCountDownTimer(MainActivity context, Timer timer) {
        super(timer.getTotalSecondsNumber() * 1000, 1000);
        mTotalSecondsNumber = timer.getTotalSecondsNumber();
        mContext = context;
        mTimer = timer;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        millisUntilFinished /= 1000;
        mTotalSecondsNumber = millisUntilFinished;
        mTimer.countDownTime();
        mContext.updateTextViews();
    }

    @Override
    public void onFinish() {
        onTick(1000);
        mContext.setCountDownEnabled(false);
        AlarmAlertDialog a = new AlarmAlertDialog(mContext);
        a.show();
    }
}
