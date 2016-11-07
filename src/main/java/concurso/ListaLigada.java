package concurso;

import java.util.Iterator;

/**
 * Created by fc on 26/10/16.
 */
public class ListaLigada<T> implements Lista<T> {

    private Celula<T> primeira;
    private Celula<T> ultima;

    private int tamanho = 0;

    public void adiciona(Object elemento) {
        if (tamanho == 0) {
            adicionaNoComeco(elemento);
        } else {
            adicionaNoFim(elemento);
        }
    }

    private void adicionaNoFim(Object elemento) {
        Celula<T> nova = new Celula(elemento);
        ultima.setProxima(nova);
        ultima = nova;
        tamanho++;
    }

    public void adicionaNoComeco(Object elemento){
        Celula<T> nova = new Celula(elemento, primeira);
        this.primeira = nova;
        if (tamanho == 0)
            this.ultima = this.primeira;
        this.tamanho++;
    }

    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0){
            this.adicionaNoComeco(elemento);
        } else if(posicao == this.tamanho){
            this.adiciona(elemento);
        } else {
            Celula<T> anterior = this.pegaCelula(posicao -1);
            Celula<T> nova = new Celula(elemento, anterior.getProxima());
            anterior.setProxima(nova);
            tamanho++;
        }
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
    }

    // LINEAR TIME
    private Celula<T> pegaCelula(int posicao) {
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula<T> atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    // LINEAR TIME
    public T pega(int posicao) {
        return pegaCelula(posicao).getElemento();
    }

    public T remove(int posicao) {
        if (posicao == 0){
            return removeDoComeco();
        } else if (posicao == tamanho -1) {
            return remove();
        } else {
            Celula<T> anterior = pegaCelula(posicao - 1);
            Celula<T> atual = anterior.getProxima();
            Celula<T> posterior = atual.getProxima();
            anterior.setProxima(posterior);
            this.tamanho--;
            return atual.getElemento();
        }
    }

    public T remove(){
        if (tamanho >1 ) {
            Celula<T> penultima = pegaCelula(tamanho - 2);
            Celula<T> ultima = this.ultima;
            this.ultima = penultima;
            this.ultima.setProxima(null);
            this.tamanho--;
            return ultima.getElemento();
        } else
            return removeDoComeco();

    }

    public boolean remove(T elemento) {
        return false;
    }

    public T removeDoComeco() {
        Celula<T> primeira = this.primeira;
        if (tamanho == 1) {
            this.primeira = null;
            this.ultima = null;
        } else {
            this.primeira = this.primeira.getProxima();
            this.ultima = this.primeira.getProxima();
        }
        this.tamanho--;
        return primeira.getElemento();
    }

    public int tamanho() {
        return tamanho;
    }

    public void adicionarTodos(Lista<T> lista) {

    }

    public Iterator<T> iterator() {
        return null;
    }

    public boolean contem(Object elemento) {
        Celula<T> atual = this.primeira;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }

    public String toString() {
        // Verificando se a Lista está vazia
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Celula<T> atual = primeira;
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

}
