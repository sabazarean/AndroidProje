package com.music.saba.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdOrderPage extends AppCompatActivity {

    private ImageView imagedesign , img;
    TextView tvDesign ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_order_page);

        Button button = (Button)findViewById(R.id.submitbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ContentIntent = new Intent(ThirdOrderPage.this,UserAccountActivity.class);
                ThirdOrderPage.this.startActivity(ContentIntent);
            }
        });


        ImageButton edtDesign= (ImageButton)findViewById(R.id.edtCloth);
        edtDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContentIntent = new Intent(ThirdOrderPage.this,ClothShow.class);
                ThirdOrderPage.this.startActivity(ContentIntent);
            }
        });




        TextView setOrder_clothTextView = (TextView)findViewById(R.id.setOrder_clothTextView);
        img =(ImageView)findViewById(R.id.thirdImageCloth) ;
        Intent intent2 = getIntent();
        int image2 =intent2.getExtras().getInt("ClothImage");
        img.setImageResource(image2);





    }


}
