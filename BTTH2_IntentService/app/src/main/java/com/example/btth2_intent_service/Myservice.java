package com.example.btth2_intent_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Myservice extends Service {
    MediaPlayer mymedia;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mymedia=MediaPlayer.create(Myservice.this, R.raw.photograph);
        mymedia.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mymedia.isPlaying()) mymedia.pause();
        else mymedia.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mymedia.stop();
    }
}
