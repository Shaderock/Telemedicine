package com.example.telemedicine.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.telemedicine.Interfaces.IHomeFragment;
import com.example.telemedicine.fragments_home_screen.DoctorDetailsFragment;
import com.example.telemedicine.fragments_home_screen.HomeFragment;
import com.example.telemedicine.R;
import com.example.telemedicine.fragments_home_screen.NotificationFragment;
import com.example.telemedicine.fragments_home_screen.RequestFragment;
import com.example.telemedicine.models.Doctor;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeScreen extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        FloatingActionButton.OnClickListener, IHomeFragment
{

    private BadgeDrawable badgeDrawable;
    private int menuItemId;
    private BottomNavigationView navigation;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        replaceToHomeFragment();

        fab = findViewById(R.id.fab_request);
        fab.setOnClickListener(this);

        navigation = findViewById(R.id.bnv_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        setBadge();
    }

    private void replaceToHomeFragment()
    {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setIHomeFragment(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_fragment_container, homeFragment).commit();
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
                        .replace(R.id.FL_fragment_container, new NotificationFragment()).commit();
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
            case R.id.fab_request:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FL_fragment_container, new RequestFragment()).commit();
                break;
        }
    }

    @Override
    public void onCardClick(Doctor doctor)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FL_fragment_container, new DoctorDetailsFragment()).commit();
    }
}
