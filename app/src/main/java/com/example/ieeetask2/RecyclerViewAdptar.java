package com.example.ieeetask2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdptar extends RecyclerView.Adapter<RecyclerViewAdptar.FoodViewHolder> {

    ArrayList<food> foods;

    public RecyclerViewAdptar(ArrayList<food> foods) {
        this.foods = foods;
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v=   LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,null,false);
        FoodViewHolder viewHolder=new FoodViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        food f=foods.get(position);
        holder.tv.setText(f.getText());
        holder.img.setImageResource(f.getImg());


    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class FoodViewHolder  extends RecyclerView.ViewHolder{

        TextView tv;
        ImageView img;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.textView2);
            img=itemView.findViewById(R.id.imageView2);
        }
    }




}
