package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Paiement extends AppCompatActivity {
TextView commande ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement);

        Button annulerBtn , confirmerBtn ;

        commande= findViewById(R.id.tvCommande);
        annulerBtn= findViewById(R.id.annulerBtn);
        confirmerBtn = findViewById(R.id.confirmerBtn);

        String cmdID = getIntent().getStringExtra("plat_name") ;
        String idRestau = getIntent().getStringExtra("restaurant_id");
        //commande.setText(cmdID);
        //.child(idRestau)

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Restaurants").child(idRestau);
        ref.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nomRestau = snapshot.child("Nom").getValue().toString();
                String nomPlat = snapshot.child("Menu").child(cmdID).child("NomPlat").getValue().toString();

                commande.setText(nomPlat +" chez "+ nomRestau);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        annulerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paiement.this , PlatModel.class);
                startActivity(i);
            }
        });
        //confirmerBtn.setOnClickListener();
    }
}