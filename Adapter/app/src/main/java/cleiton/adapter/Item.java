package cleiton.adapter;

import java.io.Serializable;

/**
 * Created by Cleiton Gonçalves on 21/01/2016.
 */
public class Item implements Serializable {
    private String nome;
    private String telefone;

    public Item(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}