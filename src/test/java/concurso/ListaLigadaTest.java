package concurso;

import aplicacoes.Aluno;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fc on 26/10/16.
 */
public class ListaLigadaTest {

    @Test
    public void adicionaNoFim(){
        ListaLigada listaLigada = new ListaLigada();
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        listaLigada.adiciona(franco);
        listaLigada.adiciona(gabriel);
        Assert.assertEquals(franco, listaLigada.pega(0));
        Assert.assertEquals(gabriel, listaLigada.pega(1));
    }

    @Test
    public void adicionaNoComeco(){
        ListaLigada listaLigada = new ListaLigada();
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        listaLigada.adicionaNoComeco(franco);
        listaLigada.adicionaNoComeco(gabriel);
        Assert.assertEquals(gabriel, listaLigada.pega(0));
        Assert.assertEquals(franco, listaLigada.pega(1));
    }

    @Test
    public void adicionaPorPosicao(){
        ListaLigada listaLigada = new ListaLigada();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        listaLigada.adiciona(henrique);
        listaLigada.adiciona(0, franco);
        listaLigada.adiciona(1, gabriel);
        Assert.assertEquals(franco, listaLigada.pega(0));
        Assert.assertEquals(gabriel, listaLigada.pega(1));
        Assert.assertEquals(henrique, listaLigada.pega(2));
    }

    @Test
    public void deveRemoverDoComeco(){
        ListaLigada listaLigada = new ListaLigada();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        listaLigada.adiciona(henrique);
        listaLigada.adiciona(0, franco);
        listaLigada.adiciona(1, gabriel);
        listaLigada.remove(0);
        Assert.assertEquals(gabriel, listaLigada.pega(0));
        Assert.assertEquals(henrique, listaLigada.pega(1));
    }

    @Test
    public void deveRemoverDeQualquerPosicao(){
        ListaLigada listaLigada = new ListaLigada();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        listaLigada.adiciona(henrique);
        listaLigada.adiciona(0, franco);
        listaLigada.adiciona(1, gabriel);
        listaLigada.remove(1);
        Assert.assertEquals(franco, listaLigada.pega(0));
        Assert.assertEquals(henrique, listaLigada.pega(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRemoverDoFim(){
        ListaLigada listaLigada = new ListaLigada();
        Aluno henrique = new Aluno(2L, "Henrique");
        Aluno franco = new Aluno(0L, "Franco");
        Aluno gabriel = new Aluno(1L, "Gabriel");
        listaLigada.adiciona(henrique);
        listaLigada.adiciona(0, franco);
        listaLigada.adiciona(1, gabriel);
        listaLigada.remove(2);
        Assert.assertEquals(franco, listaLigada.pega(0));
        Assert.assertEquals(gabriel, listaLigada.pega(1));
        listaLigada.pega(2);
    }
}
