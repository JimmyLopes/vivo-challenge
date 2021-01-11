package br.com.vivo.challenge.backend.resource;

import br.com.vivo.challenge.backend.dto.ClassificacaoDto;
import br.com.vivo.challenge.backend.dto.MelhorVoltaCorridaDto;
import br.com.vivo.challenge.backend.dto.MelhorVoltaHeroiDto;
import br.com.vivo.challenge.backend.dto.VelocidadeMediaHeroiDto;
import br.com.vivo.challenge.backend.service.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compasso-uol/heroi")
public class HeroiLeituraResource {

    private final HeroiService heroiService;

    @Autowired
    public HeroiLeituraResource(HeroiService heroiService) {
        this.heroiService = heroiService;
    }

    @GetMapping("/classificacao")
    public ResponseEntity<ClassificacaoDto> buscarClassificacao() {
        return ResponseEntity.ok(heroiService.classificarCorrida());
    }

    @GetMapping("{codigoHeroi}/best-lap")
    public ResponseEntity<MelhorVoltaHeroiDto> buscarMelhorVolta(@PathVariable String codigoHeroi) {
        return ResponseEntity.ok(heroiService.buscarMelhorVoltaHeroi(codigoHeroi));
    }

    @GetMapping("/best-lap")
    public ResponseEntity<MelhorVoltaCorridaDto>  buscarMelhorVoltaCorrida(){
        return ResponseEntity.ok(heroiService.buscarMelhorVoltaCorrida());
    }

    @GetMapping("{codigoHeroi}/velocidade-media")
    public ResponseEntity<VelocidadeMediaHeroiDto> definirVelocidadeMediaHeroi(@PathVariable String codigoHeroi) {
        return ResponseEntity.ok(heroiService.definirVelocidadeMedia(codigoHeroi));
    }
}
