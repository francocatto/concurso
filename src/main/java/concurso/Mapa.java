package concurso;

/**
 * Created by fc on 07/11/16.
 */
public interface Mapa<K, V> {

    void adiciona(K chave, V valor);

    V pega(K chave);

    void remove(K chave);

    boolean contemChave(K chave);

    int tamanho();
}
