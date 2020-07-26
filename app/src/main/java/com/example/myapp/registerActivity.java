package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity
{
    private EditText nameEditText, emailEditText, passwordEditText;
    private Button registerButton;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerButton = findViewById(R.id.registerButton);
        emailEditText = findViewById(R.id.emailEtxt);
        passwordEditText = findViewById(R.id.passwordEtxt);




        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password))
                {
                    Toast.makeText(registerActivity.this, "You must fill all the information",
                            Toast.LENGTH_SHORT).show();
                }
                else if (password.length() < 7)
                {
                    Toast.makeText(registerActivity.this, "Password too short",
                            Toast.LENGTH_SHORT).show();
                }
                else
                    {
                            performRegister(email, password);
                    }

            }
        });
    }

    private void performRegister(String Email, String Password)
    {
        auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener
                (registerActivity.this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    Toast.makeText(registerActivity.this, "Account created",
                            Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        Toast.makeText(registerActivity.this, "Registration error",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

}