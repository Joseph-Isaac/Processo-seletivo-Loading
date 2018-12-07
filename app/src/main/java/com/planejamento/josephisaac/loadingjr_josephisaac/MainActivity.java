package com.planejamento.josephisaac.loadingjr_josephisaac;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView cadastro;
    private ImageView visualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastro = (ImageView) findViewById(R.id.imageView2);
        visualizar = (ImageView) findViewById(R.id.imageView3);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Cadastro.class));
            }
        });

        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Visualizar.class));
            }
        });
    }
}
