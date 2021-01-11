package br.com.vivo.challenge.backend.service;

import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.dto.ClassificacaoDto;
import br.com.vivo.challenge.backend.dto.MelhorVoltaCorridaDto;
import br.com.vivo.challenge.backend.dto.MelhorVoltaHeroiDto;
import br.com.vivo.challenge.backend.dto.NovoHeroiDto;

import javax.validation.Valid;

public interface HeroiService {
    Heroi salvarHeroi(@Valid NovoHeroiDto novoHeroiDto);

    ClassificacaoDto classificarCorrida();

    MelhorVoltaHeroiDto buscarMelhorVoltaHeroi(String codigoHeroi);

    MelhorVoltaCorridaDto buscarMelhorVoltaCorrida();
}
