package br.edu.ifms;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by fc on 22/10/16.
 */
public class VetorTeste {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void deveInserirElementoNaListaEDeslocarParaDireita() {
        VetorImpl vetor = new VetorImpl(8);
        Character data[] = {'A', 'B', 'C', 'D', 'E'};
        vetor.inicializa(data);
        vetor.adicionar(3, 'X');
        Assert.assertEquals('X', vetor.pega(3));
        Assert.assertEquals('C', vetor.pega(4));
        Assert.assertEquals('D', vetor.pega(5));
        Assert.assertEquals('E', vetor.pega(6));
    }

    @Test
    public void deveRemoverElementoDaListaEDeslocarParaEsquerda() {
        VetorImpl vetor = new VetorImpl(8);
        Character data[] = {'A', 'B', 'C', 'D', 'E'};
        vetor.inicializa(data);
        vetor.remover(3);
        Assert.assertEquals('D', vetor.pega(3));
        Assert.assertEquals('E', vetor.pega(4));
        exception.expect(IllegalArgumentException.class);
        vetor.pega(5);
    }
}
