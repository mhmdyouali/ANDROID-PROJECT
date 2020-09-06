package com.example.ieeetask2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    CheckBox remember_cb;
    TextView create_tv;
    EditText mail_et , password_et ;
    Button sign_in_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

          id();

        //----- login layout ( check box ) remember me  code -------------------

        remember_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mail_et.setText("mmdouh1112@gmail.com");
                password_et.setText("00001111");
            }
        });


        //------- login layout (text view) create account code -------------------

        create_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create_page = new Intent(login.this , register.class);
                startActivity(create_page);
            }
        });


        //------- login layout (button) create account code -------------------

        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_home = new Intent(login.this ,home.class);
                startActivity(to_home);
            }
        });

    }


    private void id ()
    {
        remember_cb = findViewById(R.id.login_layout_remember_cb);
        create_tv = findViewById(R.id.login_layout_create_account_tv);
        mail_et = findViewById(R.id.login_layout_mail_et);
        password_et = findViewById(R.id.login_layout_password_et);
        sign_in_btn = findViewById(R.id.login_layout_sign_in_btn);
    }

}