package br.edu.ifms;

import java.util.Arrays;

/**
 * Created by fc on 17/10/16.
 */
public class VetorImpl implements Vetor {


    private int total = 0;

    private Object[] elementos;

    public VetorImpl(int capacity) {
        elementos = new Object[capacity];
    }

    public void adicionar(Object elemento) {
        elementos[total] = elemento;
        total++;
    }

    public void remover(){
        elementos[total] = null;
        total--;
    }

    public boolean contem(Object elemento){
        for (int i=0; i < total; i++)
            if (elemento.equals(elementos[i]))
                return true;
        return false;
    }

    public void adicionar(int posicao, Object elemento){
        posicao--;
        deslocarParaDireita(posicao);
        this.elementos[posicao] = elemento;
        total++;
    }

    public void remover(int posicao){
        posicao--;
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

    public Object pega(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return elementos[posicao - 1];
    }

    private boolean posicaoOcupada(int posicao) {
        posicao--;
        return posicao >= 0 && posicao < this.total;
    }

    public String toString() {
        return Arrays.toString(elementos);
    }

    public void inicializa(Object[] elementos){
        for (Object elemento : elementos) {
            adicionar(elemento);
        }
    }

}
