package com.example.ieeetask2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button to_home , create_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          id();

        //----------- welcome toast ------------

        Toast.makeText(getApplicationContext() ,"Welcome" , Toast.LENGTH_LONG).show();

        //-------- login button code --------------

        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_home_page = new Intent(MainActivity.this , login.class);
                startActivity(to_home_page);
            }
        });


        //-------- create account button code --------------

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_create_account_page = new Intent(MainActivity.this , register.class);
                startActivity(to_create_account_page);
            }
        });
        

    }

    private void id ()
    {
        to_home = findViewById(R.id.start_layout_login_btn);
        create_account = findViewById(R.id.start_layout_create_account_btn);
    }


}