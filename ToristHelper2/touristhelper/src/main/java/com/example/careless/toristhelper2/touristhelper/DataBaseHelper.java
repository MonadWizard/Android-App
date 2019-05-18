package com.example.careless.toristhelper2.touristhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "touristHelper.db";
    public static final String Table_Info = "place";

    //AllData............
    public static final String COL_1 = "Id";
    public static final String COL_2 = "Title";
    public static final String COL_3 = "Details";
    public static final String COL_4 = "District";
    public static final String COL_5 = "Image";
    public static final String COL_6 = "Long_Lagi";
    public static final String COL_7 = "PlaceName";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {  //Create Table

        db.execSQL("create table " + Table_Info + "(Id INTEGER PRIMARY KEY AUTOINCREMENT,Title TEXT,Details TEXT," +
                "District TEXT, Image TEXT, Long_Lagi TEXT, PlaceName TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Info);

        onCreate(db);
    }


    public boolean insertData(String title, String details, String district, String img, String long_lagi, String placeName) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, title);
        contentValues.put(COL_3, details);
        contentValues.put(COL_4, district);
        contentValues.put(COL_5, img);
        contentValues.put(COL_6, long_lagi);
        contentValues.put(COL_7, placeName);
        long valu = db.insert(Table_Info, null, contentValues);
        if (valu == -1) {
            return false;
        } else {
            return true;
        }

    }






    public Cursor getAllData(String district) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ Table_Info +" WHERE  District = '" + district+"'", null);

        return res;
    }




}
