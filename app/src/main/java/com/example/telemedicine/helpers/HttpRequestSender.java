package com.example.telemedicine.helpers;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.telemedicine.Interfaces.IHttpRequestSender;
import com.example.telemedicine.models.Constants;
import com.example.telemedicine.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestSender
{
    private RequestQueue queue;
    private IHttpRequestSender iHttpRequestSender;

    public HttpRequestSender()
    {
        iHttpRequestSender = null;
    }

    public void setIHttpRequestSender(IHttpRequestSender iHttpRequestSender)
    {
        this.iHttpRequestSender = iHttpRequestSender;
    }

    public void Reg(Context context)
    {
        queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, Constants.REG_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        if (iHttpRequestSender != null)
                            iHttpRequestSender.onRegSuccess();
                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
                if (iHttpRequestSender != null)
                    iHttpRequestSender.onRegFailure();
            }
        }
        )
        {
            @Override
            public Map<String, String> getHeaders()
            {
                HashMap<String, String> headers = new HashMap<>();
                headers.put(Constants.CONTENT_TYPE, Constants.CONTENT_TYPE_VALUE);
                return headers;
            }

            @Override
            protected Map<String, String> getParams()
            {
                HashMap<String, String> params = new HashMap<>();
                params.put("FullName", User.getFullName());
                params.put("Birthday", User.getBirthday());
                params.put("Email", User.getEmail());
                params.put("Phone", User.getPhone());
                params.put("Address", User.getAddress());
                params.put("Username", User.getUsername());
                params.put("Password", User.getPassword());
                params.put("Base64Photo", User.getBase64photo());
                return params;
            }
        };

        queue.add(stringRequest);
    }

    public void Auth(Context context)
    {
        queue = Volley.newRequestQueue(context);

        HashMap<String, String> data = new HashMap<>();
        data.put("Email", User.getEmail());
        data.put("Password", User.getPassword());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST, Constants.AUTH_URL, new JSONObject(data),
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        if (iHttpRequestSender != null)
                            iHttpRequestSender.onLoginSuccess();
                        try
                        {
                            User.setToken(response.getString("Message"));
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
                if (iHttpRequestSender != null)
                    iHttpRequestSender.onLoginFailure();
            }
        }
        );

        queue.add(jsonObjectRequest);
    }

    public void UserProfile()
    {

    }

    public void DocList()
    {

    }

    public void GetDoc()
    {

    }

    public void UserRequestConsultation()
    {

    }
}
