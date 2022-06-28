package com.labprog.egresso.model.repositories;


import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.entities.FaixaSalario;
import com.labprog.egresso.model.entities.ProfEgresso;
import com.labprog.egresso.service.repositories.CargoRepository;
import com.labprog.egresso.service.repositories.EgressoRepository;
import com.labprog.egresso.service.repositories.FaixaSalarioRepository;
import com.labprog.egresso.service.repositories.ProfEgressoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProfEgressoRepositoryTest {

    @Autowired
    private ProfEgressoRepository profEgressoRepository;

    @Autowired
    private EgressoRepository egressoRepository;

    @Autowired
    private FaixaSalarioRepository faixaSalarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Test
    public void deveSalvarUmProfEgresso() {

        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        FaixaSalario faixaSalarioSalvo = faixaSalarioRepository.save(FaixaSalario.builder().descricao("Descricao").build());
        Cargo cargoSalvo = cargoRepository.save(Cargo.builder().nome("Nome").build());


        ProfEgresso profEgresso = ProfEgresso.builder()
                .cargo(cargoSalvo)
                .egresso(egressoSalvo)
                .faixaSalario(faixaSalarioSalvo)
                .empresa("Empresa")
                .descricao("Descricao")
                .dataRegistro(LocalDate.now())
                .build();

        ProfEgresso salvo = profEgressoRepository.save(profEgresso);

        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(salvo.getIdProfEgresso(), profEgresso.getIdProfEgresso());
        Assertions.assertEquals(salvo.getCargo(), profEgresso.getCargo());
        Assertions.assertEquals(salvo.getEgresso(), profEgresso.getEgresso());
        Assertions.assertEquals(salvo.getFaixaSalario(), profEgresso.getFaixaSalario());
        Assertions.assertEquals(salvo.getEmpresa(), profEgresso.getEmpresa());
        Assertions.assertEquals(salvo.getDescricao(), profEgresso.getDescricao());
        Assertions.assertEquals(salvo.getDataRegistro(), profEgresso.getDataRegistro());
    }

    @Test
    public void deveBuscarTodosProfEgresso() {
        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        FaixaSalario faixaSalarioSalvo = faixaSalarioRepository.save(FaixaSalario.builder().descricao("Descricao").build());
        Cargo cargoSalvo = cargoRepository.save(Cargo.builder().nome("Nome").build());


        ProfEgresso profEgresso = ProfEgresso.builder()
                .cargo(cargoSalvo)
                .egresso(egressoSalvo)
                .faixaSalario(faixaSalarioSalvo)
                .empresa("Empresa")
                .descricao("Descricao")
                .dataRegistro(LocalDate.now())
                .build();

        ProfEgresso salvo = profEgressoRepository.save(profEgresso);

        List<ProfEgresso> profEgressos = profEgressoRepository.findAll();

        Assertions.assertFalse(profEgressos.isEmpty());
    }

    @Test
    public void deveBuscarProfEgressoPorId() {
        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        FaixaSalario faixaSalarioSalvo = faixaSalarioRepository.save(FaixaSalario.builder().descricao("Descricao").build());
        Cargo cargoSalvo = cargoRepository.save(Cargo.builder().nome("Nome").build());


        ProfEgresso profEgresso = ProfEgresso.builder()
                .cargo(cargoSalvo)
                .egresso(egressoSalvo)
                .faixaSalario(faixaSalarioSalvo)
                .empresa("Empresa")
                .descricao("Descricao")
                .dataRegistro(LocalDate.now())
                .build();

        ProfEgresso salvo = profEgressoRepository.save(profEgresso);

        Optional<ProfEgresso> profEgressoBuscado = profEgressoRepository.findById(profEgresso.getIdProfEgresso());

        Assertions.assertTrue(profEgressoBuscado.isPresent());
    }

    @Test
    public void deveDeletarProfEgresso() {
        Egresso egressoSalvo = egressoRepository.save(Egresso.builder().nome("Abc").email("a@a").cpf("1234567").build());
        FaixaSalario faixaSalarioSalvo = faixaSalarioRepository.save(FaixaSalario.builder().descricao("Descricao").build());
        Cargo cargoSalvo = cargoRepository.save(Cargo.builder().nome("Nome").build());


        ProfEgresso profEgresso = ProfEgresso.builder()
                .cargo(cargoSalvo)
                .egresso(egressoSalvo)
                .faixaSalario(faixaSalarioSalvo)
                .empresa("Empresa")
                .descricao("Descricao")
                .dataRegistro(LocalDate.now())
                .build();

        ProfEgresso salvo = profEgressoRepository.save(profEgresso);

        Optional<ProfEgresso> profEgressoBuscado = profEgressoRepository.findById(profEgresso.getIdProfEgresso());

        Assertions.assertTrue(profEgressoBuscado.isPresent());

        profEgressoRepository.deleteById(profEgresso.getIdProfEgresso());

        profEgressoBuscado = profEgressoRepository.findById(profEgresso.getIdProfEgresso());

        Assertions.assertFalse(profEgressoBuscado.isPresent());
    }
}
