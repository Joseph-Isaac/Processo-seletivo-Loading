package com.planejamento.josephisaac.loadingjr_josephisaac;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Visualizar extends Activity {

    private ListView listView;
    private SimpleCursorAdapter simpleCursorAdapter;
    private Cursor cursor;
    private SQLiteDatabase db;
    private ArrayList<String> itens;
    private ArrayAdapter<String> itensAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);



        criaLista();

    }

    private void buscaDados() {
        db = null;
        try {

            db = openOrCreateDatabase(Banco.NOME_BANCO, MODE_PRIVATE, null);
            cursor = db.rawQuery("SELECT * FROM "+Banco.TABELA, null);

        }catch (Exception e){
            e.printStackTrace();
            Log.i("BuscaDado", e.getMessage());
            Toast.makeText(Visualizar.this, "Erro ao buscar os dados", Toast.LENGTH_SHORT).show();
        }
    }

    private void criaLista() {

        try{
            listView = (ListView) findViewById(R.id.listView);
            buscaDados();

            String[] from = {Banco.TAREFA, Banco.CATEGORIA, Banco.DATA, Banco.HORARIO, Banco.LOCAL};
            int[] to = {R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10};

            simpleCursorAdapter = new SimpleCursorAdapter(Visualizar.this, R.layout.lista_personalizada, cursor, from, to);

            /*
            itens = new ArrayList<>();

            cursor = db.rawQuery("SELECT * FROM "+Banco.TABELA, null);

            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            itens);
*/
            listView.setAdapter(simpleCursorAdapter);

            /*cursor.moveToFirst();
            while (cursor != null){
                itens.add(cursor.getString(cursor.getColumnIndex(Banco.TAREFA)));
                cursor.moveToNext();
            }*/

        }catch (Exception e){
            Log.i("CriaListaEr", e.getMessage());
        }
    }

}