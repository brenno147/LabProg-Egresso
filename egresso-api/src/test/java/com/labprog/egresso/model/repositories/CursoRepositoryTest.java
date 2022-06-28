package com.labprog.egresso.model.repositories;

import java.util.List;
import java.util.Optional;

import com.labprog.egresso.model.entities.Curso;

import com.labprog.egresso.service.repositories.CursoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CursoRepositoryTest {

  @Autowired
  CursoRepository repository;

  @Test
  public void deveInserirUmCurso() {

    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    Curso salvo = repository.save(curso);

    Assertions.assertNotNull(salvo);
    Assertions.assertEquals(curso.getNome(), salvo.getNome());
    Assertions.assertEquals(curso.getNivel(), salvo.getNivel());

  }

  @Test
  public void deveBuscarTodosOsCursos() {

    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    repository.save(curso);

    List<Curso> cursos = repository.findAll();

    Assertions.assertFalse(cursos.isEmpty());

  }

  @Test
  public void deveBuscarCursoPorId() {

    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    repository.save(curso);

    Optional<Curso> cursoBuscado = repository.findById(curso.getId_curso());

    Assertions.assertTrue(cursoBuscado.isPresent());

  }

  @Test
  public void deveRemoverUmCurso() {
    
    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    Curso salvo = repository.save(curso);
    
    Optional<Curso> cursoBuscado = repository.findById(curso.getId_curso());

    Assertions.assertTrue(cursoBuscado.isPresent());

    repository.deleteById(curso.getId_curso());

    cursoBuscado = repository.findById(curso.getId_curso());

    Assertions.assertFalse(cursoBuscado.isPresent());


  }
}
