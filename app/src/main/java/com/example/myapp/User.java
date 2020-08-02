package com.example.myapp;

public class User
{
    private String userID;
    private String name;
    private String email;
    private double balance;

    public String getUserID()
    {
        return userID;
    }

    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public User(String id, String name, String email, double balance)
    {
        this.userID = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setBalance(float balance)
    {
        this.balance = balance;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public double getBalance()
    {
        return balance;
    }
}
