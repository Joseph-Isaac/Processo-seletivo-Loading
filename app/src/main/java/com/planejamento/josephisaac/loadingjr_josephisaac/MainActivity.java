package com.planejamento.josephisaac.loadingjr_josephisaac;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView cadastro;
    private ImageView visualizar;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastro = (ImageView) findViewById(R.id.imageView2);
        visualizar = (ImageView) findViewById(R.id.imageView3);
        criaTabela();

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

    private void criaTabela() {

        db = null;

        try {

            db = openOrCreateDatabase(Banco.NOME_BANCO, MODE_PRIVATE, null);

            String sql = "CREATE TABLE IF NOT EXISTS "+Banco.TABELA+"("+
                    Banco.ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Banco.TAREFA+" TEXT, "+
                    Banco.CATEGORIA+" TEXT, "+
                    Banco.DATA+" TEXT, "+
                    Banco.HORARIO+" TEXT, "+
                    Banco.LOCAL+" TEXT)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
            Log.i("TabelaErro", e.getMessage());
        }
    }


}
