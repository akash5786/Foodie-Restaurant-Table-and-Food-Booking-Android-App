package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {
    TextView showdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        showdata = (TextView) findViewById(R.id.rtv1);
        showdata = (TextView) findViewById(R.id.rtv2);
        showdata = (TextView) findViewById(R.id.rtv3);
        showdata = (TextView) findViewById(R.id.rtv4);
        showdata = (TextView) findViewById(R.id.rtv5);
        showdata.setText(getIntent().getStringExtra("data"));
    }
}