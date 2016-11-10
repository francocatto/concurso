package concurso;

/**
 * Created by fc on 10/11/16.
 */
public interface ArvoreBinaria<T> extends Arvore<T> {

    Posicao<T> esquerda(Posicao<T> p) throws IllegalArgumentException;

    Posicao<T> direita(Posicao<T> p) throws IllegalArgumentException;

    Posicao<T> irmao(Posicao<T> p) throws IllegalArgumentException;
}