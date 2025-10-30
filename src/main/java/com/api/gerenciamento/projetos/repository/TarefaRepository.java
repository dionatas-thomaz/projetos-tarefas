package com.api.gerenciamento.projetos.repository;

import com.api.gerenciamento.projetos.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByProjetoId(Long projetoId);
}
