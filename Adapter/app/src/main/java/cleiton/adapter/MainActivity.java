package cleiton.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import adapter.CustomAdapter;
import adapter.view.Update;
import butterknife.Bind;
import butterknife.ButterKnife;
import helper.BancoHelper;
import model.Agenda;

public class MainActivity extends AppCompatActivity {
    BancoHelper bh;
    @Bind(R.id.listItens)
    ListView listView;
    private List<Agenda> agendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        bh =  new BancoHelper(getBaseContext());

        agendas = bh.getAllAgendas();

        CustomAdapter custonAdapter = new CustomAdapter(agendas, getApplicationContext());
        listView.setAdapter(custonAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),Update.class);
                startActivity(i);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(),Update.class);
                i.putExtra("agenda",agendas.get(position));
                startActivity(i);
            }
        });
    }

    private void atualizaLista(){
        agendas= bh.getAllAgendas();

        CustomAdapter custonAdapter = new CustomAdapter(agendas, getApplicationContext());
        listView.setAdapter(custonAdapter);
    }



}