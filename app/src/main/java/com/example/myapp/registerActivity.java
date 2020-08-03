package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registerActivity extends AppCompatActivity
{
    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton;
    private String email, password, confirmPassword, passwordRegx, emailRegx, name;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

//    private DB_Sqlite db = new DB_Sqlite(this);
//    public  User user;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButton = findViewById(R.id.registerButton);
        nameEditText = findViewById(R.id.nameEtxt);
        emailEditText = findViewById(R.id.emailEtxt);
        passwordEditText = findViewById(R.id.passwordEtxt);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordETXT);
        progressBar = findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Tools.Keyboard.hide(registerActivity.this);


                if (checkInput())
                {
                    progressBar.setVisibility(View.VISIBLE);
//                    Toast.makeText(registerActivity.this, "This may take a while",
//                            Toast.LENGTH_SHORT).show();

                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener
                            (registerActivity.this, new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(task.isSuccessful())
                            {
//                                user = new User(auth.getUid(), name, email, 0.0);
//                                boolean isAdded = db.addUser(user);
                                Toast.makeText(registerActivity.this, "Welcome " + name,
                                        Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(registerActivity.this, MainActivity.class));
                                finish();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                            else
                            {
                                progressBar.setVisibility(View.INVISIBLE);
                                String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                                switch (errorCode)
                                {
                                case "ERROR_INVALID_CREDENTIAL":
                                    emailEditText.setError("Invalid credential");
                                    emailEditText.requestFocus();
                                    break;

                                case "ERROR_INVALID_EMAIL":
                                    emailEditText.setError("Email is badly formatted ");
                                    emailEditText.requestFocus();
                                    break;

                                case "ERROR_EMAIL_ALREADY_IN_USE":
                                    emailEditText.setError("Email is is already in use by another account ");
                                    emailEditText.requestFocus();
                                    break;
                                }
//                                Toast.makeText(registerActivity.this, "Registration failed: "
//                                        + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
        name = nameEditText.getText().toString();
        email = emailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        confirmPassword = confirmPasswordEditText.getText().toString();

        passwordRegx = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        emailRegx = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        Pattern passPattern = Pattern.compile(passwordRegx );
        Matcher passMatcher = passPattern.matcher(password);

        Pattern emailPattern = Pattern.compile(emailRegx);
        Matcher emailMatcher = passPattern.matcher(email);



        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword) || TextUtils.isEmpty(name))
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


    public void onClick(View view)
    {
        startActivity(new Intent(registerActivity.this, loginActivity.class));
        finish();
    }

}