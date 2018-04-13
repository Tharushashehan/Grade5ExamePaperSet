package com.example.lakshan.simulaion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lakshan on 2/10/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="Student_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="AGE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db =this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("create table %s(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AGE TEXT)", TABLE_NAME));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXIST %s", TABLE_NAME));
        onCreate(db);
    }
}
