package cleiton.trabalholistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Cleiton Gonçalves on 30/11/2015.
 */
public class TelaListaLanches extends Activity {

    private ArrayList<Cardapio> listaCardapio;

    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_lanche);

        listView = (ListView) findViewById(R.id.listViewCardapio);

        preencheLista();
        clickLista();
    }

    private void preencheLista() {
        listaCardapio = new ArrayList<Cardapio>();

        Cardapio x_eggie = new Cardapio(1, "X_eggie", "pão, ovo, mussarela e hambúrguer", 7);
        Cardapio x_salada = new Cardapio(2, "X-Salada", "pão, mussarela, presunto, catupiry, hamburguer, salada", 8);
        Cardapio x_calabresa = new Cardapio(3, "X-Calabresa", "pão, hambúrguer, presunto, mussarela, alface, tomate e salsicha", 4);
        Cardapio x_coracao = new Cardapio(4, "X-Coração", "pão, coração, alface, presunto, mussarela", 14);
        Cardapio x_bagunca = new Cardapio(5, "X-Bagunça", "pão, hambúrguer, salsicha, presento, mussarela, bacon", 10);
        Cardapio x_tudo = new Cardapio(6, "X-Tudo", "pão, hambúrguer, presunto, mussarela, alface, tomate, ovo, salsicha, calabresa e bacon", 11);
        Cardapio x_baguncinha = new Cardapio(7, "X-Baguncinha", "pão, salsicha, hambúguer, presento e mussarela", 9);
        Cardapio x_casa = new Cardapio(8, "X-Casa", "pão, hambúguer, molho especial, presento, mussarela, milho, ervilha, bacon, salsicha", 9);
        Cardapio x_mignon = new Cardapio(9, "X-Mignon", "pão, filé mignon, presento, mussarela e ovo", 14);
        Cardapio x_salsicha = new Cardapio(10, "X-Salsicha", "pão, salsicha, batata palha e molho", 5);


        listaCardapio.add(x_eggie);
        listaCardapio.add(x_salada);
        listaCardapio.add(x_calabresa);
        listaCardapio.add(x_coracao);
        listaCardapio.add(x_bagunca);
        listaCardapio.add(x_tudo);
        listaCardapio.add(x_baguncinha);
        listaCardapio.add(x_casa);
        listaCardapio.add(x_mignon);
        listaCardapio.add(x_salsicha);

        AdapterCardapio adapterCardapio = new AdapterCardapio(TelaListaLanches.this, listaCardapio);
        listView.setAdapter(adapterCardapio);
    }

    private void clickLista() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
                Cardapio cardapio = (Cardapio) adapter.getAdapter().getItem(posicao);
                Intent intent = new Intent(TelaListaLanches.this, SubInfoLanches.class);
                intent.putExtra("CARDAPIO", cardapio);
                startActivity(intent);

                Toast.makeText(TelaListaLanches.this, cardapio.getConteudo(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
