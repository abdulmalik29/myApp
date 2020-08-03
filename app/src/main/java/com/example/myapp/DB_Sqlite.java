package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Date;

public class DB_Sqlite extends SQLiteOpenHelper
{
    public static final String DBname = "myApp.db";
    public static final String USERS_TABLE = "Users";
    public static final String TRANSACTIONS_TABLE = "Transactions";
    public static final String CATEGORY_TABLE = "Category";

    public DB_Sqlite(@Nullable Context context)
    {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) // it should be triggered once
    {
        sqLiteDatabase.execSQL("CREATE TABLE " + USERS_TABLE + " (userID VARCHAR PRIMARY KEY , name VARCHAR , email VARCHAR)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TRANSACTIONS_TABLE + " (" +
                "    transactionsID INTEGER PRIMARY KEY\n" +
                "                           UNIQUE" +
                "                           NOT NULL," +
                "    userID         STRING  REFERENCES Users (userID)" +
                "                           NOT NULL," +
                "    categoryID     INTEGER REFERENCES " + CATEGORY_TABLE + " (categoryID)" +
                "                           NOT NULL," +
                "    amount         DOUBLE  NOT NULL," +
                "    date           DATE    NOT NULL" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE " + CATEGORY_TABLE + " (" +
                "    categoryID INTEGER PRIMARY KEY" +
                "                       NOT NULL," +
                "    userID     STRING  REFERENCES Users (userID) " +
                "                       NOT NULL," +
                "    name       STRING  UNIQUE" +
                "                       NOT NULL," +
                "    total      STRING  NOT NULL" +
                ");");


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

    public boolean addTransaction(Transaction transaction, User user)
    {
        android.text.format.DateFormat df = new android.text.format.DateFormat();

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("userID", user.getUserID());
        cv.put("categoryID", "1");
        cv.put("amount", "");
        cv.put("date", "");

        long insert = db.insert(TRANSACTIONS_TABLE, null, cv);
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
