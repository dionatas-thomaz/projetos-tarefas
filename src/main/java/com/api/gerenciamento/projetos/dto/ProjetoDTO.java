
package com.api.gerenciamento.projetos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoDTO {
    @NotBlank(message = "nome do projeto e obrigatorio")
    private String nome;
    private String descricao;
}