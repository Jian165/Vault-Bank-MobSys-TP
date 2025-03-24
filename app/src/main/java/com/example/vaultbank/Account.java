package com.example.vaultbank;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Account extends Fragment {

    private View view;
    private TextView lblFullName;
    private TextView lblPhoneNumber;
    private CardView cvLagout;
    private PersonalInfromationModel personalInfo;

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_account, container, false);
        loadComponents();
        personalInfo = PersonalInfo.getPersonalInfo();
        lblFullName.setText(personalInfo.getFirstName()+" "+personalInfo.getLastName());
        lblPhoneNumber.setText(""+personalInfo.getPhoneNumber());
        cvLagout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutDialog();
            }
        });
        return view;
    }

    private void loadComponents()
    {
        lblFullName = view.findViewById(R.id.lbl_profileName);
        lblPhoneNumber = view.findViewById(R.id.lbl_AccountNo);
        cvLagout = view.findViewById(R.id.cv_logaout);
    }
    public void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to log out and close the app?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity(getActivity());
                System.exit(0);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Logout cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }



}