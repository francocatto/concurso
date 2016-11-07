package concurso;

import java.util.List;

/**
 * Created by fc on 04/11/16.
 */
public interface Conjunto<T> {

    public void adiciona(T elemento);

    public void remove(T elemento);

    public boolean contem(T elemento);

    public Lista<T> pegaTodos();

    public int tamanho();
}
