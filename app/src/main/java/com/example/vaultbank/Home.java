package com.example.vaultbank;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Home extends Fragment {
    ArrayList<DealsModel> dealsModels = new ArrayList<>();
    RecyclerView rvDeals;
    View view;

    TextView lblDate;
    TextView lblName;
    TextView lblAmount;
    ImageButton btnSend;
    ImageButton btnReceive;

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
        loadRecyclerView();

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String date = formatter.format(today);
        lblDate.setText(date);
        Bonus();
        lblName.setText("Hello "+PersonalInfo.getPersonalInfo().getFirstName());
        lblAmount.setText("₱"+String.format("%.2f",AccountBalanceModel.getAmount()));

        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent requestMoneyIntent = new Intent(getActivity(),RequestMoney.class);
                startActivity(requestMoneyIntent);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendMonyIntent = new Intent(getActivity(), SendMoney.class);
                startActivity(sendMonyIntent);
            }
        });
        return view;
    }

    private void Bonus()
    {
        if(AccountBalanceModel.BonusCount!=1){
            Toast.makeText(getActivity(), "You Get ₱100 as a Sign-in Bonus!", Toast.LENGTH_SHORT).show();
            AccountBalanceModel.setAmount(100);
        }
        AccountBalanceModel.BonusCount=1;
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
        lblDate = view.findViewById(R.id.lbl_H_Date);
        lblName = view.findViewById(R.id.lbl_H_username);
        lblAmount = view.findViewById(R.id.lbl_Amount);
        btnReceive = view.findViewById(R.id.btn_RequestMoney);
        btnSend = view.findViewById(R.id.btn_SendMoney);
    }
    private void loadRecyclerView(){
        DealsReacyclerViewAdopter adopter = new DealsReacyclerViewAdopter(this.getActivity(),dealsModels);
        rvDeals.setAdapter(adopter);
        rvDeals.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }


}