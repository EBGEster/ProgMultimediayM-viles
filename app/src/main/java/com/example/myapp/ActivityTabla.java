package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Vector;

public class ActivityTabla extends AppCompatActivity {

    private ButtonStartActivityListener buttonVolverTablaListener = new ButtonStartActivityListener(Activity2.class, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);
        Vector<String> tabla = Activity2.getTabla();

        TableLayout tableLayout = findViewById(R.id.tabla);
        for (String s: tabla) {
            TextView textView = new TextView(this);
            textView.setText(s);
            tableLayout.addView(textView);
        }

        Button buttonVolverTabla = findViewById(R.id.volver_tabla);
        buttonVolverTabla.setOnClickListener(buttonVolverTablaListener);
    }

}
