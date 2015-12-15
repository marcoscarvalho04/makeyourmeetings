package com.apps.marcos.makeyourmeetings.Persistencia;

import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLInput;

/*--------------------------------------------------------------------------------------------------------------------------------|
 * Classe: DatabaseManager
 *
 * Função: Faz o gerenciamento do Database, criando conexões de acordo com a necessidade das classes.
 *
 * Métodos:
 * getReadbleDatabase - Retorna uma database para leitura de acordo com o banco criado.
 * getWritableDatabasae - Retorna uma database para escrita de acordo com o banco criado.
 *
 * -------------------------------------------------------------------------------------------------------------------------------|
     * */
public class DatabaseManager {


    public static SQLiteDatabase getReadbleDatabase(CriarBancoSQLite criarBancoSQLite){
        return criarBancoSQLite.getReadableDatabase();
    }

    public static SQLiteDatabase getWritableDatabase(CriarBancoSQLite criarBancoSQLite) {
        return criarBancoSQLite.getWritableDatabase();
    }

}
