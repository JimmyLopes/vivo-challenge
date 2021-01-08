package br.com.vivo.challenge.backend.utils;

import br.com.vivo.challenge.backend.domain.Matriz;

import java.util.HashMap;
import java.util.Map;

public final class MatrizUtils {
    // Construtor privado para evitar instância indevida
    private MatrizUtils() {
    }

    /**
     * Método que procura a quantidade de vezes(Value) que um elemento(Key) do vetor se repete dentro da matriz e armazena em um mapa
     *
     * @param matriz a matriz base
     * @param vetor o vetor contendo os elementos procurados
     * @return o map contendo a contagem dos elementos e os elementos
     */
    public static Map<Integer, Integer> procurarRecorrencia(Matriz matriz, int[] vetor){
        //HashMap com o valor procurado e a qntdade de ocorrencias
        Map<Integer, Integer> recorrencia = new HashMap<>();
        for (int i : vetor) {
            int qntdRepeticoes = matriz.findElement(i);
            recorrencia.put(i, qntdRepeticoes);
        }
        return recorrencia;
    }
}
