package com.example.myapp;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MiServicio extends Service {

    private static MediaPlayer player;

    public static MediaPlayer getPlayer() {
        return player;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this,R.raw.avril_lavigne);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        player.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId ) {
        if(player.isPlaying())
            player.stop();

        player.start();

        return super.onStartCommand(intent, flags, startId );
    }

    @Override
    public void onDestroy() {
        player.release();
        stopSelf();
        super.onDestroy();
    }
}
