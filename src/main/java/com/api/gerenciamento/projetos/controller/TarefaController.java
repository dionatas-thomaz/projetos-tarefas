package com.api.gerenciamento.projetos.controller;

import com.api.gerenciamento.projetos.dto.TarefaDTO;
import com.api.gerenciamento.projetos.entity.Tarefa;
import com.api.gerenciamento.projetos.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> create(@Valid @RequestBody TarefaDTO dto) {
        Tarefa t = Tarefa.builder()
                .descricao(dto.getDescricao())
                .status(dto.getStatus() != null ? dto.getStatus() : null)
                .dataLimite(dto.getDataLimite())
                .build();
        Tarefa saved = tarefaService.create(t, dto.getProjetoId());
        return ResponseEntity.created(URI.create("/api/tarefas/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll() {
        return ResponseEntity.ok(tarefaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @Valid @RequestBody TarefaDTO dto) {
        Tarefa t = Tarefa.builder()
                .descricao(dto.getDescricao())
                .status(dto.getStatus())
                .dataLimite(dto.getDataLimite())
                .build();
        Tarefa updated = tarefaService.update(id, t, dto.getProjetoId());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
