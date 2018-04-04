package estruturas.interfaces;

import java.security.InvalidParameterException;

/**
 *
 * @author Miguel Silva(1271106300)
 * @param <Tipo> Tipo do vetor
 */
public interface Lista<Tipo> extends Iterable<Tipo> {

    public void adicionar(Tipo elemento);

    public void adicionar(int posicao, Tipo elemento) throws InvalidParameterException;

    public void adicionarNoInicio(Tipo elemento);

    public int contem(Tipo elemento) throws InvalidParameterException;

    public Tipo obter(int posicao) throws InvalidParameterException;

    public int tamanho();

    public default int capacidade() {
        return Integer.MAX_VALUE;
    }

    public void remover(int posicao) throws InvalidParameterException;

    public int remover(Tipo elemento);

    public void removerDoInicio();

    public void limpar();

}
