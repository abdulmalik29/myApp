package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
    Button addAmountButton;
    EditText amountEditText;
    String amountInString, amountRegx;
    BigDecimal amountInBigDecimal;

    private DB_Sqlite db = new DB_Sqlite(this);
    FirebaseAuth auth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAmountButton = findViewById(R.id.addAmountBtn);
        amountEditText = findViewById(R.id.amountETxt);

        final LocalDate localDate = LocalDate.now();


        addAmountButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (checkInput())
                {
//                    User user = registerActivity.user;
//                    Transaction transaction = new Transaction(1, auth.getUid(), 1, amountInString, localDate.toString());
//                    boolean b = db.addUser(user);
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }


    private boolean checkInput()
    {
        amountInString =  amountEditText.getText().toString();

        amountRegx = "^(\\d*\\.*)?\\d{0,3}$";
        Pattern amountPattern = Pattern.compile(amountRegx );
        Matcher amountMatcher = amountPattern.matcher(amountInString);


        if(TextUtils.isEmpty(amountInString))
        {
            amountEditText.setError("Add amount");
            amountEditText.requestFocus();
            return false;
        }
        else if (!(amountMatcher.find()))
        {
            amountEditText.setError("Incorrect input");
            amountEditText.requestFocus();
            return false;
        }
        return true;
    }

    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity( new Intent(MainActivity.this, startupActivity.class));
        finish();
    }
}