package com.example.vaultbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersonalInfo extends AppCompatActivity {
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtPhoneNumber;
    private EditText edtEmail;
    private TextView lblError;
    private Button btnNext;
    private boolean hasError;

    private static PersonalInfromationModel personalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadComponent();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtFirstName.getText().toString().isEmpty()||edtLastName.getText().toString().isEmpty()||edtEmail.getText().toString().isEmpty()||edtPhoneNumber.getText().toString().isEmpty()){
                    hasError =true;
                    lblError.setText("Fill all Infromation Requirements");
                }
                else
                {
                    hasError =false;
                    lblError.setText("");
                    personalInfo = new PersonalInfromationModel(edtFirstName.getText().toString(),edtLastName.getText().toString(),edtEmail.getText().toString(),Long.parseLong(edtPhoneNumber.getText().toString()));
                }
                if(!hasError){
                    Intent intentRegist = new Intent(PersonalInfo.this, Regist.class);
                    startActivity(intentRegist);
                }
            }
        });


    }
   private void loadComponent()
   {
       edtFirstName = findViewById(R.id.edt_R_Firstname);
       edtLastName = findViewById(R.id.edt_R_LastName);
       edtPhoneNumber = findViewById(R.id.edt_R_PhoneNumber);
       edtEmail = findViewById(R.id.edt_R_email);
       btnNext = findViewById(R.id.btn_R_Next);
       lblError = findViewById(R.id.lbl_Error_PersonalInfo);
   }

    public static PersonalInfromationModel getPersonalInfo() {
        return personalInfo;
    }
}