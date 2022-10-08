package com.example.archivosgel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class escribirArchivo extends AppCompatActivity {

    Button guardar, leer;
    TextView lectura;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir_archivo);

        guardar = findViewById(R.id.BtnSalve);
        leer = findViewById(R.id.BtnRead);
        lectura = findViewById(R.id.TvLectura);

        guardar.setOnClickListener(v -> guardarArchivo());
        leer.setOnClickListener(v -> leerFile());

    }

    private void leerFile() {
        InputStreamReader miArchivo; //variable para manipular el archivo
        String cadena = "";
        String texto = "";
        try {
            miArchivo = new InputStreamReader(openFileInput("myFile.txt"));
            Toast.makeText(this,"Archivo leido",Toast.LENGTH_SHORT).show();
            BufferedReader almacenamiento = new BufferedReader(miArchivo);
            cadena=almacenamiento.readLine();
            while(cadena != null){
                    texto = texto + cadena + "\n";
                    cadena=almacenamiento.readLine();
            }
            almacenamiento.close();
            miArchivo.close();
            lectura.setText(texto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void guardarArchivo() {

        OutputStreamWriter miArchivo; //Manipular archivo

        try {
            miArchivo = new OutputStreamWriter(openFileOutput("myFile.txt",Context.MODE_PRIVATE));
            Toast.makeText(this,"Archivo Creado",Toast.LENGTH_SHORT).show();
            miArchivo.write("Felipe;24;Santiago de cali" + "\n");
            miArchivo.write("Andres;22;Santiago de Cali" + "\n");
            miArchivo.flush();
            miArchivo.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}