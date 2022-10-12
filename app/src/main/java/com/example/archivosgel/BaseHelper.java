package com.example.archivosgel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    private static final String tabla = "create table Personas(Id integer Primary Key Autoincrement, Telefono text, Nombre text, Edad text,Ciudad text)";

    public BaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS Persona");
        //onCreate(db);
    }
}
