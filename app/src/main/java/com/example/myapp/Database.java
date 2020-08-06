package com.example.myapp;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Transaction.class}, version = 1)
public abstract class Database extends RoomDatabase
{
    private static volatile Database database ;

    public abstract TransactionDAO transactionDAO();

    public static Database getDatabase(Context context)
    {
        if (database == null)
        {
            synchronized (Database.class)
            {
                database = Room.databaseBuilder(context.getApplicationContext(), Database.class,
                        "myAppDatabase").fallbackToDestructiveMigration().build();
            }

        }
        return database;
    }


}
