package model;

/**
 *
 * @author Miguel Silva (1271106300)
 */
public class Pessoa {

    private String cpf, nome;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
