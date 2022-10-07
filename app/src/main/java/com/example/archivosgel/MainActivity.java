package com.example.archivosgel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button escritura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escritura = findViewById(R.id.Escritura);
        escritura.setOnClickListener( v -> irEscritura());
    }

    private void irEscritura() {
        Intent i = new Intent(this,escribirArchivo.class);
        startActivity(i);
    }
}