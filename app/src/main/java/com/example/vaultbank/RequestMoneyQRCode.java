package com.example.vaultbank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RequestMoneyQRCode extends AppCompatActivity {
    TextView lblphoneNumber;
    TextView lblAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_money_qrcode);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadComponent();

        Intent intent = getIntent();
        float amount = intent.getFloatExtra("RequestAmount",0.00f);
        lblAmount.setText("Amount: ₱"+String.format("%.2f", amount));
        lblphoneNumber.setText(""+PersonalInfo.getPersonalInfo().getPhoneNumber());

        new Handler().postDelayed(() -> {
            AccountBalanceModel.setAmount(AccountBalanceModel.getAmount()+amount);
            Toast.makeText(this, "You Have been Payed ₱"+amount, Toast.LENGTH_SHORT).show();
            Intent dashBoardIntent = new Intent(RequestMoneyQRCode.this,Dashboard.class);
            dashBoardIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(dashBoardIntent);
        }, 5000);

    }

    private void loadComponent()
    {
        lblphoneNumber = findViewById(R.id.lbl_qr_No);
        lblAmount = findViewById(R.id.lbl_qr_amount);

    }

}