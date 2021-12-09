package com.example.login.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.login.R;
import com.example.login.navbar.HomePageA;
import com.google.android.material.button.MaterialButton;

public class ConfirmEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_email);
        MaterialButton confirm2btn = (MaterialButton) findViewById(R.id.conff);

        confirm2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmEmail.this, HomePageA.class);
                startActivity(intent);
            }
        });
    }
}