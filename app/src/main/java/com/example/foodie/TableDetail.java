package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TableDetail extends AppCompatActivity {
    private EditText pName, pEmail, pPhone, pTable, pTime;
    private Button preceiptt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_detail);

        pName = (EditText) findViewById(R.id.pName);
        pEmail = (EditText) findViewById(R.id.pEmail);
        pPhone = (EditText) findViewById(R.id.pPhone);
        pTable = (EditText) findViewById(R.id.pTable);
        pTime = (EditText) findViewById(R.id.pTime);
        preceiptt = (Button) findViewById(R.id.preceiptt);

        preceiptt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = preceiptt.getText().toString();
                Intent intent = new Intent(TableDetail.this, Receipt.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
    }
}