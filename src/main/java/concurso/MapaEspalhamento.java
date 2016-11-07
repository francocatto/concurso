package concurso;

/**
 * Created by fc on 07/11/16.
 */
public class MapaEspalhamento<K, V> implements Mapa<K, V> {

    private Vetor<Lista<Associacao<K, V>>> tabela;
    private int tamanho = 0;

    public MapaEspalhamento() {
        this.tabela = new VetorImpl<Lista<Associacao<K, V>>>();
        for (int i = 0; i < 100; i++) {
            this.tabela.adicionar(new ListaDuplamenteLigada<Associacao<K, V>>());
        }
    }

    private int calculaIndiceDaTabela(K chave) {
        return Math.abs(chave.hashCode()) % this.tabela.tamanho();
    }

    public void adiciona(K chave, V valor) {
        if (!this.contemChave(chave)) {
            Associacao<K, V> associacao = new Associacao<K, V>(chave, valor);
            Lista<Associacao<K, V>> associacoes = tabela.pega(calculaIndiceDaTabela(chave));
            associacoes.adiciona(associacao);
            tamanho++;
        }
    }

    public V pega(K chave) {
        Lista<Associacao<K, V>> associacoes = tabela.pega(calculaIndiceDaTabela(chave));
        for (Associacao<K, V> associacao : associacoes) {
            if (associacao.getChave().equals(chave)) {
                return associacao.getValor();
            }
        }
        throw new IllegalArgumentException("chave não existe");
    }

    public void remove(K chave) {
        Lista<Associacao<K, V>> associacoes = tabela.pega(calculaIndiceDaTabela(chave));
        for (int i = 0; i < associacoes.tamanho(); i++) {
            Associacao associacao = associacoes.pega(i);

            if (chave.equals(associacao.getChave())) {
                associacoes.remove(i);
                tamanho--;
                break;
            }
        }
    }

    public boolean contemChave(K chave) {
        int indice = this.calculaIndiceDaTabela(chave);
        Lista<Associacao<K, V>> lista = this.tabela.pega(indice);

        for (int i = 0; i < lista.tamanho(); i++) {
            Associacao<K, V> associacao = lista.pega(i);
            if (associacao.getChave().equals(chave)) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return 0;
    }

    private Lista<Associacao<K, V>> pegaTodas() {
        Lista<Associacao<K, V>> associacoes = new ListaDuplamenteLigada<Associacao<K, V>>();
        for (Lista<Associacao<K, V>> lista : this.tabela) {
            associacoes.adicionarTodos(lista);
        }
        return associacoes;
    }

    @Override
    public String toString() {
        return this.pegaTodas().toString();
    }

    private void redimensionaTabela(int novaCapacidade) {
        Lista<Associacao<K, V>> elementos = this.pegaTodas();
        this.tabela.clear();

        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.adicionar(i, new ListaDuplamenteLigada<Associacao<K, V>>());
        }

        for (Associacao<K, V> elemento : elementos) {
            this.adiciona(elemento.getChave(), elemento.getValor());
        }
    }

    private void verificaCarga() {
        int capacidade = this.tabela.tamanho();
        double carga = (double) this.tamanho / capacidade;

        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }
}
