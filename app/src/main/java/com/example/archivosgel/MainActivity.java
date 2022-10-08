package com.example.archivosgel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button escritura, base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escritura = findViewById(R.id.Escritura);
        base = findViewById(R.id.BaseDeDatos);
        escritura.setOnClickListener( v -> irEscritura());
        base.setOnClickListener(v -> irBaseDeDatos());
    }

    private void irBaseDeDatos() {
        Intent i = new Intent(this,BaseDeDatos.class);
        startActivity(i);
    }

    private void irEscritura() {
        Intent i = new Intent(this,escribirArchivo.class);
        startActivity(i);
    }
}