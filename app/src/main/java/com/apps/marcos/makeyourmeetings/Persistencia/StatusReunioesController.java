package com.apps.marcos.makeyourmeetings.Persistencia;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.apps.marcos.makeyourmeetings.Models.StatusReunioes;


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


    public StatusReunioesController(Context context){
        this.criarBancoSQLite = CriarBancoSQLite.retornarBancoSQLite(context);
    }
    public StatusReunioesController(CriarBancoSQLite criarBancoSQLite){
        this.criarBancoSQLite = criarBancoSQLite;
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
        System.out.println("DEBUG: Iniciando operação de coleta das informações. Verificando parâmetros");
        if(idStatus <= 0) {
            System.out.println("DEBUG: idStatus inválido. Jogando exceção a ser tratada");
            throw new IllegalArgumentException("Status de reunião inválido.");
        } else {
            db = DatabaseManager.getReadbleDatabase(this.criarBancoSQLite);
            System.out.println("DEBUG: Parâmetro correto. Retornando status de reunião de acordo com o parâmetro informado ");
            String clausuraWhere = new String();
            System.out.println("DEBUG: Montando Clausura WHERE");
            clausuraWhere = "=?";
            String[] camposPesquisa = {"idStatus"};
            String[] valores = {String.valueOf(idStatus)};
            System.out.println("DEBUG: Clausura WHERE montada, junto aos valores. Consultando e retornando caso encontre valores. Caso contrário, retornar NULL");
            Cursor pesquisa = db.query(StatusReunioes.nomeTabelaStatusReunioes, camposPesquisa, clausuraWhere, valores, null, null, StatusReunioes.nomeCampoIdStatusReunioes);
            if(pesquisa == null) return null;
            pesquisa.moveToFirst();
            return pesquisa;
        }
    }
}
