package com.example.tukangcangkulapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TukangActivity extends Activity {
    private SQLiteDatabase db = null;
    private Cursor tukangCursor = null;
    private EditText txtcarikota;
    private EditText txtcarikecam;
    private EditText txtcarikeluh;
    Button Cari;
    public dataTukang Datatukang = null;
    public static final String KOTA="kota";
    public static final String KECAMATAN="kecamatan";
    public static final String KELURAHAN="kelurahan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Datatukang = new dataTukang(this);
        db = Datatukang.getWritableDatabase();
        Datatukang.createTable(db);
        Datatukang.generateData(db);

        setContentView(R.layout.activity_caritukang);
        txtcarikota = (EditText) findViewById(R.id.txtcarikota);
        txtcarikeluh = (EditText) findViewById(R.id.txtcarikeluh);
        txtcarikecam = (EditText) findViewById(R.id.txtcarikecam);
        Cari = (Button) findViewById(R.id.btncari);
    }
    public void CariData(View view){
        if(txtcarikota.getText().length()==0 && txtcarikecam.getText().length()==0 && txtcarikeluh.getText().length()==0){
            Toast.makeText(this, "Kota dan Kecamatan harus diisi jangan sampai kosong!", Toast.LENGTH_LONG).show();
            return;
        }
        String result = "";
        String caritukang = txtcarikota.getText().toString();
        tukangCursor = db.rawQuery("SELECT ID, NAMA, NOTELP "
                + "FROM tukang where KOTA='" + caritukang
                + "'ORDER BY KOTA", null);

        if (tukangCursor.moveToFirst()) {
            result = "No Hp: " + tukangCursor.getString(2) + "\n" + "Nama Tukang: " + tukangCursor.getString(1);
            for(; !tukangCursor.isAfterLast();
                tukangCursor.moveToNext()) {
                result = "No Hp: " + tukangCursor.getString(2) + "\n" +"Nama Tukang: " + tukangCursor.getString(1);
            }



        }
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Hasil Pencarian");
        builder.setMessage(""+String.valueOf(result)).setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialogHasil = builder.create();
        dialogHasil.show();

        if (result.equals("")) {
            Toast.makeText(this, "Tukang tidak ada", Toast.LENGTH_SHORT).show();
        }

    }
}
