package concurso;

/**
 * Created by fc on 26/10/16.
 */
public class ListaLigada implements Lista {

    private Celula primeira;
    private Celula ultima;

    private int tamanho = 0;

    public void adiciona(Object elemento) {
        if (tamanho == 0) {
            adicionaNoComeco(elemento);
        } else {
            adicionaNoFim(elemento);
        }
    }

    private void adicionaNoFim(Object elemento) {
        Celula nova = new Celula(elemento);
        ultima.setProxima(nova);
        ultima = nova;
        tamanho++;
    }

    public void adicionaNoComeco(Object elemento){
        Celula nova = new Celula(elemento, primeira);
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
            Celula anterior = this.pegaCelula(posicao -1);
            Celula nova = new Celula(elemento, anterior.getProxima());
            anterior.setProxima(nova);
            tamanho++;
        }
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
    }

    // LINEAR TIME
    private Celula pegaCelula(int posicao) {
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    // LINEAR TIME
    public Object pega(int posicao) {
        return pegaCelula(posicao).getElemento();
    }

    public void remove(int posicao) {
        if (posicao == 0){
            removeDoComeco();
        } else if (posicao == tamanho -1) {
            remove();
        } else {
            Celula anterior = pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula posterior = atual.getProxima();
            anterior.setProxima(posterior);
            this.tamanho--;
        }
    }

    public void remove(){
        if (tamanho >1 ) {
            ultima = pegaCelula(tamanho - 2);
            ultima.setProxima(null);
            this.tamanho--;
        }else
            removeDoComeco();
    }

    public void removeDoComeco() {
        if (tamanho == 1) {
            this.primeira = null;
            this.ultima = null;
        }else {
            this.primeira = this.primeira.getProxima();
            this.ultima = this.primeira.getProxima();
        }
        this.tamanho--;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean contem(Object elemento) {
        Celula atual = this.primeira;
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
        Celula atual = primeira;
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
