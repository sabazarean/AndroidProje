package com.music.saba.myapplication;

/**
 * Created by Saba on 4/19/2018.
 */


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class UserAccount_Fragment extends Fragment{

    SharedPreferences sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(G.context);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.activity_toolbar3, container,false);

        EditText nametxt =(EditText)view.findViewById(R.id.fullName);
        EditText emailtxt =(EditText)view.findViewById(R.id.userEmailId);
        EditText mobileNumber =(EditText)view.findViewById(R.id.mobileNumber);
        EditText location =(EditText)view.findViewById(R.id.location);
        EditText city =(EditText)view.findViewById(R.id.city);
        EditText post_code =(EditText)view.findViewById(R.id.post_code);
        EditText address =(EditText)view.findViewById(R.id.address);
        Button submitInfoBtn =(Button) view.findViewById(R.id.submitInfoBtn);

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(G.context);
        String email = sharedPreferences.getString("email", "No name defined");//"No name defined" is the default value.
        String name = sharedPreferences.getString("name", "No name defined");//"No name defined" is the default value.
        int id = sharedPreferences.getInt("id", 0); //0 is the default value.
        if (id != 0) {
            nametxt.setText(name);
            emailtxt.setText(email);


        }



        return view;
    }


    private static final String JSON_URL = "http://dimia.ir/api/createUserProfile";

    private void CreatProfile(final String name, final String city, final String address , final String province , final int phone_number , final BigInteger post_code) {
        StringRequest postRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("LOG",""+response);

                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getString("status").equals("false")) {
                                Toast.makeText(getContext(), "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                Log.d("Response", "" + jsonObject.getString("message"));
                            }

                            else {
                                JSONObject jsonUser = new JSONObject(jsonObject.getString("user"));
                                editor.putString("city", jsonUser.getString("city"));
                                editor.putString("name", jsonUser.getString("name"));
                                editor.putString("address", jsonUser.getString("name"));
                                editor.putString("province", jsonUser.getString("province"));
                                editor.putInt("phone_number",jsonUser.getInt("phone_number"));
                                editor.putInt("post_code",jsonUser.getInt("post_code"));
                                editor.putInt("id",jsonUser.getInt("id"));
                                editor.apply();

                                Toast.makeText(getContext(), "شما با موفقیت عضو شدید", Toast.LENGTH_SHORT).show();
                                Intent loginIntent = new Intent(getActivity(), ToolbarActivity.class);
                                getActivity().startActivity(loginIntent);
                            }

                            Log.d("Response", "" + jsonObject.getString("status"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", "" + error.getMessage());
                    }
                }
        )

        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name",name);
                params.put("city", city);
                params.put("province", province);
//                params.put("phone_number", phone_number);
//                params.put("post_code", post_code);
                params.put("address", address);
                return params;
            }
        };

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        //adding the string request to request queue
        requestQueue.add(postRequest);
    }



}
