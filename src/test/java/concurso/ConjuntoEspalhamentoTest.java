package concurso;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fc on 04/11/16.
 */

public class ConjuntoEspalhamentoTest {

    @Test
    public void deveFazerOperacoesDeConjunto() {
        ConjuntoEspalhamento<String> conjunto = new ConjuntoEspalhamento<String>();

        conjunto.adiciona("palavra");
        conjunto.adiciona("computador");
        conjunto.adiciona("apostila");
        conjunto.adiciona("instrutor");
        conjunto.adiciona("mesa");
        conjunto.adiciona("telefone");

        Assert.assertTrue(conjunto.contem("apostila"));

        conjunto.remove("apostila");

        Assert.assertFalse(conjunto.contem("apostila"));

        Assert.assertEquals(5, conjunto.tamanho());
    }
}
