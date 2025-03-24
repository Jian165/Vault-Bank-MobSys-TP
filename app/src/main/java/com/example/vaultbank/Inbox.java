package com.example.vaultbank;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Inbox extends Fragment {

    RecyclerView rvInbox;
    View view;
    public static ArrayList<MessageModel> messageModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_inbox, container, false);
        loadComponents();
        SetupMessages();
        MessageRecyclerViewAdopter adopter = new MessageRecyclerViewAdopter(this.getActivity(),messageModels);
        rvInbox.setAdapter(adopter);
        rvInbox.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }

    private void SetupMessages()
    {
        String[] messageTitle = getResources().getStringArray(R.array.inbox_title);
        String[] messageText = getResources().getStringArray(R.array.inbox_message);
        String[] messageTime = getResources().getStringArray(R.array.inbox_time);

        for(int i=0;i<messageTitle.length;i++) {
            messageModels.add(new MessageModel(messageTitle[i],messageText[i],messageTime[i]));
        }
    }
    public static void MessageModel(MessageModel messageModel)
    {
        messageModels.add(messageModel);

    }

    private void loadComponents(){
        rvInbox = view.findViewById(R.id.rv_Transaction);
    }
}