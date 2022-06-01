package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.Depoimento;

import com.labprog.egresso.model.entities.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {

    List<Depoimento> findByOrderByDataDesc();

    List<Depoimento> findByEgresso(Egresso egresso);
}
