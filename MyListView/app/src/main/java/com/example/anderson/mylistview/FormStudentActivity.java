package com.example.anderson.mylistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormStudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);
    }

    public void sendStudent(View v){
        EditText et_nome = (EditText)findViewById(R.id.et_nome);
        String nome = String.valueOf(et_nome.getText());
        Intent returnIntent = new Intent();
        returnIntent.putExtra("student", nome);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
