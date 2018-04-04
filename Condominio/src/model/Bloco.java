package model;

import estruturas.vetor.MyVetor;

/**
 *
 * @author Miguel Silva (1271106300)
 */
public class Bloco {

    private int codigo;
    private String nome;
    private MyVetor<Integer> apartamentos;

    public Bloco(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void addApartamento() {

    }

}
