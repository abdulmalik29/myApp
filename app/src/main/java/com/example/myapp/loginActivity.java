package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity
{
    EditText passwordEditText, userNameEditText;
    Button logingButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordEditText = findViewById(R.id.etPassword);
        userNameEditText = findViewById(R.id.etUserName);
    }
    public void onLoginClick(View view)
    {
        String password = passwordEditText.getText().toString(); // gets the password in a variable
        String username = userNameEditText.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }
}