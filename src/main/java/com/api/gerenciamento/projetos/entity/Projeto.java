package com.api.gerenciamento.projetos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projetos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome do projeto é obrigatório")
    private String nome;

    private String descricao;

    private LocalDate dataCriacao;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefa> tarefas = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        if (dataCriacao == null) {
            dataCriacao = LocalDate.now();
        }
    }
}
