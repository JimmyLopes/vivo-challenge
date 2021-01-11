package br.com.vivo.challenge.backend.dto;

public class HeroiRetornoCorridaIncompletaDto {
    private String posicao;
    private String codigoSuperHeroi;
    private String nomeSuperHeroi;
    private Integer qntdVoltas;
    private Double tempoParcialProva;

    // Construtor Utilizado nos testes
    public HeroiRetornoCorridaIncompletaDto() {
    }

    public HeroiRetornoCorridaIncompletaDto(String codigoSuperHeroi, String nomeSuperHeroi, Integer qntdVoltas, Double tempoParcialProva) {
        this.posicao = "Corrida incompleta";
        this.codigoSuperHeroi = codigoSuperHeroi;
        this.nomeSuperHeroi = nomeSuperHeroi;
        this.qntdVoltas = qntdVoltas;
        this.tempoParcialProva = tempoParcialProva;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

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

    public Integer getQntdVoltas() {
        return qntdVoltas;
    }

    public void setQntdVoltas(Integer qntdVoltas) {
        this.qntdVoltas = qntdVoltas;
    }

    public Double getTempoParcialProva() {
        return tempoParcialProva;
    }

    public void setTempoParcialProva(Double tempoParcialProva) {
        this.tempoParcialProva = tempoParcialProva;
    }
}
