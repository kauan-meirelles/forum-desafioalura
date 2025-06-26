package com.alura.forumhub.dto;

import com.alura.forumhub.model.Topico;
import java.time.format.DateTimeFormatter;

public class TopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private String nomeCurso;
    private String nomeAutor;
    private String status;
    private String dataCriacao;

    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.nomeCurso = topico.getCurso().getNome();
        this.nomeAutor = topico.getAutor().getNome();
        this.status = topico.getStatus().toString();
        this.dataCriacao = topico.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getStatus() {
        return status;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }
}
