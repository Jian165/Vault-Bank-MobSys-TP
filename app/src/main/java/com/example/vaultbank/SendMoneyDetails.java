package com.example.vaultbank;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SendMoneyDetails extends AppCompatActivity {
    TextView lbLReciverPhone,
            lblCurrentBalance,
            lblSendAmount,
            lblSecurePay,
            lblSecureAmount,
            lblTotalSend;
    ;
    Button btnSendMony;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_money_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadComponents();

        Intent intent = getIntent();
        long phoneNumberReciver = intent.getLongExtra("SEND_PHONE_NUMBER",0);
        float amountToSend = intent.getFloatExtra("SEND_AMOUNT",0.00f);
        boolean isSecure = intent.getBooleanExtra("SEND_SECURE",false);
        float secureToPay = 30.0f;
        float TotalAmoutToPay = 0;
        float CurrentBalance = AccountBalanceModel.getAmount();

        lbLReciverPhone.setText(""+phoneNumberReciver);
        lblCurrentBalance.setText("₱"+CurrentBalance);
        lblSendAmount.setText("₱"+amountToSend);

        if(!isSecure)
        {
            lblSecurePay.setVisibility(TextView.INVISIBLE);
            lblSecureAmount.setVisibility(TextView.INVISIBLE);
            TotalAmoutToPay = amountToSend;
        }
        else
        {
            lblSecurePay.setVisibility(TextView.VISIBLE);
            lblSecureAmount.setVisibility(TextView.VISIBLE);
            TotalAmoutToPay = amountToSend + secureToPay;
        }
        lblTotalSend.setText("₱"+String.format("%.2f",TotalAmoutToPay));

        float finalTotalAmoutToPay = TotalAmoutToPay;
        btnSendMony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(CurrentBalance < finalTotalAmoutToPay){
                   showErrorDialog();
               }
               else
               {
                   AccountBalanceModel.setAmount(AccountBalanceModel.getAmount()-finalTotalAmoutToPay);
                   Toast.makeText(SendMoneyDetails.this, "You Successfully Send Money!", Toast.LENGTH_SHORT).show();
                   Intent dashboardIntent = new Intent(SendMoneyDetails.this,Dashboard.class);
                   dashboardIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                   startActivity(dashboardIntent);
               }

            }
        });
    }
    public void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Insufficient  Balance");
        builder.setMessage("Your Current Account Balance is not enough");
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.setNegativeButton("Menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent dashboardIntent = new Intent(SendMoneyDetails.this,Dashboard.class);
                dashboardIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(dashboardIntent);
            }
        });

        builder.create().show();
    }

    public void loadComponents()
    {
       lbLReciverPhone = findViewById(R.id.lbl_receiverPhone);
        lblCurrentBalance = findViewById(R.id.lbl_currentBalance);
        lblSendAmount = findViewById(R.id.lbl_AmountSend);
        lblSecurePay = findViewById(R.id.lbl_SecurePay);
        lblSecureAmount = findViewById(R.id.lbl_SecureAmout);
        lblTotalSend = findViewById(R.id.TotalPayment);
        btnSendMony = findViewById(R.id.btn_send_money);
    }
}