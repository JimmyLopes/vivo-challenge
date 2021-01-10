package br.com.vivo.challenge.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class ClassificacaoDto {

    List<HeroiRetornoDto> heroisCorridaCompleta = new ArrayList<>();
    List<HeroiRetornoCorridaIncompletaDto> heroisCorridaIncompleta = new ArrayList<>();

    public ClassificacaoDto(List<HeroiRetornoDto> heroisCorridaCompleta, List<HeroiRetornoCorridaIncompletaDto> heroisCorridaIncompleta) {
        this.heroisCorridaCompleta = heroisCorridaCompleta;
        this.heroisCorridaIncompleta = heroisCorridaIncompleta;
    }

    public List<HeroiRetornoDto> getHeroisCorridaCompleta() {
        return heroisCorridaCompleta;
    }

    public void setHeroisCorridaCompleta(List<HeroiRetornoDto> heroisCorridaCompleta) {
        this.heroisCorridaCompleta = heroisCorridaCompleta;
    }

    public List<HeroiRetornoCorridaIncompletaDto> getHeroisCorridaIncompleta() {
        return heroisCorridaIncompleta;
    }

    public void setHeroisCorridaIncompleta(List<HeroiRetornoCorridaIncompletaDto> heroisCorridaIncompleta) {
        this.heroisCorridaIncompleta = heroisCorridaIncompleta;
    }
}
