package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Demo extends AppCompatActivity {

    private CheckBox nt1,nt2,nt3,nt4,nt5,nt6;
    private Button nWriteResultButton,pay1;
    private TextView nResultTView;
    private ArrayList<String> nResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        nt1 = findViewById(R.id.t1);
        nt2 = findViewById(R.id.t2);
        nt3 = findViewById(R.id.t3);
        nt4 = findViewById(R.id.t4);
        nt5 = findViewById(R.id.t5);
        nt6 = findViewById(R.id.t6);

        nWriteResultButton = findViewById(R.id.od);
        nResultTView = findViewById(R.id.det);
        nResult = new ArrayList<>();
        nResultTView.setEnabled(false);

        nt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nt1.isChecked())
                    nResult.add("Table 1 is booked!!");
                else
                    nResult.remove("Table 1 is booked!!");
            }
        });

        nt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nt2.isChecked())
                    nResult.add("Table 2 is booked!!");
                else
                    nResult.remove("Table 2 is booked!!");
            }
        });

        nt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nt3.isChecked())
                    nResult.add("Table 3 is booked!!");
                else
                    nResult.remove("Table 3 is booked!!");
            }
        });

        nt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nt4.isChecked())
                    nResult.add("Table 4 is booked!!");
                else
                    nResult.remove("Table 4 is booked!!");
            }
        });

        nt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nt5.isChecked())
                    nResult.add("Table 5 is booked!!");
                else
                    nResult.remove("Table 5 is booked!!");
            }
        });

        nt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nt6.isChecked())
                    nResult.add("Table 6 is booked!!");
                else
                    nResult.remove("Table 6 is booked!!");
            }
        });

        nWriteResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : nResult)
                    stringBuilder.append(s).append("\n");

                nResultTView.setText(stringBuilder.toString());
                nResultTView.setEnabled(false);
            }
        });

        pay1 = findViewById(R.id.pay1);
        pay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Demo.this, Payment.class);
                startActivity(intent);
            }
        });


    }
}