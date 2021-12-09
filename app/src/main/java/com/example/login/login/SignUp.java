package com.example.login.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    EditText familyname, firstname,telephone,  email, password, confPassword;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        MaterialButton confirmbtn = (MaterialButton) findViewById(R.id.confirm);
        familyname = findViewById(R.id.familyname);
        firstname = findViewById(R.id.firstname);
        telephone = findViewById(R.id.telephone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.passwd);
        confPassword = findViewById(R.id.confpasswd);

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Utilisateurs");
                String familynameV = familyname.getText().toString();
                String firstnameV = firstname.getText().toString();
                String telephoneV = telephone.getText().toString();
                String emailV = email.getText().toString();
                String passwordV = password.getText().toString();
                String conf = confPassword.getText().toString();
                if(!conf.equals(passwordV) ){
                    Context context = getApplicationContext();

                    CharSequence text = "password not matched";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {
                    UserHelperClass helperClass = new UserHelperClass(familynameV, firstnameV, telephoneV, emailV, passwordV);
                    reference.child(telephoneV).setValue(helperClass);
                    Intent intent = new Intent(SignUp.this, ConfirmEmail.class);
                    startActivity(intent);
                }
            }
        });
    }
}