package com.example.telemedicine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SignupScreen extends AppCompatActivity
{
    private Button addPhotos;
    private Toolbar toolbar;
    private TextView toolbar_title, fullName,
            birthday, email, phoneNumber, location;
    private EditText fullNameInput, birthdayInput,
            emailInput, phoneNumberInput, locationInput;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        toolbar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);

        addPhotos = findViewById(R.id.addPhotosBtn);
        fullName = findViewById(R.id.fullName);
        birthday = findViewById(R.id.birthday);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);
        location = findViewById(R.id.location);

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
        setFonts();
    }

    @Override
    protected void onStart()
    {
        super.onStart();


    }

    private void setFonts()
    {
        Typeface proximanova_regular = Typeface.createFromAsset(getAssets(),
                "fonts/proximanova-regular.otf");
        Typeface proximanova_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/proximanova-semibold.otf");
        toolbar_title.setTypeface(proximanova_semibold);

        addPhotos.setTypeface(proximanova_regular);

        fullName.setTypeface(proximanova_semibold);
        birthday.setTypeface(proximanova_semibold);
        email.setTypeface(proximanova_semibold);
        phoneNumber.setTypeface(proximanova_semibold);
        location.setTypeface(proximanova_semibold);

        fullNameInput.setTypeface(proximanova_regular);
        birthdayInput.setTypeface(proximanova_regular);
        emailInput.setTypeface(proximanova_regular);
        phoneNumberInput.setTypeface(proximanova_regular);
        locationInput.setTypeface(proximanova_regular);

        next.setTypeface(proximanova_semibold);
    }
}
