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

public class IndentAdapter extends RecyclerView.Adapter<IndentAdapter.MyViewHolder> {

    private Context mContex;
    private List<IndentJava> mData;

    public IndentAdapter(Context mContex, List<IndentJava> mData) {
        this.mContex = mContex;
        this.mData = mData;
    }

    @Override
    public IndentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContex);
        view = mInflater.inflate(R.layout.cardview_item_indent, parent, false);
        return new IndentAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IndentAdapter.MyViewHolder holder, final int position) {

        holder.IndentImageDsing.setImageResource(mData.get(position).getIndentImageDsing());
        holder.IndentIamgeCloth.setImageResource(mData.get(position).getIndentIamgeCloth());
        holder.cardViewDesignIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContex,Designs.class);
                intent.putExtra("IndentImageDsing",mData.get(position).getIndentImageDsing());
                mContex.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView IndentImageDsing ;
        ImageView IndentIamgeCloth;
        CardView cardViewDesignIntent , cardViewClothIntent;

        public MyViewHolder(View itemView) {
            super(itemView);
            IndentImageDsing = (ImageView) itemView.findViewById(R.id.imageViewDesignOrderPagee);
            IndentIamgeCloth = (ImageView) itemView.findViewById(R.id.imgClothIndent);
            cardViewDesignIntent = (CardView) itemView.findViewById(R.id.cardViewDesignIntent);
            cardViewClothIntent = (CardView) itemView.findViewById(R.id.cardViewClothIntent);

        }
    }
}
