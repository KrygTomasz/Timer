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
    }

    @OnClick(R.id.buttonPlusMinuteOne)
    public void onButtonPlusMinute1Click() {
        String digitStr = textViewMinuteOne.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=10;
        textViewMinuteOne.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonPlusMinuteTen)
    public void onButtonPlusMinute2Click() {
        String digitStr = textViewMinuteTen.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=6;
        textViewMinuteTen.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonPlusSecondOne)
    public void onButtonPlusSecond1Click() {
        String digitStr = textViewSecondOne.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=10;
        textViewSecondOne.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonPlusSecondTen)
    public void onButtonPlusSecond2Click() {
        String digitStr = textViewSecondTen.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=6;
        textViewSecondTen.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonMinusMinuteOne)
    public void onButtonMinusMinute1Click() {
        String digitStr = textViewMinuteOne.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 10+digit;
        textViewMinuteOne.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonMinusMinuteTen)
    public void onButtonMinusMinute2Click() {
        String digitStr = textViewMinuteTen.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 6+digit;
        textViewMinuteTen.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonMinusSecondOne)
    public void onButtonMinusSecond1Click() {
        String digitStr = textViewSecondOne.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 10+digit;
        textViewSecondOne.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonMinusSecondTen)
    public void onButtonMinusSecond2Click() {
        String digitStr = textViewSecondTen.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 6+digit;
        textViewSecondTen.setText(Integer.toString(digit));
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
