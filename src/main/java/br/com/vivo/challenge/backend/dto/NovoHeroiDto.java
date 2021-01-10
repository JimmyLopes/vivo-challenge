package br.com.vivo.challenge.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class NovoHeroiDto {

    private String codigoHeroi;
    private String nomeHeroi;

    private List<VoltaDto> voltasHeroi = new ArrayList<>();

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

    public List<VoltaDto> getVoltasHeroi() {
        return voltasHeroi;
    }

    public void setVoltasHeroi(List<VoltaDto> voltasHeroi) {
        this.voltasHeroi = voltasHeroi;
    }
}
