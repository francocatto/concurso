package concurso;

/**
 * Created by fc on 04/11/16.
 */
public interface Fila<T> {

    public void insere(T elemento);

    public T remove();

    public boolean vazia();
}
