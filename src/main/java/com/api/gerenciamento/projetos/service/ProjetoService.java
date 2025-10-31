package com.api.gerenciamento.projetos.service;

import com.api.gerenciamento.projetos.entity.Projeto;
import com.api.gerenciamento.projetos.exception.ResourceNotFoundException;
import com.api.gerenciamento.projetos.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto create(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Projeto findById(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto nao encontrado com id: " + id));
    }

    public Projeto update(Long id, Projeto updated) {
        Projeto existing = findById(id);
        existing.setNome(updated.getNome());
        existing.setDescricao(updated.getDescricao());
        return projetoRepository.save(existing);
    }

    public void delete(Long id) {
        Projeto existing = findById(id);
        projetoRepository.delete(existing);
    }
}
