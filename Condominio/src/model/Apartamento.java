package model;

/**
 *
 * @author Miguel Silva (1271106300)
 */
public class Apartamento {

    private int numero;
    private Pessoa dono;

    public Apartamento(int numero) {
        this.numero = numero;
        this.dono = null;
    }

    public int getNumero() {
        return numero;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }
    
}
