package com.example.treintaalda.sqlDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "basedatos";
    public static final int DB_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tablaBrazo =
                "CREATE TABLE brazo(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR);";
        db.execSQL(tablaBrazo);
        tablaBrazoDB(db);

        String tablaAbdomen =
                "CREATE TABLE abdomen(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR);";
        db.execSQL(tablaAbdomen);
        tablaAbdomenDB(db);

        String tablaMancuerna =
                "CREATE TABLE pesas(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR);";
        db.execSQL(tablaMancuerna);
        tablaMancuernaDB(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tablaBrazoDB");
        db.execSQL("DROP TABLE IF EXISTS tablaAbdomenDB");
        db.execSQL("DROP TABLE IF EXISTS tablaMancuernaDB");
        onCreate(db);
    }

    private void tablaMancuernaDB(SQLiteDatabase db){
        ContentValues pecho1 = new ContentValues();
        pecho1.put("name", "Pesas");
        db.insert("pesas", null, pecho1);
    }
    private void tablaAbdomenDB(SQLiteDatabase db){
        ContentValues abdo1 = new ContentValues();
        abdo1.put("name", "Abdomen");
        db.insert("abdomen", null, abdo1);
    }
    private void tablaBrazoDB(SQLiteDatabase db){
        ContentValues bra1 = new ContentValues();
        bra1.put("name", "Brazo");
        db.insert("brazo", null, bra1);
    }
}
