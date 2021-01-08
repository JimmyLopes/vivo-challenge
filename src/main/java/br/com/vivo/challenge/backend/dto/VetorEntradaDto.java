package br.com.vivo.challenge.backend.dto;

import java.util.ArrayList;
import java.util.List;

public class VetorEntradaDto {
    List<Integer> valoresVetor = new ArrayList<>();

    public List<Integer> getValoresVetor() {
        return valoresVetor;
    }

    public void setValoresVetor(List<Integer> valoresVetor) {
        this.valoresVetor = valoresVetor;
    }
}
