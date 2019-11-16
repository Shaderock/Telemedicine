package com.example.telemedicine.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Doctor implements Parcelable
{
    private String name;
    private float rating;
    private String specialty;
    private String address;

    public Doctor(String name, float rating, String specialty, String address)
    {
        this.name = name;
        this.rating = rating;
        this.specialty = specialty;
        this.address = address;
    }

    public Doctor()
    {

    }

    protected Doctor(Parcel in)
    {
        name = in.readString();
        rating = in.readFloat();
        specialty = in.readString();
        address = in.readString();
    }

    public static final Creator<Doctor> CREATOR = new Creator<Doctor>()
    {
        @Override
        public Doctor createFromParcel(Parcel in)
        {
            return new Doctor(in);
        }

        @Override
        public Doctor[] newArray(int size)
        {
            return new Doctor[size];
        }
    };

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getSpecialty()
    {
        return specialty;
    }

    public void setSpecialty(String specialty)
    {
        this.specialty = specialty;
    }

    public float getRating()
    {
        return rating;
    }

    public void setRating(float rating)
    {
        this.rating = rating;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeFloat(rating);
        dest.writeString(specialty);
        dest.writeString(address);
    }
}
