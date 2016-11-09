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
        else {
            Celula<T> anterior = pegaCelula(posicao - 1);
            Celula<T> atual = anterior.getProxima();
            anterior.setProxima(new Celula<T>(elemento, atual));
            tamanho++;
        }
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

    private Celula<T> pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula<T> atual = ultima.getProxima();
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.tamanho;
    }

    @Override
    public T pega(int posicao) {
        return pegaCelula(posicao).getElemento();
    }

    @Override
    public T remove(int posicao) {
        if (posicao == tamanho - 1)
            return remove();
        else if (posicao == 0)
            return removeDoComeco();
        else {
            Celula<T> anterior = pegaCelula(posicao - 1);
            Celula<T> atual = anterior.getProxima();
            Celula<T> proxima = atual.getProxima();
            anterior.setProxima(proxima);
            return atual.getElemento();
        }
    }

    @Override
    public T removeDoComeco() {
        if (estaVazio())
            return null;
        Celula<T> primeira = ultima.getProxima();
        Celula<T> excluido = ultima;
        if (primeira == ultima) {
            ultima = null;
        } else {
            Celula<T> proxima = primeira.getProxima();
            ultima.setProxima(proxima);
            excluido = primeira;
        }
        tamanho--;
        return excluido.getElemento();
    }

    @Override
    public T remove() {
        Celula<T> removido = ultima;
        Celula<T> penultima = pegaCelula(tamanho - 2);
        Celula<T> primeira = ultima.getProxima();
        penultima.setProxima(primeira);
        ultima = penultima;
        tamanho--;
        return removido.getElemento();
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
