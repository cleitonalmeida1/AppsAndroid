package cleiton.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Item> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView)findViewById(R.id.listItens);
        itens=new ArrayList<Item>();
        Popula();
        CustomAdapter custonAdapter = new CustomAdapter(itens,getApplicationContext());
        listView.setAdapter(custonAdapter);
    }

    private void Popula(){
        itens.add(new Item("Cleiton","(67) 3291-7701"));
        itens.add(new Item("Priscila","(67) 3291-2212"));
        itens.add(new Item("Creuza","(43) 8743-4856"));
        itens.add(new Item("Renan","(43) 8732-1234"));

    }
}