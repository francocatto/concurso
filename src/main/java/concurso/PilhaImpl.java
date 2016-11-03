package concurso;

/**
 * Created by fc on 03/11/16.
 */
public class PilhaImpl implements Pilha {

    private Lista lista = new ListaLigada();

    public void insere(Object elemento) {
        lista.adiciona(elemento);
    }

    public boolean vazia() {
        return lista.tamanho() == 0;
    }

    public void remove() {
        lista.remove(lista.tamanho());
    }
}
