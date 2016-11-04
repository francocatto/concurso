package concurso;

/**
 * Created by fc on 26/10/16.
 */
public class ListaDuplamenteLigada implements Lista {

    private CelulaDupla primeira;
    private CelulaDupla ultima;

    private int tamanho = 0;


    public void adiciona(Object elemento) {
        if (tamanho == 0){
            adicionaPrimeiroElemento(elemento);
        } else {
            adicionaNoFim(elemento);
        }
    }

    private void adicionaPrimeiroElemento(Object elemento) {
        this.ultima = this.primeira = new CelulaDupla(elemento);
        tamanho++;
    }

    private void adicionaNoFim(Object elemento) {
        CelulaDupla nova = new CelulaDupla(elemento);
        nova.setAnterior(this.ultima);
        this.ultima.setProxima(nova);
        this.ultima = nova;
        tamanho++;
    }

    public void adiciona(int posicao, Object elemento) {
        if (tamanho == 0 || posicao == 0){
            adicionaNoComeco(elemento);
        } else if(posicao == tamanho) {
            adicionaNoFim(elemento);
        } else {
            CelulaDupla anterior = this.pegaCelula(posicao - 1);
            CelulaDupla atual = anterior.getProxima();
            CelulaDupla nova = new CelulaDupla(elemento, atual);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            atual.setAnterior(nova);
            this.tamanho++;
        }

    }

    public void adicionaNoComeco(Object elemento) {
        if (tamanho == 0)
            adicionaPrimeiroElemento(elemento);
        else {
            CelulaDupla nova = new CelulaDupla(elemento, this.primeira);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
            this.tamanho++;
        }
    }

    public Object pega(int posicao) throws IllegalArgumentException {
        return pegaCelula(posicao).getElemento();
    }

    private CelulaDupla pegaCelula(int posicao) {
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        CelulaDupla atual = this.primeira;
        for (int i=0; i < posicao; i++){
            atual = atual.getProxima();
        }
        return atual;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
    }

    public void remove(int posicao) {
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        if (posicao == 0) {
            removeDoComeco();
        }
        // Diferencial da duplamente ligada está aqui, pois remover o ultimo elemento é O(1)
        else if (posicao == tamanho -1) {
            remove();
        }
        else {
            CelulaDupla atual = pegaCelula(posicao);
            CelulaDupla anterior = atual.getAnterior();
            CelulaDupla proxima = atual.getProxima();
            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            tamanho--;
        }
    }

    public void removeDoComeco() {
        CelulaDupla segunda = this.primeira.getProxima();
        segunda.setAnterior(null);
        this.primeira = segunda;
        tamanho--;
    }

    public void remove() {
        CelulaDupla penultima = this.ultima.getAnterior();
        if (penultima != null) {
            penultima.setProxima(null);
            this.ultima = penultima;
    }
    tamanho--;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean contem(Object o) {
        return false;
    }

    public String toString() {
        // Verificando se a Lista está vazia
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        CelulaDupla atual = primeira;
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
