package com.labprog.egresso.model.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.labprog.egresso.model.entities.Depoimento;
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
public class DepoimentoRepositoryTest {
  
  @Autowired
  DepoimentoRepository depoimentoRepository;
  
  @Autowired
  EgressoRepository egressoRepository;

  @Test
  public void deveInserirUmDepoimento() {

    Egresso egresso = Egresso.builder()
          .nome("Egresso")
          .email("teste@teste")
          .cpf("123456789")
          .resumo("Resumo")
          .urlFoto("UrlFoto")
          .build();

    Egresso egressoSalvo = egressoRepository.save(egresso);

    Assertions.assertNotNull(egressoSalvo);

    Depoimento depoimento = Depoimento.builder()
          .egresso(egresso)
          .texto("Teste de depoimento longo, bla bla")
          .data(LocalDate.now())
          .build();

    Depoimento depoimentoSalvo = depoimentoRepository.save(depoimento);

    Assertions.assertNotNull(depoimentoSalvo);

    Assertions.assertEquals(depoimento.getEgresso(), depoimentoSalvo.getEgresso());
    Assertions.assertEquals(depoimento.getTexto(), depoimentoSalvo.getTexto());
    Assertions.assertEquals(depoimento.getData(), depoimentoSalvo.getData());

  }

  @Test
  public void deveBuscarTodosOsDepoimentos() {

    Egresso egresso = Egresso.builder()
          .nome("Egresso")
          .email("teste@teste")
          .cpf("123456789")
          .resumo("Resumo")
          .urlFoto("UrlFoto")
          .build();

    Egresso egressoSalvo = egressoRepository.save(egresso);

    Assertions.assertNotNull(egressoSalvo);

    Depoimento depoimento = Depoimento.builder()
          .egresso(egresso)
          .texto("Teste de depoimento longo, bla bla")
          .data(LocalDate.now())
          .build();

    depoimentoRepository.save(depoimento);

    List<Depoimento> depoimentos =depoimentoRepository.findAll();

    Assertions.assertFalse(depoimentos.isEmpty());

  }

  @Test
  public void deveBuscarDepoimentoPorId() {

    Egresso egresso = Egresso.builder()
          .nome("Egresso")
          .email("teste@teste")
          .cpf("123456789")
          .resumo("Resumo")
          .urlFoto("UrlFoto")
          .build();

    Egresso egressoSalvo = egressoRepository.save(egresso);

    Assertions.assertNotNull(egressoSalvo);

    Depoimento depoimento = Depoimento.builder()
          .egresso(egresso)
          .texto("Teste de depoimento longo, bla bla")
          .data(LocalDate.now())
          .build();

    depoimentoRepository.save(depoimento);

    Optional<Depoimento> depoimentoBuscado = depoimentoRepository.findById(depoimento.getId_depoimento());

    Assertions.assertTrue(depoimentoBuscado.isPresent());
  }

  @Test
  public void deveRemoverUmDepoimento() {

    Egresso egresso = Egresso.builder()
          .nome("Egresso")
          .email("teste@teste")
          .cpf("123456789")
          .resumo("Resumo")
          .urlFoto("UrlFoto")
          .build();

    Egresso egressoSalvo = egressoRepository.save(egresso);

    Assertions.assertNotNull(egressoSalvo);

    Depoimento depoimento = Depoimento.builder()
          .egresso(egresso)
          .texto("Teste de depoimento longo, bla bla")
          .data(LocalDate.now())
          .build();

    depoimentoRepository.save(depoimento);

    Optional<Depoimento> depoimentoBuscado = depoimentoRepository.findById(depoimento.getId_depoimento());

    Assertions.assertTrue(depoimentoBuscado.isPresent());

    depoimentoRepository.deleteById(depoimento.getId_depoimento());

    depoimentoBuscado = depoimentoRepository.findById(depoimento.getId_depoimento());

    Assertions.assertFalse(depoimentoBuscado.isPresent());
  }

}
