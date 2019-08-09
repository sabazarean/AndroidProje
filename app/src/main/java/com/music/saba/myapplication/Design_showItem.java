package com.music.saba.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class Design_showItem extends AppCompatActivity {

    private ImageView img ;

    public void onBackPressed()
    {
        Intent AboutUsIntent = new Intent(Design_showItem.this,ContentShow.class);
        Design_showItem.this.startActivity(AboutUsIntent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_show_item);

        //Initializing the bottomNavigationView
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.back_menu:
                                Intent AboutUsIntent = new Intent(Design_showItem.this,ContentShow.class);
                                Design_showItem.this.startActivity(AboutUsIntent);
                                break;
                            case R.id.home_menu:
                                Intent Intent = new Intent(Design_showItem.this,ToolbarActivity.class);
                                Design_showItem.this.startActivity(Intent);
                                break;
                            case R.id.bookmark_menu:
                                Toast.makeText(getBaseContext(),  "This photo save in to your favourits", Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                });


        img = (ImageView)findViewById(R.id.img_main_design);
        Intent intent = getIntent();
        int image = intent.getExtras().getInt("MainImage");
        img.setImageResource(image);
    }
}
