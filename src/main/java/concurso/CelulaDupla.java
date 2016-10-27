package concurso;

/**
 * Created by fc on 26/10/16.
 */
public class CelulaDupla {

    private Object elemento;

    private CelulaDupla proxima;

    private CelulaDupla anterior;

    public CelulaDupla(Object elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla(Object elemento, CelulaDupla proxima) {
        this.elemento = elemento;
        this.proxima = proxima;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla getProxima() {
        return proxima;
    }

    public void setProxima(CelulaDupla proxima) {
        this.proxima = proxima;
    }

    public CelulaDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaDupla anterior) {
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
