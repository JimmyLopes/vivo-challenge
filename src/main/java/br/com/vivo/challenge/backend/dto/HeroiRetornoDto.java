package br.com.vivo.challenge.backend.dto;

public class HeroiRetornoDto {

    private String codigoSuperHeroi;
    private String nomeSuperHeroi;
    private String qntdVoltas;
    private String tempoTotalProva;

    public String getCodigoSuperHeroi() {
        return codigoSuperHeroi;
    }

    public void setCodigoSuperHeroi(String codigoSuperHeroi) {
        this.codigoSuperHeroi = codigoSuperHeroi;
    }

    public String getNomeSuperHeroi() {
        return nomeSuperHeroi;
    }

    public void setNomeSuperHeroi(String nomeSuperHeroi) {
        this.nomeSuperHeroi = nomeSuperHeroi;
    }

    public String getQntdVoltas() {
        return qntdVoltas;
    }

    public void setQntdVoltas(String qntdVoltas) {
        this.qntdVoltas = qntdVoltas;
    }

    public String getTempoTotalProva() {
        return tempoTotalProva;
    }

    public void setTempoTotalProva(String tempoTotalProva) {
        this.tempoTotalProva = tempoTotalProva;
    }
}
