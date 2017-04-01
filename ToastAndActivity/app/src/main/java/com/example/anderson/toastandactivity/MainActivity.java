package com.example.anderson.toastandactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button1(View v) {
        EditText etNome = (EditText) findViewById(R.id.et_nome);
        Toast.makeText(this, etNome.getText(), Toast.LENGTH_SHORT).show();
    }

    public void button2(View v) {
        Intent intent = new Intent(this, StudentActivity.class);
        this.startActivity(intent);
    }
}
