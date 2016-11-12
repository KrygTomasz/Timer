package com.example.kryguu.timer;

/**
 * Created by kryguu on 11.11.2016.
 */

public class Timer {
    private int[] mTime = {0, 0, 0, 0};
    public Timer(int minuteTen, int minuteOne, int secondTen, int secondOne) {
        mTime = new int[]{minuteTen, minuteOne, secondTen, secondOne};
    }

    public int[] getmTime() {
        return mTime;
    }

    public void setmTime(int minuteTen, int minuteOne, int secondTen, int secondOne) {
        this.mTime = new int[]{minuteTen, minuteOne, secondTen, secondOne};
    }

    public void addTime(int minuteTen, int minuteOne, int secondTen, int secondOne) {
        int[] timeToAdd = {minuteTen, minuteOne, secondTen, secondOne};
        for (int i = 0; i<mTime.length; i++) {
            mTime[i] += timeToAdd[i];
        }
        calculateModuloTime();
    }

    private void calculateModuloTime() {
        mTime[0] %= 6;
        if (mTime[0] < 0) mTime[0] += 6;
        mTime[1] %= 10;
        if (mTime[1] < 0) mTime[1] += 10;
        mTime[2] %= 6;
        if (mTime[2] < 0) mTime[2] += 6;
        mTime[3] %= 10;
        if (mTime[3] < 0) mTime[3] += 10;
    }

    public int getTotalSecondsNumber() {
        return mTime[0]*10*60 + mTime[1]*60 + mTime[2]*10 + mTime[3];
    }

    public void countDownTime() {
        addTime(0,0,0,-1);
        if (mTime[3] == 9) {
            addTime(0,0,-1,0);
            if(mTime[2] == 5) {
                addTime(0,-1,0,0);
                if (mTime[1] == 9) {
                    addTime(-1,0,0,0);
                    if (mTime[0] == 5) {
                        setmTime(0,0,0,0);
                    }
                }
            }
        }
    }
}
