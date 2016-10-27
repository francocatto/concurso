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
            adicionaFim(elemento);
        }
    }

    private void adicionaPrimeiroElemento(Object elemento) {
        this.primeira = new CelulaDupla(elemento);
        this.ultima = this.primeira;
        tamanho++;
    }

    private void adicionaFim(Object elemento) {
        CelulaDupla nova = new CelulaDupla(elemento);
        CelulaDupla anterior = this.ultima;
        nova.setAnterior(anterior);
        anterior.setProxima(nova);
        this.ultima = nova;
        tamanho++;
    }

    public void adiciona(int posicao, Object elemento) {
        if (tamanho == 0){
            adicionaPrimeiroElemento(elemento);
        } else if(posicao == tamanho){
            adicionaFim(elemento);
        } else {
            /*CelulaDupla nova = new CelulaDupla(elemento);
            CelulaDupla atual = pegaCelula(posicao);
            CelulaDupla anteriorDaAtual = atual.getAnterior();
            nova.setProxima(atual);
            atual.setAnterior(nova);
            nova.setAnterior(anteriorDaAtual);
            this.tamanho++;*/
            CelulaDupla anterior = this.pegaCelula(posicao - 1);
            CelulaDupla proxima = anterior.getProxima();
            CelulaDupla nova = new CelulaDupla(elemento, anterior.getProxima());
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.tamanho++;
        }

    }

    public void adicionaNoComeco(Object elemento) {
        if (tamanho == 0)
            adicionaPrimeiroElemento(elemento);
        else {
            CelulaDupla nova = new CelulaDupla(elemento);
            nova.setProxima(this.primeira);
            this.primeira = nova;
        }
    }

    public Object pega(int posicao) {
        return pegaCelula(posicao).getElemento();
    }

    private CelulaDupla pegaCelula(int posicao) {
        CelulaDupla atual = this.primeira;
        for (int i=0; i <= posicao; i++){
            atual = atual.getProxima();
        }
        return atual;
    }

    public void remove(int posicao) {

    }

    public int tamanho() {
        return 0;
    }

    public boolean contem(Object o) {
        return false;
    }

}
