/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas.encadeada;

import estruturas.interfaces.Lista;
import java.security.InvalidParameterException;
import java.util.Iterator;

/**
 *
 * @author Miguel Silva (1271106300)
 * @param <Tipo> Tipo da lista
 */
public class MySimpleLinked<Tipo> implements Lista<Tipo> {

    private KnotSimpleLinked<Tipo> inicio, fim;
    private int contador;

    public MySimpleLinked() {
        this.contador = 0;
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public void adicionar(Tipo elemento) {
        KnotSimpleLinked<Tipo> item = new KnotSimpleLinked<>(elemento);
        if (this.inicio == null) {
            this.inicio = item;
        } else {
            this.fim.setProximo(item);
        }
        this.fim = item;
        this.contador++;
    }

    @Override
    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException {
        if (posicao > 0 && posicao <= this.contador) {
            KnotSimpleLinked<Tipo> novo = new KnotSimpleLinked<>(elemento);
            KnotSimpleLinked<Tipo> proximo = this.inicio;
            KnotSimpleLinked<Tipo> anterior = null;

            for (int i = 0; i < posicao; i++) {
                anterior = proximo;
                proximo = proximo.getProximo();
            }
            anterior.setProximo(novo);
            novo.setProximo(proximo);
        } else {
            this.adicionar(elemento);
            System.out.println("AVISO: POSIÇÃO MAIOR QUE O TAMANHO DA LISTA. ITEM ADICIONADO NO FINAL!");
        }
        this.contador++;
    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {
        if (this.contador == 0) {
            this.inicio = this.fim = null;
        } else {
            KnotSimpleLinked<Tipo> aux = this.inicio;
            this.inicio = new KnotSimpleLinked<>(elemento);
            inicio.setProximo(aux);
        }
        this.contador++;
    }

    @Override
    /**
     * @return {int} se não encontrar retorna -1
     */
    public int contem(Tipo elemento) throws InvalidParameterException {
        KnotSimpleLinked<Tipo> atual = this.inicio;
        for (int i = 0; i < this.contador; i++) {
            if (atual.getConteudo().equals(elemento) || atual.getConteudo() == elemento) {
                return i;
            }
            atual = atual.getProximo();
        }
        return -1;
    }

    @Override
    public Tipo obter(int posicao) throws InvalidParameterException {
        if (posicao == 0 && posicao > this.contador) {
            return null;
        } else {
            KnotSimpleLinked<Tipo> atual = this.inicio;
            for (int i = 0; i < posicao; i++) {
                atual = atual.getProximo();
            }
            return atual.getConteudo();
        }

    }

    @Override
    public int tamanho() {
        return this.contador;
    }

    @Override
    public void remover(int posicao) throws InvalidParameterException {
        if (posicao > 0 && posicao <= this.contador) {
            KnotSimpleLinked<Tipo> atual = this.inicio;
            KnotSimpleLinked<Tipo> anterior = null;

            for (int i = 0; i < posicao; i++) {
                anterior = atual;
                atual = atual.getProximo();
            }
            System.out.println(atual.getConteudo());
            anterior.setProximo(atual.getProximo());
            this.contador--;
        } else if (posicao == 0) {
            removerDoInicio();
        }
    }

    @Override
    public int remover(Tipo elemento) {
        KnotSimpleLinked<Tipo> atual = this.inicio;
        KnotSimpleLinked<Tipo> anterior = null;
        for (int i = 0; i < this.contador; i++) {
            if (atual.getConteudo().equals(elemento) || atual.getConteudo() == elemento) {
                anterior.setProximo(atual.getProximo());
                this.contador--;
                return i;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return -1;
    }

    @Override
    public void removerDoInicio() {
        this.inicio = this.inicio.getProximo();
        this.contador--;
    }

    @Override
    public void limpar() {
        this.inicio = this.fim = null;
        this.contador = 0;
    }

    @Override
    public Iterator<Tipo> iterator() {
        return new IteradorSimpleLinked();
    }

    private class IteradorSimpleLinked implements Iterator<Tipo> {

        private KnotSimpleLinked<Tipo> proximo;

        public IteradorSimpleLinked() {
            this.proximo = inicio;
        }

        @Override
        public boolean hasNext() {
            return proximo != null;
        }

        @Override
        public Tipo next() {
            Tipo elemento = this.proximo.getConteudo();
            this.proximo = this.proximo.getProximo();
            return elemento;
        }

    }

}
