package br.com.vivo.challenge.backend.service;

import br.com.vivo.challenge.backend.dto.RecorrenciaDto;
import br.com.vivo.challenge.backend.dto.VetorEntradaDto;

public interface MatrizService {

    /**
     * Método responsável por validar o vetor, construir a matriz e procurar a recorrências dos elementos do vetor de entrada dentro da matriz
     *
     * @param vetorEntradaDto o vetor de entrada
     * @return o dto com as recorrências do vetor na matriz
     */
    RecorrenciaDto procurarRecorrencia(VetorEntradaDto vetorEntradaDto);
}
