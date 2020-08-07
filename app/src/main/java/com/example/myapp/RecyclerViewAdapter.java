package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private final LayoutInflater layoutInflater;
    private Context mContext;

    List<Transaction> allTransactions;

    public RecyclerViewAdapter(List<Transaction> transactions, Context context)
    {
        layoutInflater = LayoutInflater(context);
        this.allTransactions = transactions;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transactions_row,
                parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.textView1.setText("allTransactions.get(position).getCategoryID()");
        holder.textView2.setText(allTransactions.get(position).getCategoryID());

    }

    @Override
    public int getItemCount()
    {
        return allTransactions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView1, textView2;
        private int mPosition;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }

    }
}
