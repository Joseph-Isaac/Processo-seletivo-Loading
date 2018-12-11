package com.planejamento.josephisaac.loadingjr_josephisaac;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Banco {



    public static final String NOME_BANCO = "banco.db";
    public static final String ID = "_id";
    public static final String TABELA = "tabela_cadastro";
    public static final String TAREFA = "tarefa";
    public static final String CATEGORIA = "categoria";
    public static final String DATA = "data";
    public static final String HORARIO = "horario";
    public static final String LOCAL = "local";


}