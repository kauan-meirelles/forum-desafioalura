package com.alura.forumhub.controller;

import com.alura.forumhub.dto.TopicoDto;
import com.alura.forumhub.dto.TopicoForm;
import com.alura.forumhub.model.Curso;
import com.alura.forumhub.model.Topico;
import com.alura.forumhub.model.Usuario;
import com.alura.forumhub.repository.CursoRepository;
import com.alura.forumhub.repository.TopicoRepository;
import com.alura.forumhub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TopicoForm form) {
        if (topicoRepository.existsByTituloAndMensagem(form.getTitulo(), form.getMensagem())) {
            return ResponseEntity.badRequest().body("Tópico duplicado");
        }

        Optional<Usuario> autor = usuarioRepository.findByNome(form.getNomeAutor());
        Optional<Curso> curso = cursoRepository.findByNome(form.getNomeCurso());

        if (autor.isEmpty() || curso.isEmpty()) {
            return ResponseEntity.badRequest().body("Curso ou autor não encontrado");
        }

        Topico topico = new Topico();
        topico.setTitulo(form.getTitulo());
        topico.setMensagem(form.getMensagem());
        topico.setAutor(autor.get());
        topico.setCurso(curso.get());

        topicoRepository.save(topico);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @GetMapping
    public List<TopicoDto> listar() {
        return topicoRepository.findAll().stream()
                .map(TopicoDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(topico -> ResponseEntity.ok(new TopicoDto(topico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoForm form) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isEmpty()) return ResponseEntity.notFound().build();

        Topico topico = topicoOptional.get();
        topico.setTitulo(form.getTitulo());
        topico.setMensagem(form.getMensagem());
        topicoRepository.save(topico);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) return ResponseEntity.notFound().build();
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
