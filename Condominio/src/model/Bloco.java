package model;

import estruturas.vetor.MyVetor;

/**
 *
 * @author Miguel Silva (1271106300)
 */
public class Bloco {
    
    private int codigo;
    private String nome;
    private MyVetor<Apartamento> listApartamento;
    
    public Bloco(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.listApartamento = new MyVetor<>();
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public MyVetor<Apartamento> getListAP() {
        return listApartamento;
    }
    
    public void addApartamento(int numeroAP) {
        this.listApartamento.adicionar(new Apartamento(numeroAP));
    }
    
    public void venderAP(int numAP, Pessoa dono) {
        for (Apartamento ap : listApartamento) {
            if (ap.getNumero() == numAP) {
                ap.setDono(dono);
            }
        }
    }
    
}
