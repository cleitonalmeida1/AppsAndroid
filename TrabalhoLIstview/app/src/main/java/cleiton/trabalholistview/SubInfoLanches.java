package cleiton.trabalholistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Cleiton Gonçalves on 30/11/2015.
 */
public class SubInfoLanches extends Activity {

    private ListView listViewInfoLanches;
    private Cardapio cardapioSelecionado;
    private ArrayList<InfoLanches> listaSubInfoLanche;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_info_lanches);

        listViewInfoLanches = (ListView) findViewById(R.id.listViewSubCardapioInfo);

        cardapioSelecionado = (Cardapio) getIntent().getSerializableExtra("CARDAPIO");
        preencheSubInfoLanche();
    }

    private void preencheSubInfoLanche(){
        listaSubInfoLanche = new ArrayList<InfoLanches>();


        InfoLanches info = new InfoLanches(cardapioSelecionado.getId(), cardapioSelecionado.getIngredientes(), cardapioSelecionado.getValor());
        listaSubInfoLanche.add(info);

        AdapterItemCardapio adapter = new AdapterItemCardapio(SubInfoLanches.this, listaSubInfoLanche);
        listViewInfoLanches.setAdapter(adapter);
    }
}
