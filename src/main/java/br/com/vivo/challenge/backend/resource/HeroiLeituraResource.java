package br.com.vivo.challenge.backend.resource;

import br.com.vivo.challenge.backend.dto.HeroiRetornoDto;
import br.com.vivo.challenge.backend.service.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compasso-uol/heroi")
public class HeroiLeituraResource {

    private final HeroiService heroiService;

    @Autowired
    public HeroiLeituraResource(HeroiService heroiService) {
        this.heroiService = heroiService;
    }

    @GetMapping("/classificacao")
    public ResponseEntity<List<HeroiRetornoDto>> buscarClassificacao() {
        return ResponseEntity.ok(heroiService.buscarTodos());
    }

}
