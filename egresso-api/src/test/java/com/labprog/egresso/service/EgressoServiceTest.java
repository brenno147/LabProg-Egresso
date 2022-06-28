package com.labprog.egresso.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.repositories.EgressoRepository;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EgressoServiceTest {

    @Autowired
    EgressoService service;

    @Autowired
    EgressoRepository repository;
    
    @Test
    // salvar egresso
    public void deveSalvarEgresso(){

        // Cenário: Criar um egresso
        Egresso egresso = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .senha("123")
            .build();
        

        // Ação: salvar um egresso
        Egresso salvo = service.salvar(egresso);

        // Verificação: verificar se o cargo criado foi salvo
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(egresso.getNome(),salvo.getNome());
        Assertions.assertEquals(egresso.getSenha(), salvo.getSenha());
        Assertions.assertNotNull(salvo.getIdEgresso());
    }


    @Test
    //remover
    public void deveDeletarUmEgresso(){

        // Cenário: Criar um egresso
        Egresso egresso = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .senha("123")
            .build();

        // Ação: salva um egresso
        Egresso salvo = service.salvar(egresso);

        // Ação: remover um egresso
        service.remover(salvo.getIdEgresso());

        // Verificação: verificar se o egresso criado foi removido
        Optional<Egresso> testRemovido = repository.findById(salvo.getIdEgresso());

        Assertions.assertTrue(testRemovido.isEmpty());
        
    }
}
