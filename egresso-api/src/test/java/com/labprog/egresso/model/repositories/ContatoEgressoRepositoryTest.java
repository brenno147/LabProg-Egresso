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

        ContatoEgresso salvo = contatoEgressoRepository.save(contato);

        Assertions.assertNotNull(salvo);
    }
}
