package concurso;

/**
 * Created by fc on 26/10/16.
 */
public interface Lista {

    public void adiciona(Object elemento);
    public void adiciona(int posicao, Object elemento);
    public Object pega(int posicao);
    public void remove(int posicao);
    public int tamanho();
    public boolean contem(Object o);
}
