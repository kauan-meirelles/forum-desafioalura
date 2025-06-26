package com.alura.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoForm {

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotBlank
    private String nomeCurso;

    @NotBlank
    private String nomeAutor;
}
