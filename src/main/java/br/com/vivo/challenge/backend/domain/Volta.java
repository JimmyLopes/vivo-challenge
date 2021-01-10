package br.com.vivo.challenge.backend.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDateTime;

@RedisHash("Volta_tb")
public class Volta {

    @Id
    private String idVolta;

    @Indexed
    private Integer numeroVolta;
    private LocalDateTime inicioVolta;
    private LocalDateTime fimVolta;

    @Indexed
    private Double velocidadeVolta;

    public Volta() {
    }

    public Volta(Integer numeroVolta, LocalDateTime inicioVolta, LocalDateTime fimVolta, Double velocidadeVolta) {
        this.numeroVolta = numeroVolta;
        this.inicioVolta = inicioVolta;
        this.fimVolta = fimVolta;
        this.velocidadeVolta = velocidadeVolta;
    }

    public String getIdVolta() {
        return idVolta;
    }

    public void setIdVolta(String idVolta) {
        this.idVolta = idVolta;
    }

    public Integer getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(Integer numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public LocalDateTime getInicioVolta() {
        return inicioVolta;
    }

    public void setInicioVolta(LocalDateTime inicioVolta) {
        this.inicioVolta = inicioVolta;
    }

    public LocalDateTime getFimVolta() {
        return fimVolta;
    }

    public void setFimVolta(LocalDateTime fimVolta) {
        this.fimVolta = fimVolta;
    }

    public Double getVelocidadeVolta() {
        return velocidadeVolta;
    }

    public void setVelocidadeVolta(Double velocidadeVolta) {
        this.velocidadeVolta = velocidadeVolta;
    }
}
