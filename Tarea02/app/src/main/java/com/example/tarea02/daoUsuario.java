package com.example.tarea02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class daoUsuario {

    Context c;
    Usuario u;
    ArrayList <Usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tabla = "CREATE TABLE usuario ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nombre TEXT,"
            + "correo TEXT,"
            + "direccion TEXT,"
            + "contraseña TEXT,"
            + "CP INTEGER,"
            + "telefono INTEGER,"
            + "no_ext INTEGER,"
            + "tarjeta INTEGER,"
            + "CVV INTEGER,"
            + "vencimiento INTEGER"
            + ")";

    public daoUsuario(Context c){
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);

        // Verificar si la tabla ya existe
        Cursor cursor = sql.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='usuario'", null);
        if (cursor.getCount() == 0) {
            // La tabla no existe, entonces se crea
            sql.execSQL(tabla);
        }

        u = new Usuario();
    }


    //Si insertUsuario regresa true, es que el registro faalló, de lo contrario, si regresa false, el registro fue exitoso
    public boolean insertUsuario(Usuario u) {
        if (buscar(u.getCorreo()) > 0) {
            return true; // Usuario ya existe, registro fallido
        }

        if (buscar(u.getCorreo()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("nombre", u.getNombre());
            cv.put("correo", u.getCorreo());
            cv.put("direccion", u.getDireccion());
            cv.put("contraseña", u.getContraseña());
            cv.put("CP", u.getCP());
            cv.put("telefono", u.getTelefono());
            cv.put("no_ext", u.getNo_ext());
            cv.put("tarjeta", u.getTarjeta());
            cv.put("CVV", u.getCVV());
            cv.put("vencimiento", u.getVencimiento());

            long result = sql.insert("usuario", null, cv);

            if (result < 0) {
                Log.d("InsertUsuario", "Error inserting user");
            } else {
                Log.d("InsertUsuario", "User inserted successfully");
            }

            return result < 0;
        } else {
            return false;
        }
    }


    public int buscar(String u){
        int x = 0;
        lista = selectUsuarios();
        for (Usuario us : lista) {
            if(us.getCorreo().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList <Usuario> lista = new ArrayList<Usuario>();
        Cursor cr = sql.rawQuery("select * from usuario ", null);
        if(cr != null && cr.moveToFirst()){
            do {
                Usuario u = new Usuario();
                u.setID(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setCorreo(cr.getString(2));
                u.setDireccion(cr.getString(3));
                u.setContraseña(cr.getString(4));
                u.setCP(cr.getInt(5));
                u.setTelefono(cr.getInt(6));
                u.setNo_ext(cr.getInt(7));
                u.setTarjeta(cr.getInt(8));
                u.setCVV(cr.getInt(9));
                u.setVencimiento(cr.getInt(10));
                lista.add(u);
            } while (cr.moveToNext());
        }
        return lista;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return sql;
    }



}