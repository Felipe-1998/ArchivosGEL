package com.example.archivosgel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Link Consulta de datos:https://academiaandroid.com/sqlite-en-app-android-actualizar-eliminar-y-consultar-datos/

public class ConsultaBase extends AppCompatActivity {

    Button buscar, actualizar, eliminar;
    EditText telefono;
    TextView nombre,edad, ciudad;

    BaseHelper conn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_base);

        conn=new BaseHelper(this,"mibase",null, 1);

        buscar = findViewById(R.id.btnBuscar);
        actualizar = findViewById(R.id.btnActualizar);
        eliminar = findViewById(R.id.btnEliminar);

        telefono = findViewById(R.id.edtTelefono);

        edad = findViewById(R.id.tvEdad);
        ciudad = findViewById(R.id.tvCiudad);
        nombre = findViewById(R.id.tvNombre);

        //Listener

        buscar.setOnClickListener(v -> consultar());
    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametro = new String[]{telefono.getText().toString()};
        String[] campos = new String[]{"Nombre","Edad","Ciudad"};

        try{
            Cursor cursor = db.query("Personas", campos,"Telefono"+"=?",parametro,null,null,null);
            cursor.moveToFirst();
            nombre.setText(cursor.getString(0));
            edad.setText(cursor.getString(1));
            ciudad.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(this,"El documento no existe",Toast.LENGTH_SHORT).show();
            Limpiar();
        }
    }

    private void Limpiar() {
        edad.setText("");
        ciudad.setText("");
    }
}