package br.com.vivo.challenge.backend.dto;

public class MelhorVoltaCorridaDto {
    private String nomeHeroi;
    private String codigoHeroi;
    private Double melhorVoltaCorrida;

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public String getCodigoHeroi() {
        return codigoHeroi;
    }

    public void setCodigoHeroi(String codigoHeroi) {
        this.codigoHeroi = codigoHeroi;
    }

    public Double getMelhorVoltaCorrida() {
        return melhorVoltaCorrida;
    }

    public void setMelhorVoltaCorrida(Double melhorVoltaCorrida) {
        this.melhorVoltaCorrida = melhorVoltaCorrida;
    }
}
