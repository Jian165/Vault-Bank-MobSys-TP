package com.example.vaultbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SendMoney extends AppCompatActivity {
    EditText phoneNumberReceiver;
    EditText amountSend;
    Switch securePay;
    Button btnNext;

    boolean hasError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_money);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadCoponents();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasError = false;
                long phoneNumber = 0;
                float amount = 0;
                boolean isSecurePay = false;

                if(phoneNumberReceiver.getText().toString().isEmpty())
                {
                    hasError = true;
                    phoneNumberReceiver.setError("Enter Phone number");
                }
                else
                {
                    phoneNumber = Long.parseLong(phoneNumberReceiver.getText().toString());
                }

                if(amountSend.getText().toString().isEmpty())
                {
                    hasError = true;
                    amountSend.setError("Enter Amount");
                }
                else
                {
                    amount = Float.parseFloat(amountSend.getText().toString());
                }
                isSecurePay = securePay.isChecked();

                if(!hasError)
                {
                    Intent sendDetailsIntent =  new Intent(SendMoney.this,SendMoneyDetails.class);
                    sendDetailsIntent.putExtra("SEND_PHONE_NUMBER",phoneNumber);
                    sendDetailsIntent.putExtra("SEND_AMOUNT",amount);
                    sendDetailsIntent.putExtra("SEND_SECURE",isSecurePay);
                    startActivity(sendDetailsIntent);
                }
            }
        });

    }

    private void loadCoponents()
    {
       phoneNumberReceiver = findViewById(R.id.edt_send_phone);
        amountSend = findViewById(R.id.edt_send_amount);
        securePay = findViewById(R.id.switchPay);
        btnNext = findViewById(R.id.btn_send_Next);
    }
}