package com.music.saba.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import com.music.saba.myapplication.AboutUs_Fragment;
import com.music.saba.myapplication.Messages_Fragment;
import com.music.saba.myapplication.Settings_Fragment;
import com.music.saba.myapplication.UserAccount_Fragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button BtnContent= (Button)findViewById(R.id.button2);
        Button btnChose =(Button)findViewById(R.id.button5);
        BtnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContentIntent = new Intent(MainActivity.this,ContentShow.class);
                MainActivity.this.startActivity(ContentIntent);
            }
        });

        Button BtnAboutUs =(Button)findViewById(R.id.button6);
        BtnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AboutUsIntent = new Intent(MainActivity.this,ToolbarActivity.class);
                MainActivity.this.startActivity(AboutUsIntent);
            }
        });

        Button btnPaint =(Button)findViewById(R.id.button4);
        btnPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paintIntent = new Intent(MainActivity.this,Pallet.class);
                MainActivity.this.startActivity(paintIntent);
            }
        });


        Button btnShell =(Button)findViewById(R.id.button3);
        btnShell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paintIntent = new Intent(MainActivity.this,ShellSilver.class);
                MainActivity.this.startActivity(paintIntent);
            }
        });


        btnChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent choseIntent = new Intent(MainActivity.this,
                        OrderPage.class);
                MainActivity.this.startActivity(choseIntent);
            }
        });
    }


}
