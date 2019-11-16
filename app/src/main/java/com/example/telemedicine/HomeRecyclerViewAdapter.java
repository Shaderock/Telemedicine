package com.example.telemedicine;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.telemedicine.models.Doctor;

import java.util.ArrayList;

public class HomeRecyclerViewAdapter extends
        RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>
{

    private Context context;
    private ArrayList<Doctor> doctors;

    public HomeRecyclerViewAdapter(Context context, ArrayList<Doctor> doctors)
    {
        this.context = context;
        this.doctors = doctors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.d("log", "onCreateViewHolder");

        View view = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.layout_doctor_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {
        Log.d("log", "onBindViewHolder");

        holder.name.setText(doctors.get(position).getName());
        holder.rating.setText(String.valueOf(doctors.get(position).getRating()));
        holder.specialty.setText(doctors.get(position).getSpecialty());
        holder.address.setText(doctors.get(position).getAddress());

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context).
                load(R.drawable.avatar)
                .apply(requestOptions)
                .into(holder.avatar);

        holder.doctorCard.setOnClickListener(new CardView.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("log", "onClick: clicked on: " +
                        doctors.get(position).getName() +
                        " position " + position);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return doctors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView avatar, star;
        public TextView name, rating;

        public TextView specialty;

        public ImageView icon;
        public TextView address;

        public CardView doctorCard;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            star = itemView.findViewById(R.id.star);
            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            specialty = itemView.findViewById(R.id.specialty);
            icon = itemView.findViewById(R.id.icon);
            address = itemView.findViewById(R.id.address);
            doctorCard = itemView.findViewById(R.id.doctorCard);
        }
    }
}
