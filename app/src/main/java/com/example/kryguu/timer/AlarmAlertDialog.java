package com.example.kryguu.timer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by kryguu on 12.11.2016.
 */

public class AlarmAlertDialog extends AlertDialog.Builder {
    Context mContext;
    MediaPlayer mediaPlayer;
    public AlarmAlertDialog(Context context) {
        super(context);
        mContext = context;
        mediaPlayer = MediaPlayer.create(mContext, R.raw.alarm);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        this.setTitle(R.string.alert_dialog_title);
        this.setIcon(R.drawable.ic_clock);
        this.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                mediaPlayer.stop();
            }
        });
    }
}
