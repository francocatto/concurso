package concurso;

import aplicacoes.StringInverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fc on 03/11/16.
 */
public class StringInverterTest {

    @Test
    public void deveInverterUmaFraseQualquer(){
        StringInverter frase = new StringInverter("Uma Frase Qualquer");
        Assert.assertEquals("reuqlauQ esarF amU", frase.inverter());
    }

}
