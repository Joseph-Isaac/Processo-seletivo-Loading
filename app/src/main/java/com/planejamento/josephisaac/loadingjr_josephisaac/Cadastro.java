package com.planejamento.josephisaac.loadingjr_josephisaac;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Cadastro extends AppCompatActivity {

    private SQLiteDatabase db;
    private EditText tarefa;
    private EditText categoria;
    private EditText data;
    private EditText horario;
    private EditText local;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        
        tarefa = (EditText) findViewById(R.id.editText);
        categoria = (EditText) findViewById(R.id.editText2);
        data = (EditText) findViewById(R.id.editText3);
        horario = (EditText) findViewById(R.id.editText4);
        local = (EditText) findViewById(R.id.editText5);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastrar(tarefa.getText().toString(), categoria.getText().toString(), data.getText().toString(),
                        horario.getText().toString(), local.getText().toString());
                finish();
            }
        });
    }

    public void Cadastrar(String tarefa, String categoria, String data, String horario, String local){

        db = null;

        try{
            db = openOrCreateDatabase(Banco.NOME_BANCO, MODE_PRIVATE, null);

            String sql = "INSERT INTO "+Banco.TABELA+" ("+Banco.TAREFA
                    +", "+Banco.CATEGORIA+", "+Banco.DATA+", "
                    +Banco.HORARIO+", "+Banco.LOCAL+") VALUES  ('"
                    +tarefa+"', '"+categoria+"', '"+data+"', '"+horario+"', '"
                    +local+"' )";

            db.execSQL(sql);
            db.close();
            finish();
            
        }catch (Exception e){
            e.printStackTrace();
            Log.i("CadastroErro", e.getMessage());
            Toast.makeText(Cadastro.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
        }
    }
}
