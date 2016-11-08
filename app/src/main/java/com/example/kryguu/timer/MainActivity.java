package com.example.kryguu.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textViewMinute1) TextView textViewMinute1;
    @BindView(R.id.textViewMinute2) TextView textViewMinute2;
    @BindView(R.id.textViewSecond1) TextView textViewSecond1;
    @BindView(R.id.textViewSecond2) TextView textViewSecond2;
    @BindView(R.id.buttonPlusMinute1) Button buttonPlusMinute1;
    @BindView(R.id.buttonPlusMinute2) Button buttonPlusMinute2;
    @BindView(R.id.buttonPlusSecond1) Button buttonPlusSecond1;
    @BindView(R.id.buttonPlusSecond2) Button buttonPlusSecond2;
    @BindView(R.id.buttonMinusMinute1) Button buttonMinusMinute1;
    @BindView(R.id.buttonMinusMinute2) Button buttonMinusMinute2;
    @BindView(R.id.buttonMinusSecond1) Button buttonMinusSecond1;
    @BindView(R.id.buttonMinusSecond2) Button buttonMinusSecond2;
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

    @OnClick(R.id.buttonPlusMinute1)
    public void onButtonPlusMinute1Click() {
        String digitStr = textViewMinute1.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=6;
        textViewMinute1.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonPlusMinute2)
    public void onButtonPlusMinute2Click() {
        String digitStr = textViewMinute2.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=10;
        textViewMinute2.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonPlusSecond1)
    public void onButtonPlusSecond1Click() {
        String digitStr = textViewSecond1.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=6;
        textViewSecond1.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonPlusSecond2)
    public void onButtonPlusSecond2Click() {
        String digitStr = textViewSecond2.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit++;
        digit%=10;
        textViewSecond2.setText(Integer.toString(digit));
    }





    @OnClick(R.id.buttonMinusMinute1)
    public void onButtonMinusMinute1Click() {
        String digitStr = textViewMinute1.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 6+digit;
        textViewMinute1.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonMinusMinute2)
    public void onButtonMinusMinute2Click() {
        String digitStr = textViewMinute2.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 10+digit;
        textViewMinute2.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonMinusSecond1)
    public void onButtonMinusSecond1Click() {
        String digitStr = textViewSecond1.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 6+digit;
        textViewSecond1.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonMinusSecond2)
    public void onButtonMinusSecond2Click() {
        String digitStr = textViewSecond2.getText().toString();
        int digit = Integer.parseInt(digitStr);
        digit--;
        if (digit<0) digit = 10+digit;
        textViewSecond2.setText(Integer.toString(digit));
    }

    @OnClick(R.id.buttonStart)
    public void onButtonStartClick() {
        String digitMinute1Str = textViewMinute1.getText().toString();
        String digitMinute2Str = textViewMinute2.getText().toString();
        String digitSecond1Str = textViewSecond1.getText().toString();
        String digitSecond2Str = textViewSecond2.getText().toString();
        int digitMinute1 = Integer.parseInt(digitMinute1Str);
        int digitMinute2 = Integer.parseInt(digitMinute2Str);
        int digitSecond1 = Integer.parseInt(digitSecond1Str);
        int digitSecond2 = Integer.parseInt(digitSecond2Str);

        int totalSecondsNumber = countTotalSecondsNumber(digitMinute1,digitMinute2,digitSecond1,digitSecond2);

        counter = new CountDownTimer(totalSecondsNumber, 1000) {
            String tempSecondStr;
            int tempSecond;
            public void onTick(long millisUntilFinished) {
                setMainTimerTextViews((int)millisUntilFinished/1000);
            }

            public void onFinish() {
                textViewMinute1.setText("");
            }
        }.start();
    }

    private int countTotalSecondsNumber(int digitMinute1, int digitMinute2, int digitSecond1, int digitSecond2) {
        return digitMinute1*10*60 + digitMinute2*60 + digitSecond1*10 + digitSecond2;
    }

    private void setMainTimerTextViews(int seconds) {

        //textViewMinute1.setText(""+millisUntilFinished / 1000);
    }

}
