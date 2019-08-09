package com.music.saba.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Basket extends AppCompatActivity {

        private ImageView img ;
        private TextView titleb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        img = (ImageView)findViewById(R.id.imageViewBasket);
        titleb =(TextView)findViewById(R.id.textViewTitleBasket);
    }
}
