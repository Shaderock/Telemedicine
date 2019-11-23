package com.example.telemedicine.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.telemedicine.Interfaces.CardOnClickListener;
import com.example.telemedicine.Interfaces.IHomeFragment;
import com.example.telemedicine.fragments_home_screen.DoctorDetailsFragment;
import com.example.telemedicine.fragments_home_screen.HomeFragment;
import com.example.telemedicine.R;
import com.example.telemedicine.fragments_home_screen.NotificationFragment;
import com.example.telemedicine.fragments_home_screen.RequestFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeScreen extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        FloatingActionButton.OnClickListener, IHomeFragment
{
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private EditText nameInput, deseaseInput,
            locationInput, descriptionInput;
    private Button request;
    private BadgeDrawable badgeDrawable;
    private int menuItemId;
    private BottomNavigationView navigation;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        replaceToHomeFragment();

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        nameInput = findViewById(R.id.nameOutput);
        deseaseInput = findViewById(R.id.deseaseInput);
        locationInput = findViewById(R.id.locationInput);
        descriptionInput = findViewById(R.id.descriptionInput);

        request = findViewById(R.id.request);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        setBadge();
    }

    private void replaceToHomeFragment()
    {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setiHomeFragment(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, homeFragment).commit();
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
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new NotificationFragment()).commit();
                break;
            case R.id.home:
                replaceToHomeFragment();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.fab:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new RequestFragment()).commit();
                break;
        }
    }

    @Override
    public void onCardClick()
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new DoctorDetailsFragment()).commit();
    }
}
