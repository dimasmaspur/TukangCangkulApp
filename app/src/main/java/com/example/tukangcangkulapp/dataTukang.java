package com.example.tukangcangkulapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dataTukang extends SQLiteOpenHelper {
    private static final String Database_Name="dbtukang";
    private static final String NIK="nik";
    private static final String NAMA="nama";
    private static final String NOTELP="notelp";
    private static final String KOTA="kota";
    private static final String KECAMATAN="kecamatan";
    private static final String KELURAHAN="kelurahan";
    private static final String ALAMAT="alamat";

    public dataTukang (Context context) { super(context, Database_Name, null, 1);}

    public void createTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS tukang(id integer primary key autoincrement,"+
                " nik TEXT, nama TEXT, notelp TEXT, kota TEXT, kelurahan TEXT, kecamatan TEXT, alamat TEXT);");
    }
    public void generateData(SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(NIK,"3701918654321");
        cv.put(NAMA, "Budi");
        cv.put(NOTELP, "089643404969");
        cv.put(KOTA, "Jakarta");
        cv.put(KECAMATAN, "Kebon Jeruk");
        cv.put(KELURAHAN, "Sukabumi Utara");
        cv.put(ALAMAT, "Jl.Sulaiman");
        db.insert("tukang", NIK, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newversion) {
        //TODO Auto-generated method stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO Auto-generated method stub
    }
}
