package concurso;

/**
 * Created by fc on 26/10/16.
 */
public interface Lista {

    public void adiciona(Object elemento);
    public void adiciona(int posicao, Object elemento);
    public void adicionaNoComeco(Object elemento);
    public Object pega(int posicao);
    public void remove(int posicao);
    public void removeDoComeco();
    public void remove();
    public int tamanho();
    public boolean contem(Object o);
}
