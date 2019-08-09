package com.music.saba.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContentShow extends AppCompatActivity {
    List<DesignJava> listDesign;

    public void onBackPressed()
    {
        Intent AboutUsIntent = new Intent(ContentShow.this,ToolbarActivity.class);
        ContentShow.this.startActivity(AboutUsIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_show);


        listDesign = new ArrayList<>();
        listDesign.add(new DesignJava("Falling Up", R.drawable.nnn, R.drawable.img1));
        listDesign.add(new DesignJava("Overdues", R.drawable.c2, R.drawable.img1));
        listDesign.add(new DesignJava("Batty", R.drawable.c3, R.drawable.img1));
        listDesign.add(new DesignJava("Its Dark in here", R.drawable.c4, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("Masks", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("Dancing Pants", R.drawable.c6, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("Diving Board", R.drawable.c7, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("The Land Of Happy", R.drawable.c8, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("Carrots", R.drawable.c9, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("Something Missing", R.drawable.c10, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("How not Have to...", R.drawable.c11, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));
        listDesign.add(new DesignJava("title1", R.drawable.c5, R.drawable.about_icon_email));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView_content_id);
        ContentAdapter myAdapter = new ContentAdapter(this, listDesign);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);
    }
}
