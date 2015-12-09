package com.apps.marcos.makeyourmeetings.Persistencia;

import com.apps.marcos.makeyourmeetings.Activities.MainActivity;
import com.apps.marcos.makeyourmeetings.Models.Reunioes;
import com.apps.marcos.makeyourmeetings.Models.StatusReunioes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriarBancoSQLite extends SQLiteOpenHelper {
    /*--------------------------------------------------------------------------------------------------------------------------------|
    * Classe: CriarBancoSQLite
    *
    * Função: Cria e dropa o banco do sistema. Não faz consultas em tables, delegando isso a outras classes que o farão.
    *
    * Métodos:
    * onCreate, onUpgrade: Próprias da classe SQLiteOpenHelper. Servem apenas quando se há uma revisão no banco e para
    *  (Criar e dropar o banco existente)
    *
    * -------------------------------------------------------------------------------------------------------------------------------|
        * */
    public CriarBancoSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, this.nomeBanco, null, this.versao);
    }
    private static final String nomeBanco = "MakeYourMeetings.db";
    private static final int versao = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL1 = "CREATE TABLE "+ StatusReunioes.nomeTabelaStatusReunioes+"("+
                StatusReunioes.nomeCampoIdStatusReunioes+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                StatusReunioes.nomeCampoDescricaoStatusReunioes+"VARCHAR(100) NOT NULL)";
        // Fim do primeiro Script. Ele foi colocado propositalmente primeiro para que a tabela Status reuniões seja criada
        // Antes de ser referenciada como FK da tabela Reuniões.

        String SQL = "CREATE TABLE "+ Reunioes.nomeTabelaReunioes+"("+
                Reunioes.nomeCampoId+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Reunioes.nomeCampoDataReuniao+"DATETIME NOT NULL,"+
                Reunioes.nomeCampoDescricaoReuniao+"VARCHAR(100) NOT NULL"+
                Reunioes.nomeCampoStatusReuniao+"INT NOT NULL FOREIGN KEY REFERENCES "+StatusReunioes.nomeTabelaStatusReunioes+"("+StatusReunioes.nomeCampoIdStatusReunioes+");" +
                      "INSERT INTO "+StatusReunioes.nomeTabelaStatusReunioes+"("+StatusReunioes.nomeCampoDescricaoStatusReunioes+")" +
                      "VALUES(Agendada)"+
                      "INSERT INTO "+StatusReunioes.nomeTabelaStatusReunioes+"("+StatusReunioes.nomeCampoDescricaoStatusReunioes+")" +
                      "VALUES(Ocorrida)";;
        db.execSQL(SQL1);
        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS"+Reunioes.nomeTabelaReunioes);
            db.execSQL("DROP TABLE IF EXISTS"+StatusReunioes.nomeTabelaStatusReunioes);
            onCreate(db);
    }

    public static CriarBancoSQLite retornarBancoSQLite(Context context){
        return new CriarBancoSQLite(context,nomeBanco,null,versao);
    }
}
