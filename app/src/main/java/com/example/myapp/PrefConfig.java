package com.example.myapp;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig
{
    private SharedPreferences sharedPreferences;
    private Context context;

    public PrefConfig(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file),Context.MODE_PRIVATE);
    }


}
