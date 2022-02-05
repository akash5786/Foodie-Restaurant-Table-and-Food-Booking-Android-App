package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    private CheckBox mBurger, mPasta, mPizza,mChowmein,mMomos;
    private Button mOrder,pay;
    private TextView mResultTextView;
    private ArrayList<String> mDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mBurger = findViewById(R.id.burg);
        mPasta = findViewById(R.id.pasta);
        mPizza = findViewById(R.id.piz);
        mChowmein = findViewById(R.id.ch);
        mMomos = findViewById(R.id.mo);

        mOrder = findViewById(R.id.od);
        mResultTextView = findViewById(R.id.det);
        mDetail = new ArrayList<>();
        mResultTextView.setEnabled(false);

        mBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBurger.isChecked())
                    mDetail.add("Your Burger is Ordered!!");
                else
                    mDetail.remove("Your Burger is Ordered!!");
            }
        });

        mPasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPasta.isChecked())
                    mDetail.add("Your Pasta is Ordered!!");
                else
                    mDetail.remove("Your Pasta is Ordered!!");
            }
        });

        mPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPizza.isChecked())
                    mDetail.add("Your Pizza is Ordered!!");
                else
                    mDetail.remove("Your Pizza is Ordered!!");
            }
        });

        mChowmein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChowmein.isChecked())
                    mDetail.add("Your Chowmein is Ordered!!");
                else
                    mDetail.remove("Your Chowmein is Ordered!!");
            }
        });

        mMomos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMomos.isChecked())
                    mDetail.add("Your Momos is Ordered!!");
                else
                    mDetail.remove("Your Momos is Ordered!!");
            }
        });

        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : mDetail)
                    stringBuilder.append(s).append("\n");

                mResultTextView.setEnabled(false);
                mResultTextView.setText(stringBuilder.toString());
            }
        });

        pay = findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Menu.this, Payment.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menuitem,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.logout) {
            Intent intent = new Intent(Menu.this, EmailLogin.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}