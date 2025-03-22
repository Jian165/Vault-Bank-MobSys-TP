package com.example.vaultbank;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Transactions extends Fragment {
    RecyclerView rvTransaction;
    View view;

    ArrayList<TransactionModel> transactionModel= new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_transactions, container, false);
        loadComponents();
        SetupTransactionModel();
        TransactionRecyclerViewAdopter adopter = new TransactionRecyclerViewAdopter(this.getActivity(),transactionModel);
        rvTransaction.setAdapter(adopter);
        rvTransaction.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }

    private void SetupTransactionModel()
    {
        String[] transactionType = getResources().getStringArray(R.array.transaction_type);
        String[] transactionDate = getResources().getStringArray(R.array.transaction_date);
        String[] transactionTime = getResources().getStringArray(R.array.transaction_time);
        String[] transactionAmount = getResources().getStringArray(R.array.transactio_amount);

        for(int i=0;i<transactionType.length;i++) {
            transactionModel.add(new TransactionModel(transactionType[i],transactionTime[i],transactionDate[i],transactionAmount[i]));
        }
    }

    private void loadComponents()
    {
        rvTransaction = view.findViewById(R.id.rv_Transaction);
    }
}