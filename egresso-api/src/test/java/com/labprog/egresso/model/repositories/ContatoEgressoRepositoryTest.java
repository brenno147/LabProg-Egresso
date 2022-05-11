package com.labprog.egresso.model.repositories;

import java.util.List;

import com.labprog.egresso.model.entities.Contato;
import com.labprog.egresso.model.entities.ContatoEgresso;


import com.labprog.egresso.model.entities.ContatoEgressoPK;
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
public class ContatoEgressoRepositoryTest {
    
    @Autowired
    private ContatoEgressoRepository contatoEgressoRepository;

    @Autowired
    private EgressoRepository egressoRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    @Test
    public void deveSalvarContatoEgresso(){

        // Cenário: Criar ContatoEgresso
        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        Contato contatoSalvo = contatoRepository.save(Contato.builder().nome("Celular").url_logo("1234567").build());

        ContatoEgresso contato = ContatoEgresso.builder()
                .id(ContatoEgressoPK.builder()
                        .contato_id(contatoSalvo.getId())
                        .egresso_id(egressoSalvo.getIdEgresso())
                        .build())
                .contato(contatoSalvo)
                .egresso(egressoSalvo)
                .build();

        // Ação: Salvar ContatoEgresso
        ContatoEgresso salvo = contatoEgressoRepository.save(contato);

        // Verificação: Se o contato foi salvo
        Assertions.assertNotNull(salvo);
    }

    @Test
    public void deveRetornarTodosAsOcorrenciasDaTabelaContatoEgresso(){

        // Cenário: Criar ContatoEgresso
        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        Contato contatoSalvo = contatoRepository.save(Contato.builder().nome("Celular").url_logo("1234567").build());

        ContatoEgresso contato = ContatoEgresso.builder()
                .id(ContatoEgressoPK.builder()
                        .contato_id(contatoSalvo.getId())
                        .egresso_id(egressoSalvo.getIdEgresso())
                        .build())
                .contato(contatoSalvo)
                .egresso(egressoSalvo)
                .build();
        
        // Ação: Salvar ContatoEgresso e encontrar todos as ocorências

        ContatoEgresso salvo = contatoEgressoRepository.save(contato);
        List<ContatoEgresso> contatosEgresso = contatoEgressoRepository.findAll();

        // Verificação: Se a lista é maior que 0 
        Assertions.assertNotNull(salvo);
        Assertions.assertTrue(contatosEgresso.size() > 0);
    }

    @Test
    public void deveRetornarAQuantidadeDeLinhasPresentesEmContatoEgresso(){

        // Cenário: Criar ContatoEgresso
        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        Contato contatoSalvo = contatoRepository.save(Contato.builder().nome("Celular").url_logo("1234567").build());

        ContatoEgresso contato = ContatoEgresso.builder()
                .id(ContatoEgressoPK.builder()
                        .contato_id(contatoSalvo.getId())
                        .egresso_id(egressoSalvo.getIdEgresso())
                        .build())
                .contato(contatoSalvo)
                .egresso(egressoSalvo)
                .build();
        
        // Ação: Obter a quantidade de ContatoEgresso na tabela

        ContatoEgresso salvo = contatoEgressoRepository.save(contato);
        Long count  = contatoEgressoRepository.count();

        // Verificação: Se a quantidade retornada é maior que 0
        Assertions.assertNotNull(salvo);
        Assertions.assertTrue(count > 0);
    }

    @Test
    public void deveDeletarTodasAsOcorrenciasDeContatoEgresso(){

        // Cenário: Criar ContatoEgresso

        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        Contato contatoSalvo = contatoRepository.save(Contato.builder().nome("Celular").url_logo("1234567").build());

        ContatoEgresso contato = ContatoEgresso.builder()
                .id(ContatoEgressoPK.builder()
                        .contato_id(contatoSalvo.getId())
                        .egresso_id(egressoSalvo.getIdEgresso())
                        .build())
                .contato(contatoSalvo)
                .egresso(egressoSalvo)
                .build();
        
        // Ação: Deletar todos os contatos da tabela

        ContatoEgresso salvo = contatoEgressoRepository.save(contato);
        contatoEgressoRepository.deleteAll();

        Long count = contatoEgressoRepository.count();

        // Verificação: Se não existem ContatoEgresso nessa tabela
        Assertions.assertNotNull(salvo);
        Assertions.assertTrue(count==0);
    }
}
