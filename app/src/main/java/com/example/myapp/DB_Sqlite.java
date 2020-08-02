package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Sqlite extends SQLiteOpenHelper
{
    public static final String DBname = "myApp.db";
    public static final String USERS_TABLE = "Users";
    public static final String TRANSACTIONS_TABLE = "Transactions";

    public DB_Sqlite(@Nullable Context context)
    {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) // it should be triggered once
    {
        sqLiteDatabase.execSQL("CREATE TABLE " + USERS_TABLE + " (userID VARCHAR PRIMARY KEY , name VARCHAR , email VARCHAR)");

        sqLiteDatabase.execSQL("CREATE TABLE Transactions (" +
                "    transactionsID INTEGER PRIMARY KEY," +
                "    userID         STRING  REFERENCES Users (userID)," +
                "    category       STRING," +
                "    amount         INTEGER  NOT NULL," +
                "    date           DATE\n" +
                ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
//        sqLiteDatabase.execSQL("DROP TABle IF EXISTS " + USERS);
//        onCreate(sqLiteDatabase);

    }

    public boolean addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("userID", user.getUserID());
        cv.put("name", user.getName());
        cv.put("email", user.getEmail());

        long insert = db.insert(USERS_TABLE, null, cv);
        if (insert == -1)
        {
            return false;
        }
        else
            {
                return true;
            }
    }
}
