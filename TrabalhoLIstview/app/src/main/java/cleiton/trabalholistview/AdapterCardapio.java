package cleiton.trabalholistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cleiton Gonçalves on 30/11/2015.
 */
public class AdapterCardapio extends BaseAdapter {

    private Context ctx;
    private List<Cardapio> listaCardapio;

    public AdapterCardapio(Context ctx, List<Cardapio> listaCardapio){
        this.ctx = ctx;
        this.listaCardapio = listaCardapio;
    }

    @Override
    public int getCount() {
        return listaCardapio.size();
    }

    @Override
    public Object getItem(int posicao) {
        return listaCardapio.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return listaCardapio.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        Cardapio cardapio = listaCardapio.get(posicao);

        View view = LayoutInflater.from(ctx).inflate(R.layout.tela_lanche, null);

        TextView texto = (TextView) view.findViewById(R.id.texViewtLanche);

        texto.setText(cardapio.getConteudo());

        return view;
    }
}
