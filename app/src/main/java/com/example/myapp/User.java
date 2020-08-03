package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (primaryKeys  = "userID", tableName = "Users")
public class User
{
    @NonNull
    private String userID;

    @ColumnInfo(name = "userName")
    private String name;

    @ColumnInfo(name = "userEmail")
    private String email;


    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
