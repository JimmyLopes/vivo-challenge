package br.com.vivo.challenge.backend.dto;

public class VelocidadeMediaHeroiDto {
    private String codigoHeroi;
    private String nomeHeroi;
    private Double velocidadeMediaCorrida;

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

    public Double getVelocidadeMediaCorrida() {
        return velocidadeMediaCorrida;
    }

    public void setVelocidadeMediaCorrida(Double velocidadeMediaCorrida) {
        this.velocidadeMediaCorrida = velocidadeMediaCorrida;
    }
}
