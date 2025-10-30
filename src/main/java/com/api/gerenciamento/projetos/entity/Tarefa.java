package com.api.gerenciamento.projetos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "descrição da tarefa é obrigatória")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status = StatusTarefa.PENDENTE;

    private LocalDate dataLimite;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;
}
