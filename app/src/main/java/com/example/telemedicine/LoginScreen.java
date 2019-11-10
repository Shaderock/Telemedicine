package com.example.telemedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity
{
    private EditText emailInput, passwordInput;
    private Button loginBtn, signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);
        emailInput = findViewById(R.id.emailEditText);
        passwordInput = findViewById(R.id.passwordEditText);
        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.signUpBtn);
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

        emailInput.setTypeface(proximanova_regular);
        passwordInput.setTypeface(proximanova_regular);
        loginBtn.setTypeface(proximanova_semibold);
        signUpBtn.setTypeface(proximanova_semibold);
    }
}
