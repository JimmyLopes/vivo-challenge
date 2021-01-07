package br.com.vivo.challenge.backend.service.impl;

import br.com.vivo.challenge.backend.domain.Matriz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe responsável pela primeira questão (q1):
 * <p>
 * Dada uma matriz de números inteiro M x N,
 * receba um vetor A[N], sendo que os valores
 * inteiros do vetor correspondam ao intervalo
 * [0;15]. Retornar a quantidade de vezes que cada
 * elemento do vetor aparece na matriz. Retorna 0
 * caso não encontre nenhuma ocorrência.
 */

public class QuestaoUmServiceImpl {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre com o valor de linhas e colunas da matriz:");
        //Transforma todas as entradas em valores positivos
        int linhas = Math.abs(scanner.nextInt());
        int colunas = Math.abs(scanner.nextInt());

        Matriz matriz = new Matriz(linhas, colunas);
        //Exibe a matriz gerada aleatoriamente
        matriz.lerMatriz();

        System.out.println("Entre com os valores inteiros do vetor de [" + colunas + "] posições, os valores devem estar entre 0 e 15:");
        int[] vetor = new int[colunas];
        for (int i = 0; i < colunas; i++) {
            int valueInput = Math.abs(scanner.nextInt());
            if (valueInput < 0 || valueInput > 15) {
                i--;
                System.out.println("O Valor inputado não corresponde a um valor válido. Entre com um novo valor válido.");
            } else {
                vetor[i] = valueInput;
            }
        }

    exibeVetor(vetor);

    Map<Integer, Integer> integerIntegerHashMap = procurarElementosDoVetorNaMatriz(matriz, vetor);

    exibeRecorrencias(integerIntegerHashMap);

}

    private static void exibeRecorrencias(Map<Integer, Integer> recorrenciaElementos) {
        pularLinha();
        System.out.println("Recorrência dos elementos do vetor na matriz:");
        for (Map.Entry<Integer, Integer> entry : recorrenciaElementos.entrySet()) {
            System.out.println("O elemento [" + entry.getKey() + "] se repete na matriz por [" + entry.getValue() + "] vez(es).");
        }
    }

    private static Map<Integer, Integer> procurarElementosDoVetorNaMatriz(Matriz matriz, int[] vetor) {
        //HashMap com o valor procurado e a qntdade de ocorrencias
        Map<Integer, Integer> recorrencia = new HashMap<>();
        for (int i : vetor) {
            int qntdRepeticoes = matriz.findElement(i);
            recorrencia.put(i, qntdRepeticoes);
        }
        return recorrencia;
    }

    public static void exibeVetor(int[] vetor) {
        pularLinha();
        System.out.println("Vetor [" + vetor.length + "] inputado:");
        for (int i : vetor) {
            System.out.println(i + "\t");
        }
    }

    private static void pularLinha() {
        System.out.println();
    }
}
