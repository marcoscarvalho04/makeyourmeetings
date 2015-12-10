package com.apps.marcos.makeyourmeetings.Activities;
import com.apps.marcos.makeyourmeetings.R;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;



/*--------------------------------------------------------------------------------------------------------------------------------|
* Aplicativo: Make your Meetings
*
* Criador: Marcos Carvalho
*
* Função do aplicativo: Facilitar a vida das pessoas, lembrando - as das reuniões que estão por vir e agendando novas reuniões,
* conforme a necessidade de cada um.
*
* Data da criação: 08/12/2015
*
* Release: v0.01
*
*--------------------------------------------------------------------------------------------------------------------------------|
* */



public class MainActivity extends AppCompatActivity {
    /*--------------------------------------------------------------------------------------------------------------------------------|
    * Classe: MainActivity
    *
    * Função: Parte inicial do sistema. Chama a activity principal e a configura para todo o resto do sistema.
    *
    * Métodos:
    * onCreate, onStart: Próprias do android.
    *
    * */
    ListView listReunioesMarcadas;
    Button bntMarcarReuniao;
    Button btnMostrarHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Adicionando os componentes da tela as variáveis instanciadas de classe.*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        this.listReunioesMarcadas = (ListView) findViewById(R.id.listReunioesMarcadas);
        this.bntMarcarReuniao = (Button) findViewById(R.id.bntMarcarReuniao);
        this.btnMostrarHistorico = (Button) findViewById(R.id.bntMostrarHistorico);
    }

    @Override
    protected void onStart(){
        super.onStart();

    }
}
