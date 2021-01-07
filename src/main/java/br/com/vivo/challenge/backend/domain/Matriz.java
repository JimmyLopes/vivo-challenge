package br.com.vivo.challenge.backend.domain;

import java.util.Random;

public class Matriz {

    private int linhas;
    private int colunas;
    private int[][] matrizInt;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        //Inicializando a matriz
        this.matrizInt = new int[this.linhas][this.colunas];

        this.construirMatriz();
    }

    /**
     * Método responsável por gerar a matriz a partir de linhas e colunas informados,
     * e preencher ela com valores aleatórios segundo a semente passada.
     */
    private void construirMatriz() {
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                this.matrizInt[i][j] = new Random().nextInt(101);
            }
        }
    }

    /**
     * Método que exibe no console a matriz inteira
     */
    public void lerMatriz() {
        System.out.println();
        System.out.println("Matriz [" + this.linhas + "][" + this.colunas + "]:");
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                System.out.print(matrizInt[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Método responsável por contar a quantidade de recorências de um elemento na matriz
     *
     * @return a quantidade de recorrências
     */
    public int findElement(int element) {
        int times = 0;
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                if (this.matrizInt[i][j] == element){
                    times++;
                }
            }
        }
        return times;
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public int[][] getMatriz() {
        return matrizInt;
    }

    public void setMatriz(int[][] matrizInt) {
        this.matrizInt = matrizInt;
    }
}
