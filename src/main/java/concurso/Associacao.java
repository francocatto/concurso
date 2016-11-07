package concurso;

/**
 * Created by fc on 07/11/16.
 */
public class Associacao<K, V> {

    private K chave;
    private V valor;

    public Associacao(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }
}
