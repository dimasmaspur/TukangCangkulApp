package com.example.tukangcangkulapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisActivity extends Activity {
    private  SQLiteDatabase db = null;
    private Cursor tukangCursor = null;
    private EditText txtnik;
    private EditText txtnama;
    private EditText txtnohp;
    private EditText txtkota;
    private EditText txtkecam;
    private EditText txtkeluh;
    private EditText txtalamat;
    Button simpan;

    private dataTukang Datatukang = null;
    public static final String NIK="nik";
    public static final String NAMA="nama";
    public static final String NOTELP="notelp";
    public static final String KOTA="kota";
    public static final String KECAMATAN="kecamatan";
    public static final String KELURAHAN="kelurahan";
    public static final String ALAMAT="alamat";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Datatukang = new dataTukang(this);
        db = Datatukang.getWritableDatabase();
        Datatukang.createTable(db);
        Datatukang.generateData(db);

        setContentView(R.layout.activity_registrasi);
        txtnik = (EditText) findViewById(R.id.txtnik);
        txtnama = (EditText) findViewById(R.id.txtnama);
        txtnohp = (EditText) findViewById(R.id.txtnohp);
        txtkota = (EditText) findViewById(R.id.txtkota);
        txtkeluh = (EditText) findViewById(R.id.txtkeluh);
        txtkecam = (EditText) findViewById(R.id.txtkecam);
        txtalamat = (EditText) findViewById(R.id.txtalamat);
        simpan = (Button) findViewById(R.id.btnsimpan);
    }
    public void SimpanData(View view) {
        if(txtnik.getText().length()==0 && txtnama.getText().length()==0){
            Toast.makeText(this, "Data tidak boleh kosong!", Toast.LENGTH_LONG).show();
            return;
        }
        SQLiteDatabase db = Datatukang.getWritableDatabase();
        ContentValues tc = new ContentValues();
        tc.put(NIK,txtnik.getText().toString());
        tc.put(NAMA,txtnama.getText().toString());
        tc.put(NOTELP,txtnohp.getText().toString());
        tc.put(KOTA,txtkota.getText().toString());
        tc.put(KELURAHAN,txtkeluh.getText().toString());
        tc.put(KECAMATAN,txtkecam.getText().toString());
        tc.put(ALAMAT,txtalamat.getText().toString());
        db.insert("tukang",null,tc);
        Toast.makeText(getBaseContext(), "data sudah disimpan", Toast.LENGTH_LONG).show();
    }
}

