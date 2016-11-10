package concurso;

/**
 * Created by fc on 10/11/16.
 */
public abstract class ArvoreAbstrata<T> implements Arvore<T> {

    @Override
    public boolean ehExterno(Posicao<T> p) throws IllegalArgumentException {
        return numeroDeFilhos(p) == 0;
    }

    @Override
    public boolean ehInterno(Posicao<T> p) throws IllegalArgumentException {
        return numeroDeFilhos(p) > 0;
    }

    @Override
    public boolean ehRaiz(Posicao<T> p) throws IllegalArgumentException {
        return p == raiz();
    }

    @Override
    public boolean ehVazio() {
        return tamanho() == 0;
    }

    /* TEMPO LINEAR*/
    public int profundidade(Posicao<T> p) {
        if (ehRaiz(p))
            return 0;
        else
            return 1 + profundidade(pai(p));
    }

    private int altura() {
        return altura(raiz());
    }

    private int altura(Posicao<T> posicao) {
        int h = 0;
        //for ()
        return h;
    }
}