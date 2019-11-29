package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private MediaPlayer player;
        private int playerPos;

        public AsyncTaskRunner(MediaPlayer player) {
            super();
            this.player = player;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                playerPos = player.getCurrentPosition();
                player.pause();
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }


        @Override
        protected void onPostExecute(String result) {
            player.seekTo(playerPos);
            player.start();
        }


        @Override
        protected void onPreExecute() {
        }


        @Override
        protected void onProgressUpdate(String... text) {
        }
    }

    private ButtonStartActivityListener buttonVolverInicioListener = new ButtonStartActivityListener(MainActivity.class, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button buttonCrearServicio = findViewById(R.id.crear_Servicio);
        buttonCrearServicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startService(new Intent(Activity3.this, MiServicio.class));
            }
        });

        Button buttonDetenerServicio = findViewById(R.id.detener_servicio);
        buttonDetenerServicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopService(new Intent(Activity3.this, MiServicio.class));
            }
        });

        Button buttonVolverInicio = findViewById(R.id.volver_main);
        buttonVolverInicio.setOnClickListener(buttonVolverInicioListener);

        Button buttonPausarServicio = findViewById(R.id.pausa);
        buttonPausarServicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer player = MiServicio.getPlayer();
                if (player != null)
                    new AsyncTaskRunner(player);
            }
        });
    }
}
