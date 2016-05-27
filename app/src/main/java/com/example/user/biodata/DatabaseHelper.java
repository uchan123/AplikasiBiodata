package com.example.user.biodata;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by My Computer on 5/26/2016.
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    Context context;

    private static final String DATABASE_NAME = "alumni.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    private static final String TABLE_Alumni = "alumni";

    private static final String COL_NPM = "NPM";
    private static final String COL_NAMA = "NAMA";
    private static final String COL_IPK = "IPK";
    private static final String COL_TTL = "TTL";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_TELP = "TELP";
    private static final String COL_KEAHLIAN = "KEAHLIAN";
    private static final String COL_PROFESI = "PROFESI";
    private static final String COL_PENGALAMAN = "PENGALAMAN";
    private static final String COL_NAMA_ORTU = "NAMA_ORTU";
    private static final String COL_ALAMAT = "ALAMAT";
    private static final String COL_JUDUL_SKRIPSI = "JUDUL_SKRIPSI";
    private static final String COL_BEST = "Best";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public List<Alumni> getAllAlumni() {
        List<Alumni> Alumni = new ArrayList<>();

        String query = "SELECT * FROM Alumni";

        db = this.getReadableDatabase();

        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                Alumni.add(new Alumni(
                        c.getString(c.getColumnIndex(COL_NPM)),
                        c.getString(c.getColumnIndex(COL_NAMA)),
                        c.getDouble(c.getColumnIndex(COL_IPK)),
                        c.getString(c.getColumnIndex(COL_TTL)),
                        c.getString(c.getColumnIndex(COL_EMAIL)),
                        c.getString(c.getColumnIndex(COL_TELP)),
                        c.getString(c.getColumnIndex(COL_KEAHLIAN)),
                        c.getString(c.getColumnIndex(COL_PROFESI)),
                        c.getString(c.getColumnIndex(COL_PENGALAMAN)),
                        c.getString(c.getColumnIndex(COL_NAMA_ORTU)),
                        c.getString(c.getColumnIndex(COL_ALAMAT)),
                        c.getString(c.getColumnIndex(COL_JUDUL_SKRIPSI)),
                        c.getInt(c.getColumnIndex(COL_BEST)) == 1 ? true : false,
                        getfotofromnpm(c.getString(c.getColumnIndex(COL_NPM)))
                ));
            } while (c.moveToNext());
        }
        return Alumni;
    }

    public List<Alumni> getAllTheBest() {
        List<Alumni> TheBest = new ArrayList<>();
        String query = "Select * from " + TABLE_Alumni + " where " + COL_BEST + "=1";

        db = this.getReadableDatabase();

        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {
                TheBest.add(new Alumni(
                        c.getString(c.getColumnIndex(COL_NPM)),
                        c.getString(c.getColumnIndex(COL_NAMA)),
                        c.getDouble(c.getColumnIndex(COL_IPK)),
                        c.getString(c.getColumnIndex(COL_TTL)),
                        c.getString(c.getColumnIndex(COL_EMAIL)),
                        c.getString(c.getColumnIndex(COL_TELP)),
                        c.getString(c.getColumnIndex(COL_KEAHLIAN)),
                        c.getString(c.getColumnIndex(COL_PROFESI)),
                        c.getString(c.getColumnIndex(COL_PENGALAMAN)),
                        c.getString(c.getColumnIndex(COL_NAMA_ORTU)),
                        c.getString(c.getColumnIndex(COL_ALAMAT)),
                        c.getString(c.getColumnIndex(COL_JUDUL_SKRIPSI)),
                        c.getInt(c.getColumnIndex(COL_BEST)) == 1 ? true : false,
                        getfotofromnpm(c.getString(c.getColumnIndex(COL_NPM)))
                ));
            } while (c.moveToNext());
        }
        return TheBest;
    }

    public Alumni getAlumni(String npm) {
        Alumni alumni = null;
        String query = "selesct * from " + TABLE_Alumni + " where " + COL_NPM + "='" + npm + "'";

        db = this.getReadableDatabase();

        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            alumni =  new Alumni(c.getString(c.getColumnIndex(COL_NPM)),
                    c.getString(c.getColumnIndex(COL_NAMA)),
                    c.getDouble(c.getColumnIndex(COL_IPK)),
                    c.getString(c.getColumnIndex(COL_TTL)),
                    c.getString(c.getColumnIndex(COL_EMAIL)),
                    c.getString(c.getColumnIndex(COL_TELP)),
                    c.getString(c.getColumnIndex(COL_KEAHLIAN)),
                    c.getString(c.getColumnIndex(COL_PROFESI)),
                    c.getString(c.getColumnIndex(COL_PENGALAMAN)),
                    c.getString(c.getColumnIndex(COL_NAMA_ORTU)),
                    c.getString(c.getColumnIndex(COL_ALAMAT)),
                    c.getString(c.getColumnIndex(COL_JUDUL_SKRIPSI)),
                    c.getInt(c.getColumnIndex(COL_BEST)) == 1 ? true : false,
                    getfotofromnpm(c.getString(c.getColumnIndex(COL_NPM))));
        }
        return alumni;
    }

    private int getfotofromnpm(String npm) {
        try {
            return context.getResources().getIdentifier(npm, "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}