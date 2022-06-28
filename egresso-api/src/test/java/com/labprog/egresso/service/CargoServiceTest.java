package com.labprog.egresso.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.entities.FaixaSalario;
import com.labprog.egresso.model.entities.ProfEgresso;
import com.labprog.egresso.service.repositories.CargoRepository;
import com.labprog.egresso.service.repositories.EgressoRepository;
import com.labprog.egresso.service.repositories.FaixaSalarioRepository;
import com.labprog.egresso.service.repositories.ProfEgressoRepository;

import com.labprog.egresso.service.exceptions.RegraNegocioException;
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

public class CargoServiceTest {

    @Autowired
    CargoService service;
    
    @Autowired
    CargoRepository repository;

    @Autowired
    EgressoRepository egreRep;

    @Autowired
    FaixaSalarioRepository fsRep;

    @Autowired
    ProfEgressoRepository pfEgreRep;

    
    
    @Test
    // salvar cargo
    public void deveSalvarCargo(){

        // Cenário: Criar um cargo
        Cargo cargo = Cargo.builder()
            .nome("Desenvolvedor Front end")
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();
        
        // Ação: salvar um cargo
        Cargo salvo = service.salvar(cargo);

        // Verificação: verificar se o cargo criado foi salvo
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(cargo.getNome(),salvo.getNome());
        Assertions.assertEquals(cargo.getDescricao(), salvo.getDescricao());
        Assertions.assertNotNull(salvo.getId());
    }

    
    @Test
    public void deveEditarCargo(){

        // Cenário: Criar um cargo e salvar 
        Cargo cargo = Cargo.builder()
            .nome("Desenvolvedor Front end Back end")
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();

        Cargo salvo = service.salvar(cargo);

        // modificar 
        salvo.setDescricao("Criação de aplicações para melhor a UX");

        // Ação: Editar
        Cargo editado = service.editar(cargo);
        
        // Verificação: verificar se o cargo foi modificado
        Assertions.assertNotNull(editado);
    }


    @Test
    //deletar
    public void deveDeletarUmCargo(){
        // Cenário: Criar um cargo e salvar
        Cargo cargo = Cargo.builder()
            .nome("Desenvolvedor Front end")
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();

        Cargo salvo = service.salvar(cargo);

        // Ação: deletar um cargo
        service.deletar(salvo);

        // Verificação: verificar se o cargo criado foi deletado
        Optional<Cargo> testDeletado = repository.findById(salvo.getId());

        Assertions.assertTrue(testDeletado.isEmpty());
        
    }

    @Test
    // Quantidade de egressos em cada cargo
    public void deveRetornarAQuantidadeDeEgressosEmUmCargo(){

        // Cenário: Criar cargos, egressos, faixa_salario, profEgresso 
        Cargo cargo1 = Cargo.builder()
            .nome("Desenvolvedor Front end")
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();

        Cargo cargo2 = Cargo.builder()
            .nome("Analista de dados")
            .descricao("Se dedica a analisar e interpretar dados coletados. ")
            .build();

        FaixaSalario faixaSalario = FaixaSalario.builder()
            .descricao("Entre 2.000 e 5.000")
            .build();
        
        
        Egresso egresso1 = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();
        
        Egresso egresso2 = Egresso.builder()
            .nome("Egresso2")
            .email("teste2@teste2")
            .cpf("123456782")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();
        
        Egresso egresso3 = Egresso.builder()
            .nome("Egresso3")
            .email("teste3@teste3")
            .cpf("123456783")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();
        
        // Salvar faixa_salario, egressos, cargos
        Cargo c_salvo1 = service.salvar(cargo1);
        Cargo c_salvo2 = service.salvar(cargo2);

        Egresso e_salvo1 = egreRep.save(egresso1);
        Egresso e_salvo2 = egreRep.save(egresso2);
        Egresso e_salvo3 = egreRep.save(egresso3);

        FaixaSalario fs_salvo = fsRep.save(faixaSalario);


        ProfEgresso profEgresso1 = ProfEgresso.builder()
            .cargo(c_salvo1)
            .egresso(e_salvo1)
            .faixaSalario(fs_salvo)
            .empresa("Empresa")
            .descricao("Descricao")
            .dataRegistro(LocalDate.now())
            .build();

        ProfEgresso profEgresso2 = ProfEgresso.builder()
            .cargo(c_salvo2)
            .egresso(e_salvo2)
            .faixaSalario(fs_salvo)
            .empresa("Empresa")
            .descricao("Descricao")
            .dataRegistro(LocalDate.now())
            .build();


        ProfEgresso profEgresso3 = ProfEgresso.builder()
            .cargo(c_salvo1)
            .egresso(e_salvo3)
            .faixaSalario(fs_salvo)
            .empresa("Empresa")
            .descricao("Descricao")
            .dataRegistro(LocalDate.now())
            .build();

        //salvar ProfEgressos

        ProfEgresso pfeg_salvo1 = pfEgreRep.save(profEgresso1);
        ProfEgresso pfeg_salvo2 = pfEgreRep.save(profEgresso2);
        ProfEgresso pfeg_salvo3 = pfEgreRep.save(profEgresso3);

        // Ação: Saber quantos estão em cada cargo
        List<CargoNumEgresso> quant_egre_cargo = service.quantEgressoPorCargo();
        

        // Verificação: verificar se retornou a lista de cargos com a quantidade de egressos
        Assertions.assertNotNull(quant_egre_cargo);
        Assertions.assertTrue(quant_egre_cargo.size()==2);
        Assertions.assertTrue(quant_egre_cargo.get(0).getNumEgresso()==2);
        Assertions.assertTrue(quant_egre_cargo.get(1).getNumEgresso()==1);
    }

    
    @Test
    // Consultar por egresso os cargos que ele está
    public void deveRetornarQuaisCargosUmEgressoEsta(){

        // Cenário: Criar cargos, egressos, faixa_salario, profEgresso 
        Cargo cargo1 = Cargo.builder()
            .nome("Desenvolvedor Front end")
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();

        Cargo cargo2 = Cargo.builder()
            .nome("Analista de dados")
            .descricao("Se dedica a analisar e interpretar dados coletados. ")
            .build();

        FaixaSalario faixaSalario = FaixaSalario.builder()
            .descricao("Entre 2.000 e 5.000")
            .build();
        
        
        Egresso egresso1 = Egresso.builder()
            .nome("Egresso")
            .email("teste@teste")
            .cpf("123456789")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();
        
        Egresso egresso2 = Egresso.builder()
            .nome("Egresso2")
            .email("teste2@teste2")
            .cpf("123456782")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();
        
        Egresso egresso3 = Egresso.builder()
            .nome("Egresso3")
            .email("teste3@teste3")
            .cpf("123456783")
            .resumo("Resumo")
            .urlFoto("UrlFoto")
            .build();
        
        // Salvar faixa_salario, egressos, cargos
        Cargo c_salvo1 = service.salvar(cargo1);
        Cargo c_salvo2 = service.salvar(cargo2);

        Egresso e_salvo1 = egreRep.save(egresso1);
        Egresso e_salvo2 = egreRep.save(egresso2);
        Egresso e_salvo3 = egreRep.save(egresso3);

        FaixaSalario fs_salvo = fsRep.save(faixaSalario);


        ProfEgresso profEgresso1 = ProfEgresso.builder()
            .cargo(c_salvo1)
            .egresso(e_salvo1)
            .faixaSalario(fs_salvo)
            .empresa("Empresa")
            .descricao("Descricao")
            .dataRegistro(LocalDate.now())
            .build();

        ProfEgresso profEgresso2 = ProfEgresso.builder()
            .cargo(c_salvo2)
            .egresso(e_salvo2)
            .faixaSalario(fs_salvo)
            .empresa("Empresa")
            .descricao("Descricao")
            .dataRegistro(LocalDate.now())
            .build();


        ProfEgresso profEgresso3 = ProfEgresso.builder()
            .cargo(c_salvo1)
            .egresso(e_salvo3)
            .faixaSalario(fs_salvo)
            .empresa("Empresa")
            .descricao("Descricao")
            .dataRegistro(LocalDate.now())
            .build();

        //salvar ProfEgressos

        ProfEgresso pfeg_salvo1 = pfEgreRep.save(profEgresso1);
        ProfEgresso pfeg_salvo2 = pfEgreRep.save(profEgresso2);
        ProfEgresso pfeg_salvo3 = pfEgreRep.save(profEgresso3);

        // Ação: Saber quais cargos o egresso 1 está
        List<Cargo> quant_egre_cargo = service.consultarCargoPorEgresso(egresso1.getIdEgresso());

        // Verificação: verificar se o egresso possui algum cargo
        Assertions.assertTrue(quant_egre_cargo.size() > 0);
    }


    // Teste de erro

    @Test
    // salvar cargo sem nome
    public void deveDarErroAoSalvarCargoSemNome(){

        // Cenário: Criar um cargo
        Cargo cargo = Cargo.builder()
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();
        
        // Ação: salvar um cargo

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            service.salvar(cargo);
        });

    }

    @Test
    public void deveDarErroAoEditarCargoNaoSalvo(){

        // Cenário: Criar um cargo e salvar 
        Cargo cargo = Cargo.builder()
            .nome("Desenvolvedor Front end Back end")
            .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
            .build();

        // modificar 
        cargo.setDescricao("Criação de aplicações para melhor a UX");

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            service.editar(cargo);
        });
        

    }
    

}
