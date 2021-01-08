package br.com.vivo.challenge.backend.service.impl;

import br.com.vivo.challenge.backend.domain.Matriz;
import br.com.vivo.challenge.backend.dto.RecorrenciaDto;
import br.com.vivo.challenge.backend.dto.VetorEntradaDto;
import br.com.vivo.challenge.backend.exceptions.BusinessException;
import br.com.vivo.challenge.backend.service.MatrizService;
import br.com.vivo.challenge.backend.utils.MatrizUtils;
import br.com.vivo.challenge.backend.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
public class MatrizServiceImpl implements MatrizService {

    public static final int MAX_VALUE_FOR_VECTOR_ELEMENT = 15;

    @Override
    public RecorrenciaDto procurarRecorrencia(VetorEntradaDto vetorEntradaDto) {
        //Valida o vetor de entrada
        validarVetorEntrada(vetorEntradaDto);
        // Restringe o número de colunas da matriz que será gerada como sendo o tamanho do vetor de entrada
        int colunas = vetorEntradaDto.getValoresVetor().size();
        // Atribui um valor randômico entre 0 e 10, para a quantidade de linhas da matriz
        int linhas = new Random().nextInt(11);
        // Gera uma matriz como os valores de linhas e colunas
        Matriz matriz = new Matriz(linhas, colunas);
        // Criar o vetor a partir do dto
        int[] vetor = vetorEntradaDto.getValoresVetor().stream()
                .mapToInt(Integer::valueOf).toArray();

        Map<Integer, Integer> mapRecorrencias = MatrizUtils.procurarRecorrencia(matriz, vetor);

        return new RecorrenciaDto(mapRecorrencias, matriz, vetor);
    }

    private void validarVetorEntrada(VetorEntradaDto vetorEntradaDto) {
        // Verificar se existe elementos dentro do vetor
        if (vetorEntradaDto.getValoresVetor().isEmpty()){
            throw new BusinessException(StringUtils.buscarMensagemDeValidacao("vetor.vazio"));
        }
        vetorEntradaDto.getValoresVetor().forEach(integer -> {
            if (integer < 0 || integer > 15){
                throw new BusinessException(StringUtils.buscarMensagemDeValidacao("vetor.range.invalido", MAX_VALUE_FOR_VECTOR_ELEMENT));
            }
        });
    }
}
