package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registerActivity extends AppCompatActivity
{
    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton;
    private String email, password, confirmPassword, passwordRegx, emailRegx;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        registerButton = findViewById(R.id.registerButton);
        emailEditText = findViewById(R.id.emailEtxt);
        passwordEditText = findViewById(R.id.passwordEtxt);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordETXT);
        progressBar = findViewById(R.id.progressBar);

        if (auth.getCurrentUser() != null)
        {
            startActivity(new Intent(registerActivity.this, MainActivity.class));
            finish();
        }



        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (checkInput())
                {

                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener
                            (registerActivity.this, new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(registerActivity.this, "Registration failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else
                                {
                                    progressBar.setVisibility(View.VISIBLE);
                                    startActivity(new Intent(registerActivity.this, MainActivity.class));
                                    finish();
                                    Toast.makeText(registerActivity.this, "Welcome",
                                            Toast.LENGTH_SHORT).show();


                                }
                        }
                    });

                }
                else
                    {
                        Toast.makeText(registerActivity.this, "Something went wrong",
                                Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }


    private boolean checkInput()
    {
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        confirmPassword = confirmPasswordEditText.getText().toString();
        passwordRegx = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        emailRegx = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" ;

        Pattern passPattern = Pattern.compile(passwordRegx );
        Matcher passMatcher = passPattern.matcher(password);

        Pattern emailPattern = Pattern.compile(emailRegx);
        Matcher emailMatcher = passPattern.matcher(email);



        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword))
        {
            Toast.makeText(registerActivity.this, "You must fill in all the information",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
//        else if (!(emailMatcher.find()))
//        {
//            emailEditText.setError("Invalid email");
//            passwordEditText.requestFocus();
//            return false;
//        }
        else if (password.length() < 7)
        {
            passwordEditText.setError("Password too short");
            passwordEditText.requestFocus();
            return false;

        }
        else if(!(password.equals(confirmPassword)))
        {
            confirmPasswordEditText.setError("Passwords are not identical");
            confirmPasswordEditText.requestFocus();
            return false;

        }
        else if (!(passMatcher.find()))
        {
            passwordEditText.setError("Password must contain numbers and characters");
            passwordEditText.requestFocus();
            return false;
        }

        return true;
    }


}