package com.example.anderson.mylistview;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> listAdapter;
    ArrayList<String> students = new ArrayList<String>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        students.add("Anderson");
        students.add("Artur da Costa Oliveira");
        listAdapter = new ArrayAdapter<String>(this, R.layout.row_student, students);
        listview.setAdapter(listAdapter);
        registerForContextMenu(listview);
    }

    public void newStudent(View v) {
        Intent intent = new Intent(this, FormStudentActivity.class);
        this.startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                students.add(data.getStringExtra("student"));
                listAdapter = new ArrayAdapter<String>(this, R.layout.row_student, students);
                listview.setAdapter(listAdapter);
            }
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("MENU DE ALUNOS");
        menu.add(Menu.NONE, 0, Menu.NONE, "Ligar para o aluno");
        menu.add(Menu.NONE, 1, Menu.NONE, "Mandar SMS para o aluno");
        menu.add(Menu.NONE, 2, Menu.NONE, "Ver localização no mapa");
        menu.add(Menu.NONE, 3, Menu.NONE, "Acessar site do aluno");
        super.onCreateContextMenu(menu, view, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case 0:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }
                } else {
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+81999999999"));
                    startActivity(intent);
                }
                return true;
            case 1:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:81999999999"));
                intent.putExtra("sms_body", "Enviando SMS");
                startActivity(intent);
                return true;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Rua+da+Aurora,Recife"));
                startActivity(intent);
                return true;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Call Permission Granted..Please dial again.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Call permission not granted", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
