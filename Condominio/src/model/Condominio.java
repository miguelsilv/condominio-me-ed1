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
    private int codBloco = 1;

    public Condominio(int codigo, String nome, double valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        listaBlocos = new MyVetor<>();
    }

    public int addBloco(String nome) {
        this.listaBlocos.adicionar(new Bloco(codBloco++, nome));
        return codBloco - 1;
    }


    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public MyVetor<Bloco> getListaBlocos() {
        return listaBlocos;
    }
    
    

}
