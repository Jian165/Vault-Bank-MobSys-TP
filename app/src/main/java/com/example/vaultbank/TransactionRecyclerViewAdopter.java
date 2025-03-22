package com.example.vaultbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TransactionRecyclerViewAdopter extends RecyclerView.Adapter<TransactionRecyclerViewAdopter.TransactionViewHolder>
{
    Context context;
    ArrayList <TransactionModel> transactionModel;
   public TransactionRecyclerViewAdopter(Context context, ArrayList<TransactionModel> transactionModel){
       this.context = context;
       this.transactionModel = transactionModel;
   }
    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.transaction_layout_container,parent,false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
       holder.transactionType.setText(transactionModel.get(position).getTransactionType());
       holder.transactionDate.setText(transactionModel.get(position).getTransactionDate());
        holder.transactionTime.setText(transactionModel.get(position).getTransactionTime());
        holder.transactionAmount.setText(transactionModel.get(position).getTransactionAmount());
    }

    @Override
    public int getItemCount() {
        return transactionModel.size();
    }

    public static class TransactionViewHolder extends  RecyclerView.ViewHolder
    {
        TextView transactionType;
        TextView transactionDate;
        TextView transactionAmount;
        TextView transactionTime;
        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionType = itemView.findViewById(R.id.lbl_transactionType);
            transactionDate = itemView.findViewById(R.id.lbl_transactionDate);
            transactionAmount = itemView.findViewById(R.id.lbl_transactionAmount);
            transactionTime = itemView.findViewById(R.id.lbl_transactionTime);
        }
    }
}
