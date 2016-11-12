package com.example.kryguu.timer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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

    Timer timer = new Timer(0,0,0,0);
    CustomCountDownTimer counter = new CustomCountDownTimer(MainActivity.this, timer);
    boolean countDownEnabled = false;
    List<Button> buttonsPlusMinusTable = new ArrayList<Button>();
    MediaPlayer mClickSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initUIComponents();
    }

    private void initUIComponents() {
        buttonsPlusMinusTable.add(buttonPlusMinuteTen);
        buttonsPlusMinusTable.add(buttonPlusMinuteOne);
        buttonsPlusMinusTable.add(buttonPlusSecondTen);
        buttonsPlusMinusTable.add(buttonPlusSecondOne);
        buttonsPlusMinusTable.add(buttonMinusMinuteTen);
        buttonsPlusMinusTable.add(buttonMinusMinuteOne);
        buttonsPlusMinusTable.add(buttonMinusSecondTen);
        buttonsPlusMinusTable.add(buttonMinusSecondOne);
        for (Button button: buttonsPlusMinusTable) {
            button.setOnClickListener(click);
        }
        mClickSound = MediaPlayer.create(this, R.raw.click);
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
            mClickSound.start();
            timer.addTime(minuteTen,minuteOne,secondTen,secondOne);
            updateTextViews();
        }
    };

    public void updateTextViews() {
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
        if (countDownEnabled == false) {
            setCountDownEnabled(true);
        }
        mClickSound.start();
    }

    public void setCountDownEnabled(boolean enabled) {
        countDownEnabled = enabled;
        setEnabledPlusMinusButtons(enabled == false);

        if (enabled) {
            counter = new CustomCountDownTimer(MainActivity.this, timer);
            counter.start();
        }
        else {
            counter.cancel();
        }
    }

    public void setEnabledPlusMinusButtons(boolean enabled) {
        for (Button button: buttonsPlusMinusTable) {
            button.setEnabled(enabled);
        }
    }

    @OnClick(R.id.buttonStop)
    public void onButtonStopClick() {
        setCountDownEnabled(false);
        timer.setmTime(0, 0, 0, 0);
        updateTextViews();
        mClickSound.start();
    }

    @OnClick(R.id.buttonPause)
    public void onButtonPauseClick() {
        if (countDownEnabled) {
            setCountDownEnabled(false);
        }
        mClickSound.start();
    }
}
