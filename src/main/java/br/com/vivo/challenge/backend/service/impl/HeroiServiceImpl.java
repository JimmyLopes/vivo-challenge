package br.com.vivo.challenge.backend.service.impl;

import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.domain.Volta;
import br.com.vivo.challenge.backend.dto.HeroiRetornoDto;
import br.com.vivo.challenge.backend.dto.NovoHeroiDto;
import br.com.vivo.challenge.backend.dto.VoltaDto;
import br.com.vivo.challenge.backend.repository.HeroiRepository;
import br.com.vivo.challenge.backend.service.HeroiService;
import br.com.vivo.challenge.backend.utils.DateUtils;
import br.com.vivo.challenge.backend.utils.ListUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class HeroiServiceImpl implements HeroiService {

    private final HeroiRepository heroiRepository;
    private final ModelMapper mapper;

    @Autowired
    public HeroiServiceImpl(HeroiRepository heroiRepository, ModelMapper mapper) {
        this.heroiRepository = heroiRepository;
        this.mapper = mapper;
    }

    @Override
    public Heroi salvarHeroi(@Valid NovoHeroiDto novoHeroi) {
        Heroi heroi = new Heroi();
        heroi.setNome(novoHeroi.getCodigoHeroi());
        heroi.setNome(novoHeroi.getNomeHeroi());
        heroi.setVoltasHeroi(getListOfVoltasFromDto(novoHeroi.getVoltasHeroi()));
        return heroiRepository.save(heroi);
    }

    @Override
    public List<HeroiRetornoDto> buscarTodos() {
        List<Heroi> herois = ListUtils.getListFromIterable(heroiRepository.findAll());
        return null;
    }

    private List<Volta> getListOfVoltasFromDto(List<VoltaDto> voltasHeroi) {
        return voltasHeroi.stream()
                .map(voltaDto -> new Volta(voltaDto.getNumeroVolta(),
                        DateUtils.getLocalDateTimeFromString(voltaDto.getTempoLargada()),
                        DateUtils.getLocalDateTimeFromString(voltaDto.getTempoChegada()),
                        voltaDto.getVelocidade()))
                .collect(Collectors.toList());
    }
}
