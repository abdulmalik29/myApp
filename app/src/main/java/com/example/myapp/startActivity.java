package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class startActivity extends AppCompatActivity
{
    public PrefConfig prefConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        prefConfig = new PrefConfig(this);

        if(findViewById(R.id.fragment_container)!= null)
        {
            if(savedInstanceState != null)
            {
                return;
            }

            if(prefConfig.readLoginStatus()) // if the user is logged in show MainActivity
            {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            else
            {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                        new loginFragment()).commit();
            }
        }
    }
}