package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TableInfo extends AppCompatActivity {
    private EditText name,surname,tablename,tablesurname;
    Button add;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_info);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        tablename = findViewById(R.id.tablename);
        tablesurname = findViewById(R.id.tablesurname);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String usersurname = surname.getText().toString();
                String usertable = tablename.getText().toString();
                String usertablesurname = tablesurname.getText().toString();

                Intent intent = new Intent(TableInfo.this, TableShow.class);
                intent.putExtra("keyname",username);
                intent.putExtra("keysurname",usersurname);
                intent.putExtra("keytable",usertable);
                intent.putExtra("keytableuser",usertablesurname);
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
            Intent intent = new Intent(TableInfo.this, EmailLogin.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}