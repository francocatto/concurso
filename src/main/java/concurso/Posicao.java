package concurso;

/**
 * Created by fc on 09/11/16.
 */
public interface Posicao<T> {
    T getElement() throws IllegalStateException;
}