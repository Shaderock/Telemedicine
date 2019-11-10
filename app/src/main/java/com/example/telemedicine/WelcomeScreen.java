package com.example.telemedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity
{
    private TextView welcome, quote, urgent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        welcome = findViewById(R.id.welcome);
        quote = findViewById(R.id.quote);
        urgent = findViewById(R.id.urgent);
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
    }
}
