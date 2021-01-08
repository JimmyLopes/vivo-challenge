package br.com.vivo.challenge.backend.dto;

import br.com.vivo.challenge.backend.domain.Matriz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RecorrenciaDto {

    private List<String> matrizGerada;
    private String vetorEntrada;
    private List<String> recorrencias;

    public RecorrenciaDto(Map<Integer, Integer> mapRecorrencias, Matriz matriz, int[] vetor) {
        this.matrizGerada = gerarMatriz(matriz);
        this.vetorEntrada = gerarVetor(vetor);
        this.recorrencias = gerarRecorrencias(mapRecorrencias);
    }

    private List<String> gerarRecorrencias(Map<Integer, Integer> mapRecorrencias) {
        List<String> recorrencia = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mapRecorrencias.entrySet()) {
            recorrencia.add("O elemento [" + entry.getKey() + "] se repete na matriz por [" +
                    entry.getValue() + "] vez(es).");
        }
        return recorrencia;
    }

    private String gerarVetor(int[] vetor) {
        return Arrays.toString(vetor);
    }

    private List<String> gerarMatriz(Matriz matriz) {
        List<String> matrizExibida = new ArrayList<>();
        for (int[] item : matriz.getMatriz()) {
            matrizExibida.add(Arrays.toString(item));
        }
        return matrizExibida;
    }

    public List<String> getMatrizGerada() {
        return matrizGerada;
    }

    public void setMatrizGerada(List<String> matrizGerada) {
        this.matrizGerada = matrizGerada;
    }

    public String getVetorEntrada() {
        return vetorEntrada;
    }

    public void setVetorEntrada(String vetorEntrada) {
        this.vetorEntrada = vetorEntrada;
    }

    public List<String> getRecorrencias() {
        return recorrencias;
    }

    public void setRecorrencias(List<String> recorrencias) {
        this.recorrencias = recorrencias;
    }
}
