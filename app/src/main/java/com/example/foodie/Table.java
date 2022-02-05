package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Table extends AppCompatActivity {
    private CheckBox mt1, mt2, mt3,mt4,mt5,mt6;
    private Button mOrd,pay;
    private TextView mRTV;
    private ArrayList<String> mDet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mt1 = findViewById(R.id.t1);
        mt2 = findViewById(R.id.t2);
        mt3 = findViewById(R.id.t3);
        mt4 = findViewById(R.id.t4);
        mt5 = findViewById(R.id.t5);
        mt6 = findViewById(R.id.t6);

        mOrd = findViewById(R.id.od);
        mRTV = findViewById(R.id.det);
        mDet = new ArrayList<>();
        mRTV.setEnabled(false);

        mt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mt1.isChecked())
                    mDet.add("Table 1 is Booked!!");
                else
                    mDet.remove("Table 1 is Booked!!");
            }
        });

        mt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mt2.isChecked())
                    mDet.add("Table 2 is Booked!!");
                else
                    mDet.remove("Table 2 is Booked!!");
            }
        });

        mt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mt3.isChecked())
                    mDet.add("Table 3 is Booked!!");
                else
                    mDet.remove("Table 3 is Booked!!");
            }
        });

        mt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mt4.isChecked())
                    mDet.add("Table 4 is Booked!!");
                else
                    mDet.remove("Table 4 is Booked!!");
            }
        });

        mt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mt5.isChecked())
                    mDet.add("Table 5 is Booked!!");
                else
                    mDet.remove("Table 5 is Booked!!");
            }
        });

        mt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mt6.isChecked())
                    mDet.add("Table 6 is Booked!!");
                else
                    mDet.remove("Table 6 is Booked!!");
            }
        });

        mOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : mDet)
                    stringBuilder.append(s).append("\n");

                mRTV.setEnabled(false);
                mRTV.setText(stringBuilder.toString());
            }
        });

        pay = findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Table.this, Payment.class);
                startActivity(intent);
            }
        });

    }
}