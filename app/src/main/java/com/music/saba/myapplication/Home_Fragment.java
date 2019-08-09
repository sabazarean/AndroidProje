package com.music.saba.myapplication;

/**
 * Created by Saba on 4/19/2018.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.music.saba.myapplication.R;

public class Home_Fragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);


        ImageButton exitBtn =(ImageButton)view.findViewById(R.id.exiBtn);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(getActivity(),LoginActivity.class);
                getActivity().startActivity(loginintent);
            }
        });

        Button BtnContent= (Button)view.findViewById(R.id.button2);
        BtnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContentIntent = new Intent(getActivity(),ContentShow.class);
                getActivity().startActivity(ContentIntent);
            }
        });

        Button BtnAboutUs =(Button)view.findViewById(R.id.button6);
        BtnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AboutUsIntent = new Intent(getActivity(),AboutUsActivity.class);
                getActivity().startActivity(AboutUsIntent);
            }
        });

        Button btnPaint =(Button)view.findViewById(R.id.button4);
        btnPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paintIntent = new Intent(getActivity(),Pallet.class);
                getActivity().startActivity(paintIntent);
            }
        });


        Button btnShell =(Button)view.findViewById(R.id.button3);
        btnShell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paintIntent = new Intent(getActivity(),ShellSilver.class);
                getActivity().startActivity(paintIntent);
            }
        });

        Button btnChose =(Button)view.findViewById(R.id.button5);
        btnChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent choseIntent = new Intent(getActivity(),
                        OrderPage.class);
                getActivity().startActivity(choseIntent);
            }
        });

        ImageButton exit =(ImageButton)view.findViewById(R.id.exiBtn);
        final Fragment me=this ;
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent choseIntent = new Intent(getActivity(),
                        LoginActivity.class);
                getActivity().startActivity(choseIntent);
            }
        });


        return view;
    }


}