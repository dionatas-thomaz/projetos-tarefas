package com.api.gerenciamento.projetos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "projetos")

public class Projetos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O  Nome do projeto não pode estar em branco.")
    @Column(nullable = false, length = 100)
    private String Nome_do_projeto;

    @NotBlank(message = "O CPF não pode estar em branco.")
    @CPF(message = "O formato do CPF é inválido.")
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private BigDecimal creditos = BigDecimal.ZERO;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

}
