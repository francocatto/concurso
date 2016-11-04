package aplicacoes;

import concurso.Pilha;
import concurso.PilhaImpl;

/**
 * Created by fc on 03/11/16.
 */
public class StringInverter {

    private String frase;

    private Pilha<Character> pilha = new PilhaImpl();

    public StringInverter(String frase) {
        this.frase = frase;
        for (int i = 0; i < frase.length(); i++) {
            Character character = frase.charAt(i);
            pilha.insere(character);
        }
    }

    public String inverter() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < frase.length(); i++) {
            stringBuffer.append(pilha.remove().toString());
        }
        return stringBuffer.toString();
    }
}
