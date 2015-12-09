package com.apps.marcos.makeyourmeetings.Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/*--------------------------------------------------------------------------------------------------------------------------------|
   * Classe: ReunioesController
   *
   * Função: Classe responsável pelo controle da tabela reuniões, trazendo informações filtradas e prontas para manipulação.
   *
   * Métodos:
   *
   *
   * -------------------------------------------------------------------------------------------------------------------------------|
       * */
public class ReunioesController {
    public SQLiteDatabase db;
    public CriarBancoSQLite criarBancoSQLite;

    public ReunioesController(Context context){
        criarBancoSQLite = CriarBancoSQLite.retornarBancoSQLite(context);
    }

    public void inserirNovaReuniao(){

    }
}
