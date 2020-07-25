package com.example.myapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registerFragment extends Fragment
{

    private EditText nameEditText, emailEditText, passwordEditText;
    private Button registerButton;

    private TextView loginTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);

        nameEditText = view.findViewById(R.id.nameTXT);
        emailEditText = view.findViewById(R.id.emailEtxt);
        passwordEditText = view.findViewById(R.id.passwordTXT);
        registerButton = view.findViewById(R.id.registerBTN);

        registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                performRegistration1();
            }
        });
        return view;
    }


    public void performRegistration1()
    {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Call<User> call = startActivity.apiInterface.performRegistration(name, email, password);

        call.enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {
                if (response.body().getResponse().equals("ok"))
                {
                    startActivity.prefConfig.displayToast("Account Created");

                }
                else if (response.body().getResponse().equals("exist"))
                {
                    startActivity.prefConfig.displayToast("User already exist");
                }
                else
                {
                    startActivity.prefConfig.displayToast("Something went wrong...");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t)
            {

            }
        });
        nameEditText.setText("");
        emailEditText.setText("");
        passwordEditText.setText("");
    }
}