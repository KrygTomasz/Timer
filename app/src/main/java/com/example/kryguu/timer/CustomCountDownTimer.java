package com.example.kryguu.timer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;

/**
 * Created by kryguu on 12.11.2016.
 */

public class CustomCountDownTimer extends CountDownTimer {

    private MainActivity mContext;
    private Timer mTimer;

    public CustomCountDownTimer(MainActivity context, Timer timer) {
        super(timer.getTotalSecondsNumber() * 1000, 1000);
        mContext = context;
        mTimer = timer;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        millisUntilFinished /= 1000;
        mTimer.countDownTime();
        mContext.updateTextViews();
    }

    @Override
    public void onFinish() {
        mTimer.countDownTime();
        mContext.updateTextViews();
        AlarmAlertDialog a = new AlarmAlertDialog(mContext);
        a.show();
        mContext.setCountDownEnabled(false);
    }
}
