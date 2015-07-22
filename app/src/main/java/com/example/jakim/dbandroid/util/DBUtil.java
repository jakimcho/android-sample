package com.example.jakim.dbandroid.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jakim on 12.7.2015 ã..
 */
public class DBUtil extends SQLiteOpenHelper {
    static final String DB_NAME = "users_db";
    static final int CUR_VERSION = 1;
    protected SQLiteDatabase db;

    public DBUtil(Context context){
        super(context, DB_NAME, null, CUR_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ DB_NAME + " (_id integer primary key autoincrement, " +
                "user_name text not null, " +
                "user_sir_name text not null, " +
                "user_gender integer not null);");
        Log.d("Dl", "Create DB");

    }

    public void open(){
        this.db = getWritableDatabase();
    }
    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
