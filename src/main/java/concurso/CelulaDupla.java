package concurso;

/**
 * Created by fc on 26/10/16.
 */
public class CelulaDupla<T> {

    private T elemento;

    private CelulaDupla<T> proxima;

    private CelulaDupla<T> anterior;

    public CelulaDupla(T elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla(T elemento, CelulaDupla<T> proxima) {
        this.elemento = elemento;
        this.proxima = proxima;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla<T> getProxima() {
        return proxima;
    }

    public void setProxima(CelulaDupla<T> proxima) {
        this.proxima = proxima;
    }

    public CelulaDupla<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaDupla<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "CelulaDupla{" +
                "elemento=" + elemento +
                ", proxima=" + proxima +
                ", anterior=" + anterior +
                '}';
    }
}
