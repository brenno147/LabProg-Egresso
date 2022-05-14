package com.labprog.egresso.model.repositories;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import com.labprog.egresso.model.entities.Curso;
import com.labprog.egresso.model.entities.CursoEgresso;
import com.labprog.egresso.model.entities.CursoEgressoPK;
import com.labprog.egresso.model.entities.Egresso;

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
public class CursoEgressoRepositoryTest {
  
  @Autowired
  private CursoEgressoRepository cursoEgressoRepository;
  
  @Autowired
  private CursoRepository cursoRepository;
  
  @Autowired
  private EgressoRepository egressoRepository;

  @Test
  public void deveSalvarCursoEgresso() {

    Egresso egresso = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();


    Egresso egressoSalvo = egressoRepository.save(egresso);

    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    Curso cursoSalvo = cursoRepository.save(curso);

    CursoEgressoPK cursoEgressoPk = CursoEgressoPK.builder()
        .egresso_id(egressoSalvo.getIdEgresso())
        .curso_id(cursoSalvo.getId_curso())
        .build();
  

    CursoEgresso cursoEgresso = CursoEgresso.builder()
          .id(cursoEgressoPk)
          .curso(cursoSalvo)
          .egresso(egressoSalvo)
          .data_inicio(LocalDate.now())
          .data_conclusao(LocalDate.now())
          .build();
  
    CursoEgresso salvo = cursoEgressoRepository.save(cursoEgresso);

    Assertions.assertEquals(salvo, cursoEgresso);

  }

  @Test
  public void deveBuscarTodosOsCursosEgressos() {

    Egresso egresso = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();


    Egresso egressoSalvo = egressoRepository.save(egresso);

    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    Curso cursoSalvo = cursoRepository.save(curso);

    CursoEgressoPK cursoEgressoPk = CursoEgressoPK.builder()
        .egresso_id(egressoSalvo.getIdEgresso())
        .curso_id(cursoSalvo.getId_curso())
        .build();
  

    CursoEgresso cursoEgresso = CursoEgresso.builder()
          .id(cursoEgressoPk)
          .curso(cursoSalvo)
          .egresso(egressoSalvo)
          .data_inicio(LocalDate.now())
          .data_conclusao(LocalDate.now())
          .build();
  
    cursoEgressoRepository.save(cursoEgresso);

    List<CursoEgresso> cursosEgressos = cursoEgressoRepository.findAll();

    Assertions.assertFalse(cursosEgressos.isEmpty());

  }

  @Test
  public void deveBuscarCursoEgressoPorId() {

    Egresso egresso = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();


    Egresso egressoSalvo = egressoRepository.save(egresso);

    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    Curso cursoSalvo = cursoRepository.save(curso);

    CursoEgressoPK cursoEgressoPk = CursoEgressoPK.builder()
        .egresso_id(egressoSalvo.getIdEgresso())
        .curso_id(cursoSalvo.getId_curso())
        .build();
  

    CursoEgresso cursoEgresso = CursoEgresso.builder()
          .id(cursoEgressoPk)
          .curso(cursoSalvo)
          .egresso(egressoSalvo)
          .data_inicio(LocalDate.now())
          .data_conclusao(LocalDate.now())
          .build();
  
    cursoEgressoRepository.save(cursoEgresso);

    Optional<CursoEgresso> cursoEgressoBuscado = cursoEgressoRepository.findById(cursoEgresso.getId());

    Assertions.assertTrue(cursoEgressoBuscado.isPresent());

  }

  @Test
  public void deveRemoverUmCursoEgresso() {
   
    Egresso egresso = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();


    Egresso egressoSalvo = egressoRepository.save(egresso);

    Curso curso = Curso.builder()
          .nome("Ciência da Computação")
          .nivel("3")
          .build();

    Curso cursoSalvo = cursoRepository.save(curso);

    CursoEgressoPK cursoEgressoPk = CursoEgressoPK.builder()
        .egresso_id(egressoSalvo.getIdEgresso())
        .curso_id(cursoSalvo.getId_curso())
        .build();
  

    CursoEgresso cursoEgresso = CursoEgresso.builder()
          .id(cursoEgressoPk)
          .curso(cursoSalvo)
          .egresso(egressoSalvo)
          .data_inicio(LocalDate.now())
          .data_conclusao(LocalDate.now())
          .build();
  
    cursoEgressoRepository.save(cursoEgresso);

    Optional<CursoEgresso> cursoEgressoBuscado = cursoEgressoRepository.findById(cursoEgresso.getId());

    Assertions.assertTrue(cursoEgressoBuscado.isPresent());

    cursoEgressoRepository.deleteById(cursoEgresso.getId());

    cursoEgressoBuscado = cursoEgressoRepository.findById(cursoEgresso.getId());

    Assertions.assertFalse(cursoEgressoBuscado.isPresent());

  }
}
