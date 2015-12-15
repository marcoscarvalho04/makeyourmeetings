package com.apps.marcos.makeyourmeetings.Persistencia;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/*--------------------------------------------------------------------------------------------------------------------------------|
   * Classe: StatusReunioesController
   *
   * Função: Classe responsável pelo controle da tabela statusReunioes, trazendo informações filtradas e prontas para manipulação.
   *
   * Métodos:
   * Cursor retornarStatusReuniao: Retorna o status reunião passado via parâmetro.
   *
   * -------------------------------------------------------------------------------------------------------------------------------|
       * */
public class StatusReunioesController {

    private SQLiteDatabase db;
    private CriarBancoSQLite criarBancoSQLite;
    public Cursor retornarStatusReuniao;

    public StatusReunioesController(Context context){
        this.criarBancoSQLite = CriarBancoSQLite.retornarBancoSQLite(context);
    }

    public Cursor retornarStatusReuniao(int idStatus){
      /*
        * Método: retornarStatusReuniao
        *
        * Função: fazer a inserção de informações sobre reuniões na base SQLite do aparelho.
        *
        * Retorno:
        * true - informação inserida com sucesso.
        * IllegalException - Exceção ao tentar fazer a inserção da informação.
        *
        * */
    }
}
