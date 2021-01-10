package br.com.vivo.challenge.backend.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@RedisHash("Heroi_tb")
public class Heroi {

    @Id
    private String codigo;

    @Indexed
    private String nome;

    private List<Volta> voltasHeroi = new ArrayList<>();

    public Heroi() {
    }

    public Heroi(String codigo, String nome, List<Volta> voltasHeroi) {
        this.codigo = codigo;
        this.nome = nome;
        this.voltasHeroi = voltasHeroi;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Volta> getVoltasHeroi() {
        return voltasHeroi;
    }

    public void setVoltasHeroi(List<Volta> voltasHeroi) {
        this.voltasHeroi = voltasHeroi;
    }
}
