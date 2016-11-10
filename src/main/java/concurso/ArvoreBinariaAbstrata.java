package concurso;

import java.util.Iterator;

/**
 * Created by fc on 10/11/16.
 */
public class ArvoreBinariaAbstrata<T> extends ArvoreAbstrata<T> implements ArvoreBinaria<T> {


    @Override
    public Posicao<T> esquerda(Posicao<T> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Posicao<T> direita(Posicao<T> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Posicao<T> irmao(Posicao<T> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Posicao<T> raiz() {
        return null;
    }

    @Override
    public Posicao<T> pai(Posicao<T> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Posicao<T>> filhos(Posicao<T> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int numeroDeFilhos(Posicao<T> p) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int tamanho() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterable<Posicao<T>> posicoes() {
        return null;
    }
}
