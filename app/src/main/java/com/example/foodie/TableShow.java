package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TableShow extends AppCompatActivity {
    private TextView name,surname,tablename,tablesurname;
    private Button pay2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_show);

        name = findViewById(R.id.text_name);
        surname = findViewById(R.id.text_surname);
        tablename = findViewById(R.id.text_tablename);
        tablesurname = findViewById(R.id.text_tablesurname);

        String username = getIntent().getStringExtra("keyname");
        String userSurname = getIntent().getStringExtra("keysurname");
        String userTable = getIntent().getStringExtra("keytable");
        String userTablesurname = getIntent().getStringExtra("keytableuser");

        name.setText(username);
        surname.setText(userSurname);
        tablename.setText(userTable);
        tablesurname.setText(userTablesurname);

        pay2 = findViewById(R.id.pay2);
        pay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TableShow.this, Payment.class);
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
            Intent intent = new Intent(TableShow.this, EmailLogin.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}