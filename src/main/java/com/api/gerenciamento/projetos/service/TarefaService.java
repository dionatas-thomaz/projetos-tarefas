package com.api.gerenciamento.projetos.service;

import com.api.gerenciamento.projetos.entity.Projeto;
import com.api.gerenciamento.projetos.entity.Tarefa;
import com.api.gerenciamento.projetos.exception.ResourceNotFoundException;
import com.api.gerenciamento.projetos.repository.ProjetoRepository;
import com.api.gerenciamento.projetos.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final ProjetoRepository projetoRepository;

    public TarefaService(TarefaRepository tarefaRepository, ProjetoRepository projetoRepository) {
        this.tarefaRepository = tarefaRepository;
        this.projetoRepository = projetoRepository;
    }

    public Tarefa create(Tarefa tarefa, Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com id: " + projetoId));
        tarefa.setProjeto(projeto);
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    public Tarefa findById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id: " + id));
    }

    public Tarefa update(Long id, Tarefa updated, Long projetoId) {
        Tarefa existing = findById(id);

        existing.setDescricao(updated.getDescricao());
        existing.setStatus(updated.getStatus());
        existing.setDataLimite(updated.getDataLimite());

        if (projetoId != null && !projetoId.equals(existing.getProjeto().getId())) {
            Projeto projeto = projetoRepository.findById(projetoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com id: " + projetoId));
            existing.setProjeto(projeto);
        }

        return tarefaRepository.save(existing);
    }

    public void delete(Long id) {
        Tarefa existing = findById(id);
        tarefaRepository.delete(existing);
    }

    public List<Tarefa> findByProjetoId(Long projetoId) {
        // Verifica se projeto existe
        projetoRepository.findById(projetoId)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com id: " + projetoId));
        return tarefaRepository.findByProjetoId(projetoId);
    }
}
