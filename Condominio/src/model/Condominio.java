package model;

import estruturas.vetor.MyVetor;

/**
 *
 * @author Miguel Silva (1271106300)
 */
public class Condominio {

    private int codigo;
    private String nome;
    private double valor;
    private MyVetor<Bloco> listaBlocos;

    public Condominio(int codigo, String nome, double valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        listaBlocos = new MyVetor<>();
    }
    
    

}
