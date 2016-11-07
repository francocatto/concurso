package aplicacoes;

import concurso.Mapa;
import concurso.MapaEspalhamento;

/**
 * Created by fc on 07/11/16.
 */
public class TesteTempoMapaEspalhamento {
    public static void main(String[] args) {

        Mapa<String, Carro> mapaLista = new MapaEspalhamento<String, Carro>();
        int numeroDeElementos = 15000;
        long inicio = System.currentTimeMillis();

        for (int i = 0; i < numeroDeElementos; i++) {
            mapaLista.adiciona("" + i, new Carro("c" + i));
        }

        for (int i = 0; i < numeroDeElementos; i++) {
            mapaLista.pega("" + i);
        }

        for (int i = 0; i < numeroDeElementos; i++) {
            mapaLista.contemChave("" + i);
        }

        for (int i = 0; i < numeroDeElementos; i++) {
            mapaLista.remove("" + i);
        }


        long fim = System.currentTimeMillis();

        System.out.println("Tempo: " + (fim - inicio) / 1000.0);
    }
}
