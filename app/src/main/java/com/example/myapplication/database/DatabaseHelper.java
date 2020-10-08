package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.DAO.NguoiDungDAO;
import com.example.myapplication.model.NguoiDung;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="dbBookManager";
    public static final int VERSION=1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(NguoiDungDAO.SQL_NGUOI_DUNG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL(NguoiDungDAO.TABLE_NAME);
    }
}
