package concurso;

/**
 * Created by fc on 04/11/16.
 */
public interface Conjunto<T> {

    void adiciona(T elemento);

    void remove(T elemento);

    boolean contem(T elemento);

    Lista<T> pegaTodas();

    int tamanho();
}
