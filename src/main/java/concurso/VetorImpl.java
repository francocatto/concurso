package concurso;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by fc on 17/10/16.
 */
public class VetorImpl<T> implements Vetor<T>, Iterable<T> {


    private static final int CAPACIDADE_PADRAO = 10;
    private int tamanho = 0;
    private Object[] elementos;

    public VetorImpl() {
        elementos = new Object[CAPACIDADE_PADRAO];
    }

    public VetorImpl(int capacity) {
        if (capacity == 0)
            elementos = new Object[CAPACIDADE_PADRAO];
        else
            elementos = new Object[capacity];
    }

    private static int capacidadeMaxima(int capacidade) {
        if (capacidade < 0) {
            throw new OutOfMemoryError();
        } else {
            return capacidade > 2147483639 ? 2147483647 : 2147483639;
        }
    }

    public void adicionar(T elemento) {
        verificarCapacidade();
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public void remover(){
        elementos[tamanho] = null;
        tamanho--;
    }

    public boolean contem(T elemento){
        for (int i = 0; i < tamanho; i++)
            if (elemento.equals(elementos[i]))
                return true;
        return false;
    }

    private void verificarCapacidade() {
        if (elementos.length == tamanho()) {
            expandir(1);
        }
    }

    public void adicionar(int posicao, T elemento){
        deslocarParaDireita(posicao);
        this.elementos[posicao] = elemento;
        tamanho++;
    }

    public void remover(int posicao){
        deslocarParaEsquerda(posicao);
        this.elementos[tamanho - 1] = null;
        tamanho--;
    }

    private void deslocarParaDireita(int posicao) {
        for (int i = tamanho - 1; i >= posicao; i--)
            this.elementos[i+1] = this.elementos[i];
    }

    private void deslocarParaEsquerda(int posicao) {
        for (int i = posicao + 1; i <= tamanho - 1; i++)
            this.elementos[i-1] = this.elementos[i];
    }

    public int tamanho() {
        return tamanho;
    }

    public T pega(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return (T) elementos[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.tamanho;
    }

    public String toString() {
        return Arrays.toString(elementos);
    }

    public void inicializa(T[] elementos){
        for (T elemento : elementos) {
            adicionar(elemento);
        }
    }

    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < elementos.length; i++)
            elementos[i] = null;
        tamanho = 0;
    }

    private void expandir(int var1) {
        int var2 = this.elementos.length;
        int var3 = var2 + var1;

        if (var3 - 2147483639 > 0) {
            var3 = capacidadeMaxima(var1);
        }
        this.elementos = Arrays.copyOf(this.elementos, var3);
    }

    public Iterator<T> iterator() {
        return new VetorIterator();
    }

    private class VetorIterator implements Iterator {
        int cursor = 0;

        public boolean hasNext() {
            return cursor < tamanho();
        }

        public T next() {
            return pega(cursor++);
        }

        public void remove() {

        }

    }
}
