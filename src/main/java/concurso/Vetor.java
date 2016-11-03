package br.edu.ifms;

/**
 * Created by fc on 17/10/16.
 */
public interface Vetor {
    void adicionar(Object elemento);

    void remover();

    boolean contem(Object elemento);

    void adicionar(int posicao, Object elemento);

    void remover(int posicao);

    int getTotal();

    Object pega(int posicao);

    String toString();
}
