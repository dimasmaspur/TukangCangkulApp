package com.example.tukangcangkulapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void akun(View view) {
        startActivity(new Intent(MainActivity.this, RegisActivity.class));
    }

    public void tng(View view) {
        startActivity(new Intent(MainActivity.this, TukangActivity.class));
    }

    public void tes(View view) {
        startActivity(new Intent(MainActivity.this, TestiActivity.class));
    }

    public void help(View view) {
        startActivity(new Intent(MainActivity.this, HelpActivity.class));
    }

}

