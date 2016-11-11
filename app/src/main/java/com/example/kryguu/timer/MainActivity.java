package com.example.kryguu.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.textViewMinuteOne) TextView textViewMinuteOne;
    @BindView(R.id.textViewMinuteTen) TextView textViewMinuteTen;
    @BindView(R.id.textViewSecondOne) TextView textViewSecondOne;
    @BindView(R.id.textViewSecondTen) TextView textViewSecondTen;
    @BindView(R.id.buttonPlusMinuteOne) Button buttonPlusMinuteOne;
    @BindView(R.id.buttonPlusMinuteTen) Button buttonPlusMinuteTen;
    @BindView(R.id.buttonPlusSecondOne) Button buttonPlusSecondOne;
    @BindView(R.id.buttonPlusSecondTen) Button buttonPlusSecondTen;
    @BindView(R.id.buttonMinusMinuteOne) Button buttonMinusMinuteOne;
    @BindView(R.id.buttonMinusMinuteTen) Button buttonMinusMinuteTen;
    @BindView(R.id.buttonMinusSecondOne) Button buttonMinusSecondOne;
    @BindView(R.id.buttonMinusSecondTen) Button buttonMinusSecondTen;
    @BindView(R.id.buttonStart) Button buttonStart;
    @BindView(R.id.buttonPause) Button buttonPause;
    @BindView(R.id.buttonStop) Button buttonStop;

    CountDownTimer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        buttonPlusMinuteTen.setOnClickListener(click);
        buttonPlusMinuteOne.setOnClickListener(click);
        buttonPlusSecondTen.setOnClickListener(click);
        buttonPlusSecondOne.setOnClickListener(click);
        buttonMinusMinuteTen.setOnClickListener(click);
        buttonMinusMinuteOne.setOnClickListener(click);
        buttonMinusSecondTen.setOnClickListener(click);
        buttonMinusSecondOne.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        public void onClick(View v) {
            int minuteTen = 0, minuteOne = 0, secondTen = 0, secondOne = 0;
            switch (v.getId()){
                case R.id.buttonPlusMinuteTen:
                    minuteTen = 1;
                    break;
                case R.id.buttonPlusMinuteOne:
                    minuteOne = 1;
                    break;
                case R.id.buttonPlusSecondTen:
                    secondTen = 1;
                    break;
                case R.id.buttonPlusSecondOne:
                    secondOne = 1;
                    break;
                case R.id.buttonMinusMinuteTen:
                    minuteTen = -1;
                    break;
                case R.id.buttonMinusMinuteOne:
                    minuteOne = -1;
                    break;
                case R.id.buttonMinusSecondTen:
                    secondTen = -1;
                    break;
                case R.id.buttonMinusSecondOne:
                    secondOne = -1;
                    break;
            }
            addTime(minuteTen,minuteOne,secondTen,secondOne);
        }
    };

    private void addTime(int minuteTen, int minuteOne, int secondTen, int secondOne) {
        String minuteTenStr = textViewMinuteTen.getText().toString();
        String minuteOneStr = textViewMinuteOne.getText().toString();
        String secondTenStr = textViewSecondTen.getText().toString();
        String secondOneStr = textViewSecondOne.getText().toString();
        int minuteTenDigit = Integer.parseInt(minuteTenStr);
        int minuteOneDigit = Integer.parseInt(minuteOneStr);
        int secondTenDigit = Integer.parseInt(secondTenStr);
        int secondOneDigit = Integer.parseInt(secondOneStr);
        int[] currentTime = {minuteTenDigit,minuteOneDigit,secondTenDigit,secondOneDigit};
        int[] timeToAdd = {minuteTen, minuteOne, secondTen, secondOne};
        for (int i = 0; i<currentTime.length; i++) {
            currentTime[i] += timeToAdd[i];
        }
        currentTime = calculateModuloTime(currentTime);
        textViewMinuteTen.setText(Integer.toString(currentTime[0]));
        textViewMinuteOne.setText(Integer.toString(currentTime[1]));
        textViewSecondTen.setText(Integer.toString(currentTime[2]));
        textViewSecondOne.setText(Integer.toString(currentTime[3]));
    }

    private int[] calculateModuloTime(int[] time) {
        if (time.length == 4) {
            int[] calculatedTime = time;
            calculatedTime[0] %= 6;
            if (calculatedTime[0] < 0) calculatedTime[0] += 6;
            calculatedTime[1] %= 10;
            if (calculatedTime[1] < 0) calculatedTime[1] += 10;
            calculatedTime[2] %= 6;
            if (calculatedTime[2] < 0) calculatedTime[2] += 6;
            calculatedTime[3] %= 10;
            if (calculatedTime[3] < 0) calculatedTime[3] += 10;
            return calculatedTime;
        }
        else {
            return time;
        }
    }

    @OnClick(R.id.buttonStart)
    public void onButtonStartClick() {
        String digitMinuteOneStr = textViewMinuteOne.getText().toString();
        String digitMinuteTenStr = textViewMinuteTen.getText().toString();
        String digitSecondOneStr = textViewSecondOne.getText().toString();
        String digitSecondTenStr = textViewSecondTen.getText().toString();
        int digitMinute1 = Integer.parseInt(digitMinuteOneStr);
        int digitMinute2 = Integer.parseInt(digitMinuteTenStr);
        int digitSecond1 = Integer.parseInt(digitSecondOneStr);
        int digitSecond2 = Integer.parseInt(digitSecondTenStr);

        int totalSecondsNumber = countTotalSecondsNumber(digitMinute1,digitMinute2,digitSecond1,digitSecond2);

        counter = new CountDownTimer(totalSecondsNumber, 1000) {
            String tempSecondStr;
            int tempSecond;
            public void onTick(long millisUntilFinished) {
                setMainTimerTextViews((int)millisUntilFinished/1000);
            }

            public void onFinish() {
                textViewMinuteOne.setText("");
            }
        }.start();
    }

    private int countTotalSecondsNumber(int digitMinute1, int digitMinute2, int digitSecond1, int digitSecond2) {
        return digitMinute1*10*60 + digitMinute2*60 + digitSecond1*10 + digitSecond2;
    }

    private void setMainTimerTextViews(int seconds) {

        //textViewMinute1.setText(""+millisUntilFinished / 1000);
    }

    @Override
    public void onClick(View view) {

    }
}
