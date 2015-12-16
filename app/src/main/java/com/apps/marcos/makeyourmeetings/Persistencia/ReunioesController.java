package com.apps.marcos.makeyourmeetings.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import com.apps.marcos.makeyourmeetings.Models.Reunioes;

/*--------------------------------------------------------------------------------------------------------------------------------|
   * Classe: ReunioesController
   *
   * Função: Classe responsável pelo controle da tabela reuniões, trazendo informações filtradas e prontas para manipulação.
   *
   * Métodos:
   * boolean inserirNovaReuniao: Através de uma classe Reuniao, é feita a persistência dos dados inseridos pelo usuário para
   * criação de uma nova reunião.
   * Cursor selecionarUmaReuniao - Selecionar uma reunião com a classe passada via parâmetro.
   * Cursor selecionarPorData - Seleciona uma reunião na data repassada por parâmetro.
   *
   * -------------------------------------------------------------------------------------------------------------------------------|
       * */
public class ReunioesController {
    public SQLiteDatabase db;
    public CriarBancoSQLite criarBancoSQLite;

    public ReunioesController(Context context){
        criarBancoSQLite = CriarBancoSQLite.retornarBancoSQLite(context);
    }

    public boolean inserirNovaReuniao(Reunioes reuniao){
        /*
        * Método: inserirNovaReuniao
        *
        * Função: fazer a inserção de informações sobre reuniões na base SQLite do aparelho.
        *
        * Retorno:
        * true - informação inserida com sucesso.
        * IllegalException - Exceção ao tentar fazer a inserção da informação.
        *
        * */
        ContentValues valores = new ContentValues();
        long resultado;
        this.db = DatabaseManager.getWritableDatabase(this.criarBancoSQLite);
        System.out.println("DEBUG: Checando valores antes de inserir o registro");
        if(reuniao.getDataReuniao() == null || reuniao.getDescricaoReuniao() == null || reuniao.getStatusReuniao() <= 0 ){
            System.out.println("DEBUG: Pelo menos um valor é nulo. Jogando exceção, uma vez que todos os valores devem vir preenchidos");
            throw new IllegalArgumentException("Todos os valores devem vir preenchidos");
        }
        System.out.println("DEBUG: Evitando violação de chaves e checando se o status reunião está inserido na tabela de statusReunioes");


        System.out.println("DEBUG: Iniciando execução do método: inserirNovaReuniao. Colocando dados da reunião");

        valores.put("dataReuniao", String.valueOf(reuniao.getDataReuniao()));
        valores.put("statusReuniao", reuniao.getStatusReuniao());
        valores.put("descricaoReuniao", reuniao.getDescricaoReuniao());
        System.out.println("DEBUG: Dados inseridos, começando inserção no banco de dados!");
        resultado = db.insert(reuniao.nomeTabelaReunioes, null, valores);
        if(resultado==-1)
        {
            System.out.println("DEBUG: Problema ao fazer a inserção da informação na base. Jogando exceção");
            throw new IllegalArgumentException("Não foi possível inserir a informação.");
        }
        else {
            System.out.println("DEBUG: Informação inserida com sucesso! Método: inserirNovaReuniao finalizado");
            return true;
        }


    }

    public Cursor selecionarUmaReuniao(Reunioes reuniao){
          /*
        * Método: selecionarUmaReuniao
        *
        * Função: Pesquisar sobre uma reunião através da classe Reuniões. Os atributos serão vistos e então pesquisados para filtrarmos
        * os dados da pesquisa.
        *
        * Retorno:
        *  Cursor - Informação (Ou informações) levantadas a partir da classe.
        *  null - nenhuma informação.
        * IllegalException - Exceção ao tentar fazer a consulta da informação
        *
        * */
        System.out.println("DEBUG: Inicio do método: selecionarUmaReuniao.\n\n\n\n");
        Cursor cursor;
        db = DatabaseManager.getReadbleDatabase(this.criarBancoSQLite);
        System.out.println("DEBUG: Inicio das validações de dados. Verificando se há algum campo nulo ou incorreto");
        System.out.println("na classe recebida via parâmetro");
        if(reuniao.getDataReuniao() == null && reuniao.getDescricaoReuniao() == null && reuniao.getStatusReuniao()<= 0 &&
                reuniao.getIdReuniao() <= 0 ){
            System.out.println("DEBUG: Houve um problema. Todos os parâmetros estão nulos e os ids menores ou iguais a 0. Lançar" +
                    "exceção");
            throw new IllegalArgumentException("Todos os parâmetros estão incorretos. Setar pelo menos um parâmetros para continuar a pesquisa");
        }
        // Iniciando pesquisa. Verificando quais campos estão preenchidos.
        LinkedList<String> campos = new LinkedList<String>();
        LinkedList<String> valoresCampos = new LinkedList<String>();
        System.out.println("DEBUG: Campos validados. Checando quais os campos estão preenchidos para a pesquisa ser iniciada.");
        String clausuraWhere = "";
        if(reuniao.getIdReuniao() > 0) {
            campos.add("idReuniao");
            valoresCampos.add(String.valueOf(reuniao.getIdReuniao()));
        }
        if(reuniao.getStatusReuniao() > 0){
            System.out.println("DEBUG: Checando consistência de dados: Verificando se o status reunião está na tabela de status Reuniões");
            campos.add("statusReuniao");
            valoresCampos.add(String.valueOf(reuniao.getStatusReuniao()));
        }
        if(reuniao.getDescricaoReuniao() != null) {
            campos.add("descricaoReuniao");
            valoresCampos.add(reuniao.getDescricaoReuniao());
        }
        if(reuniao.getDataReuniao() != null){
            campos.add("dataReuniao");
            valoresCampos.add(String.valueOf(reuniao.getDataReuniao()));
        }
        System.out.println("DEBUG: Campos coletados: \n idReuniao = "+reuniao.getIdReuniao()+"\n statusReuniao = "+reuniao.getStatusReuniao());
        System.out.println("descricaoReuniao = "+reuniao.getDescricaoReuniao()+"\ndataReuniao = "+reuniao.getDataReuniao().toString());
        System.out.println("DEBUG: Montando clausura WHERE ");
        for(String campoSelecionado : campos){
            clausuraWhere += campoSelecionado+"=? AND";
        }
        System.out.println("DEBUG: Clausura WHERE montada. montando o cursor para a pesquisa");
        String camposPesquisa[] = (String[]) campos.toArray();
        cursor = db.query(reuniao.nomeTabelaReunioes,camposPesquisa,clausuraWhere,(String[]) valoresCampos.toArray(),null,null,"idReuniao");
        System.out.println("DEBUG: pesquisa feita. Verificando cursor para retornar o valor certo do método");
        if(cursor == null) return null;
        db.close();
        cursor.moveToFirst();
        System.out.println("DEBUG: Término do método de pesquisa: selecionarUmaReuniao. Retornando cursor com o resultado");
        return cursor;

    }

    public Cursor selecionarPorData(GregorianCalendar data){
    /*
        * Método: selecionarPorData
        *
        * Função: Pesquisa uma reuinião pela data passada via parâmetro.
        *
        * Retorno:
        *  Cursor - Reuniões pesquisadas.
        *  null - nenhuma informação.
        *  IllegalException - Exceção ao tentar fazer a consulta da informação
        *
        * */
        System.out.println("DEBUG: Verificando data (Se nula ou data válida)");
        if(data == null){
            System.out.println("DEBUG: Data veio nula. Jogando exceção para tratamento");
            throw new IllegalArgumentException("Data nula.");

        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    }


}
