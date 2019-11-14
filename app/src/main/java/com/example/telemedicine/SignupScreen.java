package com.example.telemedicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class SignupScreen extends AppCompatActivity
{
    private Button addPhotos;
    private Toolbar toolbar;
    private EditText fullNameInput, birthdayInput,
            emailInput, phoneNumberInput, locationInput;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        toolbar = findViewById(R.id.toolbar);

        addPhotos = findViewById(R.id.addPhotosBtn);

        fullNameInput = findViewById(R.id.fullNameInput);
        birthdayInput = findViewById(R.id.birthdayInput);
        emailInput = findViewById(R.id.emailInput);
        phoneNumberInput = findViewById(R.id.phoneNumberInput);
        locationInput = findViewById(R.id.locationInput);

        next = findViewById(R.id.nextBtn);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new
                        Intent(SignupScreen.this, WelcomeScreen.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finishAffinity();
            }
        });
    }
}
