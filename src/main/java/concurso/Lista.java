package concurso;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by fc on 26/10/16.
 */
public interface Lista<T> extends Iterable<T> {

    public void adiciona(T elemento);
    public void adiciona(int posicao, T elemento);
    public void adicionaNoComeco(T elemento);
    public T pega(int posicao);
    public T remove(int posicao);
    public T removeDoComeco();
    public T remove();
    public boolean remove(T elemento);
    public int tamanho();
    public boolean contem(T o);
    public void adicionarTodos(Lista<T> lista);
    public Iterator<T> iterator();
}
