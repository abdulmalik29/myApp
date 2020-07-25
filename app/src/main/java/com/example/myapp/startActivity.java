package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class startActivity extends AppCompatActivity implements loginFragment.OnLoginFormActivityListener
{
    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        prefConfig = new PrefConfig(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

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

    @Override
    public void performRegister()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new registerFragment()).addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String name)
    {

    }
}