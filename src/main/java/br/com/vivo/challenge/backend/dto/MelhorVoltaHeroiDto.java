package br.com.vivo.challenge.backend.dto;

public class MelhorVoltaHeroiDto {

    private String codigoHeroi;
    private String nomeHeroi;
    private Integer numeroVolta;
    private Double tempoVolta;

    public String getCodigoHeroi() {
        return codigoHeroi;
    }

    public void setCodigoHeroi(String codigoHeroi) {
        this.codigoHeroi = codigoHeroi;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public Integer getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(Integer numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public Double getTempoVolta() {
        return tempoVolta;
    }

    public void setTempoVolta(Double tempoVolta) {
        this.tempoVolta = tempoVolta;
    }
}
