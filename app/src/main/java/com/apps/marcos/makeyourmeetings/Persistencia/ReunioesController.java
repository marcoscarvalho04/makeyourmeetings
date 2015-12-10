package com.apps.marcos.makeyourmeetings.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.apps.marcos.makeyourmeetings.Models.Reunioes;

/*--------------------------------------------------------------------------------------------------------------------------------|
   * Classe: ReunioesController
   *
   * Função: Classe responsável pelo controle da tabela reuniões, trazendo informações filtradas e prontas para manipulação.
   *
   * Métodos:
   *void inserirNovaReuniao: Através de uma classe Reuniao, é feita a persistência dos dados inseridos pelo usuário para
   * criação de uma nova reunião.
   *
   * -------------------------------------------------------------------------------------------------------------------------------|
       * */
public class ReunioesController {
    public SQLiteDatabase db;
    public CriarBancoSQLite criarBancoSQLite;

    public ReunioesController(Context context){
        criarBancoSQLite = CriarBancoSQLite.retornarBancoSQLite(context);
    }

    public void inserirNovaReuniao(Reunioes reuniao){
        ContentValues valores = new ContentValues();
        long resultado;
        this.db = criarBancoSQLite.getWritableDatabase();
        System.out.println("Colocando dados da reunião");
        valores.put("dataReuniao",String.valueOf(reuniao.getDataReuniao()));


    }
}
