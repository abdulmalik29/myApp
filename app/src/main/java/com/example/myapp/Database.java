package com.example.myapp;

import androidx.room.Dao;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class}, version = 1)
public abstract class Database extends RoomDatabase
{
    public abstract DAO dao();
}
