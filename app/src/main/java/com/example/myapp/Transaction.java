package com.example.myapp;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(tableName = "Transactions")
public class Transaction
{
    @PrimaryKey
    private int transactionsID;

    @ForeignKey(entity = User.class, parentColumns = "userID", childColumns = "userID", onDelete = ForeignKey.CASCADE)
    private String userID;

    @ForeignKey(entity = Category.class, parentColumns = "categoryID", childColumns = "categoryID", onDelete = ForeignKey.CASCADE)
    private int categoryID;
    private BigDecimal amount;
    private LocalDate LocalDate;


}
