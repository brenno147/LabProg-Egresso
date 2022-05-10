package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.Egresso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EgressoRepositoryTest {

    @Autowired
    EgressoRepository repository;

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
    public void testeBuscarEgressoPorId() {
        Optional<Egresso> egresso= repository.findById(1L);
        
        Assertions.assertTrue(egresso.isPresent());
    }

}
