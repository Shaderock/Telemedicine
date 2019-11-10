package com.example.telemedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity
{
    private TextView welcome, quote, urgent;
    private Button loginBtn, signUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        welcome = findViewById(R.id.welcome);
        quote = findViewById(R.id.quote);
        urgent = findViewById(R.id.urgent);
        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.signUpBtn);

        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(WelcomeScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(WelcomeScreen.this, SignupScreen.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        setFonts();
    }

    private void setFonts()
    {
        Typeface proximanova_regular = Typeface.createFromAsset(getAssets(),
                "fonts/proximanova-regular.otf");
        Typeface proximanova_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/proximanova-semibold.otf");
        welcome.setTypeface(proximanova_semibold);
        quote.setTypeface(proximanova_regular);
        urgent.setTypeface(proximanova_semibold);
        loginBtn.setTypeface(proximanova_semibold);
        signUpBtn.setTypeface(proximanova_semibold);
    }
}
