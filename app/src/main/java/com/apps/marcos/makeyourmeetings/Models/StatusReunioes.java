package com.apps.marcos.makeyourmeetings.Models;

/*--------------------------------------------------------------------------------------------------------------------------------|
* Classe: Reunioes
*
* Função: Mapeia a tabela de StatusReuniões. Modela e configura a parte do banco referente à tabela de statusReunioes.
*
* Métodos:
* Gets e sets
*
* Criação: 09/12/2015.
*
* Modificação: 10/12/2015
*
* -------------------------------------------------------------------------------------------------------------------------------|
* */
public class StatusReunioes {

    public static final String nomeTabelaStatusReunioes ="statusReunioes";
    public static final String nomeCampoIdStatusReunioes = "idStatusReunioes";
    public static final String nomeCampoDescricaoStatusReunioes = "descricaoStatusReunioes";

    private String descricaoStatusReunioes;
    public StatusReunioes(String descricaoStatusReunioes){
        this.descricaoStatusReunioes = descricaoStatusReunioes;

    }

    public String getDescricaoStatusReunioes() {
        return descricaoStatusReunioes;
    }

    public void setDescricaoStatusReunioes(String descricaoStatusReunioes) {
        this.descricaoStatusReunioes = descricaoStatusReunioes;
    }
}
