package com.api.gerenciamento.projetos.controller;

import com.api.gerenciamento.projetos.dto.ProjetoDTO;
import com.api.gerenciamento.projetos.entity.Projeto;
import com.api.gerenciamento.projetos.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<Projeto> create(@Valid @RequestBody ProjetoDTO dto) {
        Projeto projeto = Projeto.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .build();
        Projeto saved = projetoService.create(projeto);
        return ResponseEntity.created(URI.create("/api/projetos/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> findAll() {
        return ResponseEntity.ok(projetoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Long id, @Valid @RequestBody ProjetoDTO dto) {
        Projeto updated = Projeto.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .build();
        return ResponseEntity.ok(projetoService.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projetoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
