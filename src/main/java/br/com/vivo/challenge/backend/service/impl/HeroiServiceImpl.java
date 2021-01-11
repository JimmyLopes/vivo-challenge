package br.com.vivo.challenge.backend.service.impl;

import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.domain.Volta;
import br.com.vivo.challenge.backend.dto.*;
import br.com.vivo.challenge.backend.exceptions.BusinessException;
import br.com.vivo.challenge.backend.exceptions.ResourceNotFoundException;
import br.com.vivo.challenge.backend.repository.HeroiRepository;
import br.com.vivo.challenge.backend.repository.VoltaRepository;
import br.com.vivo.challenge.backend.service.HeroiService;
import br.com.vivo.challenge.backend.utils.DateUtils;
import br.com.vivo.challenge.backend.utils.ListUtils;
import br.com.vivo.challenge.backend.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Validated
public class HeroiServiceImpl implements HeroiService {

    private final HeroiRepository heroiRepository;
    private final VoltaRepository voltaRepository;

    @Autowired
    public HeroiServiceImpl(HeroiRepository heroiRepository, VoltaRepository voltaRepository) {
        this.heroiRepository = heroiRepository;
        this.voltaRepository = voltaRepository;
    }

    /**
     * Método responsável por salvar um novo herói
     *
     * @param novoHeroi o novo herói a ser salvo
     * @return o herói salvo
     */
    @Override
    public Heroi salvarHeroi(@Valid NovoHeroiDto novoHeroi) {
        Heroi heroi = new Heroi();
        heroi.setCodigo(novoHeroi.getCodigoHeroi());
        heroi.setNome(novoHeroi.getNomeHeroi());
        heroi.setVoltasHeroi(getListOfVoltasFromDto(novoHeroi.getVoltasHeroi()));
        return heroiRepository.save(heroi);
    }

    /**
     * Gera a classificação da corrida
     *
     * @return retorna a classificação
     */
    @Override
    public ClassificacaoDto classificarCorrida() {
        List<Heroi> herois = buscarTodos();
        return this.classificarHerois(herois);
    }

    /**
     * Busca um herói e define sua melhor volta
     *
     * @param codigoHeroi o código do heroi procurado
     * @return a melhor volta do herói procurado
     */
    @Override
    public MelhorVoltaHeroiDto buscarMelhorVoltaHeroi(String codigoHeroi) {
        Heroi heroiProcurado = this.buscarHeroi(codigoHeroi);
        return obterMelhorVolta(heroiProcurado);
    }

    /**
     * Método que define qual foi a melhor volta da corrida
     *
     * @return a melhor volta da corrida
     */
    @Override
    public MelhorVoltaCorridaDto buscarMelhorVoltaCorrida() {
        List<Heroi> herois = buscarTodos();

        //Map contendo as voltas e os tempos respectivos
        Map<Volta, Double> mapVoltaXTempo = new HashMap<>();
        herois.forEach( heroi -> heroi.getVoltasHeroi().forEach(volta -> mapVoltaXTempo.put(volta, getTempoVolta(volta))));

        MelhorVoltaCorridaDto melhorVoltaCorridaDto = new MelhorVoltaCorridaDto();
        melhorVoltaCorridaDto.setMelhorVoltaCorrida(Double.MAX_VALUE);

        String idMelhorVolta = null;

        for (Map.Entry<Volta, Double> entry: mapVoltaXTempo.entrySet()){
            if(melhorVoltaCorridaDto.getMelhorVoltaCorrida() > entry.getValue()){
                melhorVoltaCorridaDto.setMelhorVoltaCorrida(entry.getValue());
                idMelhorVolta = entry.getKey().getIdVolta();
            }
        }

        //Busca o heroi com a melhor volta
        if (idMelhorVolta == null){
            throw new BusinessException(StringUtils.buscarMensagemDeValidacao("volta.melhor.inexistente"));
        } else {
            for (Heroi hero: herois){
                for (Volta volta: hero.getVoltasHeroi()){
                    if (volta.getIdVolta().equals(idMelhorVolta)){
                        melhorVoltaCorridaDto.setNomeHeroi(hero.getNome());
                        melhorVoltaCorridaDto.setCodigoHeroi(hero.getCodigo());
                    }
                }
            }
        }
        return melhorVoltaCorridaDto;
    }

    /**
     * Método responsável por buscar todos heróis cadastrados
     *
     * @return a lista com os heróis
     */
    private List<Heroi> buscarTodos(){
        return ListUtils.getListFromIterable(heroiRepository.findAll());
    }

    /**
     * Método que contém a lógica para obter a melhor volta de um certo herói
     *
     * @param heroi o heroi
     * @return o dto da melhor volta do herói construido
     */
    @SuppressWarnings("java:S1871")
    private MelhorVoltaHeroiDto obterMelhorVolta(Heroi heroi) {
        MelhorVoltaHeroiDto bestLap = new MelhorVoltaHeroiDto();
        Map<Volta, Double> mapTempoXVolta = new HashMap<>();

        //Injetando o valor de tempo das voltar no map
        heroi.getVoltasHeroi()
                .forEach(volta -> mapTempoXVolta.put(volta, getTempoVolta(volta)));

        bestLap.setTempoVolta(null);
        bestLap.setNumeroVolta(null);

        //Definindo a volta com o menorTempo
        for (Map.Entry<Volta, Double> entry : mapTempoXVolta.entrySet()) {
            if (bestLap.getTempoVolta() == null && bestLap.getNumeroVolta() == null){
                setarValoresBestLap(bestLap, entry);
            } else if (bestLap.getTempoVolta() > entry.getValue()){
                //Troca o valor de melhor volta caso o tempo setado seja maior que o tampo do value
                setarValoresBestLap(bestLap, entry);
            }
        }

        bestLap.setCodigoHeroi(heroi.getCodigo());
        bestLap.setNomeHeroi(heroi.getNome());
        return bestLap;
    }

    /**
     * Método responsável por injetar o número e tempo da melhor volta
     *
     * @param bestLap a melhor volta
     * @param entry a entrada que possui os valores a serem injetados na melhor volta
     */
    private void setarValoresBestLap(MelhorVoltaHeroiDto bestLap, Map.Entry<Volta, Double> entry) {
        bestLap.setNumeroVolta(entry.getKey().getNumeroVolta());
        bestLap.setTempoVolta(entry.getValue());
    }

    /**
     * Método Responsável por ir no banco e buscar o herói pelo seu código.
     *
     * @param codigoHeroi o código do herói procurado
     * @return retorna o herói caso ache, ou lança uma exceção por violação nas regras de negócio
     */
    private Heroi buscarHeroi(String codigoHeroi) {
        return heroiRepository.findById(codigoHeroi)
                .orElseGet(() -> {
                    throw new ResourceNotFoundException(StringUtils.buscarMensagemDeValidacao("heroi.nao.encontrado", codigoHeroi));
                });
    }

    /**
     * Gera uma lista de voltas a partir do dto
     *
     * @param voltasHeroi o dto contendo as voltaHerois a serem mapeadas
     * @return a lista de volta mapeadas
     */
    private List<Volta> getListOfVoltasFromDto(List<VoltaDto> voltasHeroi) {
        return voltasHeroi.stream()
                .map(voltaDto -> new Volta(getNextIdVolta(),
                        voltaDto.getNumeroVolta(),
                        DateUtils.getLocalDateTimeFromString(voltaDto.getTempoLargada()),
                        DateUtils.getLocalDateTimeFromString(voltaDto.getTempoChegada()),
                        voltaDto.getVelocidade()))
                .collect(Collectors.toList());
    }

    /**
     * Método responsável por gerar o próximo id de volta.
     *
     * @return o próximo id
     */
    @SuppressWarnings("java:S2131")
    private String getNextIdVolta() {
        int qntdVoltas = ListUtils.getListFromIterable(voltaRepository.findAll()).size();
        return Integer.valueOf(qntdVoltas).toString();
    }

    /**
     * Método responsável por aplicar a lógica de classificação dos heróis a partir de uma lista de heróis.
     * Divide a classificação entre heróis que terminaram a corrida e os que não terminaram a corrida.
     *
     * @param herois a lista de heróis
     * @return a classificação dos heróis na corrida
     */
    @SuppressWarnings("java:S3864")
    private ClassificacaoDto classificarHerois(List<Heroi> herois) {
        //Lista com o tempo de prova dos herois
        List<HeroiRetornoDto> heroisRetorno = herois.stream()
                .map(heroi -> new HeroiRetornoDto(heroi.getCodigo(),
                        heroi.getNome(),
                        heroi.getVoltasHeroi().size(),
                        getTempoTotalProva(heroi.getVoltasHeroi())
                )).collect(Collectors.toList());

        //Retirar herois que nao completaram a corrida
        List<HeroiRetornoDto> heroisNaoFinalistas = heroisRetorno.stream().map(hero -> {
            if (hero.getQntdVoltas() != 4) {
                return hero;
            } else {
                return null;
            }
        })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        heroisRetorno.removeAll(heroisNaoFinalistas);

        // Ordena os herois que completaram a corrida pelo tempo
        ordenarHeroisPeloTempo(heroisRetorno);

        // Monta a lista de retorno dos herois que completaram a corrida
        AtomicInteger i = new AtomicInteger();
        List<HeroiRetornoDto> heroisCorridaCompleta = heroisRetorno.stream()
                .peek(hero -> {
                    hero.setPosicao(i.get() + 1);
                    i.getAndIncrement();
                }).collect(Collectors.toList());

        //Monta a lista com os herois que nao completaram a corrida
        List<HeroiRetornoCorridaIncompletaDto> heroisCorridaIncompleta = heroisNaoFinalistas.stream()
                .map(hero -> new HeroiRetornoCorridaIncompletaDto(hero.getCodigoSuperHeroi(),
                        hero.getNomeSuperHeroi(),
                        hero.getQntdVoltas(),
                        hero.getTempoTotalProva()))
                .collect(Collectors.toList());

        return new ClassificacaoDto(heroisCorridaCompleta, heroisCorridaIncompleta);
    }

    /**
     * Ordena Decrescentemente os heróis pelo seu tempo total de prova
     *
     * @param heroisRetorno a lista de heróis
     */
    private void ordenarHeroisPeloTempo(List<HeroiRetornoDto> heroisRetorno) {
        // Utiliza o Bubble Sort para ordenar os herois pelo tempo total de prova
        for (int i = 0; i < heroisRetorno.size(); i++) {
            for (int j = 1; j < (heroisRetorno.size() - i); j++) {
                if (heroisRetorno.get(j - 1).getTempoTotalProva() > heroisRetorno.get(j).getTempoTotalProva()) {
                    //troca os herois caso o tempo do primeiro seja maior que o segundo
                    HeroiRetornoDto temp = heroisRetorno.get(j - 1);
                    heroisRetorno.set(j - 1, heroisRetorno.get(j));
                    heroisRetorno.set(j, temp);
                }
            }
        }
    }

    /**
     * Calcula o tempo total da corrida a partir de uma lista de voltas
     *
     * @param voltasHeroi a lista
     * @return o tempo total da corrida
     */
    private Double getTempoTotalProva(List<Volta> voltasHeroi) {
        //Armazena os valores de tempo de cada volta
        List<Double> tempoVoltas = voltasHeroi.stream().map(this::getTempoVolta).collect(Collectors.toList());

        return tempoVoltas.stream().mapToDouble(Double::doubleValue).sum();
    }

    /**
     * Método responsável por calcula o tempo de uma volta
     *
     * @param volta a volta cujo o tempo sera calculado
     * @return o tempo da volta
     */
    private Double getTempoVolta(Volta volta) {

        LocalDateTime inicioVolta = volta.getInicioVolta();

        // Variavel que armazena os minutos
        long minutes = inicioVolta.until(volta.getFimVolta(), ChronoUnit.MINUTES);
        inicioVolta = inicioVolta.plusMinutes(minutes);

        // Variavel que armazena os segundos
        long seconds = inicioVolta.until(volta.getFimVolta(), ChronoUnit.SECONDS);
        inicioVolta = inicioVolta.plusSeconds(seconds);

        // Variavel que armazena os milisegundos
        long miliseconds = inicioVolta.until(volta.getFimVolta(), ChronoUnit.MILLIS);

        //Gera a volta com soma dos valores minutos, segundos e milisegundos
        return Double.valueOf(minutes) + (Double.valueOf(seconds) / 100) + (Double.valueOf(miliseconds) / 100000);
    }
}
