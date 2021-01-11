package br.com.vivo.challenge.backend.dto;

public class HeroiRetornoDto {

    private Integer posicao;
    private String codigoSuperHeroi;
    private String nomeSuperHeroi;
    private Integer qntdVoltas;
    private Double tempoTotalProva;

    //Construtor utilizado nos testes
    public HeroiRetornoDto() {
    }

    public HeroiRetornoDto(String codigoSuperHeroi, String nomeSuperHeroi, Integer qntdVoltas, Double tempoTotalProva) {
        this.codigoSuperHeroi = codigoSuperHeroi;
        this.nomeSuperHeroi = nomeSuperHeroi;
        this.qntdVoltas = qntdVoltas;
        this.tempoTotalProva = tempoTotalProva;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
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

    public Double getTempoTotalProva() {
        return tempoTotalProva;
    }

    public void setTempoTotalProva(Double tempoTotalProva) {
        this.tempoTotalProva = tempoTotalProva;
    }
}
