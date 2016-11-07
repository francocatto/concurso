package concurso;

/**
 * Created by fc on 17/10/16.
 */
public interface Vetor<T> {
    void adicionar(T elemento);

    void remover();

    boolean contem(T elemento);

    void adicionar(int posicao, T elemento);

    void remover(int posicao);

    int getTotal();

    T pega(int posicao);

    String toString();

    public void clear();
}
