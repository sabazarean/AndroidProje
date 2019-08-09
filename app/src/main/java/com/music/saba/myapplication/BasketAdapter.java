package com.music.saba.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Saba on 4/1/2018.
 */

public class BasketAdapter  extends RecyclerView.Adapter<BasketAdapter.MyViewHolder> {

    private Context mContex ;
    private List<BasketJava> mData ;

    public BasketAdapter(Context mContex, List<BasketJava> mData) {
        this.mContex = mContex;
        this.mData = mData;
    }

    @Override
    public BasketAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContex);
        view = mInflater.inflate(R.layout.cardview_item_basket,parent,false);
        return new BasketAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BasketAdapter.MyViewHolder holder, final int position) {
        holder.tv_design_title.setText(mData.get(position).getBasketTitle());
        holder.img_design.setImageResource(mData.get(position).getBasketImage());
        holder.cv_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContex,OrderPage.class);
                intent.putExtra("BasketImage",mData.get(position).getBasketImage());
                intent.putExtra("BasketTitle",mData.get(position).getBasketTitle());
                mContex.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_design_title ;
        ImageView img_design ;
        CardView cv_design;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_design_title =(TextView)itemView.findViewById(R.id.textViewTitleBasket);
            img_design =(ImageView) itemView.findViewById(R.id.imageViewBasket);
            cv_design=(CardView)itemView.findViewById(R.id.cardView_basket_id);

        }
    }
}
