package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ButtonStartActivityListener button1Listener = new ButtonStartActivityListener(Activity2.class, this);
    private ButtonStartActivityListener button2Listener = new ButtonStartActivityListener(Activity3.class, this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  button1 = findViewById(R.id.button);
        button1.setOnClickListener(button1Listener);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(button2Listener);

    }
}
