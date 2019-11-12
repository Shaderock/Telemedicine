package com.example.telemedicine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity
{
    private Toolbar toolbar;
    private TextView toolbar_title, name, desease,
            location, description;
    private EditText nameInput, deseaseInput,
            locationInput, descriptionInput;
    private Button request;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        toolbar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);

        name = findViewById(R.id.name);
        desease = findViewById(R.id.desease);
        location = findViewById(R.id.location);
        description = findViewById(R.id.description);

        nameInput = findViewById(R.id.nameInput);
        deseaseInput = findViewById(R.id.deseaseInput);
        locationInput = findViewById(R.id.locationInput);
        descriptionInput = findViewById(R.id.descriptionInput);

        request = findViewById(R.id.request);

        toolbar.setNavigationIcon(R.drawable.ic_more_horiz_white_24dp);

        setFonts();
    }

    private void setFonts()
    {
        Typeface proximanova_regular = Typeface.createFromAsset(getAssets(),
                "fonts/proximanova-regular.otf");
        Typeface proximanova_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/proximanova-semibold.otf");
        toolbar_title.setTypeface(proximanova_semibold);
        name.setTypeface(proximanova_semibold);
        desease.setTypeface(proximanova_semibold);
        location.setTypeface(proximanova_semibold);
        description.setTypeface(proximanova_semibold);

        nameInput.setTypeface(proximanova_regular);
        deseaseInput.setTypeface(proximanova_regular);
        locationInput.setTypeface(proximanova_regular);
        descriptionInput.setTypeface(proximanova_regular);

        request.setTypeface(proximanova_semibold);
    }
}
