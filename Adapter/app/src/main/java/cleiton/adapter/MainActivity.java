package cleiton.adapter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.CustomAdapter;
import helper.Banco;
import model.Agenda;

public class MainActivity extends AppCompatActivity {
    Banco b;
    private ListView listView;
    private ArrayList<Agenda> agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView)findViewById(R.id.listItens);
        b =  new Banco(getBaseContext(), "agenda", null, 1);
        consultaBanco();
        CustomAdapter custonAdapter = new CustomAdapter(agenda,getApplicationContext());
        listView.setAdapter(custonAdapter);
    }

    private void consultaBanco() {
        String sql = "SELECT  nome, telefone, imagem FROM agenda";
        agenda = new ArrayList<Agenda>();
        Cursor cursor = b.buscar(sql);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                Agenda a = new Agenda();
                a.setNome(cursor.getString(0));
                a.setTelefone(cursor.getString(1));
                a.setImagem(cursor.getInt(2));
                agenda.add(a);
                cursor.moveToNext();
            }
        }
    }

    private void Insere(Agenda agenda) {

        SQLiteDatabase base = b.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", agenda.getNome());
        values.put("valor", agenda.getTelefone());

        long resultado = base.insert("lanche", null, values);

        if (resultado != -1) {
            Toast.makeText(this, "Deu Certo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }
    }


}