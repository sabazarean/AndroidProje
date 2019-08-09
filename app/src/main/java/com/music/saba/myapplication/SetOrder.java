package com.music.saba.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SetOrder extends AppCompatActivity {
    private ImageView imagedesign , img;
    TextView tvDesign ;
    Button edtDesign ;

    ViewPager viewPager;
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_order);


        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapterCloth ViewPagerAdapterCloth = new ViewPagerAdapterCloth(this);

        viewPager.setAdapter(ViewPagerAdapterCloth);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);


        ImageButton edtDesign= (ImageButton)findViewById(R.id.edtDesign);
        edtDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContentIntent = new Intent(SetOrder.this,Designs.class);
                SetOrder.this.startActivity(ContentIntent);
            }
        });


        CardView cvCloth = (CardView)findViewById(R.id.cardViewClothsetOrder);
        CardView cvdesign = (CardView)findViewById(R.id.cardViewDesignsetOrder);

        imagedesign =(ImageView)findViewById(R.id.setOrderImageDeisign) ;
        Intent intent2 = getIntent();
        int image1 =intent2.getExtras().getInt("ImageSetOrder");
        imagedesign.setImageResource(image1);

        cvdesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogBox();
            }
        });



        cvCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent clothIntent = new Intent(SetOrder.this, ClothShow.class);
                startActivity(clothIntent);
            }
        });


//        img = (ImageView)findViewById(R.id.imgCloth_setOrder);
//        Intent intent = getIntent();
//        int image =intent.getExtras().getInt("ClothImage");
//        img.setImageResource(image);


    }


    public void dialogBox() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("لطفا لباس مورد نظر خود را انتخاب کنید");
        alertDialogBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            SetOrder.this.runOnUiThread(new Runnable() {
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
