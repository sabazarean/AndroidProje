package com.music.saba.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Indent extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent);


        CardView cvDesign = (CardView) findViewById(R.id.cardViewDesignIntent);
        CardView cvCloth = (CardView) findViewById(R.id.cardViewClothIntent);


        cvDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clothIntent = new Intent(Indent.this, Designs.class);
                startActivity(clothIntent);
            }
        });

        cvCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clothIntent = new Intent(Indent.this, ClothShow.class);
                startActivity(clothIntent);
            }
        });
    }

}

