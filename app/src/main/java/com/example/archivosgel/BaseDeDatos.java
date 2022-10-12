package com.example.archivosgel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 //https://www.develou.com/android-sqlite-bases-de-datos/
public class BaseDeDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos);
        inicializar();
    }

    private void inicializar(){
        if(cantidadDeRegistros()==0){
            String[] texto = leerArchivo();
            BaseHelper baseHelper = new BaseHelper(this, "mibase", null, 1);
            SQLiteDatabase db = baseHelper.getWritableDatabase();
            db.beginTransaction();

            for(int i = 0; i< texto.length; i++){
                String[] linea = texto[i].split(";");
                ContentValues contentValues = new ContentValues();
                contentValues.put("Telefono",linea[0]);
                contentValues.put("Nombre", linea[1]);
                contentValues.put("Edad", linea[2]);
                contentValues.put("Ciudad", linea[3]);
                db.insert("Personas",null, contentValues);
            }
            Toast.makeText(this,"Registros insertados!!!" + texto.length, Toast.LENGTH_SHORT).show();
            db.setTransactionSuccessful();
            db.endTransaction();
        } else {
            Toast.makeText(this,"La tabla ya estaba ok", Toast.LENGTH_SHORT).show();
        }
    }

    private long cantidadDeRegistros(){
        BaseHelper baseHelper = new BaseHelper(this,"mibase",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        long cn = DatabaseUtils.queryNumEntries(db,"Personas");
        db.close();
        return cn;
    }

    private String[] leerArchivo(){
        InputStreamReader isr;
        //InputStream is;
        ByteArrayOutputStream baos = null;
        try {
            isr = new InputStreamReader(openFileInput("myFile.txt"));
            //is = getResources().openRawResource(R.raw.registros);
            baos = new ByteArrayOutputStream();
            int i = isr.read();
            while(i != -1){
                baos.write(i);
                i = isr.read();
            }
            Toast.makeText(this,i,Toast.LENGTH_SHORT).show();
            isr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baos.toString().split("\n");
    }
}