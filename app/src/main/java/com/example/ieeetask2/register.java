package com.example.ieeetask2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    Button create_account_btn ;
    EditText name_et ;
    EditText mail_et ;
    EditText phone_et ;
    EditText password_et ;

    // ---- database object ----

    myDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // linked ids of views

           id();

        // -------- database connection ------------

          db = new myDatabase(this);


       //--------- register layout (button) create account code ----------

        create_account_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user_name = name_et.getText().toString();
                String user_mail = mail_et.getText().toString();
                String user_phone = phone_et.getText().toString();
                String user_pass = password_et.getText().toString();

                user1 user = new user1(user_name ,user_mail ,user_phone, user_pass);

                 boolean result =  db.insert_user(user);

              if (result)
              {
                  Toast.makeText(getApplicationContext() ,"Data saved" , Toast.LENGTH_LONG).show();
              }
              else
              {
                  Toast.makeText(getApplicationContext() ,"Data not saved" , Toast.LENGTH_LONG).show();
              }

            }
        });

    }

    private void id ()
    {
        create_account_btn = findViewById(R.id.register_layout_create_account_btn);
        name_et = findViewById(R.id.register_layout_name_et);
        mail_et = findViewById(R.id.register_layout_mail_et);
        password_et = findViewById(R.id.register_layout_password_et);
        phone_et = findViewById(R.id.register_layout_phone_et);
    }


}