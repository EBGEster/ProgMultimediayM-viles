package com.example.myapp;


import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonStartActivityListener implements View.OnClickListener  {
    private Class<AppCompatActivity> calleeClass;
    private AppCompatActivity caller;
    public ButtonStartActivityListener(Class calleeClass, AppCompatActivity caller) {
        super();
        this.calleeClass = calleeClass;
        this.caller = caller;
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(caller, calleeClass);
        caller.startActivity(intent);
    }
}
