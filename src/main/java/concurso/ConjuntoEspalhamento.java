package concurso;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fc on 04/11/16.
 */
public class ConjuntoEspalhamento<T> implements Conjunto<T> {

    private Vetor<Lista<T>> tabela;
    private int tamanho = 0;

    public ConjuntoEspalhamento() {
        tabela = new VetorImpl<Lista<T>>(27);
        for (int i = 0; i <= 26; i++) {
            tabela.adicionar(new ListaDuplamenteLigada<T>());
        }
    }

    private int calcularIndiceDeEspalhamento(T elemento) {
        return Math.abs(elemento.hashCode() % this.tabela.getTotal());
    }

    public void adiciona(T elemento) {
        verificaCarga();
        Lista<T> lista = tabela.pega(calcularIndiceDeEspalhamento(elemento));
        if (!lista.contem(elemento)) {
            lista.adiciona(elemento);
            tamanho++;
        }
    }

    public void remove(T elemento) {
        verificaCarga();
        Lista<T> lista = tabela.pega(calcularIndiceDeEspalhamento(elemento));
        if (lista.contem(elemento)) {
            lista.remove(elemento);
            tamanho--;
        }
    }

    public boolean contem(T elemento) {
        Lista<T> lista = tabela.pega(calcularIndiceDeEspalhamento(elemento));
        return lista.contem(elemento);
    }

    public Lista<T> pegaTodos() {
        ListaDuplamenteLigada<T> todos = new ListaDuplamenteLigada<T>();
        for (int i = 0; i < this.tabela.getTotal(); i++) {
            todos.adicionarTodos(this.tabela.pega(i));
        }
        return todos;
    }

    public int tamanho() {
        return tamanho;
    }

    private void redimensionaTabela(int novaCapacidade){
        Lista<T> elementos = this.pegaTodos();
        this.tabela.clear();

        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.adicionar(i, new ListaDuplamenteLigada<T>());
        }

        for (T elemento : elementos) {
            this.adiciona(elemento);
        }
    }

    private void verificaCarga() {
        int capacidade = this.tabela.getTotal();
        double carga = (double) this.tamanho / capacidade;

        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }
}
