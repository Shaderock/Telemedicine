package com.example.telemedicine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreen extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener
{
    private Toolbar toolbar;
    private EditText nameInput, deseaseInput,
            locationInput, descriptionInput;
    private Button request;
    private BadgeDrawable badgeDrawable;
    private int menuItemId;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new RequestFragment()).commit();

        toolbar = findViewById(R.id.toolbar);

        nameInput = findViewById(R.id.nameInput);
        deseaseInput = findViewById(R.id.deseaseInput);
        locationInput = findViewById(R.id.locationInput);
        descriptionInput = findViewById(R.id.descriptionInput);

        request = findViewById(R.id.request);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        setBadge();
    }

    public void setBadge()
    {
        menuItemId = navigation.getMenu().getItem(1).getItemId();  //0 menu item index.
        badgeDrawable = navigation.getOrCreateBadge(menuItemId);
        badgeDrawable.setVisible(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.notification:
                break;
            case R.id.home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new HomeFragment()).commit();
                toolbar = findViewById(R.id.toolbar);
//                toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
//                toolbar.setNavigationOnClickListener(new View.OnClickListener()
//                {
//                    @Override
//                    public void onClick(View v)
//                    {
//                        onBackPressed();
//                    }
//                });
                break;
        }
        return true;
    }
}
