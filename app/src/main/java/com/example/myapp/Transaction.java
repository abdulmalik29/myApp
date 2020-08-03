package com.example.myapp;

import java.sql.Date;


public class Transaction
{
    private int transactionsID;
    private String userID;
    private int categoryID;
    private String amount;
    private String LocalDate;

    public Transaction(int transactionsID, String userID, int categoryID, String amount, String date)
    {
        this.transactionsID = transactionsID;
        this.userID = userID;
        this.categoryID = categoryID;
        this.amount = amount;
        this.LocalDate = date;
    }


    public int getTransactionsID()
    {
        return transactionsID;
    }

    public String getUserID()
    {
        return userID;
    }

    public int getCategoryID()
    {
        return categoryID;
    }

    public String getAmount()
    {
        return amount;
    }

    public Date getLocalDate()
    {
        Date date = Date.valueOf(LocalDate);
        return date;
    }
}
