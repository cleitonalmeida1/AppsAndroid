package cleiton.trabalholistview;

import java.io.Serializable;

public class Cardapio implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String conteudo;
    private String ingredientes;
    private double valor;

    public Cardapio(int id, String conteudo, String ingredientes, double valor){
        this.id = id;
        this.conteudo = conteudo;
        this.ingredientes = ingredientes;
        this.valor = valor;

    }

    public String getConteudo(){
        return conteudo;
    }

    public int getId(){
        return id;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public double getValor() {
        return valor;
    }
}
