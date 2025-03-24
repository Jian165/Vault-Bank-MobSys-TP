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

public class Regist extends AppCompatActivity {
    private static RegisterModel registerModel;
    private EditText edtUsername;
    private EditText EdtPassword;
    private EditText EdtConfirmPassword;
    private TextView error;
    private Button btnSignup;
    private boolean hasError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LoadComponents();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(edtUsername.getText().toString().isEmpty()||EdtPassword.getText().toString().isEmpty()||EdtConfirmPassword.getText().toString().isEmpty())
                    {
                        hasError = true;
                        error.setText("Fill all information");
                    }
                    else {
                        if(EdtPassword.getText().toString().equals(EdtConfirmPassword.getText().toString())){
                            registerModel = new RegisterModel(EdtPassword.getText().toString(), edtUsername.getText().toString()) ;
                            hasError = false;
                            error.setText("");
                        }
                        else {
                            hasError = true;
                            error.setText("Password Didn't match");
                        }
                    }

                    if (!hasError){
                        Intent intentLogin = new Intent(Regist.this,Login.class);
                        System.out.println(registerModel.getPassword()+" "+registerModel.getUsername());
                        intentLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentLogin);
                        finish();
                    }
            }
        });
    }

    private void LoadComponents()
    {
        edtUsername = findViewById(R.id.edt_R_Username);
        EdtPassword = findViewById(R.id.edt_R_CreatePassword);
        EdtConfirmPassword = findViewById(R.id.edt_R_ConfirmPassword);
        error = findViewById(R.id.lbl_Error_signup);
        btnSignup = findViewById(R.id.btn_R_SignUp);

    }
    public static RegisterModel getRegisterModel(){
        return registerModel;
    }
}