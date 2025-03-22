package com.example.vaultbank;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Home extends Fragment {
    ArrayList<DealsModel> dealsModels = new ArrayList<>();
    RecyclerView rvDeals;
    View view;
    int[] dealsImages = {
            R.drawable.img_discount,
            R.drawable.img_0interes,
            R.drawable.img_dining_discount,
            R.drawable.img_travel_dsicount,
            R.drawable.img_bonus
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        loadCompoenets();
        SetupDealsModel();
        DealsReacyclerViewAdopter adopter = new DealsReacyclerViewAdopter(this.getActivity(),dealsModels);
        rvDeals.setAdapter(adopter);
        rvDeals.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }
    private void SetupDealsModel()
    {
        String[] dealsTitle = getResources().getStringArray(R.array.deals_title);
        for(int i=0;i<dealsTitle.length;i++)
        {
           dealsModels.add(new DealsModel(dealsTitle[i],dealsImages[i]));
        }
    }

    private void loadCompoenets()
    {
        rvDeals = view.findViewById(R.id.rv_deals);
    }

}