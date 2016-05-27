package com.example.user.biodata;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created byu chn on 5/26/2016.
 */
public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "alumni.db";
    private static final int DATABASE_VERSION = 1;
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


    Context context;
    private SQLiteDatabase db;


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
//                Alumni.add(new Alumni(
//                        c.getString(c.getColumnIndex(COL_NPM)),
//                        c.getString(c.getColumnIndex(COL_NAMA)),
//                        c.getDouble(c.getColumnIndex(COL_IPK)),
//                        c.getString(c.getColumnIndex(COL_TTL)),
//                        c.getString(c.getColumnIndex(COL_EMAIL)),
//                        c.getString(c.getColumnIndex(COL_TELP)),
//                        c.getString(c.getColumnIndex(COL_KEAHLIAN)),
//                        c.getString(c.getColumnIndex(COL_PROFESI)),
//                        c.getString(c.getColumnIndex(COL_PENGALAMAN)),
//                        c.getString(c.getColumnIndex(COL_NAMA_ORTU)),
//                        c.getString(c.getColumnIndex(COL_ALAMAT)),
//                        c.getString(c.getColumnIndex(COL_JUDUL_SKRIPSI)),
//                        c.getInt(c.getColumnIndex(COL_BEST)) == 1 ? true : false,
//                        getfotourl(c.getString(c.getColumnIndex(COL_NPM)))
//                ));
                Alumni.add(new Alumni(
                        c.getString(0),
                        c.getString(1),
                        c.getDouble(2),
                        c.getString(3),
                        c.getString(4),
                        c.getString(5),
                        c.getString(6),
                        c.getString(7),
                        c.getString(8),
                        c.getString(9),
                        c.getString(10),
                        c.getString(11),
                        c.getInt(12) == 1 ? true : false,
                        getfotourl(c.getString(0))
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
                        getfotourl(c.getString(c.getColumnIndex(COL_NPM)))
                ));
            } while (c.moveToNext());
        }
        return TheBest;
    }

    public Alumni getAlumni(String npm) {
        Alumni alumni = null;
        String query = "select * from " + TABLE_Alumni + " where NPM='" + npm + "'";

        db = this.getReadableDatabase();

        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {
            alumni = new Alumni(c.getString(c.getColumnIndex(COL_NPM)),
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
                    getfotourl(c.getString(c.getColumnIndex(COL_NPM))));
        }
        return alumni;
    }

    /*private int getfotofromnpm(String npm) {
        try {
            return context.getResources().getIdentifier(npm, "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }*/

    public List<Alumni> cari(String c){
        List<Alumni> nemu = new ArrayList<>();
        //String query = "select * from" + TABLE_Alumni + " where NPM ='"+ c +"'";

        String query = "select * from alumni where npm like '%" + c + "%' or nama like '%" + c + "%' or keahlian like '%" + c + "%' or profesi like '%" + c + "%' or pengalaman like '%" + c + "%' or judul_skripsi like '%" + c + "%'";

        db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                nemu.add(new Alumni(
                        cursor.getString(cursor.getColumnIndex(COL_NPM)),
                        cursor.getString(cursor.getColumnIndex(COL_NAMA)),
                        cursor.getDouble(cursor.getColumnIndex(COL_IPK)),
                        cursor.getString(cursor.getColumnIndex(COL_TTL)),
                        cursor.getString(cursor.getColumnIndex(COL_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(COL_TELP)),
                        cursor.getString(cursor.getColumnIndex(COL_KEAHLIAN)),
                        cursor.getString(cursor.getColumnIndex(COL_PROFESI)),
                        cursor.getString(cursor.getColumnIndex(COL_PENGALAMAN)),
                        cursor.getString(cursor.getColumnIndex(COL_NAMA_ORTU)),
                        cursor.getString(cursor.getColumnIndex(COL_ALAMAT)),
                        cursor.getString(cursor.getColumnIndex(COL_JUDUL_SKRIPSI)),
                        cursor.getInt(cursor.getColumnIndex(COL_BEST)) == 1 ? true : false,
                        getfotourl(cursor.getString(cursor.getColumnIndex(COL_NPM)))
                ));
            } while (cursor.moveToNext());
        }

        return nemu;

    }

    private String getfotourl(String npm) {
        String tahun = "20" + npm.substring(0, 2);

        return "http://amikom.ac.id/public/fotomhs/" + tahun + "/" + npm + ".jpg";
    }
}