/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas.vetor;

import java.security.InvalidParameterException;
import java.util.Iterator;
import estruturas.interfaces.Lista;

/**
 *
 * @author migue
 * @param <Tipo> do array
 */
public class MyVetor<Tipo> implements Lista<Tipo> {

    private Tipo[] elementos;
    private int contador;

    public MyVetor() {
        this.elementos = ((Tipo[]) new Object[10]);
        this.contador = 0;
    }

    public MyVetor(int tamanho) throws ArrayIndexOutOfBoundsException {

        this.elementos = ((Tipo[]) new Object[tamanho]);
        this.contador = 0;
    }

    public void aumentar() {
        if (this.contador == elementos.length) {
            Tipo[] aux = (Tipo[]) new Object[(elementos.length + 1) * 2];
            for (int i = 0; i < elementos.length; i++) {
                aux[i] = elementos[i];
            }
            elementos = aux;
        }
    }

    @Override
    public void adicionar(Tipo elemento) {
        this.adicionar(this.contador, elemento);
    }

    @Override
    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException {
        aumentar();

        if (this.contador != posicao && posicao < this.contador && this.tamanho() > posicao) {
            for (int i = this.contador; i > posicao; i--) {
                Tipo aux = this.elementos[i];
                this.elementos[i] = this.elementos[i - 1];
                this.elementos[i - 1] = aux;
            }
        } else if (posicao > this.contador) {
            posicao = this.contador;
        }
        this.elementos[posicao] = elemento;
        this.contador++;
    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {
        this.adicionar(0, elemento);
    }

    @Override
    /**
     * @return {int} se não encontrar retorna -1
     */
    public int contem(Tipo elemento) throws InvalidParameterException {
        for (int i = 0; i < this.contador; i++) {
            if (this.elementos[i].equals(elemento) || this.elementos[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Tipo obter(int posicao) throws InvalidParameterException {
        return this.elementos[posicao];
    }

    @Override
    public int tamanho() {
        return this.contador;
    }

    @Override
    public int capacidade() {
        return this.elementos.length;
    }

    @Override
    public void remover(int posicao) throws InvalidParameterException {
        this.elementos[posicao] = null;
        for (int i = posicao; i < this.contador; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.contador--;
    }

    @Override
    public int remover(Tipo elemento) {
        int index = this.contem(elemento);
        if (index != -1) {
            this.remover(index);
        }
        return index;
    }

    @Override
    public void removerDoInicio() {
        this.remover(0);
    }

    @Override
    public void limpar() {
        this.elementos = ((Tipo[]) new Object[10]);
    }

    @Override
    public Iterator<Tipo> iterator() {
        return new IteradorVetor();
    }

    private class IteradorVetor implements Iterator<Tipo> {

        int posicao = 0;

        @Override
        public boolean hasNext() {
            return posicao < contador;
        }

        @Override
        public Tipo next() {
            return elementos[posicao++];
        }
    }
}
