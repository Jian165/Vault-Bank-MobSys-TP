package com.example.vaultbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageRecyclerViewAdopter extends RecyclerView.Adapter<MessageRecyclerViewAdopter.MessageViewHolder>
{
    Context context;
    ArrayList<MessageModel> messageModels;
   public MessageRecyclerViewAdopter (Context context, ArrayList<MessageModel> messageModel){
       this.context = context;
       this.messageModels = messageModel;
   }
    @NonNull
    @Override
    public MessageRecyclerViewAdopter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.message_layout_container,parent,false);
        return new MessageRecyclerViewAdopter.MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRecyclerViewAdopter.MessageViewHolder holder, int position) {
       holder.messageTitle.setText(messageModels.get(position).getTitleMessage());
       holder.messageText.setText(messageModels.get(position).getMessage());
       holder.messageTime.setText(messageModels.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public static class MessageViewHolder extends  RecyclerView.ViewHolder
    {
        TextView messageTitle;
        TextView messageTime;
        TextView messageText;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTitle = itemView.findViewById(R.id.lbl_transactionType);
            messageTime = itemView.findViewById(R.id.lbl_transactionAmount);
            messageText = itemView.findViewById(R.id.lbl_transactionDate);
        }
    }
}
