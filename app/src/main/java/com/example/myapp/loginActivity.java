package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity
{

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private ProgressBar progressBar;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.loginEmailEtxt);
        passwordEditText= findViewById(R.id.loginPasswordEtxt);
        loginButton = findViewById(R.id.loginBTN);
        progressBar =findViewById(R.id.progressBar2);


        auth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                progressBar.setVisibility(View.VISIBLE);
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                Tools.Keyboard.hide(loginActivity.this);

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(loginActivity.this,  new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(loginActivity.this, MainActivity.class));
                            finish();
                            Toast.makeText(loginActivity.this, "Welcome",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(loginActivity.this, "Login failed: " + task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });
    }

    public void onClick(View view)
    {
        startActivity(new Intent(loginActivity.this, registerActivity.class));
        finish();
    }
}