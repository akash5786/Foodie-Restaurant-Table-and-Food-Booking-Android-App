package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class NewRegistration extends AppCompatActivity {
    EditText nname,email,password;
    Button newu,registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_registration);

        nname = findViewById(R.id.nname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registration = findViewById(R.id.registration);
        newu = findViewById(R.id.newu);

        newu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(NewRegistration.this, EmailLogin.class);
                        startActivity(intent);
                    }
                });
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(NewRegistration.this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                    Toast.makeText(NewRegistration.this, "Please Enter Valid Email Address", Toast.LENGTH_SHORT).show();

                }
                else if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(NewRegistration.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().length()<6){
                    Toast.makeText(NewRegistration.this, "Please Enter 6 or more than 6 digit password", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(nname.getText().toString())){
                    Toast.makeText(NewRegistration.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else {
                    registration();
                }
            }

        });

    }

    private void registration() {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("name",nname.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("password",password.getText().toString());

                        FirebaseDatabase.getInstance().getReference()
                                .child("Users")
                                .child(FirebaseAuth.getInstance().getUid())
                                .setValue(map)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(NewRegistration.this, "Registration Successful!!....Please Login to continue!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(NewRegistration.this, EmailLogin.class));
                                        finish();
                                    }
                                });

                        Toast.makeText(NewRegistration.this, "Registration Successful!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NewRegistration.this, "Failed :"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}