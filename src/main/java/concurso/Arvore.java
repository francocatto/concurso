package concurso;

import java.util.Iterator;

/**
 * Created by fc on 09/11/16.
 */
public interface Arvore<T> extends Iterable<T> {

    /* métodos acessores */
    Posicao<T> raiz();

    Posicao<T> pai(Posicao<T> p) throws IllegalArgumentException;

    Iterable<Posicao<T>> filhos(Posicao<T> p) throws IllegalArgumentException;

    int numeroDeFilhos(Posicao<T> p) throws IllegalArgumentException;

    /* métodos de consulta */
    boolean ehInterno(Posicao<T> p) throws IllegalArgumentException;

    boolean ehExterno(Posicao<T> p) throws IllegalArgumentException;

    boolean ehRaiz(Posicao<T> p) throws IllegalArgumentException;

    /* outros */
    int tamanho();

    boolean ehVazio();

    Iterator<T> iterator();

    Iterable<Posicao<T>> posicoes();

}
