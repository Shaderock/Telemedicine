package com.example.telemedicine.Interfaces;

import com.example.telemedicine.models.Doctor;

import java.util.ArrayList;

public interface IHttpRequestSender
{
    void onRegSuccess();
    void onRegFailure();
    void onLoginSuccess();
    void onLoginFailure();
    void onGetDocListSuccess(ArrayList <Doctor> doctors);
    void onUserConsultationRequestSuccess();
    void onUserConsultationRequestFailure();
}
