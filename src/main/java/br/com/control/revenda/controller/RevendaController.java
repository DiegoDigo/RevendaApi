package br.com.control.revenda.controller;

import br.com.control.revenda.entity.Revenda;
import br.com.control.revenda.entity.dtos.RevendaDTO;
import br.com.control.revenda.service.RevendaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("revenda")
public class RevendaController {

    private final RevendaService revendaService;

    public RevendaController(RevendaService revendaService) {
        this.revendaService = revendaService;
    }

    @GetMapping("pageable")
    public ResponseEntity<?> all(Pageable pageable) {
        Page<Revenda> revendas = revendaService.getAll(pageable);
        if (revendas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(revendas);
    }

    @GetMapping
    public ResponseEntity<?> all() {
        List<Revenda> revendas = revendaService.getAll();
        if (revendas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(revendas);
    }

    @PostMapping("register")
    public ResponseEntity<?> create(@Valid @RequestBody RevendaDTO revendaDTO) {
        return ResponseEntity.ok(revendaService.save(
                new Revenda(revendaDTO.getLicense(), revendaDTO.getName())
        ));


    }
}
