package br.com.control.revenda.controller;

import br.com.control.revenda.entity.Revenda;
import br.com.control.revenda.entity.dtos.RevendaDTO;
import br.com.control.revenda.service.RevendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("revenda")
@Api(value = "Revenda")
public class RevendaController {

    private final RevendaService revendaService;

    public RevendaController(RevendaService revendaService) {
        this.revendaService = revendaService;
    }

    @ApiOperation(value = "Retorna as revendas Paginado.")
    @GetMapping
    public ResponseEntity<?> all(@RequestParam(value = "size", defaultValue = "10", required = false) int size,
                                 @RequestParam(value = "page", defaultValue = "0", required = false) int page) {
        Page<Revenda> revendas = revendaService.getAll(PageRequest.of(page, size));
        if (revendas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(revendas);
    }

    @ApiOperation(value = "Retorna as todas revendas como uma lista.")
    @GetMapping("all")
    public ResponseEntity<?> all() {
        List<Revenda> revendas = revendaService.getAll();
        if (revendas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(revendas);
    }

    @ApiOperation(value = "Salva uma nova revenda.")
    @PostMapping("register")
    public ResponseEntity<?> create(@Valid @RequestBody RevendaDTO revendaDTO) {
        return ResponseEntity.ok(revendaService.save(
                new Revenda(revendaDTO.getLicense(), revendaDTO.getName())
        ));
    }

    @ApiOperation(value = "Retorna um revenda por id.")
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        Revenda revenda = revendaService.get(id);
        if(revenda == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(revenda);
    }

    @ApiOperation(value = "Retorna um revenda por licença.")
    @GetMapping("license/{licenca}")
    public ResponseEntity<?> get(@PathVariable("licenca") int licenca) {
        Revenda revenda = revendaService.getRevenda(licenca);
        if(revenda == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(revenda);
    }
}
