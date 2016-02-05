package cleiton.adapter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import adapter.CustomAdapter;
import helper.BancoHelper;
import model.Agenda;

public class MainActivity extends AppCompatActivity {
    BancoHelper bh;
    private ListView listView;
    private List<Agenda> agendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.listItens);

        bh =  new BancoHelper(getBaseContext());

        agendas = bh.getAllLanches();

        CustomAdapter custonAdapter = new CustomAdapter(agendas, getApplicationContext());
        listView.setAdapter(custonAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agenda agenda = new Agenda();
                agenda.setNome("lanche" + agendas.size());
                agenda.setTelefone("(67) 8137-7640");
                agenda.setImagem(R.drawable.foto1);
                bh.addLanche(agenda);

                agendas.add(agenda);


                CustomAdapter custonAdapter = new CustomAdapter(agendas, getApplicationContext());
                listView.setAdapter(custonAdapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Funcao de delete
                agendas.get(position).setImagem(R.drawable.foto2);
                //usando funcao de update
                bh.updateLanche(agendas.get(position));

                atualizaLista();
            }
        });
    }

    private void atualizaLista(){
        agendas= bh.getAllLanches();

        CustomAdapter custonAdapter = new CustomAdapter(agendas, getApplicationContext());
        listView.setAdapter(custonAdapter);
    }



}