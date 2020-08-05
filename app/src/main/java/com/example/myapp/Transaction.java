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
    private BigDecimal amount;
    private LocalDate LocalDate;

    public Transaction(int transactionsID, String userID, String categoryID, BigDecimal amount, java.time.LocalDate localDate)
    {
        this.transactionsID = transactionsID;
        this.userID = userID;
        this.categoryID = categoryID;
        this.amount = amount;
        LocalDate = localDate;
    }
}
