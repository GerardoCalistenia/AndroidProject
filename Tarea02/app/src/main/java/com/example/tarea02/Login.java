package com.example.tarea02;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Login {
    private SQLiteDatabase db;

    public Login(Context context) {
        daoUsuario dao = new daoUsuario(context);
        db = dao.getSQLiteDatabase();
    }

    public boolean iniciarSesion(String correo, String contraseña) {
        String[] columnas = {"correo", "contraseña"};
        String seleccion = "correo = ? AND contraseña = ?";
        String[] args = {correo, contraseña};

        Cursor cursor = db.query("usuario", columnas, seleccion, args, null, null, null);
        int count = cursor.getCount();

        cursor.close();

        return count > 0;
    }
}
