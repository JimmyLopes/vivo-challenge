package br.com.vivo.challenge.backend.resource;

import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.dto.NovoHeroiDto;
import br.com.vivo.challenge.backend.service.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compasso-uol/heroi")
public class HeroiEscritaResource {

    private final HeroiService heroiService;

    @Autowired
    public HeroiEscritaResource(HeroiService heroiService) {
        this.heroiService = heroiService;
    }

    @PostMapping
    public ResponseEntity<Heroi> buscarRecorrencia(@RequestBody NovoHeroiDto novoHeroi) {
        return ResponseEntity.ok(heroiService.salvarHeroi(novoHeroi));
    }
}
