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

public class RequestMoney extends AppCompatActivity {
    EditText edtAmount;
    TextView lblName;
    TextView lblMobileNumber;
    TextView lblEmail;
    Button btnCancel;
    Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_money);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadComponent();

        lblName.setText("Name:"+PersonalInfo.getPersonalInfo().getFirstName()+" "+PersonalInfo.getPersonalInfo().getLastName());
        lblMobileNumber.setText("Phone:"+PersonalInfo.getPersonalInfo().getPhoneNumber());
        lblEmail.setText("Email:"+PersonalInfo.getPersonalInfo().getEmail());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DashbaordIntent = new Intent(RequestMoney.this,Dashboard.class);
                DashbaordIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(DashbaordIntent);
            }
        });
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent requestMoneyIntent = new Intent(RequestMoney.this, RequestMoneyQRCode.class);
                if(!edtAmount.getText().toString().isEmpty()){
                    requestMoneyIntent.putExtra("RequestAmount",Float.parseFloat(edtAmount.getText().toString()));
                    startActivity(requestMoneyIntent);
                }
                else{
                    edtAmount.setError("Put amount");
                }
            }
        });
    }

    private void loadComponent()
    {
        edtAmount = findViewById(R.id.edt_request_amount);
        lblName = findViewById(R.id.lbl_request_name);
        lblMobileNumber = findViewById(R.id.lbl_request_phone);
        lblEmail = findViewById(R.id.lbl_request_email);
        btnCancel = findViewById(R.id.btn_request_cancel);
        btnRequest = findViewById(R.id.btn_Request);
    }
}