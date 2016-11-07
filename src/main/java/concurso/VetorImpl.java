package concurso;

import java.util.Arrays;

/**
 * Created by fc on 17/10/16.
 */
public class VetorImpl<T> implements Vetor<T> {


    private int total = 0;

    private static final int CAPACIDADE_PADRAO = 10;

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

    public void adicionar(T elemento) {
        elementos[total] = elemento;
        total++;
    }

    public void remover(){
        elementos[total] = null;
        total--;
    }

    public boolean contem(T elemento){
        for (int i=0; i < total; i++)
            if (elemento.equals(elementos[i]))
                return true;
        return false;
    }

    public void adicionar(int posicao, T elemento){
        deslocarParaDireita(posicao);
        this.elementos[posicao] = elemento;
        total++;
    }

    public void remover(int posicao){
        deslocarParaEsquerda(posicao);
        this.elementos[total-1]=null;
        total--;
    }

    private void deslocarParaDireita(int posicao) {
        for (int i = total -1; i >= posicao; i-- )
            this.elementos[i+1] = this.elementos[i];
    }

    private void deslocarParaEsquerda(int posicao) {
        for (int i = posicao + 1; i <= total-1; i++)
            this.elementos[i-1] = this.elementos[i];
    }


    public int getTotal() {
        return total;
    }

    public T pega(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return (T) elementos[posicao];
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.total;
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
        total = 0;
    }


}
