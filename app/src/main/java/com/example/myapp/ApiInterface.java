package com.example.myapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface
{

    @GET("register.php")
    Call<User>performRegistration(@Query("name") String Name, @Query("email") String Email, @Query("password") String Password);

    @GET("login.php")
    Call<User>performLogin( @Query("email") String Email, @Query("password") String Password);

}
