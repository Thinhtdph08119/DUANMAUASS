package com.example.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;
    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (" +
            " userName text primary key, " +
            " password text, " +
            " phone text, " +
            " hoTen text" +
            ");";
    public static final String TABLE_NAME = "NguoiDung";

    public NguoiDungDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertNguoiDung(NguoiDung nguoiDung) {
        ContentValues values = new ContentValues();
        values.put("userName", nguoiDung.getUserName());
        values.put("password", nguoiDung.getPassword());
        values.put("phone", nguoiDung.getPhone());
        values.put("hoTen", nguoiDung.getHoTen());
        try {
            if (db.insert(TABLE_NAME, null, values) < 0) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e("NguoiDungDAO", ex.getMessage());
        }


        return 1;
    }

    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> dsNguoiDung = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null,
                null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NguoiDung ll = new NguoiDung();
            ll.setUserName(c.getString(0));
            ll.setPassword(c.getString(1));
            ll.setPhone(c.getString(2));
            ll.setHoTen(c.getString(3));
            dsNguoiDung.add(ll);
            Log.d("//=====", ll.toString());
            c.moveToNext();
        }
        c.close();
        return dsNguoiDung;

    }

    public int deleteNguoiDung(String usrename) {
        int result = db.delete(TABLE_NAME, "username=?", new String[]{usrename});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int updateNguoiDung(NguoiDung nguoiDung) {
        ContentValues values = new ContentValues();
        values.put("userName", nguoiDung.getUserName());
        values.put("password", nguoiDung.getPassword());
        values.put("phone", nguoiDung.getPhone());
        values.put("hoTen", nguoiDung.getHoTen());
        try {
            if (db.update(TABLE_NAME, values, "username=?", new String[]{nguoiDung.getUserName()}) < 0) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e("NguoiDungDAO", ex.getMessage());
        }


        return 1;
    }
}
