package concurso;

import aplicacoes.Aluno;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fc on 09/11/16.
 */
public class ListaCircularTest {

    @Test
    public void adicionaNoFim() {
        Lista<Aluno> lista = new ListaCircular<Aluno>();
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        lista.adiciona(franco);
        lista.adiciona(gabriel);
        Assert.assertEquals(franco, lista.pega(0));
        Assert.assertEquals(gabriel, lista.pega(1));
    }

    @Test
    public void adicionaNoComeco() {
        Lista<Aluno> lista = new ListaCircular<Aluno>();
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        lista.adicionaNoComeco(franco);
        lista.adicionaNoComeco(gabriel);
        Assert.assertEquals(gabriel, lista.pega(0));
        Assert.assertEquals(franco, lista.pega(1));
    }

    @Test
    public void adicionaPorPosicao() {
        Lista<Aluno> lista = new ListaCircular<Aluno>();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        lista.adiciona(henrique);
        lista.adiciona(0, franco);
        lista.adiciona(1, gabriel);
        Assert.assertEquals(franco, lista.pega(0));
        Assert.assertEquals(gabriel, lista.pega(1));
        Assert.assertEquals(henrique, lista.pega(2));
    }

    @Test
    public void deveRemoverDoComeco() {
        Lista<Aluno> lista = new ListaCircular<Aluno>();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        lista.adiciona(henrique);
        lista.adiciona(0, franco);
        lista.adiciona(1, gabriel);
        Assert.assertEquals(franco, lista.remove(0));
        Assert.assertEquals(gabriel, lista.pega(0));
        Assert.assertEquals(henrique, lista.pega(1));
    }

    @Test
    public void deveRemoverDeQualquerPosicao() {
        Lista<Aluno> lista = new ListaCircular<Aluno>();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        lista.adiciona(henrique);
        lista.adiciona(0, franco);
        lista.adiciona(1, gabriel);
        lista.remove(1);
        Assert.assertEquals(franco, lista.pega(0));
        Assert.assertEquals(henrique, lista.pega(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRemoverDoFim() {
        Lista<Aluno> lista = new ListaCircular<Aluno>();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        lista.adiciona(henrique);
        lista.adiciona(0, franco);
        lista.adiciona(1, gabriel);
        lista.remove(2);
        Assert.assertEquals(franco, lista.pega(0));
        Assert.assertEquals(gabriel, lista.pega(1));
        lista.pega(2);
    }
}
