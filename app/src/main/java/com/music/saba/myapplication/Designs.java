package com.music.saba.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Designs extends AppCompatActivity {

    List<DesignJava> listDesign;

    public void onBackPressed()
    {
        Intent AboutUsIntent = new Intent(Designs.this,OrderPage.class);
        Designs.this.startActivity(AboutUsIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designs);

//        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.back_menu:
//                                Intent AboutUsIntent = new Intent(Designs.this,OrderPage.class);
//                                Designs.this.startActivity(AboutUsIntent);
//                                break;
//                            case R.id.home_menu:
//                                Intent Intent = new Intent(Designs.this,ToolbarActivity.class);
//                                Designs.this.startActivity(Intent);
//                                break;
//                            case R.id.bookmark_menu:
//                                Toast.makeText(getBaseContext(),  "This photo save in to your favourits", Toast.LENGTH_LONG).show();
//                                break;
//                        }
//                        return false;
//                    }
//                });


        listDesign = new ArrayList<>();
        listDesign.add(new DesignJava("Falling Up",
                R.drawable.nnn,
                R.drawable.about_icon_email));
        listDesign.add(new DesignJava("Overdues", R.drawable.c2, R.drawable.img1));
        listDesign.add(new DesignJava("Batty", R.drawable.c3, R.drawable.des5));
        listDesign.add(new DesignJava("Its Dark in here", R.drawable.c4, R.drawable.des2));
        listDesign.add(new DesignJava("Masks", R.drawable.c5, R.drawable.des3));
        listDesign.add(new DesignJava("Dancing Pants", R.drawable.c6, R.drawable.des5));
        listDesign.add(new DesignJava("Diving Board", R.drawable.c7, R.drawable.des4));
        listDesign.add(new DesignJava("The Land Of Happy", R.drawable.c8, R.drawable.des4));
        listDesign.add(new DesignJava("Carrots", R.drawable.c9, R.drawable.des3));
        listDesign.add(new DesignJava("Something Missing", R.drawable.c10, R.drawable.des3));
        listDesign.add(new DesignJava("How not Have to...", R.drawable.c11, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView_design_id);
        DesignAdapter myAdapter = new DesignAdapter(this, listDesign);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);

    }
}
