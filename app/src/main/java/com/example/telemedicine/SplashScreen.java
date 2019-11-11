package com.example.telemedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        loadApp();
    }

    private void loadApp()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashScreen.this, WelcomeScreen.class);
                startActivity(intent);
                finishAffinity();
            }
        }, 1000);
    }
}
