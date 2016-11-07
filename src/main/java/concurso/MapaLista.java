package concurso;

/**
 * Created by fc on 07/11/16.
 */
public class MapaLista<K, V> implements Mapa<K, V> {

    private Lista<Associacao<K, V>> associacoes = new ListaDuplamenteLigada<Associacao<K, V>>();

    public void adiciona(K chave, V valor) {
        if (!this.contemChave(chave)) {
            Associacao<K, V> associacao = new Associacao<K, V>(chave, valor);
            this.associacoes.adiciona(associacao);
        }
    }

    public V pega(K chave) {
        for (Associacao<K, V> associacao : this.associacoes) {
            if (chave.equals(associacao.getChave())) {
                return associacao.getValor();
            }
        }
        throw new IllegalArgumentException("chave não existe");
    }

    public void remove(K chave) {
        for (int i = 0; i < this.associacoes.tamanho(); i++) {
            Associacao associacao = this.associacoes.pega(i);

            if (chave.equals(associacao.getChave())) {
                this.associacoes.remove(i);
                break;
            }
        }
    }

    private void validaChave(K chave) throws IllegalArgumentException {
        if (!this.contemChave(chave)) {
            throw new IllegalArgumentException("chave não existe");
        }
    }

    public boolean contemChave(K chave) {
        for (Associacao<K, V> associacao : this.associacoes) {
            if (chave.equals(associacao.getChave())) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return this.associacoes.tamanho();
    }
}
