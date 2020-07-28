package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startupActivity extends AppCompatActivity
{
    Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        loginButton= findViewById(R.id.loginBTN);
        registerButton = findViewById(R.id.registerBTN);

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                Toast.makeText(startActivity.this, "Account created"
//                        , Toast.LENGTH_SHORT).show();
                startActivity( new Intent(startupActivity.this, registerActivity.class));
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity( new Intent(startupActivity.this, loginActivity.class));
                finish();
            }
        });
    }
}