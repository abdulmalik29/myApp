package com.example.myapp;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(tableName = "Transactions")
public class Transaction
{
    @PrimaryKey(autoGenerate = true)
    private int transactionsID;
    private String userID;
    private String categoryID;
    private String amount;
    //private LocalDate LocalDate;

    public Transaction(String userID, String categoryID, String amount)
    {
        this.userID = userID;
        this.categoryID = categoryID;
        this.amount = amount;
        //LocalDate = localDate;
    }

    public void setTransactionsID(int transactionsID)
    {
        this.transactionsID = transactionsID;
    }

    public int getTransactionsID()
    {
        return transactionsID;
    }

    public String getUserID()
    {
        return userID;
    }

    public String getCategoryID()
    {
        return categoryID;
    }

    public String getAmount()
    {
        return amount;
    }
}
