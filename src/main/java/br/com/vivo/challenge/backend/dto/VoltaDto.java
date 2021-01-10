package br.com.vivo.challenge.backend.dto;

public class VoltaDto {

    private Integer numeroVolta;
    private String tempoLargada;
    private String tempoChegada;
    private Double velocidade;

    public Integer getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(Integer numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public String getTempoLargada() {
        return tempoLargada;
    }

    public void setTempoLargada(String tempoLargada) {
        this.tempoLargada = tempoLargada;
    }

    public String getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(String tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }
}
