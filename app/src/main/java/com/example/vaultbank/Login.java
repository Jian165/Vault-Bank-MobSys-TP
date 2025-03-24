package com.example.vaultbank;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    private CheckBox cbVisibility;
    private EditText edtPassword;
    private EditText edtEmail;
    private Button btnRegister;
    private Button btnLogin;
    private TextView error;
    private boolean hasError;

    RegisterModel registerModel;
    PersonalInfromationModel personalInfromationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LaodComponents();

        cbVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPersonalInfo = new Intent(Login.this, PersonalInfo.class);
                startActivity(intentPersonalInfo);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasError = false;
                    registerModel = Regist.getRegisterModel();
                    personalInfromationModel = PersonalInfo.getPersonalInfo();
                    System.out.println(registerModel != null);
                System.out.println(personalInfromationModel != null);
                    if (edtPassword.getText().toString().isEmpty() || edtEmail.getText().toString().isEmpty()) {
                        hasError = true;
                        error.setText("Enter Email And Password");
                    }
                    else {
                        if(registerModel!=null || personalInfromationModel!=null)
                        {
                            if (edtEmail.getText().toString().equals(registerModel.getUsername()) || edtEmail.getText().toString().equals(personalInfromationModel.getEmail())) {
                                if (!edtPassword.getText().toString().equals(registerModel.getPassword())) {
                                    hasError = true;
                                    error.setText("Invalid Email or Password");
                                }
                                else {
                                    hasError =false;
                                    error.setText("");
                                }
                            }
                            else{
                                hasError = true;
                                error.setText("Invalid Email or Password");
                            }

                        }
                        else
                        {
                            hasError = true;
                            error.setText("Invalid Email or Password");
                        }
                }
                if(!hasError){
                    Intent intentDashboard= new Intent(Login.this, Dashboard.class);
                    intentDashboard.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intentDashboard);
                }
            }
        });
    }

    private void LaodComponents()
    {
        error = findViewById(R.id.lbl_ErrorLogin);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        cbVisibility = findViewById(R.id.cb_visibility);
        btnRegister = findViewById(R.id.btn_createAccount);
        btnLogin = findViewById(R.id.btn_login);

    }
}