package br.com.vivo.challenge.backend.services;


import br.com.vivo.challenge.backend.dto.RecorrenciaDto;
import br.com.vivo.challenge.backend.dto.VetorEntradaDto;
import br.com.vivo.challenge.backend.exceptions.BusinessException;
import br.com.vivo.challenge.backend.service.impl.MatrizServiceImpl;
import br.com.vivo.challenge.backend.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class MatrizServiceTest {

    private static final String MOCK_FOLDER = "mocks";
    private static final String FILE_NAME_VETOR = "vetorEntrada.json";
    private static final String FILE_NAME_RECORRENCIA = "recorrencia.json";

    private MatrizServiceImpl matrizService() {
        return new MatrizServiceImpl();
    }

    static VetorEntradaDto getMockVetorEntrada() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_VETOR, VetorEntradaDto.class);
    }

    static RecorrenciaDto getMockRecorrencia() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_RECORRENCIA, RecorrenciaDto.class);
    }

    /**
     * Testa se um vetor válido vai retornar suas recorrências na matriz
     */
    @Test
    void testarBuscarRecorrencia() {
        VetorEntradaDto vetorEntradaDto = getMockVetorEntrada();
        RecorrenciaDto recorrenciaDto = getMockRecorrencia();
        RecorrenciaDto recorrenciaDtoCalculado = matrizService().procurarRecorrencia(vetorEntradaDto);
        assertEquals(recorrenciaDto.getRecorrencias().size(), recorrenciaDtoCalculado.getRecorrencias().size());
        assertEquals(vetorEntradaDto.getValoresVetor().size(), recorrenciaDtoCalculado.getRecorrencias().size());
    }

    /**
     * Testa se o serviço vai lançar exceção caso o vetor de entrada esteja vazio
     */
    @Test()
    void testarExcecaoVetorVazio() {
        VetorEntradaDto vetorEntradaDto = getMockVetorEntrada();
        vetorEntradaDto.setValoresVetor(Collections.emptyList());
        MatrizServiceImpl matrizService = matrizService();
        assertThrows(BusinessException.class, () -> matrizService.procurarRecorrencia(vetorEntradaDto));
    }

    /**
     * Testa se o serviço vai lançar exceção caso o vetor de entrada tenha algum valor inválido
     */
    @Test()
    void testarExcecaoVetorInvalido() {
        VetorEntradaDto vetorEntradaDto = getMockVetorEntrada();
        vetorEntradaDto.setValoresVetor(Arrays.asList(16, 0, 3, 5, -2));
        MatrizServiceImpl matrizService = matrizService();
        assertThrows(BusinessException.class, () -> matrizService.procurarRecorrencia(vetorEntradaDto));
    }
}
