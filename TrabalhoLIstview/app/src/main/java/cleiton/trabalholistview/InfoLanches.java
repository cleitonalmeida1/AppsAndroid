package cleiton.trabalholistview;

/**
 * Created by Cleiton Gonçalves on 30/11/2015.
 */
public class InfoLanches {
    private int id;
    private String item;
    private double valor;

    public InfoLanches(int id, String item, double valor){
        this.id = id;
        this.item = item;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public double getValor() {
        return valor;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setConteudo(double valor) {
        this.valor = valor;
    }
}
