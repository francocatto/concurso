package concurso;

/**
 * Created by fc on 26/10/16.
 */
public class Celula {

    private Object elemento;

    private Celula proxima;

    public Celula(Object elemento) {
        this.elemento = elemento;
    }

    public Celula(Object elemento, Celula proxima) {
        this.elemento = elemento;
        this.proxima = proxima;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Celula getProxima() {
        return proxima;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }
}
