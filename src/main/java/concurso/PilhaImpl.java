package concurso;

import java.util.LinkedList;

/**
 * Created by fc on 03/11/16.
 */
public class PilhaImpl<T> implements Pilha<T> {

    private Lista lista = new ListaLigada();

    //private LinkedList<T> lista = new LinkedList<T>();

    public void insere(T elemento) {

        lista.adiciona(elemento);
        //lista.add(elemento);
    }

    public boolean vazia() {

        return lista.tamanho() == 0;
        //return lista.size() == 0;
    }

    public T remove() {
        Object elemento = lista.pega(lista.tamanho()-1);
        lista.remove();
        return (T) elemento;
        //return lista.remove(lista.size()-1);
    }
}
