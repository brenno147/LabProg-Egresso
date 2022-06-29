package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.FaixaSalario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FaixaSalarioRepositoryTest {

    @Autowired
    private FaixaSalarioRepository repository;

    @Test
    public void testeSalvarFaixaSalario(){

        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao("Mil doletas")
                .build();

        FaixaSalario salvo = repository.save(faixaSalario);

        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(salvo.getIdFaixaSalario(), faixaSalario.getIdFaixaSalario());
        Assertions.assertEquals(salvo.getDescricao(), faixaSalario.getDescricao());
    }

    @Test
    public void testeBuscarFaixasSalario() {
        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao("Mil doletas")
                .build();

        FaixaSalario salvo = repository.save(faixaSalario);

        List<FaixaSalario> faixas = repository.findAll();

        Assertions.assertFalse(faixas.isEmpty());
    }

    @Test
    public void testeBuscarEgressoPorId() {
        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao("Mil doletas")
                .build();

        FaixaSalario salvo = repository.save(faixaSalario);

        Optional<FaixaSalario> faixaBuscada = repository.findById(faixaSalario.getIdFaixaSalario());

        Assertions.assertTrue(faixaBuscada.isPresent());
    }

    @Test
    public void testeRemoverEgresso() {
        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao("Mil doletas")
                .build();

        FaixaSalario salvo = repository.save(faixaSalario);

        Optional<FaixaSalario> faixaBuscada = repository.findById(faixaSalario.getIdFaixaSalario());

        Assertions.assertTrue(faixaBuscada.isPresent());

        repository.deleteById(faixaSalario.getIdFaixaSalario());

        faixaBuscada = repository.findById(faixaSalario.getIdFaixaSalario());

        Assertions.assertFalse(faixaBuscada.isPresent());

    }

}
