package com.example.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Sqlite extends SQLiteOpenHelper
{
    public static final String DBname = "myApp.db";

    public DB_Sqlite(@Nullable Context context)
    {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) // it should be triggered once
    {
        sqLiteDatabase.execSQL("CREATE TABLE Users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT , email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABle IF EXISTS Users");
        onCreate(sqLiteDatabase);
    }
}
