package com.example.myapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ViewModel extends AndroidViewModel
{
    private TransactionDAO transactionDAO;
    private Database database;

    public ViewModel(@NonNull Application application)
    {
        super(application);

        database = Database.getDatabase(application);
        transactionDAO = database.transactionDAO();
    }

    public void insert(Transaction transaction)
    {
        new InsertAsyncTask(transactionDAO).execute(transaction);
    }

    @Override
    protected void onCleared()
    {
        super.onCleared();
    }

    private class InsertAsyncTask extends AsyncTask<Transaction, Void, Void>
    {
        TransactionDAO aTransactionDAo;


        public InsertAsyncTask(TransactionDAO aTransactionDAO)
        {
            this.aTransactionDAo = aTransactionDAO;
        }

        @Override
        protected Void doInBackground(Transaction... transactions)
        {
            aTransactionDAo.insert(transactions[0]);
            return null;
        }
    }
}
