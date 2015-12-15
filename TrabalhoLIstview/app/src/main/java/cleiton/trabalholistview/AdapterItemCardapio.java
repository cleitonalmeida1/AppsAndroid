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
public class AdapterItemCardapio extends BaseAdapter {

    private Context ctx;
    private List<InfoLanches> listaInfoLanches;

    public AdapterItemCardapio(Context ctx, List<InfoLanches> listaCardapio){
        this.ctx = ctx;
        this.listaInfoLanches = listaCardapio;
    }

    @Override
    public int getCount() {
        return listaInfoLanches.size();
    }

    @Override
    public Object getItem(int posicao) {
        return listaInfoLanches.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return listaInfoLanches.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        InfoLanches infoLanches = listaInfoLanches.get(posicao);

        View view = LayoutInflater.from(ctx).inflate(R.layout.tela_info_lanche, null);

        TextView item = (TextView) view.findViewById(R.id.textViewItemInfo);
        TextView conteudo = (TextView) view.findViewById(R.id.textViewConteudoInfo);

        item.setText(infoLanches.getItem());
        conteudo.setText(String.valueOf(infoLanches.getValor()));

        return view;
    }
}
