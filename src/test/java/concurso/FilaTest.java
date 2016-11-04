package concurso;

import aplicacoes.Aluno;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fc on 04/11/16.
 */
public class FilaTest {

    @Test
    public void deveInserirERemoverAlunosDaPilha(){
        Fila<Aluno> filaDeAlunos = new FilaImpl<Aluno>();

        Aluno aluno = new Aluno(1L, "Franco");
        filaDeAlunos.insere(aluno);

        Aluno alunoRemovido = filaDeAlunos.remove();

        Assert.assertEquals(aluno, alunoRemovido);

        Assert.assertTrue(filaDeAlunos.vazia());

        Fila<String> filaDeString = new FilaImpl<String>();

        filaDeString.insere("Diana");
        filaDeString.insere("Joaquim");

        Assert.assertEquals("Diana", filaDeString.remove());
        Assert.assertEquals("Joaquim", filaDeString.remove());
    }
}
