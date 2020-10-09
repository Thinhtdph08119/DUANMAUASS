package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DAO.NguoiDungDAO;
import com.example.myapplication.model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    Button btnThemNguoiDung,
            btnupdate;
    NguoiDungDAO nguoiDungDAO;
    EditText edUser, edPass, edRepass, edPhone, edFullName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        setTitle("Them Nguoi Dung");
        btnThemNguoiDung = (Button) findViewById(R.id.btnAddUser);
        edUser = (EditText) findViewById(R.id.edUserName);
        edPass = (EditText) findViewById(R.id.edPassword);
        btnupdate = findViewById(R.id.btnUpdateUser);
        edPhone = (EditText) findViewById(R.id.edPhone);
        //edRepass = (EditText)findViewById(R.id.edRePassword);
        edFullName = (EditText) findViewById(R.id.edFullName);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra("bun");
            edUser.setText(bundle.getString("userName"));
            edPass.setText(bundle.getString("password"));
            edPhone.setText(bundle.getString("phone"));
            edFullName.setText(bundle.getString("hoTen"));

        }
    }

    public void updateUser(View v) {
        nguoiDungDAO = new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung nguoiDung = new NguoiDung(edUser.getText().toString(), edPass.getText().toString(),
                edPhone.getText().toString(), edFullName.getText().toString());
        if (nguoiDungDAO.updateNguoiDung(nguoiDung) == 1) {
            Toast.makeText(getApplicationContext(), "update thanh cong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "update that bai", Toast.LENGTH_LONG).show();
        }

    }

    public void addUser(View view) {
        nguoiDungDAO = new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung nguoiDung = new NguoiDung(edUser.getText().toString(), edPass.getText().toString(),
                edPhone.getText().toString(), edFullName.getText().toString());
        if (nguoiDungDAO.insertNguoiDung(nguoiDung) == 1) {
            Toast.makeText(getApplicationContext(), "Them thanh cong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Them that bai", Toast.LENGTH_LONG).show();
        }
    }

    public void showUsers(View view) {

        finish();

    }

}
