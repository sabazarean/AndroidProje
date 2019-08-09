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
 * Created by Saba on 3/31/2018.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.MyViewHolder> {

    private Context mContex ;
    private List<DesignJava> mData ;

    public ContentAdapter(Context mContex, List<DesignJava> mData) {
        this.mContex = mContex;
        this.mData = mData;
    }

    @Override
    public ContentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContex);
        view = mInflater.inflate(R.layout.cardview_item_design,parent,false);
        return new ContentAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentAdapter.MyViewHolder holder, final int position) {
        holder.tv_design_title.setText(mData.get(position).getTitle());
        holder.img_design.setImageResource(mData.get(position).getImage());
        holder.cv_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContex,Design_showItem.class);
                intent.putExtra("MainImage",mData.get(position).getMainImage());
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
            tv_design_title =(TextView)itemView.findViewById(R.id.design_title_id);
            img_design =(ImageView) itemView.findViewById(R.id.desig_img_id);
            cv_design=(CardView)itemView.findViewById(R.id.cardView_design_id);

        }
    }
}
