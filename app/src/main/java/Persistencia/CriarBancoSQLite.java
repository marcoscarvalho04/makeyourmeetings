package Persistencia;

import com.apps.marcos.makeyourmeetings.Activities.MainActivity;
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
    private static final String nomeTabelaReunioes = "reunioes";
    private static final String nomeCampoDataReuniao = "dataReuniao";
    private static final String nomeCampoStatusReuniao = "statusReuniao";
    private static final String nomeCampoId = "idReuniao";
    private static final String nomeTabelaStatusReunioes ="statusReunioes";
    private static final String nomeCampoIdStatusReunioes = "idStatusReunioes";
    private static final String nomeCampoDescricaoStatusReunioes = "descricaoStatusReunioes";
    private static final int versao = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE "+this.nomeTabelaReunioes+"("+
                this.nomeCampoId+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                this.nomeCampoDataReuniao+"DATETIME NOT NULL,"+
                this.nomeCampoStatusReuniao+"INT NOT NULL);" +
                      "CREATE TABLE "+this.nomeTabelaStatusReunioes+"("+
                        this.nomeCampoIdStatusReunioes+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        this.nomeCampoDescricaoStatusReunioes+"VARCHAR(100) NOT NULL)"+
                      "INSERT INTO "+this.nomeTabelaStatusReunioes+"("+this.nomeCampoDescricaoStatusReunioes+")" +
                      "VALUES(Agendada)"+
                      "INSERT INTO "+this.nomeTabelaStatusReunioes+"("+this.nomeCampoDescricaoStatusReunioes+")" +
                      "VALUES(Ocorrida)";;
        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS"+this.nomeTabelaReunioes);
            onCreate(db);
    }
}
