package com.example.myapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransactionDAO
{
    @Insert
    void addTransaction(Transaction transaction);

    @Update
    void updateTransaction(Transaction transaction);

    @Delete
    void deleteTransaction(Transaction transaction);

    @Query("SELECT * FROM Transactions ORDER BY LocalDate DESC")
    LiveData<List<Transaction>> getAllTransaction(Transaction transaction);

    //WHERE userID LIKE userID , String userID
}