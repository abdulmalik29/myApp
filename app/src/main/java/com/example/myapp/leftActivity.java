package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class leftActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

//    ArrayList<Transaction> transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left);

        Database db = Room.databaseBuilder(getApplicationContext(), Database.class,
                "dbTest").allowMainThreadQueries().build();

        List<Transaction>  allTransactions = db.transactionDAO().getAllTransaction();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(allTransactions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}