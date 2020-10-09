package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Quan Ly Sach");
        setContentView(R.layout.activity_main);
    }

    public void viewNguoiDung(View view) {
        Intent intent = new Intent(MainActivity.this,ListNguoiDungActivity.class);
        startActivity(intent);
    }

    public void viewListBookActivity(View view) {
        Intent intent=new Intent(MainActivity.this,SachActivity.class);
        startActivity(intent);
    }
}