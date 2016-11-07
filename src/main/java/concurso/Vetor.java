package concurso;

import java.util.Iterator;

/**
 * Created by fc on 17/10/16.
 */
public interface Vetor<T> extends Iterable<T> {
    void adicionar(T elemento);

    void remover();

    boolean contem(T elemento);

    void adicionar(int posicao, T elemento);

    void remover(int posicao);

    int tamanho();

    T pega(int posicao);

    String toString();

    void clear();

    Iterator<T> iterator();
}
