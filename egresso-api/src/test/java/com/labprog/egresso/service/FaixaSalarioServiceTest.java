package com.labprog.egresso.service;

import com.labprog.egresso.model.dto.SalarioNumEgresso;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.entities.FaixaSalario;
import com.labprog.egresso.model.entities.ProfEgresso;
import com.labprog.egresso.model.repositories.ProfEgressoRepository;
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
public class FaixaSalarioServiceTest {

    @Autowired
    private FaixaSalarioService faixaSalarioService;

    @Autowired
    private EgressoService egressoService;

    @Autowired
    private ProfEgressoRepository profEgressoRepository;

    @Autowired
    private CargoService cargoService;

    @Test
    public void deveSalvarFaixaSalario() {
        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao("Faixa Salarial de Teste")
                .build();

        FaixaSalario faixaSalarioResultado = faixaSalarioService.salvar(faixaSalario);

        Assertions.assertNotNull(faixaSalarioResultado);
        Assertions.assertEquals(faixaSalario.getDescricao(), faixaSalarioResultado.getDescricao());
    }

    @Test
    public void deveRemoverFaixaSalario() {
        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao("Faixa Salarial de Teste")
                .build();

        FaixaSalario faixaSalarioResultado = faixaSalarioService.salvar(faixaSalario);

        faixaSalarioService.remover(faixaSalario.getIdFaixaSalario());

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            faixaSalarioService.buscarPorId(faixaSalarioResultado.getIdFaixaSalario());
        });
    }

    @Test
    public void deveRetornarQuantidadeDeEgressosPorFaixaSalarial() {
        Cargo cargo = Cargo.builder()
                .nome("Desenvolvedor Front end")
                .descricao("responsável por se preocupar mais com a experiência (UX) e interface exibida para o usuário (UI)  trabalhando principalmente com HTML, CSS e JavaScript.")
                .build();

        FaixaSalario faixaSalario = FaixaSalario.builder()
                .descricao("Entre 2.000 e 3.000")
                .build();

        FaixaSalario faixaSalario1 = FaixaSalario.builder()
                .descricao("Entre 3.000 e 4.000")
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

        ProfEgresso profEgresso1 = ProfEgresso.builder()
                .cargo(cargo)
                .faixaSalario(faixaSalario)
                .empresa("Empresa")
                .descricao("Descricao")
                .dataRegistro(LocalDate.now())
                .build();

        ProfEgresso profEgresso2 = ProfEgresso.builder()
                .cargo(cargo)
                .faixaSalario(faixaSalario1)
                .empresa("Empresa")
                .descricao("Descricao")
                .dataRegistro(LocalDate.now())
                .build();

        ProfEgresso profEgresso3 = ProfEgresso.builder()
                .cargo(cargo)
                .faixaSalario(faixaSalario1)
                .empresa("Empresa")
                .descricao("Descricao")
                .dataRegistro(LocalDate.now())
                .build();

        egresso1.addProfissao(profEgresso1);
        egresso2.addProfissao(profEgresso2);
        egresso3.addProfissao(profEgresso3);

        cargoService.salvar(cargo);

        faixaSalarioService.salvar(faixaSalario);
        faixaSalarioService.salvar(faixaSalario1);

        egressoService.salvar(egresso1);
        egressoService.salvar(egresso2);
        egressoService.salvar(egresso3);

        List<SalarioNumEgresso> salarioNumEgressos = faixaSalarioService.quantEgressoPorSalario();

        Assertions.assertEquals(2, salarioNumEgressos.size());
        Assertions.assertEquals(1, salarioNumEgressos.get(0).getNumEgresso());
        Assertions.assertEquals(2, salarioNumEgressos.get(1).getNumEgresso());
    }
}
