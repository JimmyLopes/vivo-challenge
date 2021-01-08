package br.com.vivo.challenge.backend.resource;

import br.com.vivo.challenge.backend.dto.RecorrenciaDto;
import br.com.vivo.challenge.backend.dto.VetorEntradaDto;
import br.com.vivo.challenge.backend.service.MatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/compasso-uol/matriz")
public class MatrizResource {

    private final MatrizService matrizService;

    @Autowired
    public MatrizResource(MatrizService matrizService) {
        this.matrizService = matrizService;
    }

    @PostMapping
    public ResponseEntity<RecorrenciaDto> buscarRecorrencia(@Valid @RequestBody VetorEntradaDto vetorEntradaDto) {
        return ResponseEntity.ok(matrizService.procurarRecorrencia(vetorEntradaDto));
    }
}
