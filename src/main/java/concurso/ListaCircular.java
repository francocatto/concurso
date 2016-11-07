package concurso;

import java.util.Iterator;

/**
 * Created by fc on 07/11/16.
 */
public class ListaCircular<T> implements Lista<T> {

    private Celula<T> ultima = null;

    private int tamanho = 0;

    @Override
    public void adiciona(T elemento) {
        adicionaNoComeco(elemento);
        rotaciona();
    }

    public void rotaciona() {
        ultima = ultima.getProxima();
    }

    @Override
    public void adiciona(int posicao, T elemento) {
        if (posicao == 0)
            adicionaNoComeco(elemento);

    }

    @Override
    public void adicionaNoComeco(T elemento) {
        if (tamanho == 0) {
            ultima = new Celula<T>(elemento);
            ultima.setProxima(ultima);
        } else {
            Celula<T> novaPrimeira = new Celula<>(elemento, ultima.getProxima());
            ultima.setProxima(novaPrimeira);
        }
        tamanho++;
    }

    @Override
    public T pega(int posicao) {
        return null;
    }

    @Override
    public T remove(int posicao) {
        return null;
    }

    @Override
    public T removeDoComeco() {
        if (estaVazio())
            return null;
        Celula<T> primeira = ultima.getProxima();
        Celula<T> ultimaASerExcluida = ultima;
        if (primeira == ultima) {
            ultima = null;
        } else {
            Celula<T> proxima = primeira.getProxima();
            ultima.setProxima(proxima);
            ultimaASerExcluida = proxima;
        }
        tamanho--;
        return ultimaASerExcluida.getElemento();
    }

    @Override
    public T remove() {
        Celula<T> penultima = ultima;
        Celula<T> primeira = ultima.getProxima();
        for (int i = 0; i < tamanho - 1; i++) {
            penultima = penultima.getProxima();
        }
        penultima.setProxima(primeira);
        tamanho--;
        return penultima.getElemento();
    }

    private boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public boolean remove(T elemento) {
        return false;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public boolean contem(T o) {
        return false;
    }

    @Override
    public void adicionarTodos(Lista<T> lista) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
