package com.example.anderson.mylistview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> listAdapter ;
    ArrayList<String> students = new ArrayList<String>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById( R.id.listview );
        students.add("Anderson");
        students.add("Artur da Costa Oliveira");
        listAdapter = new ArrayAdapter<String>(this, R.layout.row_student, students);
        listview.setAdapter( listAdapter );
    }

    public void newStudent(View v) {
        Intent intent = new Intent(this, FormStudentActivity.class);
        this.startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                students.add(data.getStringExtra("student"));
                listAdapter = new ArrayAdapter<String>(this, R.layout.row_student, students);
                listview.setAdapter( listAdapter );
            }
        }
    }
}
