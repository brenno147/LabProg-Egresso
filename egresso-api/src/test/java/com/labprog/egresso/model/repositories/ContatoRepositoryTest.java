package com.labprog.egresso.model.repositories;

import java.util.List;
import java.util.Optional;

import com.labprog.egresso.model.entities.Contato;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContatoRepositoryTest {
    
    @Autowired
    ContatoRepository repository;

    @Test
    public void deveInserirContato(){

        // Cenário: Criar um contato
        Contato contato = Contato.builder()
            .nome("Alexandre")
            .url_logo("urlFoto")
            .build();


        // Ação: Inserir contato
        Contato salvo = repository.save(contato);

        // Verificar: Se o contato foi salvo
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(contato.getNome(),salvo.getNome());
        Assertions.assertEquals(contato.getUrl_logo(), salvo.getUrl_logo());
    }

    @Test
    public void deveRemoverContato(){

        // Cenário: Criar um contato
        Contato contato = Contato.builder()
            .nome("Ana")
            .url_logo("urlFoto")
            .build();


        // Ação: Inserir contato e remover contato
        Contato salvo = repository.save(contato);
        Long id = salvo.getId() ;
        repository.deleteById(id);


        // Verificação: Saber se o cargo foi removido
        Optional<Contato> retorno = repository.findById(id);
        Assertions.assertFalse(retorno.isPresent());
    }
    

    @Test
    public void deveRetornarTodosOsContatos(){

        // Cenário: Criar um contato
        Contato contato = Contato.builder()
            .nome("Ana")
            .url_logo("urlFoto")
            .build();

        Contato contato2 = Contato.builder()
            .nome("Ana")
            .url_logo("urlFoto")
            .build();


        // Ação: Inserir contato e Retornar todos os contatos
        Contato salvo = repository.save(contato);
        Contato salvo2 = repository.save(contato2);
        List<Contato> contatos = repository.findAll();


        // Verificação: Saber se foram encontradas todos os contatos
        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo2);
        Assertions.assertTrue(contatos.size()>0);
    }

    @Test
    public void deveRetornarQuantidadeDeContatosPresentesNoBanco(){
        // Cenário: Inserir cargos no banco
        Contato contato = Contato.builder()
            .nome("Carla")
            .url_logo("urlFoto")
            .build();
        Contato contato2 = Contato.builder()
            .nome("Iasmin")
            .url_logo("urlFoto")
            .build();

        // Ação: Inserir os cargos criados e retornar a quantidade de cargos 
        Contato salvo = repository.save(contato);
        Contato salvo2 = repository.save(contato2);
        Long countContato = repository.count();

        // Verificação: Se é retornado uma quantidade > 0 de cargos
        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo2); 
        Assertions.assertTrue(countContato>0);

    }

    @Test
    public void deveDeletarTodosOsContatos(){
        // Cenário: Inserir cargos no banco
        Contato contato = Contato.builder()
            .nome("André")
            .url_logo("urlFoto")
            .build();
        Contato contato2 = Contato.builder()
            .nome("Lucas")
            .url_logo("urlFoto")
            .build();

        // Ação: Inserir os cargos criados e deletar todos os cargod
        Contato salvo = repository.save(contato);
        Contato salvo2 = repository.save(contato2);
        repository.deleteAll();
        List<Contato> contatos = repository.findAll();

        // Verificação: Se é retornado uma quantidade > 0 de cargos
        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo2); 
        Assertions.assertTrue(contatos.size() == 0);

    }
}
