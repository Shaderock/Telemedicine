package com.example.telemedicine.fragments_home_screen;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import com.example.telemedicine.HomeRecyclerViewAdapter;
import com.example.telemedicine.Interfaces.CardOnClickListener;
import com.example.telemedicine.Interfaces.IHomeFragment;
import com.example.telemedicine.R;
import com.example.telemedicine.models.Doctor;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements CardOnClickListener
{

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private HomeRecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private IHomeFragment iHomeFragment;

    public HomeFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.d("log", "HomeFragment: onCreateView");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.doctorList);

        getDoctors();
        if (recyclerViewAdapter == null)
        {
            initRecyclerView();
        }
        return view;
    }

    private void getDoctors()
    {
        if (doctors != null)
        {
            doctors.clear();
            for (int i = 0; i < 7; i++)
            {
                doctors.add(new Doctor("Dudung Sokmati",
                        4.3f, "Eye Specialist",
                        "St.Bronxlyn 212"));
            }
        }
    }

    private void initRecyclerView()
    {
        Log.d("log", "initRecyclerView: init recyclerView.");
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new HomeRecyclerViewAdapter(getActivity(), doctors);
        recyclerViewAdapter.setCardOnClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onClick()
    {
        if (iHomeFragment != null)
        {
            iHomeFragment.onCardClick();
        }
    }

    public void setiHomeFragment(IHomeFragment iHomeFragment)
    {
        this.iHomeFragment = iHomeFragment;
    }
}
