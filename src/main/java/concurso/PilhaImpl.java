package concurso;

/**
 * Created by fc on 03/11/16.
 */
public class PilhaImpl<T> implements Pilha<T> {

    private Lista<T> lista = new ListaLigada<T>();

    //private LinkedList<T> lista = new LinkedList<T>();

    public void insere(T elemento) {

        lista.adiciona(elemento);
        //lista.add(elemento);
    }

    public boolean vazia() {

        return lista.tamanho() == 0;
        //return lista.tamanho() == 0;
    }

    public T remove() {
        return lista.remove();
        //return lista.remove(lista.tamanho()-1);
    }
}
