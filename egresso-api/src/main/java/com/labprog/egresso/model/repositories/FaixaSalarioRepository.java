package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.dto.SalarioNumEgresso;
import com.labprog.egresso.model.entities.FaixaSalario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaixaSalarioRepository extends JpaRepository<FaixaSalario, Long> {

    @Query("select new com.labprog.egresso.model.dto.SalarioNumEgresso(p.faixaSalario.id, count(p.egresso))" +
            "from ProfEgresso p " +
            "group by p.faixaSalario.id")
    List<SalarioNumEgresso> numEgressoPorSalario();
}
