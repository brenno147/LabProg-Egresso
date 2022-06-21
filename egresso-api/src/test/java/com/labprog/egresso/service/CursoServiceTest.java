package com.labprog.egresso.service;

import com.labprog.egresso.model.dto.CursoNumEgresso;
import com.labprog.egresso.model.entities.Curso;
import com.labprog.egresso.model.entities.CursoEgresso;
import com.labprog.egresso.model.entities.CursoEgressoPK;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.repositories.CursoEgressoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CursoServiceTest {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EgressoService egressoService;

    @Autowired
    private CursoEgressoRepository cursoEgressoRepository;

    @Test
    public void deveSalvarCurso() {
        Curso curso = Curso.builder()
                .nome("Curso de Teste")
                .nivel("Graduacao")
                .build();

        Curso cursoResultado = cursoService.salvar(curso);

        Assertions.assertNotNull(cursoResultado);
        Assertions.assertEquals(curso.getNome(), cursoResultado.getNome());
        Assertions.assertEquals(curso.getNivel(), cursoResultado.getNivel());
    }

    @Test
    public void deveRemoverCurso() {
        Curso curso = Curso.builder()
                .nome("Curso de Teste")
                .nivel("Graduacao")
                .build();

        Curso cursoResultado = cursoService.salvar(curso);

        cursoService.remover(cursoResultado.getId_curso());

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            cursoService.buscarPorId(cursoResultado.getId_curso());
        });
    }

    @Test
    public void deveBuscarPorId() {
        Curso curso = Curso.builder()
                .nome("Curso de Teste")
                .nivel("Graduacao")
                .build();

        Curso cursoResultado = cursoService.salvar(curso);

        Assertions.assertNotNull(cursoService.buscarPorId(cursoResultado.getId_curso()));
    }

    @Test
    public void deveConsultarCursoPorEgresso() {
        Curso curso = Curso.builder()
                .nome("Curso de Teste")
                .nivel("Graduacao")
                .build();

        Curso curso2 = Curso.builder()
                .nome("Curso de Teste")
                .nivel("Graduacao")
                .build();

        Curso cursoResultado = cursoService.salvar(curso);
        Curso cursoResultado2 = cursoService.salvar(curso2);

        Egresso egresso = Egresso.builder()
                .nome("Egresso de Teste")
                .cpf("123456789")
                .email("a@a")
                .resumo("Resumo de Teste")
                .urlFoto("https://www.google.com")
                .build();

        Egresso egresso2 = Egresso.builder()
                .nome("Egresso de Teste")
                .cpf("123456789")
                .email("a@a")
                .resumo("Resumo de Teste")
                .urlFoto("https://www.google.com")
                .build();

        CursoEgressoPK cursoEgressoPK = CursoEgressoPK.builder()
                .curso_id(curso.getId_curso())
                .egresso_id(egresso.getIdEgresso())
                .build();

        CursoEgresso cursoEgresso = CursoEgresso.builder()
                .id(cursoEgressoPK)
                .curso(curso)
                .data_inicio(LocalDate.now())
                .data_conclusao(LocalDate.now())
                .build();

        CursoEgressoPK cursoEgressoPK2 = CursoEgressoPK.builder()
                .curso_id(curso2.getId_curso())
                .egresso_id(egresso.getIdEgresso())
                .build();

        CursoEgresso cursoEgresso2 = CursoEgresso.builder()
                .id(cursoEgressoPK2)
                .curso(curso2)
                .data_inicio(LocalDate.now())
                .data_conclusao(LocalDate.now())
                .build();

        CursoEgressoPK cursoEgressoPK3 = CursoEgressoPK.builder()
                .curso_id(curso.getId_curso())
                .egresso_id(egresso2.getIdEgresso())
                .build();

        CursoEgresso cursoEgresso3 = CursoEgresso.builder()
                .id(cursoEgressoPK3)
                .curso(curso)
                .data_inicio(LocalDate.now())
                .data_conclusao(LocalDate.now())
                .build();

        egresso.addCurso(cursoEgresso);
        egresso.addCurso(cursoEgresso2);

        egresso2.addCurso(cursoEgresso3);

        Egresso egressoResultado = egressoService.salvar(egresso);
        Egresso egressoResultado2 = egressoService.salvar(egresso2);

        cursoEgressoRepository.save(cursoEgresso);
        cursoEgressoRepository.save(cursoEgresso2);
        cursoEgressoRepository.save(cursoEgresso3);

        List<Curso> cursos = cursoService.consultarCursoPorEgresso(egressoResultado.getIdEgresso());
        List<Curso> cursos2 = cursoService.consultarCursoPorEgresso(egressoResultado2.getIdEgresso());

        Assertions.assertEquals(2, cursos.size());
        Assertions.assertEquals(1, cursos2.size());
    }

    @Test
    public void deveRetornarQuantidadeDeEgressosPorCurso() {
        Curso curso = Curso.builder()
                .nome("Curso de Teste")
                .nivel("Graduacao")
                .build();

        Curso curso2 = Curso.builder()
                .nome("Curso de Teste")
                .nivel("Graduacao")
                .build();

        Curso cursoResultado = cursoService.salvar(curso);
        Curso cursoResultado2 = cursoService.salvar(curso2);

        Egresso egresso = Egresso.builder()
                .nome("Egresso de Teste")
                .cpf("123456789")
                .email("a@a")
                .resumo("Resumo de Teste")
                .urlFoto("https://www.google.com")
                .build();

        Egresso egresso2 = Egresso.builder()
                .nome("Egresso de Teste")
                .cpf("123456789")
                .email("a@a")
                .resumo("Resumo de Teste")
                .urlFoto("https://www.google.com")
                .build();

        CursoEgressoPK cursoEgressoPK = CursoEgressoPK.builder()
                .curso_id(curso.getId_curso())
                .egresso_id(egresso.getIdEgresso())
                .build();

        CursoEgresso cursoEgresso = CursoEgresso.builder()
                .id(cursoEgressoPK)
                .curso(curso)
                .data_inicio(LocalDate.now())
                .data_conclusao(LocalDate.now())
                .build();

        CursoEgressoPK cursoEgressoPK2 = CursoEgressoPK.builder()
                .curso_id(curso2.getId_curso())
                .egresso_id(egresso.getIdEgresso())
                .build();

        CursoEgresso cursoEgresso2 = CursoEgresso.builder()
                .id(cursoEgressoPK2)
                .curso(curso2)
                .data_inicio(LocalDate.now())
                .data_conclusao(LocalDate.now())
                .build();

        CursoEgressoPK cursoEgressoPK3 = CursoEgressoPK.builder()
                .curso_id(curso.getId_curso())
                .egresso_id(egresso2.getIdEgresso())
                .build();

        CursoEgresso cursoEgresso3 = CursoEgresso.builder()
                .id(cursoEgressoPK3)
                .curso(curso)
                .data_inicio(LocalDate.now())
                .data_conclusao(LocalDate.now())
                .build();

        egresso.addCurso(cursoEgresso);
        egresso.addCurso(cursoEgresso2);

        egresso2.addCurso(cursoEgresso3);

        Egresso egressoResultado = egressoService.salvar(egresso);
        Egresso egressoResultado2 = egressoService.salvar(egresso2);

        cursoEgressoRepository.save(cursoEgresso);
        cursoEgressoRepository.save(cursoEgresso2);
        cursoEgressoRepository.save(cursoEgresso3);

        List<CursoNumEgresso> cursos = cursoService.quantEgressoPorCurso();

        Assertions.assertEquals(2, cursos.size());
        Assertions.assertEquals(2, cursos.get(0).getNumEgresso());
        Assertions.assertEquals(1, cursos.get(1).getNumEgresso());

    }

}
