package com.labprog.egresso.service;

import com.labprog.egresso.model.entities.Depoimento;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DepoimentoServiceTest {

    @Autowired
    private DepoimentoService depoimentoService;

    @Autowired
    private EgressoService egressoService;

    @Test
    public void deveSalvarDepoimento(){


        Egresso egresso = new Egresso();
        egresso.setNome("Egresso Teste");
        egresso.setCpf("123456789");
        egresso.setEmail("m@m.com");
        egresso.setResumo("Resumo do Egresso");
        egresso.setUrlFoto("https://www.google.com");

        egressoService.salvar(egresso);

        Depoimento depoimento = Depoimento.builder()
                .texto("Depoimento de teste")
                .egresso(egresso)
                .data(LocalDate.parse("2022-06-22"))
                .build();


        Depoimento depoimentoResultado = depoimentoService.salvar(depoimento);


        Assertions.assertNotNull(depoimentoResultado);
        Assertions.assertEquals(depoimento.getTexto(), depoimentoResultado.getTexto());
        Assertions.assertEquals(depoimento.getEgresso().getIdEgresso(), depoimentoResultado.getEgresso().getIdEgresso());
        Assertions.assertEquals(depoimento.getData(), depoimentoResultado.getData());


    }

    @Test
    public void deveRemoverDepoimento() {
        Egresso egresso = new Egresso();
        egresso.setNome("Egresso Teste");
        egresso.setCpf("123456789");
        egresso.setEmail("m@m.com");
        egresso.setResumo("Resumo do Egresso");
        egresso.setUrlFoto("https://www.google.com");

        egressoService.salvar(egresso);

        Depoimento depoimento = Depoimento.builder()
                .texto("Depoimento de teste")
                .egresso(egresso)
                .data(LocalDate.parse("2022-06-22"))
                .build();


        Depoimento depoimentoResultado = depoimentoService.salvar(depoimento);


        Assertions.assertNotNull(depoimentoResultado);
        Assertions.assertEquals(depoimento.getTexto(), depoimentoResultado.getTexto());
        Assertions.assertEquals(depoimento.getEgresso().getIdEgresso(), depoimentoResultado.getEgresso().getIdEgresso());
        Assertions.assertEquals(depoimento.getData(), depoimentoResultado.getData());

        depoimentoService.remover(depoimentoResultado.getId_depoimento());

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            depoimentoService.findById(depoimentoResultado.getId_depoimento());
        });
    }

    @Test
    public void depoimentosRecentes(){
        Egresso egresso = new Egresso();
        egresso.setNome("Egresso Teste");
        egresso.setCpf("123456789");
        egresso.setEmail("m@m.com");
        egresso.setResumo("Resumo do Egresso");
        egresso.setUrlFoto("https://www.google.com");

        egressoService.salvar(egresso);

        Depoimento depoimento = Depoimento.builder()
                .texto("Depoimento de teste")
                .egresso(egresso)
                .data(LocalDate.parse("2022-06-10"))
                .build();


        Depoimento depoimentoResultado = depoimentoService.salvar(depoimento);

        Depoimento depoimento2 = Depoimento.builder()
                .texto("Depoimento de teste")
                .egresso(egresso)
                .data(LocalDate.parse("2022-06-13"))
                .build();


        Depoimento depoimento2Resultado = depoimentoService.salvar(depoimento2);

        List<Depoimento> depoimentosRecentes = depoimentoService.buscarDepoimentosRecentes();

        Assertions.assertEquals(2, depoimentosRecentes.size());

        Assertions.assertEquals(depoimento2Resultado.getId_depoimento(), depoimentosRecentes.get(0).getId_depoimento());
        Assertions.assertEquals(depoimentoResultado.getId_depoimento(), depoimentosRecentes.get(1).getId_depoimento());
    }

    @Test
    public void depoimentosPorEgresso() {
        Egresso egresso = new Egresso();
        egresso.setNome("Egresso Teste");
        egresso.setCpf("123456789");
        egresso.setEmail("m@m.com");
        egresso.setResumo("Resumo do Egresso");
        egresso.setUrlFoto("https://www.google.com");

        egressoService.salvar(egresso);

        Depoimento depoimento = Depoimento.builder()
                .texto("Depoimento de teste")
                .egresso(egresso)
                .data(LocalDate.parse("2022-06-10"))
                .build();


        Depoimento depoimentoResultado = depoimentoService.salvar(depoimento);

        Depoimento depoimento2 = Depoimento.builder()
                .texto("Depoimento de teste")
                .egresso(egresso)
                .data(LocalDate.parse("2022-06-13"))
                .build();


        Depoimento depoimento2Resultado = depoimentoService.salvar(depoimento2);

        Egresso egresso2 = new Egresso();
        egresso.setNome("Egresso Teste");
        egresso.setCpf("123456789");
        egresso.setEmail("m@m.com");
        egresso.setResumo("Resumo do Egresso");
        egresso.setUrlFoto("https://www.google.com");

        egressoService.salvar(egresso2);

        List<Depoimento> depoimentosPorEgresso = depoimentoService.buscarDepoimentoEgresso(egresso.getIdEgresso());
        List<Depoimento> depoimentosPorEgresso2 = depoimentoService.buscarDepoimentoEgresso(egresso2.getIdEgresso());

        Assertions.assertEquals(2, depoimentosPorEgresso.size());
        Assertions.assertEquals(0, depoimentosPorEgresso2.size());
    }
}
