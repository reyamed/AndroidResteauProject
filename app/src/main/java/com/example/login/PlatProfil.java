
package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.login.login.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlatProfil extends AppCompatActivity {
TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat);

        String restauId = getIntent().getStringExtra("restauId");
        int PlatId = getIntent().getIntExtra("platId", 666);
        String platId = String.valueOf(PlatId);
        //String restauId = String.valueOf(RestauId) ;

        DatabaseReference database;

        textView1 = findViewById(R.id.platNom);
        textView2 = findViewById(R.id.platPrix);
        textView3 = findViewById(R.id.platDescription);
        ImageView ImagePlat = findViewById(R.id.platImage);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Restaurants").child(restauId).child("Menu").child(platId);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nomPlat = snapshot.child("NomPlat").getValue().toString();
                String prixPlat = snapshot.child("Prix").getValue().toString();
                String platDescription = snapshot.child("DescriptionPlat").getValue().toString();
                String imagePlat = snapshot.child("ImagePlat").getValue().toString();
                textView1.setText(nomPlat);
                textView2.setText(prixPlat);
                textView3.setText(platDescription);
                Glide.with(PlatProfil.this).load(imagePlat).into(ImagePlat);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}