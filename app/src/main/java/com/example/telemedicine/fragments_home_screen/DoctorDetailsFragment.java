package com.example.telemedicine.fragments_home_screen;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telemedicine.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorDetailsFragment extends Fragment
{


    public DoctorDetailsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_details, container, false);
    }

}
