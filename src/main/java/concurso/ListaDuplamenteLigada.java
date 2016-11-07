package concurso;

import java.util.*;

/**
 * Created by fc on 26/10/16.
 */
public class ListaDuplamenteLigada<T> implements Lista<T> {

    private CelulaDupla<T> primeira;
    private CelulaDupla<T> ultima;

    private int tamanho = 0;


    public void adiciona(T elemento) {
        if (tamanho == 0) {
            adicionaPrimeiroElemento(elemento);
        } else {
            adicionaNoFim(elemento);
        }
    }

    private void adicionaPrimeiroElemento(T elemento) {
        this.ultima = this.primeira = new CelulaDupla(elemento);
        tamanho++;
    }

    private void adicionaNoFim(T elemento) {
        CelulaDupla nova = new CelulaDupla(elemento);
        nova.setAnterior(this.ultima);
        this.ultima.setProxima(nova);
        this.ultima = nova;
        tamanho++;
    }

    public void adiciona(int posicao, T elemento) {
        if (tamanho == 0 || posicao == 0) {
            adicionaNoComeco(elemento);
        } else if (posicao == tamanho) {
            adicionaNoFim(elemento);
        } else {
            CelulaDupla anterior = this.pegaCelula(posicao - 1);
            CelulaDupla atual = anterior.getProxima();
            CelulaDupla nova = new CelulaDupla(elemento, atual);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            atual.setAnterior(nova);
            this.tamanho++;
        }

    }

    public void adicionaNoComeco(T elemento) {
        if (tamanho == 0)
            adicionaPrimeiroElemento(elemento);
        else {
            CelulaDupla nova = new CelulaDupla(elemento, this.primeira);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
            this.tamanho++;
        }
    }

    public T
    pega(int posicao) throws IllegalArgumentException {
        return pegaCelula(posicao).getElemento();
    }

    private CelulaDupla<T> pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        CelulaDupla<T> atual = this.primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.tamanho;
    }

    public T remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (posicao == 0) {
            return removeDoComeco();
        }
        // Diferencial da duplamente ligada está aqui, pois remover o ultimo elemento é O(1)
        else if (posicao == tamanho - 1) {
            return remove();
        } else {
            CelulaDupla<T> atual = pegaCelula(posicao);
            CelulaDupla<T> anterior = atual.getAnterior();
            CelulaDupla<T> proxima = atual.getProxima();
            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            tamanho--;
            return atual.getElemento();
        }
    }

    public T removeDoComeco() {
        CelulaDupla<T> primeira = this.primeira;
        if (tamanho > 1) {
            CelulaDupla<T> segunda = this.primeira.getProxima();
            segunda.setAnterior(null);
            this.primeira = segunda;
        } else {
            this.primeira = null;
            this.ultima = null;
        }
        tamanho--;
        return primeira.getElemento();
    }

    public T remove() {
        CelulaDupla<T> ultima = this.ultima;
        CelulaDupla<T> penultima = this.ultima.getAnterior();
        if (penultima != null) {
            penultima.setProxima(null);
            this.ultima = penultima;
        }
        tamanho--;
        return ultima.getElemento();
    }

    public boolean remove(T elemento) {
        if (elemento != null) {
            for (CelulaDupla<T> x = primeira; x != null; x = x.getProxima()) {
                if (elemento.equals(x.getElemento())) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    T unlink(CelulaDupla<T> x) {
        // assert x != null;
        final T element = x.getElemento();
        final CelulaDupla<T> next = x.getProxima();
        final CelulaDupla<T> prev = x.getAnterior();

        if (prev == null) {
            primeira = next;
        } else {
            prev.setProxima(next);
            x.setProxima(null);
        }

        if (next == null) {
            ultima = prev;
        } else {
            next.setAnterior(prev);
            x.setProxima(null);
        }

        x.setElemento(null);
        tamanho--;
        return element;
    }

    public int tamanho() {
        return tamanho;
    }

    public void adicionarTodos(Lista<T> lista) {
        for (int i = 0; i <= lista.tamanho() - 1; i++) {
            T elemento = lista.pega(i);
            adiciona(elemento);
        }

    }

    public boolean contem(Object o) {
        for (CelulaDupla<T> x = primeira; x != null; x = x.getProxima()) {
            if (o.equals(x.getElemento())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        // Verificando se a Lista está vazia
        if (this.tamanho == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        CelulaDupla atual = primeira;
        // Percorrendo até o penúltimo elemento.
        while (atual.getProxima() != null) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        // último elemento
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }

    public Iterator<T> iterator() {
        return new ListaDuplamenteLigadaIterator();
    }

    private class ListaDuplamenteLigadaIterator implements Iterator {
        int cursor =0;
        public boolean hasNext() {
            return cursor < tamanho;
        }

        public T next() {
            return pega(cursor++);
        }

        public void remove() {

        }

    }
}
