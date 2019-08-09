package com.music.saba.myapplication;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class OrderPage extends AppCompatActivity {

    ViewPager viewPager;
    private ImageView imagedesign , img;
    TextView tvDesign ;

    public void onBackPressed()
    {
        Intent AboutUsIntent = new Intent(OrderPage.this,ToolbarActivity.class);
        OrderPage.this.startActivity(AboutUsIntent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.back_menu:
                                Intent AboutUsIntent = new Intent(OrderPage.this,ToolbarActivity.class);
                                OrderPage.this.startActivity(AboutUsIntent);
                                break;
                            case R.id.home_menu:
                                Intent Intent = new Intent(OrderPage.this,ToolbarActivity.class);
                                OrderPage.this.startActivity(Intent);
                                break;

                        }
                        return false;
                    }
                });


        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);


        CardView cvCloth =(CardView)findViewById(R.id.cardViewDesignOrderPage);

        cvCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clothIntent = new Intent(OrderPage.this, Designs.class);
                startActivity(clothIntent);
            }
        });


    }


    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            OrderPage.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }

                    else  viewPager.setCurrentItem(0);
                }
            });

        }
    }

}
