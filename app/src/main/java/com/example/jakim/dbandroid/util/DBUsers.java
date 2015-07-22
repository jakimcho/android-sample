package com.example.jakim.dbandroid.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Jakim on 12.7.2015 ã..
 */
public class DBUsers extends DBUtil {

    public DBUsers(Context context) {
        super(context);
    }

    public void addUserRecord(User user) {
        open();
        ContentValues cv = new ContentValues();
        cv.put("user_name", user.getUserName());
        cv.put("user_sir_name", user.getUserSirName());
        cv.put("user_gender", user.getUserGender());

        this.db.insert(DB_NAME, null, cv);

        close();
    }

    public Cursor getValues(){
        open();
        String [] fields = new String[]{"user_name", "user_sir_name", "user_gender"};
        return this.db.query(DB_NAME, fields, null, null, null, null, null);
    }
}
