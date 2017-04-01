package com.example.anderson.toastandactivity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        TextView etNome = (TextView) findViewById(R.id.et_nome);
        TextView etEndereco = (TextView) findViewById(R.id.et_endereco);
        TextView etFone = (TextView) findViewById(R.id.et_fone);
        TextView etSite = (TextView) findViewById(R.id.et_site);
        TextView etNota = (TextView) findViewById(R.id.et_nota);
        ImageView ivFoto = (ImageView) findViewById(R.id.iv_foto);

        etNome.setText("Anderson");
        etEndereco.setText("Rua do apolo, 180");
        etSite.setText("google.com.br");
        etFone.setText("(81) 99999-9999");
        etNota.setText("10");
        ivFoto.setImageResource(R.mipmap.ic_launcher);
    }
}
