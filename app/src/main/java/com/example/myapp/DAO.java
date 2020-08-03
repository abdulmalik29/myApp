package com.example.myapp;


import androidx.room.Dao;
import androidx.room.Insert;

// this interface is used to create methods to access or manipulate the data
@Dao
public interface DAO
{
    @Insert
    public void addUser(User user);

}
