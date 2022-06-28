package com.labprog.egresso.controller;


import com.labprog.egresso.model.dto.CursoDTO;
import com.labprog.egresso.model.dto.CursoNumEgresso;
import com.labprog.egresso.model.entities.Curso;
import com.labprog.egresso.model.repositories.CursoRepository;
import com.labprog.egresso.service.CursoService;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody CursoDTO dto){
        Curso curso = Curso.builder()
                .nome(dto.getNome())
                .nivel(dto.getNivel())
                .build();

        try {
            Curso salvo = cursoService.salvar(curso);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody CursoDTO dto){
        if (!cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Curso curso = Curso.builder()
                .id_curso(id)
                .nome(dto.getNome())
                .nivel(dto.getNivel())
                .build();

        try {
            Curso salvo = cursoService.salvar(curso);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remover(@PathVariable Long id){
        if (!cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            cursoService.remover(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Não está passando
    @GetMapping("/lista-cursos-por-egresso/{id}")
    public List<Curso> listaCargosPorEgresso(@PathVariable Long id) {
        return cursoService.consultarCursoPorEgresso(id);
    }
    
    // Não está passando
    @GetMapping("/quant-egresso-por-curso")
    public List<CursoNumEgresso> quantEgressoPorCurso(){
        return cursoService.quantEgressoPorCurso();
    }
}
