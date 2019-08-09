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
 * Created by Saba on 3/29/2018.
 */

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.MyViewHolder> {

    private Context mContex ;
    private List<DesignJava> mData ;

    public DesignAdapter(Context mContex, List<DesignJava> mData) {
        this.mContex = mContex;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContex);
        view = mInflater.inflate(R.layout.cardview_item_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_design_title.setText(mData.get(position).getTitle());
        holder.img_design.setImageResource(mData.get(position).getImage());
        holder.cv_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContex,Design_showItem.class);

                intent.putExtra("Title",mData.get(position).getTitle());
                mContex.startActivity(intent);
            }
        });

        holder.cv_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContex,SetOrder.class);
                intent.putExtra("ImageSetOrder",mData.get(position).getImage());
                intent.putExtra("MainImage",mData.get(position).getMainImage());
                intent.putExtra("Title",mData.get(position).getTitle());
                mContex.startActivity(intent);

                Intent intent1 = new Intent(mContex,ShellSilver.class);
                intent1.putExtra("ImageThirdOrderrr",mData.get(position).getImage());
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
