package concurso;

/**
 * Created by fc on 03/11/16.
 */
public interface Pilha<T> {

    public void insere(T elemento);

    public boolean vazia();

    public T remove();
}
