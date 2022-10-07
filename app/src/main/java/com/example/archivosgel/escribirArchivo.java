package com.example.archivosgel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class escribirArchivo extends AppCompatActivity {

    Button guardar, leer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir_archivo);

        guardar = findViewById(R.id.BtnSalve);
        leer = findViewById(R.id.BtnRead);

        guardar.setOnClickListener(v -> guardarArchivo());
        leer.setOnClickListener(v -> leerFile());

    }

    private void leerFile() {
        try {
            FileOutputStream archivo = openFileOutput("datos.txt", Context.MODE_PRIVATE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void guardarArchivo() {

    }
}