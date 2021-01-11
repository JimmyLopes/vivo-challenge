package br.com.vivo.challenge.backend.service;

import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.dto.*;

import javax.validation.Valid;

public interface HeroiService {
    Heroi salvarHeroi(@Valid NovoHeroiDto novoHeroiDto);

    ClassificacaoDto classificarCorrida();

    MelhorVoltaHeroiDto buscarMelhorVoltaHeroi(String codigoHeroi);

    MelhorVoltaCorridaDto buscarMelhorVoltaCorrida();

    VelocidadeMediaHeroiDto definirVelocidadeMedia(String codigoHeroi);
}
