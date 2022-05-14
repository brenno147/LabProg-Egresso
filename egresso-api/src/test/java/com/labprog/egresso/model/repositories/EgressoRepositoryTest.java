package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.Contato;
import com.labprog.egresso.model.entities.Curso;
import com.labprog.egresso.model.entities.CursoEgresso;
import com.labprog.egresso.model.entities.Egresso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EgressoRepositoryTest {

    @Autowired
    private EgressoRepository repository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void testeSalvarEgresso() {
        Egresso egresso = Egresso.builder()
                .nome("Egresso")
                .email("teste@teste")
                .cpf("123456789")
                .resumo("Resumo")
                .urlFoto("UrlFoto")
                .build();

        Egresso salvo = repository.save(egresso);

        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(salvo.getIdEgresso(), egresso.getIdEgresso());
        Assertions.assertEquals(salvo.getNome(), egresso.getNome());
        Assertions.assertEquals(salvo.getEmail(), egresso.getEmail());
        Assertions.assertEquals(salvo.getCpf(), egresso.getCpf());
        Assertions.assertEquals(salvo.getResumo(), egresso.getResumo());
        Assertions.assertEquals(salvo.getUrlFoto(), egresso.getUrlFoto());
    }

    @Test
    public void testeSalvarEgressoContato() {

        Contato contatoSalvo = contatoRepository.save(Contato.builder().nome("Alexandre").url_logo("urlFoto").build());

        Egresso egresso = Egresso.builder()
                .nome("Egresso")
                .email("teste@teste")
                .cpf("123456789")
                .resumo("Resumo")
                .urlFoto("UrlFoto")
                .contatos(Set.of(contatoSalvo))
                .build();

        Egresso salvo = repository.save(egresso);

        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(salvo.getIdEgresso(), egresso.getIdEgresso());
        Assertions.assertEquals(salvo.getNome(), egresso.getNome());
        Assertions.assertEquals(salvo.getEmail(), egresso.getEmail());
        Assertions.assertEquals(salvo.getCpf(), egresso.getCpf());
        Assertions.assertEquals(salvo.getResumo(), egresso.getResumo());
        Assertions.assertEquals(salvo.getUrlFoto(), egresso.getUrlFoto());
        Assertions.assertEquals(salvo.getContatos(), egresso.getContatos());
    }

    @Test
    public void testeBuscarEgressos() {
        Egresso egresso = Egresso.builder()
                .nome("Egresso")
                .email("teste@teste")
                .cpf("123456789")
                .resumo("Resumo")
                .urlFoto("UrlFoto")
                .build();

        Egresso salvo = repository.save(egresso);

        List<Egresso> egressos = repository.findAll();

        Assertions.assertFalse(egressos.isEmpty());
    }

    @Test
    public void testeBuscarEgressoPorId() {
        Egresso egresso = Egresso.builder()
                .nome("Egresso")
                .email("teste@teste")
                .cpf("123456789")
                .resumo("Resumo")
                .urlFoto("UrlFoto")
                .build();

        Egresso salvo = repository.save(egresso);

        Optional<Egresso> egressoBuscado = repository.findById(egresso.getIdEgresso());

        Assertions.assertTrue(egressoBuscado.isPresent());
    }

    @Test
    public void testeRemoverEgresso() {
        Egresso egresso = Egresso.builder()
                .nome("Egresso")
                .email("teste@teste")
                .cpf("123456789")
                .resumo("Resumo")
                .urlFoto("UrlFoto")
                .build();

        Egresso salvo = repository.save(egresso);

        Optional<Egresso> egressoBuscado = repository.findById(egresso.getIdEgresso());

        Assertions.assertTrue(egressoBuscado.isPresent());

        repository.deleteById(egresso.getIdEgresso());

        egressoBuscado = repository.findById(egresso.getIdEgresso());

        Assertions.assertFalse(egressoBuscado.isPresent());

    }

}
