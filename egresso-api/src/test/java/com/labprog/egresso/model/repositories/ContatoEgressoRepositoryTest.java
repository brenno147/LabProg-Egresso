package com.labprog.egresso.model.repositories;

import java.util.List;

import com.labprog.egresso.model.entities.ContatoEgresso;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@Log4j2
public class ContatoEgressoRepositoryTest {
    
    @Autowired
    ContatoEgressoRepository repository;
    

    @Test
    public void deveRetornarTodasAsOcorrenciasDeContatoEgresso(){

        // Ação receber todos as ocorrencias da tabela
        List<ContatoEgresso> contEgres = repository.findAll();

        log.info(contEgres);

        // Verificação: Saber se o tamanho da lista retornada é maior que 0
        Assertions.assertTrue(contEgres.size()>0);
    }

    @Test
    public void deveDeletarTodosOsContatosDeUmEgresso(){

        // Ação deletar todas as ocorrencias da tabela 
        repository.deleteAll();

        //Verificação: Se a quantidade de linhas é igual a 0
        log.info(repository.count());

        Assertions.assertTrue(repository.count()==0);
    }
}
