package com.apps.marcos.makeyourmeetings.Models;

import java.util.Calendar;

public class Reunioes {

    /*--------------------------------------------------------------------------------------------------------------------------------|
    * Classe: Reunioes
    *
    * Função: Mapeia a tabela de Reuniões. Serve de configuração para a base SQLIte da aplicação e para modelagem dos dados que serão posteriormente
    * inseridos nesta.
    *
    * Criação: 09/12/2015.
    *
    * Modificação: 10/12/2015
    *
    * Métodos:
    * Gets e sets.
    *
    * -------------------------------------------------------------------------------------------------------------------------------|
    * */

    public static final String nomeTabelaReunioes = "reunioes";
    public static final String nomeCampoDataReuniao = "dataReuniao";
    public static final String nomeCampoStatusReuniao = "statusReuniao";
    public static final String nomeCampoId = "idReuniao";
    public static final String nomeCampoDescricaoReuniao = "descricaoReuniao";

    private Calendar dataReuniao;
    private int statusReuniao;
    private String descricaoReuniao;

    public Reunioes(Calendar dataReuniao, int statusReuniao, String descricaoReuniao){
        this.dataReuniao = dataReuniao;
        this.statusReuniao = statusReuniao;
        this.descricaoReuniao = descricaoReuniao;
    }

    public Calendar getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(Calendar dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public int getStatusReuniao() {
        return statusReuniao;
    }

    public void setStatusReuniao(int statusReuniao) {
        this.statusReuniao = statusReuniao;
    }

    public String getDescricaoReuniao() {
        return descricaoReuniao;
    }

    public void setDescricaoReuniao(String descricaoReuniao) {
        this.descricaoReuniao = descricaoReuniao;
    }
}
