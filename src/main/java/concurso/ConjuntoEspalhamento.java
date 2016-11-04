package concurso;

import java.util.List;

/**
 * Created by fc on 04/11/16.
 */
public class ConjuntoEspalhamento<T> implements Conjunto<T> {

    private Vetor<Lista<T>> tabela;

    public ConjuntoEspalhamento() {
        tabela = new VetorImpl<Lista<T>>(27);
        for (int i = 0; i < 26; i++) {
            tabela.adicionar(new ListaDuplamenteLigada<T>());
        }
    }

    public void adiciona(T elemento) {

    }

    public void remove(T elemento) {

    }

    public boolean contem(T elemento) {
        return false;
    }

    public List<T> pegaTodos() {
        return null;
    }

    public int tamanho() {
        return 0;
    }
}
