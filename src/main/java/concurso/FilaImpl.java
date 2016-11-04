package concurso;

/**
 * Created by fc on 04/11/16.
 */
public class FilaImpl<T> implements Fila<T> {

    private ListaDuplamenteLigada<T> lista = new ListaDuplamenteLigada<T>();

    public void insere(T elemento) {
        lista.adiciona(elemento);
    }

    public T remove() {
       return lista.removeDoComeco();
    }

    public boolean vazia() {
        return lista.tamanho() == 0;
    }
}
