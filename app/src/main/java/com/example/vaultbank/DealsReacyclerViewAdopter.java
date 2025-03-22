package com.example.vaultbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DealsReacyclerViewAdopter extends RecyclerView.Adapter<DealsReacyclerViewAdopter.DealsViewHolder>
{
    Context context;
    ArrayList<DealsModel> dealsModels;
    public DealsReacyclerViewAdopter(Context context, ArrayList<DealsModel> dealsModels)
    {
        this.context =context;
        this.dealsModels = dealsModels;
    }
    @NonNull
    @Override
    public DealsReacyclerViewAdopter.DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.deals_layout_container,parent,false);
        return new DealsReacyclerViewAdopter.DealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsReacyclerViewAdopter.DealsViewHolder holder, int position) {
        holder.dealsTitle.setText(dealsModels.get(position).getDealTitle());
        holder.dealsImage.setImageResource(dealsModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dealsModels.size();
    }

    public static class DealsViewHolder extends RecyclerView.ViewHolder{
        ImageView dealsImage;
        TextView dealsTitle;
        public DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            dealsImage = itemView.findViewById(R.id.img_deals);
            dealsTitle = itemView.findViewById(R.id.lbl_dealsTitle);
        }
    }
}
