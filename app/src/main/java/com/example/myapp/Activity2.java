package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Vector;

public class Activity2 extends AppCompatActivity {

    private ButtonStartActivityListener buttonVolverListener = new ButtonStartActivityListener(MainActivity.class, this);
    private ButtonStartActivityListener buttonConsultarDatosListener = new ButtonStartActivityListener(ActivityTabla.class, this);
    private ButtonInsertarDatosListener buttonInsertarDatosListener = new ButtonInsertarDatosListener(this);
    private static Vector<String> tabla = new Vector<String>();

    public static void addDatosTabla(String datos) {
        tabla.add(datos);
    }

    public static Vector<String> getTabla() {
        return tabla;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_2);
        Toast.makeText(this, "Actividad 1", Toast.LENGTH_SHORT).show();

        Button buttonVolver = findViewById(R.id.volver);
        buttonVolver.setOnClickListener(buttonVolverListener);

        Button buttonCrearTabla = findViewById(R.id.crear_tabla);
        buttonCrearTabla.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tabla.clear();
                Toast.makeText(Activity2.this, "Tabla creada!", Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonInsertarDatos = findViewById(R.id.insertar_datos);
        buttonInsertarDatos.setOnClickListener(buttonInsertarDatosListener);

        Button buttonMostrarTabla = findViewById(R.id.consulta_datos);
        buttonMostrarTabla.setOnClickListener(buttonConsultarDatosListener);
    }
}
