package com.example.tugas_uts_genap_2023_akb_if_4_10120145;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

// Nama                 : Dimas Muhamad Bhakti
// Nim                  : 10120145
// Kelas                : IF-4
public class DBContact extends SQLiteOpenHelper {

    private static final String NamaDatabase = "contact.db";
    private static final int VersiDatabase = 1;

    static abstract class MyColumns implements BaseColumns {
        static final String NamaTabel = "tbl_contact";
        static final String Nomor= "nomor_id";
        static final String Nama = "Nama_Teman";
        static final String Email = "email";
    }

    //Query yang digunakan untuk membuat Tabel
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+MyColumns.NamaTabel+
            "("+MyColumns.Nomor+" TEXT PRIMARY KEY, "+MyColumns.Nama+" TEXT NOT NULL, "+MyColumns.Email+" TEXT NOT NULL)";

    //Query yang digunakan untuk mengupgrade Tabel
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+MyColumns.NamaTabel;

    public DBContact(Context context) {
        super(context, NamaDatabase, null, VersiDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public Cursor viewData() {
        SQLiteDatabase dbContact = this.getReadableDatabase();
        String query = "select * from "+NamaDatabase;
        Cursor cursor = dbContact.rawQuery(query, null);
        return cursor;
    }

}
