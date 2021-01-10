package br.com.vivo.challenge.backend.service;

import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.dto.HeroiRetornoDto;
import br.com.vivo.challenge.backend.dto.NovoHeroiDto;

import javax.validation.Valid;
import java.util.List;

public interface HeroiService {
    Heroi salvarHeroi(@Valid NovoHeroiDto novoHeroiDto);

    List<HeroiRetornoDto> buscarTodos();
}
