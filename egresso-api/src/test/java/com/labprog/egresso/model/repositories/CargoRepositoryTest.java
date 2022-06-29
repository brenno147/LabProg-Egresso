package com.labprog.egresso.model.repositories;

import java.util.List;
import java.util.Optional;

import com.labprog.egresso.model.entities.Cargo;

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
public class CargoRepositoryTest {

    @Autowired
    CargoRepository repository;

    @Test
    public void deveInserirUmCargo(){

        // Cenário: Criar um cargo
        Cargo cargo = Cargo.builder()
            .nome("Desenvolvedor Front end")
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();
        
        // Ação: Inserir um cargo
        Cargo salvo = repository.save(cargo);

        // Verificação: verificar se o cargo criado foi inserido
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(cargo.getNome(),salvo.getNome());
        Assertions.assertEquals(cargo.getDescricao(), salvo.getDescricao());

    }

    @Test
    public void deveRemoverUmCargo(){

        // Cenário: Criar um cargo
        Cargo cargo = Cargo.builder()
            .nome("Back end")
            .descricao("profissional responsável por planejar, construir, implementar e, principalmente, manter a estrutura tecnológica funcionando corretamente. ")
            .build();
        
        // Ação: Inserir um cargo
        Cargo salvo = repository.save(cargo);
        Long id = salvo.getId();
        repository.deleteById(id);

        // Verificação: Saber se o cargo foi removido
        Optional<Cargo> retorno = repository.findById(id);
        Assertions.assertFalse(retorno.isPresent());


    }

    @Test 
    public void deveRetornarTodosOscargos(){
        
        // Cenário: Inserir cargos no banco
        Cargo cargo = Cargo.builder()
            .nome("Back end")
            .descricao("Profissional responsável por planejar, construir, implementar e, principalmente, manter a estrutura tecnológica funcionando corretamente. ")
            .build();
        Cargo cargo2 = Cargo.builder()
            .nome("Data Science")
            .descricao("É a área de conhecimento que transforma a infinidade de dados que são gerados atualmente em informações úteis para as organizações.")
            .build();

        // Ação: Inserir cargos, encontrar todos os cargos inseridos no banco
        Cargo salvo = repository.save(cargo);
        Cargo salvo2 = repository.save(cargo2);

        List<Cargo> cargos = repository.findAll();

        // Verificação: Saber se os cargos estão sendo inseridos e retornados
        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo2);
        Assertions.assertNotNull(cargos); 
    }

    @Test
    public void deveRetornarQuantidadeDeCargosPresentesNoBanco(){
        // Cenário: Inserir cargos no banco
        Cargo cargo = Cargo.builder()
            .nome("Engenheiro de software")
            .descricao("Profissional responsável por projetar e guiar o desenvolvimento de sistemas, aplicativos e programas.")
            .build();
        Cargo cargo2 = Cargo.builder()
            .nome("Engenheiro de Teste")
            .descricao("Inspeciona e apresenta relatórios sobre a qualidade dos produtos durante todo o ciclo de produção.")
            .build();

        // Ação: Inserir os cargos criados e retornar a quantidade de cargos 
        Cargo salvo = repository.save(cargo);
        Cargo salvo2 = repository.save(cargo2);
        Long countCargos = repository.count();

        // Verificação: Se é retornado uma quantidade > 0 de cargos
        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo2); 
        Assertions.assertTrue(countCargos>0);

    }

    @Test
    public void deveDeletarTodosOsCargos(){
        // Cenário: Inserir cargos no banco
        Cargo cargo = Cargo.builder()
            .nome("Engenheiro de software")
            .descricao("Profissional responsável por projetar e guiar o desenvolvimento de sistemas, aplicativos e programas.")
            .build();
        Cargo cargo2 = Cargo.builder()
            .nome("Engenheiro de Teste")
            .descricao("Inspeciona e apresenta relatórios sobre a qualidade dos produtos durante todo o ciclo de produção.")
            .build();

        // Ação: Inserir os cargos criados e deletar todos os cargod
        Cargo salvo = repository.save(cargo);
        Cargo salvo2 = repository.save(cargo2);
        repository.deleteAll();
        List<Cargo> cargos = repository.findAll();

        // Verificação: Se é retornado uma quantidade > 0 de cargos
        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo2); 
        Assertions.assertTrue(cargos.size() == 0);

    }


}
