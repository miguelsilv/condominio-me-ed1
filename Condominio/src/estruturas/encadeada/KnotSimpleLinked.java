package estruturas.encadeada;

/**
 *
 * @author Miguel Silva (1271106300)
 */
public class KnotSimpleLinked<Tipo> {

    private Tipo conteudo;
    private KnotSimpleLinked<Tipo> proximo;

    public KnotSimpleLinked(Tipo conteudo, KnotSimpleLinked<Tipo> proximo) {
        this.conteudo = conteudo;
        this.proximo = proximo;
    }

    public KnotSimpleLinked(Tipo conteudo) {
        this.conteudo = conteudo;
        this.proximo = null;
    }

    public Tipo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Tipo conteudo) {
        this.conteudo = conteudo;
    }

    public KnotSimpleLinked<Tipo> getProximo() {
        return proximo;
    }

    public void setProximo(KnotSimpleLinked<Tipo> proximo) {
        this.proximo = proximo;
    }

}
