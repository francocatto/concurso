package concurso;

/**
 * Created by fc on 26/10/16.
 */
public interface Lista<T> {

    public void adiciona(T elemento);
    public void adiciona(int posicao, T elemento);
    public void adicionaNoComeco(T elemento);
    public T pega(int posicao);
    public T remove(int posicao);
    public T removeDoComeco();
    public T remove();
    public int tamanho();
    public boolean contem(T o);
}
