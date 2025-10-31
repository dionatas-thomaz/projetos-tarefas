package com.api.gerenciamento.projetos.dto;

import com.api.gerenciamento.projetos.entity.StatusTarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarefaDTO {
    @NotBlank(message = "descrição da tarefa e obrigatoria")
    private String descricao;
    private StatusTarefa status;
    private LocalDate dataLimite;

    @NotNull(message = "id do projeto e obrigatorio")
    private Long projetoId;
}