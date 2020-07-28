package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
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

                preformLogin(email,password);
            }
        });
    }

    private void preformLogin(String email, String password)
    {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>()
        {
            @Override
            public void onSuccess(AuthResult authResult)
            {
                Toast.makeText(loginActivity.this, "Login in successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(loginActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}