package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class loginActivity extends AppCompatActivity
{
    private EditText passwordEditText, userNameEditText;
    private Button loginButton;
    public static PrefConfig prefConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordEditText = findViewById(R.id.etPassword);
        userNameEditText = findViewById(R.id.etUserName);


        prefConfig = new PrefConfig(this);

        if(prefConfig.readLoginStatus())
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        else
        {
            Toast.makeText(this, "login page", Toast.LENGTH_SHORT).show();
        }

    }
}
