package br.com.vivo.challenge.backend.services;


import br.com.vivo.challenge.backend.config.ModelMapperConfig;
import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.domain.Volta;
import br.com.vivo.challenge.backend.dto.*;
import br.com.vivo.challenge.backend.exceptions.BusinessException;
import br.com.vivo.challenge.backend.exceptions.ResourceNotFoundException;
import br.com.vivo.challenge.backend.repository.HeroiRepository;
import br.com.vivo.challenge.backend.repository.VoltaRepository;
import br.com.vivo.challenge.backend.service.impl.HeroiServiceImpl;
import br.com.vivo.challenge.backend.utils.DateUtils;
import br.com.vivo.challenge.backend.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@SpringBootTest
class HeroiServiceTest {

    private static final String MOCK_FOLDER = "mocks";
    private static final String FILE_NAME_HEROI = "heroi.json";
    private static final String FILE_NAME_NOVO_HEROI = "novoHeroi.json";
    private static final String FILE_NAME_CORRIDA_COMPLETA = "heroiCorridaCompleta.json";
    private static final String FILE_NAME_CORRIDA_INCOMPLETA = "heroiCorridaIncompleta.json";
    private static final String FILE_NAME_VOLTA = "volta.json";
    private static final String FILE_NAME_MELHOR_VOLTA_CORRIDA = "melhorVoltaCorrida.json";
    private static final String FILE_NAME_VELOCIDADE_MEDIA = "velocidadeMedia.json";

    @Mock
    private HeroiRepository heroiRepository;

    @Mock
    private VoltaRepository voltaRepository;

    private final ModelMapper mapper = new ModelMapperConfig().modelMapper();

    private HeroiServiceImpl heroiService() {
        return new HeroiServiceImpl(heroiRepository, voltaRepository);
    }

    static Heroi getMockHeroi() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_HEROI, Heroi.class);
    }

    static NovoHeroiDto getMockNovoHeroi() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_NOVO_HEROI, NovoHeroiDto.class);
    }

    static HeroiRetornoDto getMockHeroiCorridaCompleta() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_CORRIDA_COMPLETA, HeroiRetornoDto.class);
    }

    static HeroiRetornoCorridaIncompletaDto getMockHeroiCorridaIncompleta() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_CORRIDA_INCOMPLETA, HeroiRetornoCorridaIncompletaDto.class);
    }

    static Volta getMockVolta() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_VOLTA, Volta.class);
    }


    static MelhorVoltaCorridaDto getMockMelhorVoltaCorrida() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_MELHOR_VOLTA_CORRIDA, MelhorVoltaCorridaDto.class);
    }

    static VelocidadeMediaHeroiDto getMockVelocidadeMediaHeroiDto() {
        return TestUtils.getMock(MOCK_FOLDER, FILE_NAME_VELOCIDADE_MEDIA, VelocidadeMediaHeroiDto.class);
    }

    /**
     * Testa se um heroi válido vai ser salvo pelo serviço
     */
    @Test
    void testarSalvarHeroi() {
        Heroi heroi = getMockHeroi();
        when(heroiRepository.save(Mockito.any())).thenReturn(heroi);
        Heroi heroiSalvo = heroiService().salvarHeroi(getMockNovoHeroi());
        assertEquals(heroi.getCodigo(), heroiSalvo.getCodigo());
        assertEquals(heroi.getNome(), heroiSalvo.getNome());
        assertEquals(heroi.getVoltasHeroi().size(), heroiSalvo.getVoltasHeroi().size());
    }

    /**
     * Testa se o serviço vai classificar a corrida
     */
    @Test
    void testarClassificarCorrida() {
        Heroi heroi = getMockHeroi();
        Heroi heroiCorrida = criarHeroiComTodasVoltas();
        List<HeroiRetornoDto> heroiCorridaCompleta = Collections.singletonList(getMockHeroiCorridaCompleta());
        List<HeroiRetornoCorridaIncompletaDto> heroiCorridaIncompleta = Collections.singletonList(getMockHeroiCorridaIncompleta());
        ClassificacaoDto classificacaoDto = new ClassificacaoDto(heroiCorridaCompleta, heroiCorridaIncompleta);

        when(heroiRepository.findAll()).thenReturn(Arrays.asList(heroi, heroiCorrida));

        ClassificacaoDto classificacaoDtoCalculada = heroiService().classificarCorrida();

        assertEquals(classificacaoDto.getHeroisCorridaCompleta().size(), classificacaoDtoCalculada.getHeroisCorridaCompleta().size());
        assertEquals(classificacaoDto.getHeroisCorridaIncompleta().size(), classificacaoDtoCalculada.getHeroisCorridaIncompleta().size());
    }

    private Heroi criarHeroiComTodasVoltas() {
        Heroi superman = new Heroi();
        superman.setNome("Superman");
        superman.setCodigo("038");

        Volta v1Superman = new Volta();
        v1Superman.setIdVolta("1");
        v1Superman.setNumeroVolta(1);
        v1Superman.setVelocidadeVolta(44.275);
        v1Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:48:05.575"));
        v1Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:08.277"));

        Volta v2Superman = new Volta();
        v2Superman.setIdVolta("2");
        v2Superman.setNumeroVolta(2);
        v2Superman.setVelocidadeVolta(44.053);
        v2Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:08.277"));
        v2Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:11.447"));

        Volta v3Superman = new Volta();
        v3Superman.setIdVolta("3");
        v3Superman.setNumeroVolta(3);
        v3Superman.setVelocidadeVolta(44.334);
        v3Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:11.447"));
        v3Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:14.216"));

        Volta v4Superman = new Volta();
        v4Superman.setIdVolta("4");
        v4Superman.setNumeroVolta(4);
        v4Superman.setVelocidadeVolta(44.321);
        v4Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:14.216"));
        v4Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:52:17.003"));

        superman.setVoltasHeroi(Arrays.asList(v1Superman, v2Superman, v3Superman, v4Superman));

        return superman;
    }

    /**
     * Testa se o serviço vai retornar a melhor volta de um dado herói
     */
    @Test
    void testarBuscarMelhorVoltaHeroi() {
        Heroi heroi = getMockHeroi();
        Volta melhorVolta = getMockVolta();
        when(heroiRepository.findById(Mockito.any())).thenReturn(Optional.of(heroi));
        MelhorVoltaHeroiDto melhorVoltaHeroiDto = heroiService().buscarMelhorVoltaHeroi(Mockito.anyString());
        assertEquals(melhorVoltaHeroiDto.getCodigoHeroi(), heroi.getCodigo());
        assertEquals(melhorVoltaHeroiDto.getNomeHeroi(), heroi.getNome());
        assertEquals(melhorVoltaHeroiDto.getNumeroVolta(), melhorVolta.getNumeroVolta());
    }

    /**
     * Testa se o serviço vai lançar exceção caso nao encontre o herói
     */
    @Test()
    void testarBuscarMelhorVoltaHeroiInexistente() {
        String qualquerString = Mockito.anyString();
        when(heroiRepository.findById(qualquerString)).thenReturn(Optional.empty());
        HeroiServiceImpl heroiService = heroiService();
        assertThrows(ResourceNotFoundException.class, () -> heroiService.buscarMelhorVoltaHeroi(qualquerString));
    }

    /**
     * Testa se o serviço vai retornar a melhor volta da corrida
     */
    @Test
    void testarBuscarMelhorVoltaCorrida() {
        when(heroiRepository.findAll()).thenReturn(Collections.singletonList(getMockHeroi()));
        MelhorVoltaCorridaDto melhorVoltaCorridaDto = getMockMelhorVoltaCorrida();
        MelhorVoltaCorridaDto melhorVoltaCorridaDtoCalculado = heroiService().buscarMelhorVoltaCorrida();
        assertEquals(melhorVoltaCorridaDto.getCodigoHeroi(), melhorVoltaCorridaDtoCalculado.getCodigoHeroi());
        assertEquals(melhorVoltaCorridaDto.getNomeHeroi(), melhorVoltaCorridaDtoCalculado.getNomeHeroi());
        assertEquals(melhorVoltaCorridaDto.getMelhorVoltaCorrida(), melhorVoltaCorridaDtoCalculado.getMelhorVoltaCorrida());
    }

    /**
     * Testa se o serviço vai lançar exceção caso a corrida não tenha voltas
     */
    @Test
    void testarExcecaoCorridaSemVoltas() {
        when(heroiRepository.findAll()).thenReturn(Collections.emptyList());
        HeroiServiceImpl heroiService = heroiService();
        assertThrows(BusinessException.class, heroiService::buscarMelhorVoltaCorrida);
    }

    /**
     * Testa se o serviço vai retornar a velocidade media de um herói
     */
    @Test
    void testarBuscarVelocidadeMediaHeroi() {
        Heroi heroi = getMockHeroi();
        VelocidadeMediaHeroiDto velocidadeMediaHeroiDto = getMockVelocidadeMediaHeroiDto();
        when(heroiRepository.findById(Mockito.any())).thenReturn(Optional.of(heroi));
        VelocidadeMediaHeroiDto velocidadeMediaHeroiDtoCalculada = heroiService().definirVelocidadeMedia(heroi.getCodigo());
        assertEquals(velocidadeMediaHeroiDto.getCodigoHeroi(), velocidadeMediaHeroiDtoCalculada.getCodigoHeroi());
        assertEquals(velocidadeMediaHeroiDto.getNomeHeroi(), velocidadeMediaHeroiDtoCalculada.getNomeHeroi());
        assertEquals(velocidadeMediaHeroiDto.getVelocidadeMediaCorrida(), velocidadeMediaHeroiDtoCalculada.getVelocidadeMediaCorrida());
    }

    /**
     * Testa se o serviço vai lançar exceção caso o herói não tenha completado nenhuma volta
     */
    @Test
    void testarExcecaoHeroiSemVoltas() {
        Heroi heroi = getMockHeroi();
        heroi.setVoltasHeroi(Collections.emptyList());
        when(heroiRepository.findById(Mockito.any())).thenReturn(Optional.of(heroi));
        HeroiServiceImpl heroiService = heroiService();
        assertThrows(BusinessException.class, () -> heroiService.buscarMelhorVoltaCorrida());
    }
}
