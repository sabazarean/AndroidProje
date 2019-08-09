package com.music.saba.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ClothShow extends AppCompatActivity {
    List<Product> productList;

    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloths);

        productList = new ArrayList<>();
        productList.add(
                new Product(
                        1,
                        "تاپ زنانه سبز نخی یقه گرد آستین حلقه ای مناسب فصل بهار و تابستان",
                        "برند: اویشو Oysho",
                        '3',
                        25000,
                        R.drawable.topgreen));
//
//        productList.add(
//                new Product(
//                        1,
//                        "تاپ بندی زنانه مشکی نخی یقه گرد آستین رکابی مناسب فصل بهار و تابستان",
//                        "برند: جو فِرش Joe Fresh",
//                        3,
//                        25000,
//                        R.drawable.topgray));

        productList.add(
                new Product(
                        1,
                        "تاپ زنانه طوسی نخی یقه گرد آستین حلقه ای مناسب فصل بهار و تابستان ",
                        "برند: آر.ان.اس RNS",
                        4.3,
                        25000,
                        R.drawable.topgray));
        productList.add(
                new Product(
                        1,
                        "تیشرت مردانه طوسی نخی یقه هفت آستین کوتاه مناسب فصل بهار و تابستان",
                        "برند: برشکا Bershka",
                        4.3,
                        25000,
                        R.drawable.shirtgraym));
        productList.add(
                new Product(
                        1,
                        "تیشرت مردانه زرد نخی یقه هفت آستین کوتاه مناسب فصل بهار و تابستان",
                        "برند: برشکا Bershka",
                        4.3,
                        25000,
                        R.drawable.shirtyellowm));
//        productList.add(
//                new Product(
//                        1,
//                        "تیشرت زنانه سفید نخی یقه هفت آستین کوتاه مناسب فصل بهار و تابستان",
//                        "برند: گاراژ Garage",
//                        4.3,
//                        25000,
//                        R.drawable.shirtwhitew));
        productList.add(
                new Product(
                        1,
                        "تیشرت مردانه نارنجی نخی یقه هفت آستین کوتاه مناسب فصل بهار و تابستان",
                        "برند: برشکا Bershka",
                        3,
                        25000,
                        R.drawable.shirtorangem));
        productList.add(
                new Product(
                        1,
                        "تی شرت زنانه مشکی یقه گرد با آستین کوتاه جنس پارجه کشی و نرم ناسب فصل بهار و تابستان",
                        "برند: اینک INC",
                        4.3,
                        25000,
                        R.drawable.shirtblackw));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclolerView_cth_id);
        ProductAdapter myAdapter = new ProductAdapter(this, productList);
        myrv.setLayoutManager(new GridLayoutManager(this, 1));
        myrv.setAdapter(myAdapter);
    }
}
