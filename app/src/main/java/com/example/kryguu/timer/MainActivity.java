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
    Timer timer = new Timer(0,0,0,0);

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
            timer.addTime(minuteTen,minuteOne,secondTen,secondOne);
            updateText();
        }
    };

    private void updateText() {
        String minuteTen = String.valueOf(timer.getmTime()[0]);
        String minuteOne = String.valueOf(timer.getmTime()[1]);
        String secondTen = String.valueOf(timer.getmTime()[2]);
        String secondOne = String.valueOf(timer.getmTime()[3]);
        textViewMinuteTen.setText(minuteTen);
        textViewMinuteOne.setText(minuteOne);
        textViewSecondTen.setText(secondTen);
        textViewSecondOne.setText(secondOne);
    };

    @OnClick(R.id.buttonStart)
    public void onButtonStartClick() {
        int minuteTen = timer.getmTime()[0];
        int minuteOne = timer.getmTime()[1];
        int secondTen = timer.getmTime()[2];
        int secondOne = timer.getmTime()[3];
        int totalSecondsNumber = timer.getTotalSecondsNumber();

        counter = new CountDownTimer(totalSecondsNumber*1000, 1000) {
            String tempSecondStr;
            int tempSecond;
            public void onTick(long millisUntilFinished) {
                millisUntilFinished/=1000;
                timer.countDownTime();
                updateText();
            }

            public void onFinish() {
                textViewMinuteOne.setText("");
                setEnabledPlusMinusButtons(true);
            }
        }.start();

        setEnabledPlusMinusButtons(false);
    }

    private void setEnabledPlusMinusButtons(boolean enabled) {
        buttonPlusMinuteTen.setEnabled(enabled);
        buttonPlusMinuteOne.setEnabled(enabled);
        buttonPlusSecondTen.setEnabled(enabled);
        buttonPlusSecondOne.setEnabled(enabled);
        buttonMinusMinuteTen.setEnabled(enabled);
        buttonMinusMinuteOne.setEnabled(enabled);
        buttonMinusSecondTen.setEnabled(enabled);
        buttonMinusSecondOne.setEnabled(enabled);
    }

    @Override
    public void onClick(View view) {

    }
}
